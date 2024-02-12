package JavaSortTest;

import static org.junit.jupiter.api.Assertions.*;

import Sort.BubbleSort;
import org.junit.jupiter.api.Test;


class BubbleSortTest {

    @Test
    void sort() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] testArray = new int[70];
        for (int i = 0; i < testArray.length; i++) {
            testArray[i] = testArray.length - i - 1;
        }
        bubbleSort.sort(testArray);
        assertEquals(0, testArray[0]);
        assertEquals(69, testArray[69]);
    }
}