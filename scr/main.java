import Sort.*;
import SortTester.SortingClassNode;
import SortTester.TestGenerator;
import SortTester.TestImplementer;
import SortTester.TestResultMatrix;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.random.RandomGenerator;

public class main {
    public static void main(String [] args) throws IOException {
        TestGenerator g = new TestGenerator();
        TestResultMatrix m = new TestResultMatrix();
        createMatrix(m);
        TestImplementer t = new TestImplementer(g, m);
        t.performTest();
        m.fileGenerator();
    }//end main

    /**
     * Method will go into the sort package and gather all the names of the
     * sort classes and create the arrayList to use for them.
     * It ignores the interfaces.
     */
    public static void createMatrix(TestResultMatrix m){
        ArrayList<String> nameList = new ArrayList<>();
        File f = new File("scr/Sort");
        File[] a = f.listFiles();
        for(int i = 0; i < a.length; i++){
            String name = a[i].getName();
            if(!name.contains("Interface")){
                name = name.substring(0,name.length() - 5);
                m.addSortClass(name);
            }//end
        }//end for

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

