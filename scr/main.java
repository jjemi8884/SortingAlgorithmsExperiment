import Sort.BucketSort;
import Sort.Counting;
import Sort.QuickSortMo3;



import java.util.Random;

public class main {
    public static void main(String [] args){
        int [] array = new int [10];
        Random rand = new Random();

        for (int i = 0; i < array.length; i++){
            int temp = rand.nextInt(100);
            array[i] = temp;
        }




        System.out.println("Original Array");
        printArray(array);

       // int [] bucketArray = array.clone();
        int [] mO3Array = array.clone();
        //System.out.println("");
        //BucketSort s = new BucketSort(bucketArray);
        //System.out.print("Bucket Sort Array\n");
        //printArray(bucketArray);

//        QuickSortMo3 s1 = new QuickSortMo3(mO3Array);
//
        Counting s3 = new Counting(array);
        System.out.println("Counting array");
        printArray(array);





    }//end main

    public static void printArray(int [] array){

        for (int i = 0; i < array.length; i++){
            System.out.print(array[i] + ", ");
        }
        System.out.println();
    }
}//end main class
