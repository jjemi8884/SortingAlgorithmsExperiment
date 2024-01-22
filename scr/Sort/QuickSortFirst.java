package Sort;

public class QuickSortFirst implements SortInterface{

    public QuickSortFirst(int[] intArray) {
        this.sort(intArray);
    }


    /**
     * The main call to sort the given array of integers
     *
     * @param array of integers to be sorted.
     */
    @Override
    public void sort(int[] array) {

    }

    public void quickSort(int[] array, int lowPoint, int highPoint) {
        if (lowPoint < highPoint) {
            int pivotIdx = partition(array, lowPoint, highPoint);
            quickSort(array, lowPoint, pivotIdx);
            quickSort(array, pivotIdx + 1, highPoint);

        }
    }

    public int partition(int[] array, int lowPoint, int highPoint) {
        int pivot = array[lowPoint];
        int leftPoint = lowPoint;

        for (int idx = lowPoint; idx <= highPoint; idx++) {

        }

    }
}
