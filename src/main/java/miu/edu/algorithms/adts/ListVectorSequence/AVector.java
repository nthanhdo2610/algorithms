package miu.edu.algorithms.adts.ListVectorSequence;

public class AVector implements IVector {
    private Node[] A;
    private int _front;
    private int _rear;

    public AVector(int size) {
        this.A = new Node[size+1];
        this._front = 0;
        this._rear = 0;
    }
    public Object elemAtRank(int r) {
        int ix = _rank2Index(r);
        return A[ix].elem;
    }
    public Object replaceAtRank(int r, Object e) {
        int ix = _rank2Index(r);
        Object result = A[ix].elem;
        A[ix].elem = e;
        return result;
    }
    public Position insertAtRank(int r, Object e) {
        _checkForOverflow();
	    int size = size();
        if (_isValidRank(r) || r == size) {
            Node n = new Node();
            n.elem = e;
            if (r < size/2) {
                _front = (A.length + _front - 1) % A.length;
                _shiftLeft(0, r);
                int curr = _rank2Index(r);
                n.index = curr;
                A[curr] = n;
            } else {
                _rear = (_rear + 1) % A.length;
                _shiftRight(r, size);
                int curr = _rank2Index(r);
                n.index = curr;
                A[curr] = n;
            }
            return n;
        } else {
            throw new Error("Invalid rank " + r);
        }
    }
    public Object removeAtRank(int r) {
        int ix = _rank2Index(r);
        Node n = A[ix];
        int size = size();
        if (r < size/2) {
            _shiftRight(0, r);
            _front = (_front + 1) % A.length;
        } else {
            _shiftLeft(r, size-1);
            _rear = (A.length + _rear - 1) % A.length;
        }
        return n.element();
    }
    public int size() {
        return (A.length + _rear - _front)% A.length;
    }
    public boolean isEmpty() {
        return _front == _rear;
    }

    public String toString() {
        StringBuilder result = new StringBuilder(100);
        result.append("[[ ");
        int size = size();
        if (0<size) {
            int ix = _rank2Index(0);
            result.append(A[ix]);
        }
        for (int r=1; r<size; r++) {
            int ix = _rank2Index(r);
            result.append(", " + A[ix]);
        }
        result.append(" ]] (" + _front + ", " + _rear + "), size=" + size);
        return result.toString();
    }

    protected int rankOf(Position p) {
        int r = _index2Rank(((Node)p).index);
        return r;
    }
    protected Position atRank(int r) {
        int ix = _rank2Index(r);
        return A[ix];
    }

    private int _rank2Index(int r) {
        if (! _isValidRank(r)) {
            throw new Error("Invalid rank =" + r + " size=" + size());
        }
        return (_front + r) % A.length;
    }
    private int _index2Rank(int i) {
        int r = (A.length - _front + i) % A.length;
        return r;
    }
    private boolean _isValidRank(int r) {
        return (r>=0 && r<size());
    }
    private void _shiftRight(int r1, int r2) {
        int curr = _rank2Index(r2);
        for (int i=r2; i>r1; i--) {
            int prev = _rank2Index(i-1);
            A[curr] = A[prev];
            A[curr].index = curr;
            curr = prev;
        }
    }
    private void _shiftLeft(int r1, int r2) {
        int curr = _rank2Index(r1);
        for (int i=r1; i<r2; i++) {
            int next = _rank2Index(i+1);
            A[curr] = A[next];
            A[curr].index = curr;
            curr = next;
        }
    }
    private void _checkForOverflow() {
        int size = size();
        if (size >= A.length -1) {
            int newSize = A.length + (A.length/2);
            Node[] newA = new Node[newSize];
            for (int i=0; i<size; i++) {
                int ix = _rank2Index(i);
                newA[i] = A[ix];
                newA[i].index = i;
            }
            A = newA;
            _front = 0;
            _rear = size;
        }
    }
    static private class Node implements Position {
        private Object elem;
        private int index;

        public Object element() {
            return elem;
        }
        public String toString() {
            return "(" + index + ", " + elem + ")";
        }
    }

}
