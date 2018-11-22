/**
 * <!-- ASG2
 * 
 * <pre>
 * INSTRUCTIONS FOR READING THIS ASSIGNMENT:
 * 1. Create an Eclipse project for this assignment.
 * 2. Import this file into that project.
 * 3. In Eclipse, right-click the imported file and select Export/Java/JavaDoc
 * 4. Note the destination (look for this in the bottom 1/3 of the dialog box
 * 5. Click Finish
 * 6. Find the index.html file and double click it.
 * </pre>
 * 
 * -->
 * <h1>Asg2: Linked List</h1>
 * <h2>Objectives</h2>
 * <p>
 * <ul>
 * <li>develop your ability to implement a singly linked list given its ADT</li>
 * <li>improve your ability to write JUnit tests</li>
 * <li>improve your ability to write readable code according to best
 * practices</li>
 * </ul>
 * </p>
 * <h2>Introduction</h2>
 * <p>
 * The LispADT defines the API for a list of Objects. Note that a newly created
 * LispADT is EMPTY.
 * </p>
 * <p>
 * An Object stored in a LispADT is called an element. An element is located at
 * a position in the LispADT. One of the elements is the current element. A
 * LispADT has methods to manage its list of elements (details of the methods
 * are given below).
 * </p>
 * <h3>Fluent Programming Style</h3>
 * <p>
 * Note that there are no void methods here. Methods that would normally be void
 * return the this Object so that method calls can be chained. For example:
 * 
 * <pre>
 * Suppose LispADT foo = new LinkedLisp();
 * Then foo.add("a").add("b"); produces the same result as
 * foo.add("a");
 * foo.add("b");
 * </pre>
 * </p>
 * <p>
 * Your task is to implement this ADT, develop a JUnit test class, and document
 * both using Javadoc.
 * </p>
 * <h2>Instructions</h2>
 * <p>
 * <ul>
 * <li>Study the LList.java and Link.java code in the textbook.</li>
 * <li>Your implementation should store Object references.</li>
 * <li>Your implementation should NOT use generics.</li>
 * <li>Write the Javadoc for the JUnit class and the implementation.</li>
 * <li>Write the JUnit tests for the ADT described by this API.</li>
 * <li>Implement, using a SINGLY LINKED LIST, the ADT described by this
 * API.</li>
 * <li>You may NOT use any pre-existing classes that defeat the purposes of this
 * assignment (ex. List, ArrayList, etc.)</li>
 * <li>Submit your files to Web-CAT using the eclipse menu "Project->Submit
 * Assignment..."</li>
 * <li>To see my comments after I've graded your work, or to see your results at
 * any time, login to http://web-cat.cs.vt.edu</li>
 * </ul>
 * </p>
 * <h2>Practical Tips</h2>
 * <p>
 * Develop preliminary JUnit tests before you implement the methods, using the
 * process described in class and the slides. For example, develop tests for a
 * method, implement the method, run the tests. Do this until the method passes
 * the tests. Go on to the next method.
 * </p>
 * <p>
 * Sometimes you may have to implement a little bit as well in order to write
 * your JUnit tests. The process involves switching between JUnit tests and
 * implementation, in order to develop a good understanding of the problems to
 * be solved.
 * </p>
 * </p>
 * <h2>NOTES</h2>
 * <p>
 * <li>Any submission that is not a singly linked list implementation will
 * receive NO CREDIT.</li>
 * <li>Any submission that that uses pre-existing classes like ArrayList will
 * receive NO CREDIT.</li>
 * <li>You may submit as many times as you like until the deadline.</li>
 * <li>The grade of your latest submission will be the one recorded.</li>
 * </ul>
 * </p>
 * <h2>CHECKLISTS</h2>
 * <p>
 * Check that you have done all the following.
 * <table border="1">
 * <tr>
 * <td>DONE?</td>
 * <td>TASK</td>
 * </tr>
 * <tr>
 * <td>.</td>
 * <td>The implementing class for this assignment is named LinkedLisp</td>
 * </tr>
 * <tr>
 * <td>.</td>
 * <td>All methods specified in the ADT are implemented</td>
 * </tr>
 * <tr>
 * <td>.</td>
 * <td>Except for constructors, any non-ADT methods are declared PRIVATE</td>
 * </tr>
 * <tr>
 * <td>.</td>
 * <td>Fields, if any, are declared private</td>
 * </tr>
 * <tr>
 * <td>.</td>
 * <td>Code is formatted as described in piazza</td>
 * </tr>
 * <tr>
 * <td>.</td>
 * <td>Javadoc is present in the implementation and JUnit class headers as well
 * as all non-private fields and ALL methods, as described in piazza</td>
 * </tr>
 * <tr>
 * <td>.</td>
 * <td>Class header javadoc must include a brief description of the class, and
 * the &#64;author and &#64;version tags</td>
 * </tr>
 * </table>
 * </p>
 * <p>
 * Here is a table of some common things I look for when reviewing your code:
 * <a href=
 * "https://piazza-resources.s3.amazonaws.com/j6cf19dpqik109/j7qk5asq32652g/codingcomments20170918.pdf?AWSAccessKeyId=AKIAIEDNRLJ4AZKBW6HA&Expires=1505848559&Signature=lGyzsnCmvrE1r6I%2BGTkCLfoZw70%3D">
 * Coding Comments Table</a>
 * </p>
 * <p>
 * Check that you read and followed these how-to items in piazza.
 * </p>
 * <table border="1">
 * <tr>
 * <td>DONE?</td>
 * <td>TASK</td>
 * </tr>
 * <tr>
 * <td>.</td>
 * <td>Read: how to write JUnit tests</td>
 * </tr>
 * <tr>
 * <td>.</td>
 * <td>Read: how to write readable code (and satisfy Web-CAT's format
 * checks)</td>
 * </tr>
 * <tr>
 * <td>.</td>
 * <td>Read: setup Eclipse for Web-CAT</td>
 * </tr>
 * <tr>
 * <td>.</td>
 * <td>Watch: video: setup eclipse to format your code for Web-CAT</td>
 * </tr>
 * <tr>
 * <td>.</td>
 * <td>Read: submit your assignment to Web-CAT from within Eclipse</td>
 * </tr>
 * <tr>
 * <td>.</td>
 * <td>Video: find formatting or code coverage errors in my source code</td>
 * </tr>
 * </table>
 *
 * @author acsiochi
 * @version 20170919 initial draft
 */
