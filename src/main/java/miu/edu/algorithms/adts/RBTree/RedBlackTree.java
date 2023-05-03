package miu.edu.algorithms.adts.RBTree;

public class RedBlackTree<Key, Elem> extends BinarySearchTree<Key, Elem> {
    private enum COLOR {RED, BLACK, DBLACK}

    public RedBlackTree() {
        super();
    }

    public boolean isBlack(Position p) {
        RBTnode rbn = (RBTnode) p;
        return this.isExternal(p) || rbn.isBlack();
    }

    public boolean isRed(Position p) {
        RBTnode rbn = (RBTnode) p;
        return this.isInternal(p) && rbn.isRed();
    }

    public RBTnode sibling(Position p) {
        return (RBTnode) super.sibling(p);
    }

    protected RBTnode _positionFactory() {
        RBTnode newPos = new RBTnode();
        return newPos;
    }

    public RBTnode insertItem(Key k, Elem e) {
        RBTnode q = (RBTnode) super.insertItem(k, e);
        if (q != null) { // the item was inserted
            q._color = COLOR.RED;  // add the _color attribute to q
            RBTnode z = q;
            while (this._isDoubleRed(z)) {
                RBTnode p = z.parent();
                RBTnode w = this.sibling(p); // uncle
                if (this.isBlack(w)) { // case 1: uncle is black
                    RBTnode gp = p.parent();
                    this._restructure(z);
                    gp._color = COLOR.RED;
                    gp.parent()._color = COLOR.BLACK; // new parent of gp
                    return q;
                } else { // case 2: uncle is red
                    z = this._splitRecolor(p, z);
                }
            }
        }
        return q;
    }

    public Elem removeElement(Key k) {
        if (this.isEmpty()) { // key k is not in the BST
            return null;
        }
        RBTnode v = (RBTnode) super._findPos2Remove(k);
        if (!v.key().equals(k)) { // key k is not in the BST
            // System.out.println("Key not found " + k);
            return null;
        }
        RBTnode y = this.sibling(v);
        // after deletion of v, y is sibling of r
        // console.log("Removing " + r.element().key());
        RBTnode r = (RBTnode) this.remove(v);  // r is the child of v that remains
        if (this.isBlack(v) && this.isExternal(r)) { // r the remaining child is black
            this._removeDoubleBlack(y, r);
        } else {
            r._color = COLOR.BLACK; // r has to be a red child
        }
        return v.element();
    }

    private void _rotateLeft(RBTnode y) {
        if (this.isExternal(y) || this.isRoot(y)) {
            throw new Error("Invalid Left Rotation: y cannot be the root");
        }
        RBTnode p = y.parent(); // p must not be null
        RBTnode gp = p.parent();

        p._right = y._left; // bug 1 misspelling: left_
        if (this.isInternal(y._left)) { // bug 2 null pointer, so needed if
            y.left()._parent = p;
        }

        y._left = p;
        p._parent = y;

        if (this.isRoot(p)) {
            this._root = y;
        } else if (gp._left == p) { // bug 7: typo/type error (= instead of ==)
            gp._left = y;
        } else {
            gp._right = y;
        }
        y._parent = gp;
    }

    private void _rotateRight(RBTnode y) {
        if (this.isExternal(y) || this.isRoot(y)) {
            throw new Error("Invalid Right Rotation: y cannot be the root");
        }
        RBTnode p = y.parent(); // p must not be null
        RBTnode gp = p.parent();
        p._left = y.right();
        if (this.isInternal(y._right)) { // bug 2 (same as in _rotateLeft)
            y.right()._parent = p;
        }

        y._right = p;
        p._parent = y;

        if (this.isRoot(p)) {
            this._root = y;
        } else if (gp._right == p) {
            gp._right = y;
        } else {
            gp._left = y;
        }
        y._parent = gp;
    }

