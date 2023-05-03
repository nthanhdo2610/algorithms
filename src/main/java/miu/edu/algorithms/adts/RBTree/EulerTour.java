package miu.edu.algorithms.adts.RBTree;

public class EulerTour<RType> {
    public void visitExternal(BinaryTree T, Position p, Result<RType> result) {
    }

    public void visitPreOrder(BinaryTree T, Position p, Result<RType> result) {
    }

    public void visitInOrder(BinaryTree T, Position p, Result<RType> result) {
    }

    public void visitPostOrder(BinaryTree T, Position p, Result<RType> result) {
    }

    public RType eulerTour(BinaryTree T, Position p) {
        Result<RType> r = new Result<RType>();
        if (T.isExternal(p)) {
            this.visitExternal(T, p, r);
        } else {
            this.visitPreOrder(T, p, r);
            r.leftResult = this.eulerTour(T, T.leftChild(p));
            this.visitInOrder(T, p, r);
            r.rightResult = this.eulerTour(T, T.rightChild(p));
            this.visitPostOrder(T, p, r);
        }
        return r.result;
    }

    protected class Result<RType> {
        RType leftResult;
        RType rightResult;
        RType result;
    }

}
