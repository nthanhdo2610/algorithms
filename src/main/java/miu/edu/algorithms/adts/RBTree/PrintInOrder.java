package miu.edu.algorithms.adts.RBTree;

public class PrintInOrder {
    private final Iterator _iter;

    public PrintInOrder(BinarySearchTree T) {
        this._iter = T.iterator(); // Test the iterator method
    }

    public void print() {
        this._iter.reset();
        String res = "[";
        while (this._iter.hasNext()) {
            Position next = (Position) this._iter.nextObject();
            if (this._iter.hasNext()) {
                res = res + next.toString() + " ";
            } else {
                res = res + next.toString();
            }
        }
        System.out.println(res + "]");
    }
}