    private void _restructure(RBTnode z) {
        RBTnode p = z.parent();
        RBTnode gp = p.parent();
        if (this._isLeftChild(z)) {
            if (this._isLeftChild(p)) {
                this._rotateRight(p);
            } else { // p is a right child
                this._rotateRight(z);
                this._rotateLeft(z);
            }
        } else { // z is a right child
            if (this._isLeftChild(p)) {
                this._rotateLeft(z);
                this._rotateRight(z);
            } else { // p is also a right child
                this._rotateLeft(p);
            }
        }
    }

    private RBTnode _splitRecolor(RBTnode parent, RBTnode z) {
        parent._color = COLOR.BLACK;
        this.sibling(parent)._color = COLOR.BLACK;
        RBTnode gp = parent.parent();
        gp._color = COLOR.RED;
        return gp;
    }

    private boolean _isDoubleRed(RBTnode p) {
        if (this.isRoot(p)) {
            p._color = COLOR.BLACK;
            return false;
        } else {
            return this.isRed(p.parent()); // bug 3: p._parent, not p
        }
    }

    private RBTnode _redChildOf(RBTnode p) {
        RBTnode left = p.left();
        RBTnode right = p.right();
        RBTnode redChild = null;
        if (this.isRed(left)) {
            redChild = left;
            if (this._isLeftChild(p) && this.isRed(right)) {
                redChild = right;
            }
        } else if (this.isRed(right)) { // bug 4 right instead of left
            redChild = right;
        }
        return redChild;
    }

    private RBTnode _adjustment(RBTnode y) {
        RBTnode p = y.parent();
        // console.log("p="+p.element().key());
        // console.log("y="+y.element().key());
        RBTnode newY = null;
        if (this._isLeftChild(y)) {
            newY = y.right();
            this._rotateRight(y);
        } else {
            newY = y.left();
            this._rotateLeft(y);
        }
        p._color = COLOR.RED;
        y._color = COLOR.BLACK;
        return newY;
    }

    private RBTnode _fusionRecolor(RBTnode y, RBTnode p, RBTnode r) {
        y._color = COLOR.RED;
        if (this.isRed(p)) {
            p._color = COLOR.BLACK;
        } else {
            p._color = COLOR.DBLACK;
        }
        if (this.isInternal(r)) {
            r._color = COLOR.BLACK;
        }
        return p;
    }

    private boolean _isDoubleBlack(RBTnode p) {
        return p._color == COLOR.DBLACK;
    }

    private void _removeDoubleBlack(RBTnode y, RBTnode r) {
        if (this.isExternal(r) || this._isDoubleBlack(r)) {
            if (this.isRed(y)) {  // case 3
                y = this._adjustment(y);
            }
            RBTnode py = y.parent();
            RBTnode z = this._redChildOf(y);
            if (this.isBlack(z)) { // case1: sibling has no red children
                r = this._fusionRecolor(y, py, r);
                if (this.isRoot(r)) {
                    r._color = COLOR.BLACK;
                } else {
                    y = this.sibling(r);
                    this._removeDoubleBlack(y, r);
                }
            } else { // case 2: corresponds to transfer in a 2-4 tree
                this._restructure(z);
                py.parent()._color = py._color; // new parent of py is same color py
                py._color = COLOR.BLACK;
                this.sibling(py)._color = COLOR.BLACK;
                if (this.isInternal(r)) { // bug 5: r could be null/external
                    r._color = COLOR.BLACK;
                }
            }
        }
    }

    private class RBTnode extends BSTnode {
        COLOR _color = COLOR.RED;

        public RBTnode() {
            super();
        }

        public RBTnode parent() {
            return (RBTnode) super.parent();
        }

        public RBTnode left() {
            return (RBTnode) super.left();
        }

        public RBTnode right() {
            return (RBTnode) super.right();
        }

        public String toString() {
            return "(" + key().toString() + ", " + element().toString() +
                    ", " + this._color + ")";
        }

        public boolean isRed() {
            return this._color == COLOR.RED;
        }

        public boolean isBlack() {
            return this._color == COLOR.BLACK;
        }
    }
}
