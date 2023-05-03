package miu.edu.algorithms.adts.RBTree;

public class BinaryTree {
    BTnode _root;
    int _size;

    public BinaryTree() {
        this._root = null;
        this._size = 0;
    }

    public int size() {
        return this._size;
    }

    public boolean isEmpty() {
        return this._size == 0;
    }

    public Object element(Position p) {
        return p.element();
    }

    public Position root() {
        return this._root;
    }

    public boolean isRoot(Position p) {
        return p == this._root;
    }

    public Position parent(Position p) {
        return ((BTnode) p)._parent;
    }

    public Position leftChild(Position p) {
        return ((BTnode) p)._left;
    }

    public Position rightChild(Position p) {
        return ((BTnode) p)._right;
    }

    boolean _isLeftChild(Position p) {
        BTnode tp = (BTnode) p;
        return p != null && !this.isRoot(tp)
                && tp._parent._left == p;
    }

    public Position sibling(Position p) {
        BTnode tp = (BTnode) p;
        if (this._isLeftChild(p)) {
            return tp._parent._right;
        } else {
            return tp._parent._left;
        }
    }

    public boolean isExternal(Position p) {
        return (p == null);
    }

    public boolean isInternal(Position p) {
        return (p != null);
    }

    public Object replaceElement(Position p, Object e) {
        BTnode tp = (BTnode) p;
        Object oldElem = tp._elem;
        tp._elem = e;
        return oldElem;
    }

    public void swapElements(Position p, Position q) {
        Object temp = p.element();
        ((BTnode) p)._elem = q.element();
        ((BTnode) q)._elem = temp;
    }

    protected BTnode _positionFactory() {
        return new BTnode();
    }

    public Position insertRoot(Object e) {
        if (this._size > 0) {
            throw new Error("Invalid insertRoot(e) to non-empty tree");
        }
        BTnode newRoot = _positionFactory();
        newRoot._elem = e;
        this._root = newRoot;
        this._size++;
        return this._root;
    }

    public Position insertLeft(Position p, Object e) {
        BTnode tp = (BTnode) p;
        if (this.isExternal(p) || this.isInternal(tp._left)) {
            throw new Error("Invalid insertLeft(p,e) operation");
        }
        BTnode newLeft = _positionFactory();
        newLeft._parent = tp;
        newLeft._elem = e;
        tp._left = newLeft;
        this._size++;
        return newLeft;
    }

    public Position insertRight(Position p, Object e) {
        BTnode tp = (BTnode) p;
        if (this.isExternal(p) || this.isInternal(tp._right)) {
            throw new Error("Invalid insertRight(p,e) operation");
        }
        BTnode newRight = _positionFactory();
        newRight._parent = tp;
        newRight._elem = e;
        tp._right = newRight;
        this._size++;
        return newRight;
    }

    public Position remove(Position p) {
        if (this.isExternal(p)) {
            throw new Error("Invalid remove(p): p is not internal");
        }
        BTnode tp = (BTnode) p;
        BTnode parent = tp._parent;
        BTnode remainingChild = null;
        if (this.isExternal(tp._left)) {
            remainingChild = tp._right;  // remainingChild stays in tree
        } else if (this.isExternal(tp._right)) {
            remainingChild = tp._left;   // remainingChild stays in tree
        } else {
            throw new Error("Invalid remove(p): both children are internal");
        }
        if (this.isRoot(p)) {
            this._root = remainingChild;  // remainingChild stays in tree
            if (this.isInternal(remainingChild)) {  // could be an empty tree after remove
                remainingChild._parent = null;
            }
        } else {
            if (this._isLeftChild(p)) {
                parent._left = remainingChild;  // remainingChild stays in tree
            } else {
                parent._right = remainingChild;  // remainingChild stays in tree
            }
            if (this.isInternal(remainingChild)) {
                remainingChild._parent = parent;
            }
        }
        this._size--;
        return remainingChild;  // remainingChild stays in tree
    }

    protected static class BTnode implements Position {
        BTnode _parent = null;
        BTnode _left = null;
        BTnode _right = null;
        Object _elem = null;

        public BTnode() {
        }

        public Object element() {
            return this._elem;
        }

        public String toString() {
            return "(" + _elem.toString() + ")";
        }
    }
}
