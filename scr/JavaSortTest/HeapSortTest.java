package JavaSortTest;

import Sort.HeapSort;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HeapSortTest {

    @Test
    void sort() {
        HeapSort heapSort = new HeapSort();
        int[] testArray = new int[70];
        for (int i = 0; i < testArray.length; i++) {
            testArray[i] = testArray.length - 1 - i;
        }
        heapSort.sort(testArray);
        assertEquals(0, testArray[0]);
        assertEquals(69, testArray[69]);
    }

    @Test
    void buildMaxHeap() {
        HeapSort heapSort = new HeapSort();
        int[] testArray = new int[70];
        for (int i = 0; i < testArray.length; i++) {
            testArray[i] = i;
        }
        heapSort.buildMaxHeap(testArray);
        assertEquals(69, testArray[0]);
    }

    @Test
    void heapify() {
        HeapSort heapSort = new HeapSort();
        int[] testArray = new int[70];
        for (int i = 0; i < testArray.length; i++) {
            testArray[i] = i;
        }
        heapSort.buildMaxHeap(testArray);
        int temp = testArray[0];
        testArray[0] = testArray[69];
        testArray[69] = temp;
        heapSort.heapify(testArray, testArray.length - 1, 0);
        assertEquals(68, testArray[0]);
    }
}