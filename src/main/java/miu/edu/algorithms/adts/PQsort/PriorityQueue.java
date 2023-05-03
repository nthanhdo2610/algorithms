package miu.edu.algorithms.adts.PQsort;

public class PriorityQueue<Key extends Comparable, Elem> {
    private Heap<Item> _heap;

    public PriorityQueue() {
        this._heap = new Heap<Item>();
    }

    public PriorityQueue(Heap<Item> heap) {
        this._heap = heap;
    }

    public Key key(Position<Item> pos) {
        return pos.element().key();
    }

    public Position<Item> insertItem(Key k, Elem elem) { // returns Position containing new Item
        Item newItem = new Item(k, elem);
        return this._heap.insertElem(newItem);
    }

    public Elem removeFirst() {
        Item item = this._heap.removeTop();
        return item.element();
    }

    public Key minKey() {
        Item item = this._heap.topElem();
        return item.key();
    }

    public Elem minElement() {
        Item item = this._heap.topElem();
        return item.element();
    }

    public int size() {
        return this._heap.size();
    }

    public boolean isEmpty() {
        return this._heap.isEmpty();
    }

    public void replaceKey(Position<Item> pos, Key key) {
        Item item = pos.element();
        item._key = key;
        this._heap.replaceElem(pos, item);
    }

    public Elem replaceElement(Position<Item> pos, Elem elem) {
        Item item = pos.element();
        Elem prevElem = item._elem;
        item._elem = elem;
        return prevElem;
    }

    protected class Item implements Comparable<Item> {
        private Key _key;
        private Elem _elem;

        public Item(Key key, Elem elem) {
            this._key = key;
            this._elem = elem;
        }

        public Key key() {
            return this._key;
        }

        public Elem element() {
            return this._elem;
        }

        public int compareTo(Item item) {
            // System.out.println(this.key()+", "+item2.key());
            return this.key().compareTo(item.key());
        }
    }
}
