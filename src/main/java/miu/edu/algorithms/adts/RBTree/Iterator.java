package miu.edu.algorithms.adts.RBTree;

public interface Iterator {
    boolean hasNext();

    Object nextObject();

    void reset();
}
