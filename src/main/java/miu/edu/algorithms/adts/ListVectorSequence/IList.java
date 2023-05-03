package miu.edu.algorithms.adts.ListVectorSequence;

public interface IList {

    public Position first();

    public Position last();

    public boolean isFirst(Position p);

    public boolean isLast(Position p);

    public Position before(Position p);

    public Position after(Position p);

    public int size();

    public boolean isEmpty();

    public Object replaceElement(Position p, Object e);

    public void swapElements(Position p, Position q);

    public Position insertFirst(Object e);

    public Position insertLast(Object e);

    public Position insertBefore(Position p, Object e);

    public Position insertAfter(Position p, Object e);

    public Object remove(Position p);
}
