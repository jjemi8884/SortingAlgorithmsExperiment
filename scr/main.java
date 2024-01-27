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
        ArrayList<String> names = createMatrix();
        TestResultMatrix tm = new TestResultMatrix(names.size());
        for(String n: names){
            tm.addSortClass(n);
        }//end for loop
        Iterator<SortingClassNode> itr = tm.iterator();
        int [] origin = testArray();

        while(itr.hasNext()){
            int[] test = origin.clone();
            SortingClassNode n = itr.next();
            System.out.println(n.getName());
            n.addScore(15);
        }//end while
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
        int[] array = new int[32560];
        Random r = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = r.nextInt(40000);
        }//end for
        return array;
    }
}//end main class

