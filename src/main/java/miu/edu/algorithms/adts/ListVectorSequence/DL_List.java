package miu.edu.algorithms.adts.ListVectorSequence;

public class DL_List implements IList {
    private int _size;
    private final Node _header;
    private final Node _trailer;

    public DL_List() {
        _header = new Node();
        _trailer = new Node();
        _linkNodes(_header, _trailer);
        _size = 0;
    }

    public Position first() {
        if (_header._next == _trailer) {
            throw new Error("Off the end of the list");
        }
        return _header._next;
    }
    public Position last() {
        if (_trailer._prev == _header) {
            throw new Error("Off the front of the list");
        }
        return _trailer._prev;
    }
    public boolean isFirst(Position p) {
        return (p == _header._next);
    }
    public boolean isLast(Position p) {
        return (p == _trailer._prev);
    }
    public Position before(Position p) {
        Node temp = ((Node)p)._prev;
        if (temp == _header) {
            throw new Error("Off the front of the list");
        }
        return temp;
    }
    public Position after(Position p) {
        Node temp = ((Node)p)._next;
        if (temp == _trailer) {
            throw new Error("Off the end of the list");
        }
        return temp;
    }
    public int size() {
        return _size;
    }
    public boolean isEmpty() {
        return _size == 0;
    }
    public Object replaceElement(Position p, Object e) {
        Object old = p.element();
        ((Node)p)._elem = e;
        return old;
    }
    public void swapElements(Position p, Position q) {
        Object temp = p.element();
        ((Node)p)._elem = q.element();
        ((Node)q)._elem = temp;
    }
    public Position insertFirst(Object e) {
        return insertAfter(_header, e);
    }
    public Position insertLast(Object e) {
        return insertBefore(_trailer, e);
    }
    public Position insertBefore(Position q, Object e) {
        Node p = ((Node)q)._prev;
        Node v = new Node();
        v._elem = e;
        _linkNodes(p, v);
        _linkNodes(v, (Node)q);
        _size++;
        return v;
    }
    public Position insertAfter(Position p, Object e) {
        Node q = ((Node)p)._next;
        Node v = new Node();
        v._elem = e;
        _linkNodes((Node)p, v);
        _linkNodes(v, q);
        _size++;
        return v;
    }
    public Object remove(Position p) {
        Node v = ((Node)p)._prev;
        Node q = ((Node)p)._next;
        _linkNodes(v, q);
        ((Node)p)._next = null;
        ((Node)p)._prev = null;
        _size--;
        return p.element();
    }
    public String toString() {
        StringBuilder result = new StringBuilder(100);
        result.append("<< ");
        Node curr = _header._next;
        if (curr != _trailer) {
            result.append(curr.element());
            curr = curr._next;
        }
        while (curr != _trailer) {
            result.append(", ").append(curr.element());
            curr = curr._next;
        }
        result.append(" >>, size=").append(_size);
        return result.toString();
    }

    private void _linkNodes(Node p, Node q) {
        p._next = q;
        q._prev = p;
    }

    static private class Node implements Position {
        private Object _elem;
        private Node _prev;
        private Node _next;

        public Object element() {
            return _elem;
        }
        public String toString() {
            return _elem.toString();
        }
    }

}
