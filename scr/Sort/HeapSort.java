package Sort;

public class HeapSort implements SortInterface{

    public HeapSort(int[] array) {
        this.sort(array);
    }

    @Override
    public void sort(int[] array) {
        buildMaxHeap(array);
        int size = array.length;

        for (int i = array.length - 1; i > 0; i--) {
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;
            size--;
            heapify(array, size, 0);
        }
    }

    public void buildMaxHeap(int[] array) {
        for (int i = (array.length/2) - 1; i >= 0; i--) {
            heapify(array, array.length, i);
        }
    }

    public void heapify(int[] array, int size, int root) {
        if (2 * root + 1 <= size - 1) {
            int leftChild = 2 * root + 1;
            int rightChild = 2 * root + 2;
            int largerChild = -1;

            if (2 * root + 2 > size - 1) {
                largerChild = leftChild;
            } else if (array[leftChild] >= array[rightChild]) {
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
}
