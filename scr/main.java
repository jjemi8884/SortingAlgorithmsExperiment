import Sort.*;
import SortTester.SortingClassNode;
import SortTester.TestResultMatrix;


import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.random.RandomGenerator;

public class main {
    public static void main(String [] args) {

        BucketSort s = new BucketSort();
        Counting s1 = new Counting();
        HeapSort s2  = new HeapSort();
        InsertionSort s3 = new InsertionSort();
        MergeSort s4   = new MergeSort();
        QuickSortFirst s5 = new QuickSortFirst();
        QuickSortMo3 s6  = new QuickSortMo3();
        SelectionSort s7    = new SelectionSort();
        ShellSort s8     = new ShellSort();

        ArrayList<String> names = createMatrix();
        TestResultMatrix tm = new TestResultMatrix(names.size());
        for(String n: names){
            tm.addSortClass(n);
        }//end for loop
        Iterator<SortingClassNode> itr = tm.iterator();
        int [] origin = testArray();

        ArrayList<int []> testList = new ArrayList<>();
        int[] test1 = origin.clone();
        int [] test2 = origin.clone();
        int []  test3 = origin.clone();
        testList.add(test1);
        testList.add(test2);
        testList.add(test3);

        //start clock
        s1.sort(testList.get(0));
        //end - start ->>>>>>>> 30000
        tm.addResult("BucketSort", 3000);

    }//end main

    /**
     * Method will go into the sort package and gather all the names of the
     * sort classes and create the arrayList to use for them.
     * It ignores the interfaces.
     */
    public static ArrayList<String> createMatrix(){
        ArrayList<String> nameList = new ArrayList<>();
        File f = new File("scr/Sort");
        File[] a = f.listFiles();
        for(int i = 0; i < a.length; i++){
            String name = a[i].getName();
            if(!name.contains("Interface")){
                name = name.substring(0,name.length() - 5);
                nameList.add(name);
            }//end
        }//end for
        return nameList;
    }//end createMatrix
    public static int [] testArray() {
        int[] array = new int[10];
        Random r = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = r.nextInt(40000);
        }//end for
        return array;
    }

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
}//end main class

