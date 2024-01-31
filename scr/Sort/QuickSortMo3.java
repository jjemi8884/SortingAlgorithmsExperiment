package Sort;

import java.time.chrono.MinguoDate;

public class QuickSortMo3 implements SortInterface{

    /**
     * Used for setting the size for when the insertion sort will take over from
     * the quick sort. The lowest it can go is four, were it is not recommended to go above 10.
     */
    private static final int MAX_SIZE = 10;

    /**
     * Helper method for the recursive sort call
     * @param array of integers to be sorted.
     */
    public void sort(int [] array){
        this.sort(0, array.length-1, array);
    }

    /**
     * The main call to sort the given array of integers
     * it first sees if the array is smaller than 4 then, if it
     * is then the pivot method is not used and an insertion sort is used
     * instead. The size of the array is dictated by the global variable MAX_SIZE.
     * This is something to play around with and maybe can incorporate it into the constructor.
     * BigO(n log n)
     * @param array of integers to be sorted.
     */
    private void sort(int first, int last, int[] array) {
        if((last - first) + 1 < MAX_SIZE) {
            insertionSort(first, last, array);
        }else{
            int pivotIndex = pivotSort(first, last, array);
            sort(first, pivotIndex - 1, array);
            sort(pivotIndex + 1, last, array);
        }//end if
    }//end sort

    /**
     * This method will take a pivot and sort all items less than the pivot to the left.
     * All items that are larger than the pivot to the right and reinsert the pivot
     * in its correct spot in the array by swapping with the next large number.
     * @param firstIndex cannot equal zero and less than the last index
     * @param lastIndex less than array length - 1
     * @param array the pointer to the array that we are sorting
     * @return the index to the pivot that we insert back in the array at the correct spot.
     */
    private int pivotSort(int firstIndex, int lastIndex, int [] array){
        int pivotIndex = (firstIndex + lastIndex)/2;
        mOThree(firstIndex,pivotIndex, lastIndex, array);

        //putting the pivot in the second to last entry!
        swap(pivotIndex, lastIndex -1, array);
        //assume the last index is already in the larger group due to Mo3
        int fromLeftIndex  = firstIndex + 1; // start at +1 because we know the pivot is larger form Mo3
        int fromRightIndex = lastIndex - 2;
        pivotIndex = lastIndex - 1;
        int pivotValue = array[pivotIndex];
        boolean done = false;

        //iterate the array finding the highs and lows to swap
        while(!done) {

            //move the fromLeftIndex right until find a value higher than pivot
            //should find one since it is
            while (pivotValue > array[fromLeftIndex]) {
                fromLeftIndex++;
            }//end while

            while (array[fromRightIndex] > pivotValue) {
                fromRightIndex--;
            }//end while

            if (fromLeftIndex < fromRightIndex) {
                swap(fromLeftIndex, fromRightIndex, array);
                fromLeftIndex++;
                fromRightIndex--;
            } else {
                done = true;
            }//end if
        }//end while
        swap(pivotIndex, fromLeftIndex, array);
        pivotIndex = fromLeftIndex;
        return pivotIndex;
    }//end pivot sort

    /**
     * Method to print the array for troubleshooting
     * @param array is the array to print out in a single line
     */
    public static void printArray(int [] array){
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i] + ", ");
        }//end for
        System.out.println();
    }//end printArray

    /**
     * Method to inset in order because it is not wise to do the quicksort with less than four elements.
     * @param first index of an array
     * @param last index of the array
     * @param array to be sorted.
     */
    private void insertionSort(int first, int last, int array []){
       for(int unsorted = first + 1; unsorted <= last; unsorted++){
           int nextNumberToInsert = array[unsorted];
           insertInOrder(nextNumberToInsert,first, unsorted - 1, array);
       }//for loop
    }//end insertionSort

    /**
     * private method to be used for insertion sort when the array partition is less than 4
     * @param firstIndex index in the array
     * @param lastIndex index in the array
     * @param array the array pointer for reference
     */
    private void insertInOrder(int value, int firstIndex, int lastIndex, int [] array){
        //take the last index and make room to insert
        int currentIndex = lastIndex;

        while(currentIndex >= firstIndex && value < array[currentIndex]){
            array[currentIndex + 1] = array[currentIndex];
            currentIndex--;
        }//end while
        array[currentIndex + 1] = value;
    }//end instertInOrder

    /**
     * This method will choose the first, middle and last index of an array
     * identify which of the three numbers are the median, then shift that pivot to the last index.
     * All the while ordering the arrays in the correct order.
     * Precondition - This assumes that there are at least three elements in the array.
     * @param array of integers
     */
    private void mOThree(int first, int middle, int last, int [] array){
        if(array[last] < array[first]) {
            swap(last, first, array);
        }//end if
        //known that first is smaller or last and first are the same
        if(array[middle] < array[first]){
            swap(middle, first, array);
        }//end if
        //know that middle is smaller than first, or they are the same
        if(array[middle] > array[last]) {
            swap(middle, last, array);
        }//end if
        //know that middle array is smaller that last array
    }//end mOThree

    /**
     * Method to easily swap elements in an array with BigO(1)
     * @param first element to be swapped
     * @param second element to be swapped
     * @param array the array to swap the elements
     */
    private void swap(int first, int second, int [] array){
       int temp = array[second];
       array[second] = array[first];
       array[first] = temp;
    }//end swap
}//end class
