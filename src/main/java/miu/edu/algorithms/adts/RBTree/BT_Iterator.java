package miu.edu.algorithms.adts.RBTree;

public class BT_Iterator extends EulerTour<Integer> implements Iterator {
    private int _index;
    private final Position[] _nodes;

    public BT_Iterator(BinaryTree T) {
        super();
        this._nodes = new Position[T.size()];
        this._index = 0;
        this._getNodes(T);
        this.reset();
    }

    protected void _getNodes(BinaryTree T) {
        this.eulerTour(T, T.root());
    }

    public void visitInOrder(BinaryTree T, Position v, Result<Integer> r) {
        this._nodes[this._index] = v;
        this._index++;
    }

    public boolean hasNext() {
        return this._index < this._nodes.length;
    }

    public Object nextObject() {
        Position next = this._nodes[this._index];
        this._index++;
        return next;
    }

    public void reset() {
        this._index = 0;
    }
}
