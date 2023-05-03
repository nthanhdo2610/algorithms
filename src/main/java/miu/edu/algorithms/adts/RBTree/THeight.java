package miu.edu.algorithms.adts.RBTree;

public class THeight extends EulerTour<Integer> {
    public void visitExternal(BinaryTree T, Position v, Result<Integer> r) {
        r.result = 0;
    }

    public void visitPostOrder(BinaryTree T, Position v, Result<Integer> r) {
        if (r.leftResult > r.rightResult) {
            r.result = r.leftResult + 1;
        } else {
            r.result = r.rightResult + 1;
        }
    }

    public Integer height(BinaryTree T) {
        return this.eulerTour(T, T.root());
    }
}
