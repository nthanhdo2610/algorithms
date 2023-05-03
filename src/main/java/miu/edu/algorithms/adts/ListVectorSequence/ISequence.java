package miu.edu.algorithms.adts.ListVectorSequence;

public interface ISequence extends IList, IVector {

    public Position atRank(int r);

    public int rankOf(Position p);
}
