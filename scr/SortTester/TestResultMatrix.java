package SortTester;

import java.io.FileWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.io.File;
import java.io.IOException;

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
        this(12);
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
        //System.out.println(name + " " + score);
        SortingClassNode n = getSortClass(name);
        n.addScore(score);
    }//end add Result

    /**
     * A getter for indexed sorting classes
     * @param name of the sorting class you want
     * @return the sorting class
     */
    public SortingClassNode getSortClass(String name){
        for(int i = 0; i < sortingClasses.length; i++){
            if(name.compareTo(sortingClasses[i].getName())== 0){
                return sortingClasses[i];
            }//end if
        }
        return null;
    }//end getSortClass

    /**
     * Method to get the result from a called class to be return
     * as an interation
     * @param name of the class node for the results
     * @return the iterator for node
     */
    public Iterator getResultsIterator(String name){
        SortingClassNode s = this.getSortingClass(name);
        return s.iterator();
    }//end getResultsIterator

    /**
     * Method to return an array list with all the results from the test.
     * @param name is the name of the class being tested
     * @return the arraylist with the test results inside
     */
    public ArrayList<Integer> getListResults(String name){
        ArrayList<Integer> a = new ArrayList<>();
        Iterator iter = getResultsIterator(name);
        while(iter.hasNext()){
            a.add((Integer) iter.next());
        }//end while
        return a;
    }//end getListResults

    /**
     * Method that will generate the file that can be used to
     * create the graphs for comparing run times.
     */
    public void fileGenerator() throws IOException {
        File testsR = new File("TestResults/Test_Results_Sort_Algorithms");
        try {
            if (testsR.createNewFile()){
                System.out.println("File is created: " );
            } else {
                System.out.println("File updated");
            }//end if
        } catch (IOException e){
            System.out.println("unable to create/write to file error occurred");
            e.printStackTrace();
        }//end try
        FileWriter writeTest = new FileWriter("TestResults/Test_Results_Sort_Algorithms");
        writeFile(writeTest);
    }

    /**
     * Methode to write to the give file the results of the test
     * @param f file object
     * @return boolean value if the writing was successful
     */
    private boolean writeFile(FileWriter f) throws IOException {
        boolean success = false;
        Iterator<SortingClassNode> sortMethod = this.sortIterator();
        int count = 1;
        while(sortMethod.hasNext()){
            SortingClassNode scn = sortMethod.next();
            String name = scn.getName();
            ArrayList<Integer> results = this.getListResults(name);
            f.write(name + "\n");
            int numTest = 0;
            ArrayList<String> test = getTestNames();
            StringBuilder nums = new StringBuilder();
            //Test #1: 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14
            for(int j = 0; j < 5; j++){
                nums.append(test.get(numTest));
                for(int i = j * 14; i < j * 14 + 14 ; i++) {
                    double number = results.get(i) / 1000.0;
                    nums.append(number + ", ");
                }//end for
                nums.append("\n");
                numTest++;
            }//end for
            f.write(nums.toString());
        }//end while
        f.close();
        System.out.println("Success, Test results saved");
        return true;
    }

    /**
     * This method is to get the test names to be placed in the
     * output report
     * @return ArrayList with the names of the test.
     */
    public ArrayList<String> getTestNames(){
        ArrayList<String> s = new ArrayList<>();
        s.add("Random ,");
        s.add("50% Sorted ,");
        s.add("75% Sorted ,");
        s.add("Full Sorted ,");
        s.add("Sorted in Reverse ,");
        return s;
    }//end getTestNames

    /**
     * Method that will recall the sorting class by name and return that sorting class node
     * @param name is the name of the sorting class
     * @return the sorting class node
     */
    public SortingClassNode getSortingClass(String name){
        for(int i = 0; i < sortingClasses.length; i++){
            if(sortingClasses[i].getName().equals(name)){
                return sortingClasses[i];
            }//end if
        }//end for
        return null;
    }//end getSortingClass

    /**
     * An iterator for the individual sorting classes
     * @return the iterator object
     */
    public Iterator<SortingClassNode> sortIterator(){
        return new SortClassIterator();
    };

    /**
     * Returns an iterator over elements of type {@code T}.
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
