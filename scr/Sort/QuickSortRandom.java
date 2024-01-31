package Sort;

import java.util.Random;

public class QuickSortRandom implements SortInterface{

    /**
     * The main call to sort the given array of integers
     * @param array of integers to be sorted.
     */
    @Override
    public void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    /**
     * Method to recursively call to further quicksort the left and right side of pivot index
     * @param array to be sorted
     * @param low index of current sub-array
     * @param high index of current sub-array
     */
    private void sort(int[] array, int low, int high) {
        // exit if low index is greater than or equal to high index
        if (low < high) {
            //determine pivot index, and recursively call same method for
            //lower and upper sub-arrays
            int pivot = partitioning(array, low, high);
            sort(array, low, pivot - 1);
            sort(array, pivot + 1, high);
        }
    }

    /**
     * Determines pivot value, and then ensures that value is in the correct position
     * with all numbers less below, and all numbers greater above
     * @param array to be sorted
     * @param low index of sub-array
     * @param high index of sub-array
     * @return index of pivot value
     */
    private int partitioning(int[] array, int low, int high) {
        //Randomly determine pivot index and swap the pivot value with the high value
        Random random = new Random();
        int pivot = random.nextInt((high - low) + 1) + low;
        swap(array, high, pivot);

        int pivotValue = array[high];
        int leftIndex = low - 1;

        // Iterate through array, putting numbers less than or equal to the pivot
        // value to the left side of the array
        for (int i = low; i < high; i++) {
            if (array[i] <= pivotValue) {
                leftIndex++;
                swap(array, leftIndex, i);
            }
        }

        // Put the pivot value into it's correct index and return that index
        swap(array, leftIndex + 1, high);
        return leftIndex + 1;
    }

    /**
     * Swap the values at the given indexes in the given array
     * @param array of integers
     * @param index1 to be swapped
     * @param index2 to be swapped
     */
    private void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
