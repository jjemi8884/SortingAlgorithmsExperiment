package Sort;

public class BubbleSort implements SortInterface{
    /**
     * The main call to sort the given array of integers
     * @param array of integers to be sorted.
     */
    @Override
    public void sort(int[] array) {
        //Loop through the array, comparing each adjacent pair, and swapping if
        //the left integer is less than the right integer. Check one less on each
        //time through the array.
        for (int i = array.length - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
