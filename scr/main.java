import Sort.BucketSort;
import Sort.Counting;
import Sort.QuickSortMo3;
import Sort.ShellSort;
import SortTester.SortingClassNode;
import SortTester.TestResultMatrix;


import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class main {
    public static void main(String [] args) {
        ArrayList<String> names = createMatrix();
        TestResultMatrix tm = new TestResultMatrix(names.size());
        for(String n: names){
            tm.addSortClass(n);
        }//end for loop
        Iterator<SortingClassNode> itr = tm.iterator();
        while(itr.hasNext()){
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
}//end main class
