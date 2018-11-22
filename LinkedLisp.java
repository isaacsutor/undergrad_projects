/**
 * LinkedLisp implements the LispADT to make a LinkedList which is dynamic
 * 
 * @author isaacsutor
 * @version 20171012
 *
 */
public class LinkedLisp implements LispADT {
    private Node head; // Pointer to list header
    private Node tail;
    private Node curr; // Access to current element
    private int listSize; // Size of list

    /**
     * Constructor sets size = 0
     */
    public LinkedLisp() {
        tail = new Node(null);
        curr = tail;
        head = new Node(tail);
        listSize = 0;
    }

    /*
     * (non-Javadoc)
     * 
     * @see LispADT#add(java.lang.Object)
     */
    @Override
    public LispADT add(Object c) {
        curr.setNext(new Node(curr.element(), curr.next()));
        curr.setElement(c);
        if (tail == curr) {
            tail = curr.next();
        }
        listSize++;
        return this;
    }

    /*
     * (non-Javadoc)
     * 
     * @see LispADT#curPos()
     */
    @Override
    public Integer curPos() {
        Node temp = head.next();
        int i;
        for (i = 0; curr != temp; i++) {
            temp = temp.next();
        }
        return i;
    }

    /*
     * (non-Javadoc)
     * 
     * @see LispADT#get()
     */
    @Override
    public Object get() throws RuntimeException {
        if (listSize == 0 || curr.element() == null) {
            throw new RuntimeException();
        }
        return curr.element();
    }

    /*
     * (non-Javadoc)
     * 
     * @see LispADT#moveTo(java.lang.Integer)
     */
    @Override
    public LispADT moveTo(Integer pos) {
        if ((pos < 0 || pos > listSize)) {
            return this;
        }
        curr = head.next();
        for (int i = 0; i < pos; i++) {
            curr = curr.next();
        }
        // currPos = pos;
        return this;
    }

    /*
     * (non-Javadoc)
     * 
     * @see LispADT#next()
     */
    @Override
    public LispADT next() {
        if (curr != tail) {
            curr = curr.next();
        }
        // currPos++;
        return this;
    }

    /*
     * (non-Javadoc)
     * 
     * @see LispADT#prev()
     */
    @Override
    public LispADT prev() {
        if (head.next() == curr) {
            return this;
        }
        Node temp = head;
        while (temp.next() != curr) {
            temp = temp.next();
        }
        curr = temp;
        // currPos--;
        return this;
    }

    /*
     * (non-Javadoc)
     * 
     * @see LispADT#remove()
     */
    @Override
    public LispADT remove() {
        if (curr == tail) {
            return this;
        }
        curr.setElement(curr.next().element());
        if (curr.next() == tail) {
            tail = curr;
        }
        curr.setNext(curr.next().next());
        listSize--;
        return this;
    }

    /*
     * (non-Javadoc)
     * 
     * @see LispADT#size()
     */
    @Override
    public Integer size() {
        return listSize;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        String s = "< ";
        Node temp;
        boolean stuff = false;
        if (curr == head.next()) {
            temp = head.next();
            s += "| ";
            stuff = true;
        }
        else {
            temp = head.next();
        }

        while (temp != tail) {

            s += temp.element() + " ";

            if (temp.next() == curr && !stuff) {
                s += "| ";
            }
            else if (temp.next() == tail) {
                s += "";
            }
            else {
                s += ", ";
            }
            temp = temp.next();

        }
        s += ">";
        return s;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return obj.toString().equals(this.toString());
    }
}