public interface LispADT {

    /**
     * <p>
     * Insert the Object referred to by c into this LispADT at the current
     * position.
     * </p>
     * <h3>Example</h3>
     * 
     * <pre>
     * < a1 , b1 | c1 , d1 >.insert(x) -> < a1 , b1 , | x , c1 , d1 >
     * </pre>
     * 
     * @param c
     *            reference to the Object which is to be inserted
     * @return the changed LispADT
     */
    public LispADT add(Object c);

    /**
     * Return the current position. First position is 0, last possible position
     * is numOfElements (to allow adding after the last element). The current
     * position in an empty list is 0.
     * 
     * <pre>
     * < | >.curPos() -> 0 because
     * < | >.add(x).curPos() -> 0
     * </pre>
     * 
     * @return position of current element
     */
    public Integer curPos();

    /**
     * <p>
     * Return the element at the current position of this LispADT.
     * </p>
     * <h3>Example</h3>
     * 
     * <pre>
     * < a , b | c , d >.get() -> c
     * </pre>
     * 
     * @return the current element
     * @throws RuntimeException
     *             when it is not possible to return the current element
     */
    public Object get() throws RuntimeException;

    /**
     * <p>
     * Move the current position to the given position of this list. Remember
     * that the first position is zero. Problem cases should fail silently and
     * NO changes should be made.
     * </p>
     * <h3>Example</h3>
     * 
     * <pre>
     * < a , b | c , d >.moveTo(0) -> < | a , b , c , d >.
     * </pre>
     * 
     * @param p
     *            the position to move the cursor to
     * @return the possibly changed LispADT
     */
    public LispADT moveTo(Integer p);

    /**
     * <p>
     * Move the current position one element towards the tail of this LispADT.
     * Problem cases should fail silently and NO changes should be made.
     * </p>
     * <h3>Example</h3>
     * 
     * <pre>
     * < a , b | c , d > .next() -> < a , b , c | d >
     * </pre>
     * 
     * @return the possibly changed LispADT
     */
    public LispADT next();

    /**
     * <p>
     * Move the current position one element towards the head of this LispADT.
     * Problem cases should fail silently and NO changes should be made.
     * </p>
     * <h3>Example</h3>
     * 
     * <pre>
     * < a , b | c , d >.prev() -> < a | b , c , d >
     * </pre>
     * 
     * @return the possibly changed LispADT
     */
    public LispADT prev();

    /**
     * <p>
     * Remove the current character from this LispADT. The changed LispADT
     * should be returned. Problem cases should fail silently and NO changes
     * should be made.
     * </p>
     * <h3>Example</h3>
     * 
     * <pre>
     * < a , b | c , d >.remove() -> < a , b , | d >
     * </pre>
     * 
     * @return the possibly changed LispADT
     */
    public LispADT remove();

    /**
     * <p>
     * Determine the number of elements in this list.
     * </p>
     * <h3>Example</h3>
     * 
     * <pre>
     * < a , b | c , d >.length() -> 4.
     * </pre>
     * 
     * @return number of elements in this list
     */
    public Integer size();

    /**
     * <p>
     * Determine if this LispADT is equal to the given LispADT. Two LispADTs are
     * equal if and only if they have the same elements, in the same order, and
     * have the same current element.
     * </p>
     * <h3>Example</h3>
     * 
     * <pre>
     * < a , b | c , d >.equals(< a , b | c , d >) -> true
     * </pre>
     * 
     * @param o
     *            the LispADT to check for equality with this LispADT
     * @return whether it is equal or not
     */
    public boolean equals(Object o);

    /**
     * Get the String representation of this LispADT. The String representation
     * must follow these rules:
     * <ol>
     * <li>starts with a "<" and ends with a ">"</li>
     * <li>each element is preceded by a single space</li>
     * <li>if the element is the previous element, it is followed by " |"</li>
     * <li>all other elements (except the last) are followed by " ,"</li>
     * <li>the last element is followed by a single space</li>
     * </ol>
     * <h3>Examples</h3>
     * 
     * <pre>
     * c is the current element, < a , b | c , d >
     * a is the current element, < | a , b , c , d >
     * current is after the last element < a , b , c , d | >
     * </pre>
     * 
     * @return the LinkedList as a String
     */
    public String toString();

}
