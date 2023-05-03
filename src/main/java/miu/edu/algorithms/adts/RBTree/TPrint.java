package miu.edu.algorithms.adts.RBTree;

public class TPrint extends EulerTour<String> {
    public void visitExternal(BinaryTree T, Position v, Result<String> r) {
        r.result = "";
    }

    public void visitPostOrder(BinaryTree T, Position v, Result<String> r) {
        r.result = "{" + r.leftResult + v.toString() + r.rightResult + "}";
    }

    public void print(BinaryTree T) {
        if (T.size() > 0) {
            System.out.println("Root=" + T.root().toString());
        }
        String res = this.eulerTour(T, T.root());
        System.out.println("[" + res + "]\n");
    }
}
