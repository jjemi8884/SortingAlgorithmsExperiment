package SortTester;
import java.util.Iterator;

/***
 * Node to use with the TestResultMatrix for storing individual sorting class test
 * results for speed trials
 */
public class SortingClassNode<T> implements Iterable<Integer> {
    /**
     * array to hold test results
     */
    private Integer [] timeResults;
    /**
     * string to hold name of test
     */
    private String sortClassName;
    /**
     * variable to track place in test results.
     */
    private int currentTest;

    /**
     * default constructor for the node
     * used the default value of 70 test
     * @param name name of sorting class
     */
    public SortingClassNode(String name){
        this(name, 70);
    }//end constructor

    /**
     * The main constructor that will allow the variation of
     * the number of tests that will be conducted.
     * @param name of the sorting class
     * @param numOfTest to be conducted
     */
    public SortingClassNode(String name, int numOfTest){
        this.sortClassName = name;
        this.timeResults = new Integer[numOfTest];
        this.currentTest = 0;
    }//end constructor

    /**
     * getter for the class name
     * @return class name
     */
    public String getName(){
        return this.sortClassName;
    }//end getName

    /**
     * A getter for the current test number
     * @return test number, not the array index of the test
     */
    public int getNumberTest(){
        return this.currentTest + 1;
    }//end getNumberTest

    /**
     * Method to add the current test to the array for record keeping
     * @param score the integer of the score
     */
    public void addScore(int score){
        //System.out.println(currentTest);
        this.timeResults[currentTest] = score;
        currentTest++;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     * @return an Iterator.
     */
    @Override
    public Iterator<Integer> iterator() {
        return new IteratorForSortNode();
    }//end Iterator

    /**
     * getIterator call
     * @return iterator object
     */
    public Iterator<Integer> getIterator(){
        return iterator();
    }//end

    /**
     * Easy way to print test results the command line.
     * @return the string to print or save in file.
     */
    public String toString(){
        Iterator<Integer> itr = this.iterator();
        StringBuilder result = new StringBuilder();
        result.append("For class " + this.sortClassName);
        result.append("\nHere are the results");
        result.append("\n+++++++++++++++++++++\n");
        while(itr.hasNext()){
            result.append(itr.next() + ", " );
        }//end while
        return result.toString();
    }//end toString()

    private class IteratorForSortNode implements Iterator<Integer> {
        private int nextIndex;

        /**
         * constructor for the iterator to return test results
         */
        private IteratorForSortNode() {
            this.nextIndex = 0;
        }//end constructor

        /**
         * will show is there is another test result
         * @return
         */
        public boolean hasNext() {
            return nextIndex <= timeResults.length -1 ;
        }//end hasNext

        /**
         * The next call for the iterator
         * will return the next integer until no more integers are
         * available. It will be on the client program to verify if a
         * next is available or not.
         * @return
         */
        public Integer next(){
            Integer result = timeResults[nextIndex];
            this.nextIndex++;
            return result;
        }//end next
    }//end iterator class
}
