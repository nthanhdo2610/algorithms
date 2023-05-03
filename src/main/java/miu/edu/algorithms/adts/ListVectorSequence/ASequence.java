package miu.edu.algorithms.adts.ListVectorSequence;

public class ASequence extends AVector implements ISequence {
    public ASequence(int size) {
        super(size);
    }

    // List Methods (Vector methods are inherited)

    public Position first() {
        return atRank(0);
    }

    public Position last() {
        return atRank(this.size() - 1);
    }

    public boolean isFirst(Position p) {
        return (p == first());
    }

    public boolean isLast(Position p) {
        return (p == last());
    }

    public Position before(Position p) {
        int r = rankOf(p);
        return atRank(r - 1);
    }

    public Position after(Position p) {
        int r = rankOf(p);
        return atRank(r + 1);
    }

    public Object replaceElement(Position p, Object e) {
        Object temp = p.element();
        int r = rankOf(p);
        replaceAtRank(r, e);
        return temp;
    }

    public void swapElements(Position p, Position q) {
        Object temp = p.element();
        replaceElement(p, q.element());
        replaceElement(q, temp);
    }

    public Position insertFirst(Object e) {
        return insertAtRank(0, e);
    }

    public Position insertLast(Object e) {
        return insertAfter(last(), e);
    }

    public Position insertBefore(Position q, Object e) {
        int r = rankOf(q);
        return insertAtRank(r, e);
    }

    public Position insertAfter(Position p, Object e) {
        int r = rankOf(p);
        return insertAtRank(r + 1, e);
    }

    public Object remove(Position p) {
        int r = rankOf(p);
        return removeAtRank(r);
    }

    public int rankOf(Position p) {
        return super.rankOf(p);
    }

    public Position atRank(int r) {
        return super.atRank(r);
    }

}
