package Sort;

public class InsertionSort implements SortInterface {

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
        for (int idx = 1; idx < array.length; idx++) {
            int currentVal = array[idx];
            int precedingIdx = idx - 1;

            while (precedingIdx >= 0 && array[precedingIdx] > currentVal) {
                array[precedingIdx + 1] = array[precedingIdx];
                precedingIdx--;
            }
            array[precedingIdx + 1] = currentVal;
        }


    }
}
