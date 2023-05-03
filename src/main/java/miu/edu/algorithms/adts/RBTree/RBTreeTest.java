package miu.edu.algorithms.adts.RBTree;

public class RBTreeTest {
    static public void main(String[] args) {
        RedBlackTree t0 = new RedBlackTree();

        TPrint printer = new TPrint();  // uses the EulerTour template

        printer.print(t0);
        THeight h = new THeight();  // uses the EulerTour template

        TBlackHeight bh = new TBlackHeight();  // uses the EulerTour template

        System.out.println("height=" + h.height(t0) + "\n"); // should be 0
        System.out.println("black-height=" + bh.height(t0) + "\n"); // should be 0
        System.out.println("insertItem=(50, 100)");
        t0.insertItem(50, 100);
        printer.print(t0);
        System.out.println("height=" + h.height(t0) + "\n"); // should be 1
        System.out.println("black-height=" + bh.height(t0) + "\n"); // should be 1

        System.out.println("insertItem=(150, 100)");
        t0.insertItem(150, 100);
        System.out.println("insertItem=(100, 100)");
        t0.insertItem(100, 100);
        printer.print(t0);
        System.out.println("height=" + h.height(t0) + "\n");
        System.out.println("black-height=" + bh.height(t0) + "\n");
        System.out.println("insertItem=(200, 100)");
        t0.insertItem(200, 100);
        System.out.println("insertItem=(450, 100)");
        t0.insertItem(450, 100);
        System.out.println("insertItem=(350, 100)");
        t0.insertItem(350, 100);
        System.out.println("insertItem=(250, 100)");
        t0.insertItem(250, 100);
        System.out.println("insertItem=(650, 100)");
        t0.insertItem(650, 100);
        System.out.println("insertItem=(550, 100)");
        t0.insertItem(550, 100);
        printer.print(t0);
        System.out.println("height=" + h.height(t0) + "\n");
        System.out.println("black-height=" + bh.height(t0) + "\n");

        System.out.println("insertItem=(500, 120)");
        t0.insertItem(500, 120);
        printer.print(t0);
        System.out.println("key= 200, element=" + t0.findElement(200));
        System.out.println("key= 450, element=" + t0.findElement(450));
        System.out.println("key= 500, element=" + t0.findElement(500));
        t0.insertItem(500, 130);
        System.out.println("key= 500, element=" + t0.findElement(500));
        t0.insertItem(500, 100);
        printer.print(t0);
        System.out.println("height=" + h.height(t0) + "\n");
        System.out.println("black-height=" + bh.height(t0) + "\n");
        PrintInOrder inOrderPrinter = new PrintInOrder(t0);
        inOrderPrinter.print();


        System.out.println("remove=50 elem=" + t0.removeElement(50) + "\n");
        printer.print(t0);
        System.out.println("height=" + h.height(t0) + "\n");
        System.out.println("black-height=" + bh.height(t0) + "\n");

        System.out.println("remove=50 elem=" + t0.removeElement(50) + "\n");
        printer.print(t0);
        System.out.println("height=" + h.height(t0) + "\n");
        System.out.println("black-height=" + bh.height(t0) + "\n");
        System.out.println("remove=350 elem=" + t0.removeElement(350) + "\n");
        printer.print(t0);
        System.out.println("height=" + h.height(t0) + "\n");
        System.out.println("black-height=" + bh.height(t0) + "\n");

        System.out.println("remove=200 elem=" + t0.removeElement(200) + "\n");
        printer.print(t0);
        System.out.println("height=" + h.height(t0) + "\n");
        System.out.println("black-height=" + bh.height(t0) + "\n");

        System.out.println("remove=150 elem=" + t0.removeElement(150) + "\n");
        printer.print(t0);
        System.out.println("height=" + h.height(t0) + "\n");
        System.out.println("black-height=" + bh.height(t0) + "\n");
        System.out.println("test of adjustment next");
        System.out.println("remove=250 elem=" + t0.removeElement(250) + "\n");
        printer.print(t0);
        System.out.println("height=" + h.height(t0) + "\n");
        System.out.println("black-height=" + bh.height(t0) + "\n");
        System.out.println("insert (25,100), (50,100), (200,100)");
        t0.insertItem(25, 100);
        t0.insertItem(50, 100); // double rotation
        t0.insertItem(200, 100); // rotate right
        printer.print(t0);
        System.out.println("height=" + h.height(t0) + "\n");
        System.out.println("black-height=" + bh.height(t0) + "\n");
        System.out.println("root=(" + t0.key(t0.root()) + ", " +
                t0.element(t0.root()) + ")");

    }
}
