package SortTester;

import java.util.Arrays;
import java.util.Random;

public class CreateArrays implements CreateArraysInterface {

    // originalArray that contains all the values
    private int[] originalArray;
    // clone to ensure if original is sorted, the rest are not impacted
    private int[] cloneArray;

    /**
     * Constructor for the class, used to specify size and create the original array
     * @param arraySize
     */
    public CreateArrays(int arraySize) {
        createOriginalArray(arraySize);
        cloneArray = Arrays.copyOf(originalArray, originalArray.length);
    }

    public CreateArrays() {
        this(4);
    }

    /**
     * Creates an array of specified size, with random integers 0 - 40,000 populating it
     * @param arraySize size of the array
     */
    @Override
    public void createOriginalArray(int arraySize) {
        originalArray = new int[arraySize];
        Random randGenerator = new Random();
        for (int idx = 0; idx < originalArray.length; idx++){
            originalArray[idx] = randGenerator.nextInt(0, 40001);
        }
    }

    /**
     * Creates a copy of the clone array, and sorts it
     * @return sorted copy of the original array
     */
    @Override
    public int[] sortedArray() {
        int[] sortedArray = Arrays.copyOf(cloneArray, cloneArray.length);
        Arrays.sort(sortedArray);
        return sortedArray;
    }

    /**
     * Creates a copy of the clone array, sorts it from 0 til the midway point, leaving the rest unsorted
     * @return half-sorted copy of the original array
     */
    @Override
    public int[] halfSortedArray() {
        int midPoint = originalArray.length / 2;
        int[] halfSortedArray = Arrays.copyOf(originalArray, originalArray.length);
        Arrays.sort(halfSortedArray, 0, midPoint);
        return halfSortedArray;
    }

    /**
     * Creates a copy of the clone array, sorts from 0 til the 3/4 point, leaving the rest unsorted
     * @return 3/4 sorted copy of the original array
     */
    @Override
    public int[] threeFourthSortedArray() {
        int threeFourthPoint = (originalArray.length * 3) / 4;
        int[] threeFourthSortedArray = Arrays.copyOf(originalArray, originalArray.length);
        Arrays.sort(threeFourthSortedArray, 0, threeFourthPoint);
        return threeFourthSortedArray;
    }

    /**
     * Creates a copy of the clone array that is sorted, reversing the indices, so it is in descending order
     * @return a copy of the array in descending order
     */
    @Override
    public int[] reverseOrder() {
        int[] tempSorted = sortedArray();
        int arrayLength = tempSorted.length;
        int[] reversedArray = new int[arrayLength];

        for  ( int idx = 0; idx < arrayLength; idx++) {
            reversedArray[idx] = tempSorted[arrayLength - 1 - idx];
        }

        return reversedArray;
    }

    /**
     * Retrieves the original unsorted array
     * @return initial unsorted array
     */
    @Override
    public int[] getOriginalArray() {
        return originalArray;
    }

}
