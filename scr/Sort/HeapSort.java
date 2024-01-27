package Sort;

public class HeapSort implements SortInterface{

//    /**
//     * Will call the sort method with the passed in array
//     * @param array array of integers to be sorted
//     */
//    public HeapSort(int[] array) {
//        this.sort(array);
//    }// end HeapSort constructor

    /**
     * The main call to sort the given array of integers
     * @param array of integers to be sorted.
     */
    @Override
    public void sort(int[] array) {
        // creates max heap from unsorted array
        buildMaxHeap(array);
        int size = array.length;

        // swap last leaf node and root node of max heap, remove the last node,
        // then heapify the root node of the heap
        for (int i = array.length - 1; i > 0; i--) {
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;
            size--;
            heapify(array, size, 0);
        } // end for
    } // end sort

    /**
     * Creates a max heap from an unsorted array by calling heapify each non-leaf node
     * @param array of integers to be sorted
     */
    public void buildMaxHeap(int[] array) {
        // loop through each non-leaf node, starting with the last, and heapify each
        for (int i = (array.length/2) - 1; i >= 0; i--) {
            heapify(array, array.length, i);
        } // end for
    }// end buildMaxHeap

    /**
     * Performs heapify on the given node, swaping nodes so that it resembles a max heap
     * @param array of integers to be sorted
     * @param size current size of the heap
     * @param root the root node of the given heap
     */
    public void heapify(int[] array, int size, int root) {
        // check if current root node has any children
        if (2 * root + 1 <= size - 1) {
            // set indexes of left and right children
            int leftChild = 2 * root + 1;
            int rightChild = 2 * root + 2;
            int largerChild = -1;

            // check if root has a right child, if not set larger child to left child
            if (2 * root + 2 > size - 1) {
                largerChild = leftChild;
            // find which child has a larger int value, and set it to larger child to that child
            } else if (array[leftChild] >= array[rightChild]) {
                largerChild = leftChild;
            } else {
                largerChild = rightChild;
            } // end if

            // if the larger child is larger than it's parent node, swap those node's values,
            // and then heapify the larger child node
            if (array[largerChild] > array[root]) {
                int temp = array[root];
                array[root] = array[largerChild];
                array[largerChild] = temp;
                heapify(array, size, largerChild);
            } // end if
        } // end if
    } // end heapify
}
