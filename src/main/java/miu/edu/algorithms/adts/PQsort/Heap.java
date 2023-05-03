package miu.edu.algorithms.adts.PQsort;

public class Heap<Elem extends Comparable> {
    private int _size = 0;
    protected HPos<Elem>[] _heap = new HPos[50];

    public boolean isEmpty() {
        return this._size == 0;
    }

    public int size() {
        return this._size;
    }

    public Elem topElem() {
        if (this.isEmpty()) {
            throw new Error("Invalid min() operation: Heap is empty");
        }
        return this._heap[1].element();
    }

    public Position insertElem(Elem elem) {
        this._size++;
        HPos<Elem> newPos = new HPos<Elem>(elem, this._size);
        this._heap[this._size] = newPos;
        this._upHeap(this._size);
        return newPos;
    }

    public Elem removeTop() {
        if (this.isEmpty()) {
            throw new Error("Invalid minKey() operation: Heap is empty");
        }
        Elem minElem = this.topElem();
        this._heap[1] = this._heap[this._size];
        this._size--;
        this._downHeap(1);
        return minElem;
    }

    public Elem replaceElem(Position<Elem> pos, Elem elem) {
        int i = ((HPos) pos)._index;
        Elem oldElem = pos.element();
        ((HPos) pos)._elem = elem;
        this._upHeap(i);
        this._downHeap(i);
        return oldElem;
    }

    public int compare(Elem e1, Elem e2) {
        return e1.compareTo(e2);
    }

    private boolean _less(HPos<Elem> pos1, HPos<Elem> pos2) { // bug 1 (type error on elements)
        return this.compare(pos1.element(), pos2.element()) < 0;
    }

    private boolean _greater(HPos<Elem> pos1, HPos<Elem> pos2) {
        return this.compare(pos1.element(), pos2.element()) > 0;
    }

    private boolean _lessOrEqual(HPos<Elem> pos1, HPos<Elem> pos2) {
        return this.compare(pos1.element(), pos2.element()) <= 0;
    }

    private void _swapItems(int p, int i) {
        HPos<Elem> temp = this._heap[p];
        this._heap[p] = this._heap[i];
        this._heap[p]._index = p;
        this._heap[i] = temp;
        this._heap[i]._index = i;
    }

    private void _upHeap(int i) {
        int parent = (i / 2);
        while (i > 1 && this._greater(this._heap[parent], this._heap[i])) {
            this._swapItems(parent, i);
            i = parent;
            parent = (i / 2);
        }
    }

    private int _indexOfMinKey(int r) {
        int smallest = r;
        int left = r * 2;
        int right = left + 1;
        if (left <= this._size) {
            if (this._less(this._heap[left], this._heap[smallest])) {
                smallest = left;
            }
        }
        if (right <= this._size) {
            if (this._less(this._heap[right], this._heap[smallest])) {
                smallest = right; // bug 2 (left)
            }
        }
        return smallest;
    }

    private void _downHeap(int i) {
        boolean property = false;
        while (!property) {
            int min = this._indexOfMinKey(i);
            if (min != i) {
                this._swapItems(min, i);
                i = min;
            } else {
                property = true;
            }
        }
    }

    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("[ ");
        for (int i = 1; i <= this.size(); i++) {
            res.append(this._heap[i] + " ");
        }
        res.append("]");
        return res.toString();
    }

    private class HPos<Elem> implements Position<Elem> {
        private Elem _elem;
        private int _index;

        public HPos(Elem elem, int index) {
            this._elem = elem;
            this._index = index;
        }

        public Elem element() {
            return this._elem;
        }

        public String toString() {
            return "(" + _elem + ", " + _index + ")";
        }
    }
}
