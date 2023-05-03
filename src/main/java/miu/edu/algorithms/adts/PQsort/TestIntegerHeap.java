package miu.edu.algorithms.adts.PQsort;

public class TestIntegerHeap {
    static public void main(String[] args) {
        System.out.println("Heap test");
        Heap<Integer> hp = new Heap<Integer>();
        hp.insertElem(9);
        hp.insertElem(6);
        hp.insertElem(5);
        hp.insertElem(14);
        hp.insertElem(4);
        hp.insertElem(12);
        hp.insertElem(15);
        hp.insertElem(3);
        hp.insertElem(2);
        System.out.println(hp.toString());
        while (!hp.isEmpty()) {
            System.out.print(hp.removeTop() + " ");
        }
        System.out.println();

        System.out.println();
        System.out.println("MaxHeap test");
        hp = new MaxHeap<Integer>();
        hp.insertElem(9);
        hp.insertElem(6);
        hp.insertElem(5);
        hp.insertElem(14);
        hp.insertElem(4);
        hp.insertElem(12);
        hp.insertElem(15);
        hp.insertElem(3);
        hp.insertElem(2);
        System.out.println(hp.toString());
        while (!hp.isEmpty()) {
            System.out.print(hp.removeTop() + " ");
        }
        System.out.println();
    }
}
