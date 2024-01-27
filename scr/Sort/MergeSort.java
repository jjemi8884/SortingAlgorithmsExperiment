package Sort;

import java.util.Arrays;

public class MergeSort implements SortInterface {

//    /**
//     * Uses the passed in array and calls a sort on it
//     * @param arrayOfInts an array of integers
//     */
//    public MergeSort(int[] arrayOfInts) {
//        this.sort(arrayOfInts);
//    }


    /**
     * The main call to sort the given array of integers
     *
     * @param array of integers to be sorted.
     */
    @Override
    public void sort(int[] array) {
        // base case
        if (array.length >= 2) {

            int mid = array.length / 2;
            int[] leftHalf = Arrays.copyOfRange(array, 0, mid);
            int[] rightHalf = Arrays.copyOfRange(array, mid , array.length);
            // recursively calls a new "half split" onto both halves
            sort(leftHalf);
            sort(rightHalf);
            // takes those new "halves" and merges them, while sorting
            mergeArrays(leftHalf, rightHalf, array);

        }
    }

    /**
     * A recursive helper method, used for merging split arrays and sorting them
     * @param leftSide left half of a split
     * @param rightSide right half of a split
     * @param array reference to the "original" array that was split
     */
    private void mergeArrays(int[] leftSide, int[] rightSide, int[] array) {
            int leftIdx = 0;
            int rightIdx = 0;

            // keep going while there are still elements in both that can be compared
            while (leftIdx < leftSide.length && rightIdx < rightSide.length) {
                //if the element in the left-side array is less than what's in the right, set the next slot to left
                // side's current value
                if (leftSide[leftIdx] <= rightSide[rightIdx]) {
                    array[leftIdx + rightIdx] = leftSide[leftIdx];
                    leftIdx++;
                    // right is smaller so do the opposite
                } else {
                    array[leftIdx + rightIdx] = rightSide[rightIdx];
                    rightIdx++;
                } // end else
            } // end while

            // add remaining elements of leftSide to the array
            while (leftIdx < leftSide.length) {
                array[leftIdx + rightIdx] = leftSide[leftIdx];
                leftIdx++;
            }
            // add remaining elements of rightSide to the array
            while (rightIdx < rightSide.length) {
                array[leftIdx + rightIdx] = rightSide[rightIdx];
                rightIdx++;
            }

    } // end mergeArrays


}
