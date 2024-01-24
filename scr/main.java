import Sort.BucketSort;
import Sort.QuickSortMo3;



import java.util.Random;

public class main {
    public static void main(String [] args){
        int [] array = new int [40];
        Random rand = new Random();

        for (int i = 0; i < array.length; i++){
            int temp = rand.nextInt(100);
            array[i] = temp;
        }


<<<<<<< HEAD

        System.out.println("Original Array");
        printArray(array);

       // int [] bucketArray = array.clone();
        int [] mO3Array = array.clone();
        //System.out.println("");
        //BucketSort s = new BucketSort(bucketArray);
        //System.out.print("Bucket Sort Array\n");
        //printArray(bucketArray);

        QuickSortMo3 s1 = new QuickSortMo3(mO3Array);
        System.out.println("QuickSortMo3 Array\n");
        printArray(mO3Array);





    }//end main

    public static void printArray(int [] array){
=======
>>>>>>> f0a2d120864cc47dbeec49eca7e7871675259cee
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i] + ", ");
        }
        System.out.println();
    }
}//end main class
