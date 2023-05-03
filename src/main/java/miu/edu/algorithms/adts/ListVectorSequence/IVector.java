package miu.edu.algorithms.adts.ListVectorSequence;

public interface IVector {

    public Object elemAtRank(int r);

    public Object replaceAtRank(int r, Object e);

    public Position insertAtRank(int r, Object e);

    public Object removeAtRank(int r);

    public int size();

    public boolean isEmpty();
}
