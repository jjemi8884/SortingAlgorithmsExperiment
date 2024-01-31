package SortTester;

import Sort.*;

import java.util.ArrayList;

public class TestImplementer {

    // Holds each sorting algorithm
    private SortInterface[] sortingAlgorithms;

    // Instantiation of test generator
    private TestGenerator testGenerator;

    // Instantiation of test result matrix
    private TestResultMatrix testResultMatrix;

    /**
     * Instantiates each sorting algorithm into the array, and sets instance variables
     * @param testGenerator instance of testGenerator
     * @param testResultMatrix instance of testResultMatrix
     */
    public TestImplementer(TestGenerator testGenerator, TestResultMatrix testResultMatrix) {
        sortingAlgorithms = new SortInterface[12];
        sortingAlgorithms[0] = new InsertionSort();
        sortingAlgorithms[1] = new SelectionSort();
        sortingAlgorithms[2] = new BubbleSort();
        sortingAlgorithms[3] = new ShellSort();
        sortingAlgorithms[4] = new MergeSort();
        sortingAlgorithms[5] = new QuickSortFirst();
        sortingAlgorithms[6] = new QuickSortRandom();
        sortingAlgorithms[7] = new QuickSortMo3();
        sortingAlgorithms[8] = new HeapSort();
        sortingAlgorithms[9] = new Counting();
        sortingAlgorithms[10] = new BucketSort();
        sortingAlgorithms[11] = new RadixSort();

        this.testGenerator = testGenerator;
        this.testResultMatrix = testResultMatrix;
    }

    /**
     * Performs a trail for each sorting algorithm with all 70 test arrays, and
     * gives the results to the test result matrix
     */
    public void performTest() {
        // Iterate through each sorting algorithm
        for (SortInterface sortingClass: sortingAlgorithms) {
            String name = sortingClass.getClass().getName();
            name = name.substring(5,name.length());
            // Get a new list of 70 test arrays
            ArrayList<int[]> testArrays = testGenerator.getCloneArrayList();
            // Iterate through each test array
            for (int[] array: testArrays) {
                // Record start time
                long startTime = System.nanoTime();
                // Perform the sort
                sortingClass.sort(array);
                // Record end time and calculate time in microseconds
                long endTime = System.nanoTime();
                long timeElapsed = (endTime - startTime);
                // Set time to -1 if sort was not successful
                if (!confirmSort(array)) {
                    timeElapsed = -1;
                }
                // Give results to test result matrix
                testResultMatrix.addResult(name, (int)timeElapsed);
            }
        }
    }

    /**
     * Checks that the array was sorted
     * @param array to check
     * @return {@code true} if the array has been sorted
     */
    public boolean confirmSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
