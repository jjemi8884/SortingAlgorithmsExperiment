package Sort;

public class InsertionSort implements SortInterface {

    /**
     * Uses the passed in array to call a sort on the integers
     * @param array an array of integers
     */
    public InsertionSort(int[] array) {
        this.sort(array);
    }


    /**
     * The main call to sort the given array of integers
     *
     * @param array of integers to be sorted.
     */
    @Override
    public void sort(int[] array) {
        // iteratively goes through array, sorting elements one by one
        for (int idx = 1; idx < array.length; idx++) {
            int currentVal = array[idx];
            int precedingIdx = idx - 1;
            // moves current element to correct sorted place, going backwards until correct place
            while (precedingIdx >= 0 && array[precedingIdx] > currentVal) {
                array[precedingIdx + 1] = array[precedingIdx];
                precedingIdx--;
            } // end while loop
            array[precedingIdx + 1] = currentVal;
        } // end for loop


    }  // end sort method
} // end class
