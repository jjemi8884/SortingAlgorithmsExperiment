package Sort;

public class Counting implements SortInterface{

    /**
     * The main call to sort the given array of integers
     * This method is not efficient unless there is a large frequency
     * of numbers.
     * @param array of integers to be sorted.
     */
    @Override
    public void sort(int[] array) {
        //Ensure the array is not empty
        int[] temp= new int [array.length];
        if(array != null) {
            //find the max
            int max = findMax(temp, array);
            //make the new array
            int [] newArray = new int[max + 1];
            countArray(temp, newArray);
            cumulativeSum(newArray);
            sortArray(array, newArray, temp);
        }//end if
    }//end sort

    /**
     * THis method will sort the array into a new array which will use the index
     * and the newArray to in the proper index in the output array
     * @param array    the original array
     * @param newArray the index array
     * @return the new output array
     */
    private void sortArray(int [] array, int [] newArray, int [] oldArray){
        //make a new output array to be copied over
        for(int i = oldArray.length - 1; i == 0; i--){
            int value = oldArray[i];
            int newIndex = newArray[value] - 1;
            newArray[value]--;
            array[newIndex] = value;
        }//end for loop
    }//end sortArray

    /**
     * THis method will update the new arrays with the cumulative sum
     * which will help in finding the index of number int the new array
     * @param newArray to be worked on
     */
    private void cumulativeSum(int [] newArray){
        for(int i = 1; i < newArray.length; i++){
            int oldValue = newArray[i];
            newArray[i]= oldValue + newArray[i -1];
        }//end for
    }//end cumulativeSum

    /**
     * This simple method will simply store the array number into the new arrays index
     * @param array is the current array that we are sorting
     * @param newArray is the new array that has Max + 1 indexes
     */
    private void countArray(int [] array, int [] newArray){
        for(int i = 0; i < array.length; i++){
            int aIndex = array[i];
            if(newArray[aIndex] > 1){
                newArray[aIndex]++;
            }else{
                newArray[aIndex] = 1;
            }//end if
        }//end for
    }//end countArray

    /**
     * This private method will find and return the max number of the array
     * This will also clone the array for manipulation.
     * @param array that the method will find the max of
     * @return the max number
     */
    private int findMax(int[] array, int [] oldArray){
        int max = array[0];
        for(int i = 0; i < array.length; i++){
            oldArray[i] = array[i];
            if(max < array[i]){
                max = array[i];
            }//end if
        }//end for
        return max;
    }//end findMax
}//end class
