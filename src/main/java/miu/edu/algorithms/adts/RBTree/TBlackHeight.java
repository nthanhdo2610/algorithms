package miu.edu.algorithms.adts.RBTree;

public class TBlackHeight extends EulerTour<Integer> {
    public void visitExternal(BinaryTree T, Position v, Result<Integer> r) {
        r.result = 0;
    }

    public void visitPostOrder(BinaryTree T, Position v, Result<Integer> r) {
        int bh = 0;
        if (((RedBlackTree) T).isBlack(v)) {
            bh = 1;
        }
        if (r.leftResult > r.rightResult) {
            r.result = r.leftResult + bh;
        } else {
            r.result = r.rightResult + bh;
        }
    }

    public Integer height(BinaryTree T) {
        return this.eulerTour(T, T.root());
    }
}
