package Sort;

public class ShellSort implements SortInterface {

    /**
     * Method to iterate through the list a certain distance between indexes
     * becoming smaller all the time until space is less than 1
     * @param a         array that will be used to index and sort
     */
    @Override
    public void sort(int[] a) {
        for(int space = a.length / 2; space > 0; space /= 2){
            for(int i = space; i < a.length; i++){
                int value = a[i];
                int index = i;
                while((index >= space ) && (value < a[index - space])){
                    a[index] = a[index - space];
                    index -= space;
                }//end while
                a[index] = value;
            }//end for
        }//end for
    }//end sort

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
}//end class


