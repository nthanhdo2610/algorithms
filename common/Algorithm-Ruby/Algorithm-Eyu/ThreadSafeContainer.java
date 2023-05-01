package demo;

public class ThreadSafeContainer<E> {

	private boolean isShutdown = false;
	private boolean isTailLocked = false;
	private boolean isHeadLocked = false;
	private Integer size = 0;
	private int capacity;
	private Node head;
	private Node tail;

	ThreadSafeContainer(int capacity) {
		this.capacity = capacity;
		head = new Node(null, null, null);
		tail = new Node(null, head, null);
		head.next = tail;
	}

	public void add(E element) throws ShutdownException {
		String threadName = Thread.currentThread().getName();
		checkContainerShutdown();
		synchronized (tail) {
			checkContainerShutdown();
			isTailLocked = true;
			while (size >= capacity) {				
				synchronized (head) {
					try {
						System.out.println("Container is full. Waiting...");
						head.wait();
					} catch (InterruptedException e) {
					}
				}

			}
			synchronized (size) {
				Node newNode = new Node(element, tail.previous, tail);
				tail.previous.next = newNode;
				tail.previous = newNode;
				size++;
				System.out.println(threadName + " added element to container. Container size is: " + size);
			}
			tail.notify();

		}

	}

	public void remove() throws ShutdownException {
		String threadName = Thread.currentThread().getName();
		checkContainerShutdown();
		while (size <= 0) {
			synchronized (tail) {
				try {
					System.out.println(threadName + ": Container is empty. Waiting...");
					tail.wait();
				} catch (InterruptedException e) {
				}
			}

		}
		synchronized (head) {
			checkContainerShutdown();
			synchronized (size) {
				head.next = head.next.next;
				head.next.previous = head;
				size--;
				System.out.println(threadName + " removed element from container. Container size is: " + size);
			}
			head.notify();
		}
	}

	public void clear() {
		String threadName = Thread.currentThread().getName();
		synchronized (tail) {
			synchronized (head) {
				while (head.next != tail) {
					head = head.next;
					size--;
				}
			}
			System.out.println(threadName + ": container is cleared. Container size: " + size);
			tail.notifyAll();
		}

	}

	public void shutdown() {
		synchronized (tail) {
			synchronized (head) {
				isShutdown = true;
			}
		}

	}

	public int size() {
		return size;
	}

	protected void checkContainerShutdown() throws ShutdownException {
		if (isShutdown) {
			throw new ShutdownException("Container is shutdown");
		}
	}

	class Node {
		Node next;
		Node previous;
		E element;

		Node(E elmt, Node prev, Node nxt) {
			element = elmt;
			previous = prev;
			next = nxt;
		}
	}

}
