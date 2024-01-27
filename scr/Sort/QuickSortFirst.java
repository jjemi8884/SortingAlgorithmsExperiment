package Sort;

public class QuickSortFirst implements SortInterface{

//    /**
//     * Calls a quick sort onto the passed in array
//     * @param intArray array of integers
//     */
//    public QuickSortFirst(int[] intArray) {
//        this.sort(intArray);
//    }


    /**
     * The main call to sort the given array of integers
     *
     * @param array of integers to be sorted.
     */
    @Override
    public void sort(int[] array) {
        quickSort(array, 0, array.length-1);
    }

    /**
     * A recurisive method that does the bulk of the quick sort, partitioning itself as needed to sort the array
     * @param array array to be sorted/partitioned
     * @param lowPoint the lowest index of the array
     * @param highPoint the highest index of the array
     */
    public void quickSort(int[] array, int lowPoint, int highPoint) {
        if (lowPoint < highPoint) {
            int pivotIdx = partition(array, lowPoint, highPoint);
            quickSort(array, lowPoint, pivotIdx - 1);
            quickSort(array, pivotIdx + 1, highPoint);

        }
    }

    /**
     * Sorts an array by determining the low points, high points, and the current pivot to make swap indices
     * @param array array to be sorted
     * @param lowPoint lowest index of the array
     * @param highPoint highest index of the array
     * @return index of where the pivot ended up, since our pivot is chosen as the first element in our method
     */
    public int partition(int[] array, int lowPoint, int highPoint) {
        int pivot = array[lowPoint];
        int leftPointer = lowPoint;

        // start loop from the val after the pivot, search for swaps
        for (int idx = lowPoint + 1; idx <= highPoint; idx++) {
            if (array[idx] < pivot) {
                int temp = array[idx];
                array[idx] = array[leftPointer + 1];
                array[leftPointer +  1] = temp;

                leftPointer++;
            }
        } // end for loop

        // moves around the pivot so that elements to the left are smaller, ensures pivot is at correct position
        int temp = array[lowPoint];
        array[lowPoint] = array[leftPointer];
        array[leftPointer] = temp;

        return leftPointer;
    } // end method
} // end class
