/**
 * The Link Class
 * 
 * @author Isaac Sutor
 * @version 20170219
 *
 */
public class Node {
    // Singly linked list node class
    private Object value; // Value for this node
    private Node next; // Point to next node in list

    /**
     * Instantiates a new Node
     * 
     * @param val
     *            the val
     * @param n
     *            the node this node points to
     */
    Node(Object val, Node n) {
        value = val;
        next = n;
    }

    /**
     * creates a node with no element
     * 
     * @param n
     *            the node this node points to
     */
    Node(Node n) {
        value = null;
        next = n;
    }

    /**
     * returns object value
     * 
     * @return value - the object value
     */
    public Object element() {
        return value;
    }

    /**
     * 
     * @param c
     *            the object to make the element of the node
     * @return Object value - the value of the element set
     */
    public Object setElement(Object c) {
        value = c;
        return value;
    }

    /**
     * Sets the next Node
     * 
     * @return next - next Node
     */
    public Node next() {
        return next;
    }

    /**
     * Sets the next Node
     * 
     * @param nxt
     *            - node to set to
     * @return Node - next Node
     */
    public Node setNext(Node nxt) {
        next = nxt;
        return next;
    }

}
