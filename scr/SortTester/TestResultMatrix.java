package SortTester;

import java.util.Iterator;

/**
 * This class is designed to work with Test Implementer and test generator
 * It is to store the results of the test and output results to a file for further
 * Study. Inputs will be the sorting name, test name, and the results of the sorting test in long integer
 * format. I will create a separate class to store each type of sorting class results.
 */
public class TestResultMatrix implements Iterable<SortingClassNode>{
    /**
     * private array of sorting classes that will hold the
     * test results which can also be printed.
     */
    private SortingClassNode [] sortingClasses;

    private int index;

    /**
     * Default constructor with 14 class available
     */
    public TestResultMatrix(){
        this(14);
    }//end Constructor

    /**
     * the Constructor for the TestResultMatrix
     */
    public TestResultMatrix(int numOfSorts){
        sortingClasses = new SortingClassNode[numOfSorts];
        int index = 0;
    }//end constructor

    /**
     * Method to add new classes to the matrix for tracking.
     * @param name of the sorting class to be tested
     */
    public void addSortClass(String name){
        if(index > sortingClasses.length){
            throw new ArrayIndexOutOfBoundsException("Exceeded test capacity");
        }else {
            SortingClassNode newClass = new SortingClassNode(name);
            sortingClasses[index] = newClass;
            index++;
        }//end if
    }//end add class

    /**
     * Way to add a score to the test matrix,
     * this method will find the right name and place the
     * result in the next avaiable index in the result array.
     * @param name of the sorting class.
     * @param score of the sorting class.
     */
    public void addResult(String name, int score){
        for(int i = 0; i < sortingClasses.length; i++){
            if(name.equals(sortingClasses[i].getName())){
                sortingClasses[i].addScore(score);
            }
        }
    }

    /**
     * A getter for indexed sorting classes
     * @param index of the sorting class you want
     * @return the sorting class
     */
    public SortingClassNode getSortClass(int index){
        return sortingClasses[index];
    }//end getSortClass

    /**
     * A iterator for the individual sorting classes
     * @return the iterator object
     */
    public Iterator<SortingClassNode> sortIterator(){
        return new SortClassIterator();
    };

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<SortingClassNode> iterator() {
        return sortIterator();
    }

    private class SortClassIterator implements Iterator<SortingClassNode>{
        private int index;

        /**
         * Basic constructor for the iterator
         */
        public SortClassIterator(){
            index = 0;
        }//end constructor

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return index < sortingClasses.length;
        }

        /**
         * Returns the next element in the iteration.
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public SortingClassNode next() {
            SortingClassNode s = sortingClasses[index];
            index++;
            return s;
        }
    }




}
