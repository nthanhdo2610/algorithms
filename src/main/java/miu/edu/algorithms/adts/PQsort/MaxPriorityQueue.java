package miu.edu.algorithms.adts.PQsort;

public class MaxPriorityQueue<Key extends Comparable, Elem>
        extends PriorityQueue<Key, Elem> {

    public MaxPriorityQueue() {
        super(new MaxHeap<Item>());
    }
}
