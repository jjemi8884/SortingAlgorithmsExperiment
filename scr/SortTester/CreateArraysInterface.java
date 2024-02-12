package SortTester;

public interface CreateArraysInterface {

    /**
     * Creates an array of specified size, with random integers 0 - 40,000 populating it
     * @param arraySize size of the array
     */
    void createOriginalArray(int arraySize);

    /**
     * Creates a copy of the clone array, and sorts it
     * @return sorted copy of the original array
     */
    int[] sortedArray();
    /**
     * Creates a copy of the clone array, sorts it from 0 til the midway point, leaving the rest unsorted
     * @return half-sorted copy of the original array
     */
    int[] halfSortedArray();

    /**
     * Creates a copy of the clone array, sorts from 0 til the 3/4 point, leaving the rest unsorted
     * @return 3/4 sorted copy of the original array
     */
    int[] threeFourthSortedArray();

    /**
     *  Creates a copy of the clone array that is sorted, reversing the indices, so it is in descending order
     * @return a copy of the array in descending order
     */
    int[] reverseOrder();


    /**
     * Retrieves the original unsorted array
     * @return initial unsorted array
     */
    int[] getOriginalArray();
}
