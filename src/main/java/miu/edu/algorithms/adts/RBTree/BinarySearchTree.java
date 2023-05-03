package miu.edu.algorithms.adts.RBTree;

public class BinarySearchTree<Key, Elem> extends BinaryTree {
    public BinarySearchTree() {
        super();
    }

    public Iterator iterator() {
        return new BT_Iterator(this);
    }

    protected BSTnode _positionFactory() {
        return new BSTnode();
    }

    public int compareKeys(Key key1, Key key2) {
        return (Integer) key1 - (Integer) key2;
    }

    public BSTnode root() {
        return (BSTnode) this._root;
    }

    public Key key(Position p) {
        return ((BSTnode) p)._key;
    }

    public Elem element(Position p) {
        return (Elem) p.element();
    }

    public void swapElements(Position p, Position q) {
        BSTnode tp = ((BSTnode) p);
        BSTnode tq = ((BSTnode) q);
        Key tempK = tp.key();
        Elem tempE = tp.element();
        tp._key = tq.key();
        tp._elem = tq.element();
        tq._key = tempK;
        tq._elem = tempE;
    }

    public BSTnode insertItem(Key k, Elem e) {
        if (this.isEmpty()) {
            BSTnode p = (BSTnode) this.insertRoot(e);
            p._key = k;
            return p;
        } else {
            BSTnode p = this._findPosition(k, this.root());
            int diff = this.compareKeys(k, p.key());
            if (diff == 0) { // k is already in the tree
                p._elem = e; // update/replace the element
            } else {
                if (diff < 0) {
                    p = (BSTnode) this.insertLeft(p, e);
                    p._key = k;
                } else {
                    p = (BSTnode) this.insertRight(p, e);
                    p._key = k;
                }
            }
            return p;
        }
    }

    public Elem removeElement(Key k) {
        if (this.isEmpty()) { // key k is not in the BST
            return null;
        }
        BSTnode r = this._findPos2Remove(k);
        if (r.key().equals(k)) { // key not found
            this.remove(r);
        } else {
            return null;
        }
        return r.element();
    }

    public Elem findElement(Key k) {
        if (this.isEmpty()) { // key k is not in the BST
            return null;
        }
        BSTnode p = this._findPosition(k, this.root());
        if (p.key().equals(k)) { // key not found
            return p.element();
        } else {
            return null;
        }
    }

    private BSTnode _findPosition(Key k, BSTnode p) {
        if (p.key().equals(k)) { // key not found
            return p;
        }
        int diff = this.compareKeys(k, p.key());
        if (diff < 0) {
            if (this.isExternal(p.left())) {
                return p;
            } else {
                // console.log("k=" + k + "  p.left.key="+p._left._elem._key);
                return this._findPosition(k, p.left());
            }
        } else {
            if (this.isExternal(p.right())) {
                return p;
            } else {
                // console.log("k=" + k + "  p.right.key="+p._right._elem._key);
                return this._findPosition(k, p.right());
            }
        }
    }

    protected BSTnode _findPos2Remove(Key k) {
        BSTnode v = this._findPosition(k, this.root());
        BSTnode r = v;
        if (this.isInternal(v._left) && this.isInternal(v._right)) {
            r = this._findPosition(k, v.left());
            this.swapElements(v, r);
        }
        return r;
    }

    protected class BSTnode extends BTnode {
        Key _key = null;

        public BSTnode() {
            super();
        }

        public Key key() {
            return this._key;
        }

        public Elem element() {
            return (Elem) super._elem;
        }

        public BSTnode parent() {
            return (BSTnode) super._parent;
        }

        public BSTnode left() {
            return (BSTnode) super._left;
        }

        public BSTnode right() {
            return (BSTnode) super._right;
        }

        public String toString() {
            return "(" + key().toString() + ", " + element().toString() + ")";
        }
    }
}
