package miu.edu.algorithms.adts.PQsort;

public class MaxHeap<Elem extends Comparable> extends Heap<Elem> {
    public int compare(Elem e1, Elem e2) {
        return e2.compareTo(e1); // reverse comparison
    }
}