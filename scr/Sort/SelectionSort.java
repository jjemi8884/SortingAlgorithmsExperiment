package Sort;

public class SelectionSort implements SortInterface{

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

            for (int idx2 = idx + 1 ; idx2 < array.length; idx2++) {
                if (array[idx2] < array[minIdx]) {
                    minIdx = idx2;
                }
            }

            int minVal = array[minIdx];
            array[minIdx] = array[idx];
            array[idx] = minVal;
        }
    }

}
