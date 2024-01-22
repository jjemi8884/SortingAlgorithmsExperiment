package Sort;

import java.util.Arrays;

public class MergeSort implements SortInterface {

    public MergeSort(int[] arrayOfInts) {
        this.sort(arrayOfInts);
    }


    /**
     * The main call to sort the given array of integers
     *
     * @param array of integers to be sorted.
     */
    @Override
    public void sort(int[] array) {
        if (array.length >= 2) {

            int mid = array.length / 2;
            int[] leftHalf = Arrays.copyOfRange(array, 0, mid);
            int[] rightHalf = Arrays.copyOfRange(array, mid , array.length);
            sort(leftHalf);
            sort(rightHalf);

            mergeArrays(leftHalf, rightHalf, array);

        }
    }

    private void mergeArrays(int[] leftSide, int[] rightSide, int[] temp) {
            int leftIdx = 0;
            int rightIdx = 0;

            while (leftIdx < leftSide.length && rightIdx < rightSide.length) {
                if (leftSide[leftIdx] <= rightSide[rightIdx]) {
                    temp[leftIdx + rightIdx] = leftSide[leftIdx];
                    leftIdx++;
                } else {
                    temp[leftIdx + rightIdx] = rightSide[rightIdx];
                    rightIdx++;
                }
            }

            while (leftIdx < leftSide.length) {
                temp[leftIdx + rightIdx] = leftSide[leftIdx];
                leftIdx++;
            }

            while (rightIdx < rightSide.length) {
                temp[leftIdx + rightIdx] = rightSide[rightIdx];
                rightIdx++;
            }

    }


}
