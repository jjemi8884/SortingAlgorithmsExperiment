package Sort;

public class SelectionSort implements SortInterface{

    /**
     * Uses the passed in array to call sort on the integers
     * @param array an array of integers
     */
    public SelectionSort(int[] array) {
        this.sort(array);
    }

    /**
     * The main call to sort the given array of integers
     *
     * @param array of integers to be sorted.
     */
    @Override
    public void sort(int[] array) {

        for (int idx = 0; idx < array.length - 1; idx++) {
            int minIdx = idx;

            // inner for loop searches for the "next smallest" element
            for (int idx2 = idx + 1 ; idx2 < array.length; idx2++) {
                if (array[idx2] < array[minIdx]) {
                    minIdx = idx2;
                } // end if statement
            } // end inner for loop

            // swaps the index of true minimum value with the original minIdx
            int minVal = array[minIdx];
            array[minIdx] = array[idx];
            array[idx] = minVal;
        } // end outer for loop
    } // end sort method

} // end class
