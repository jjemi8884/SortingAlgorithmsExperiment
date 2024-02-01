package SortTester;



import ArrayCreators.CreateArrays;

import java.util.ArrayList;
import java.util.Arrays;

public class TestGenerator{

    // private reference to the original ArrayList
    private ArrayList<int[]> originalArrayList;
    private ArrayList<int[]> orderedArrayList;

    /**
     * Constructor method, creates a test generator, and all the arrays within
     */
    public TestGenerator() {
        originalArrayList = new ArrayList<>(70);
        orderedArrayList = new ArrayList<>(70);
        populateArrays();
    }

    /**
     * Method to readjust the array
     */
    public void orderList(){
        for(int i = 0; i < 5; i++){
            for(int j = i; j < originalArrayList.size(); j += 5){
                orderedArrayList.add(originalArrayList.get(j));
            }
        }
    }

    /**
     * Fills the ArrayList with different integer arrays, size to the power of 2 and ordered in different ways
     */
    private void populateArrays() {
        int power = 2;
        for (int arrayGroups = 0; arrayGroups < 14; arrayGroups++) {
            CreateArrays arrayCreator = new CreateArrays((int)Math.pow(2,power));
            originalArrayList.add(arrayCreator.getOriginalArray());
            originalArrayList.add(arrayCreator.halfSortedArray());
            originalArrayList.add(arrayCreator.threeFourthSortedArray());
            originalArrayList.add(arrayCreator.sortedArray());
            originalArrayList.add(arrayCreator.reverseOrder());
            power++;
        }
        orderList();
    }



    /**
     * Retrieves a clone of the original ArrayList for the caller to use without fear of modifying the original ArrayList
     * and its contents
     * @return clone of the ArrayList (and its integer arrays)
     */
    public ArrayList<int[]> getCloneArrayList() {
        ArrayList<int[]> arrayListCopy = new ArrayList<>();
        for (int[] array: orderedArrayList) {
            arrayListCopy.add(Arrays.copyOf(array, array.length));
        }
        return arrayListCopy;
    }
}
