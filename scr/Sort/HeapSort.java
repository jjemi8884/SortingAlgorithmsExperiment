package Sort;

public class HeapSort implements SortInterface{

    public HeapSort(int[] array) {
        this.sort(array);
    }

    @Override
    public void sort(int[] array) {

    }

    public void buildMaxHeap(int[] array) {

    }

    public void heapify(int[] array, int size, int root) {
        int leftChild = 2 * root + 1;
        int rightChild = 2 * root + 2;
        int largerChild = -1;
        //TODO: logic for seeing if the parent has two children or not
        if (array[leftChild] >= array[rightChild]) {
            largerChild = leftChild;
        } else {
            largerChild = rightChild;
        }

        if (array[largerChild] > array[root]) {
            int temp = array[root];
            array[root] = array[largerChild];
            array[largerChild] = temp;
            heapify(array, size, largerChild);
        }
    }
}
