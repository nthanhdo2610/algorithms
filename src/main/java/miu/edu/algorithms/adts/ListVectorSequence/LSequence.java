package miu.edu.algorithms.adts.ListVectorSequence;

public class LSequence extends DL_List implements ISequence {
    public LSequence() {
    }

    // Vector Methods (List methods are inherited)

    public Object elemAtRank(int r) {
        Position p = atRank(r);
        if (p == null) {
            return null;
        } else {
            return p.element();
        }
    }
    public Object replaceAtRank(int r, Object e) {
        Position p = atRank(r);
        if (p == null) {
            return null;
        } else {
            return replaceElement(p, e);
        }
    }
    public Position insertAtRank(int r, Object e) {
        if (r == this.size()) {
            return insertLast(e);
        } 
        Position p = atRank(r);
        if (p == null) {
            return null;
        } else {
            return insertBefore(p, e);
        }
    }
    public Object removeAtRank(int r) {
        Position p = atRank(r);
        if (p == null) {
            return null;
        } else {
            return remove(p);
        }
    }

    public int rankOf(Position p) {
        int r = 0;
        Position curr = this.first();
        while (!this.isLast(curr) && curr != p) {
            r++;
        }
        if (curr == p) {
            return r;
        } else {
            throw new Error("Position is not in this list " + p);
        }
    }
    public Position atRank(int r) {
	if (r < 0 || r >= this.size()) { // invalid rank
            return null;
        } else {
	    Position curr = this.first();
            for (int i=0; i<r; i++) {
                curr = this.after(curr);
            }
            return curr;
        }
    }
}
