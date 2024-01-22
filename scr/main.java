import Sort.BucketSort;



import java.util.Random;

public class main {
    public static void main(String [] args){
        int [] array = new int [20];
        Random rand = new Random();

        for (int i = 0; i < array.length; i++){
            int temp = rand.nextInt(40000);
            array[i] = temp;
        }
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i] + ", ");
        }
        System.out.println("");
        BucketSort s = new BucketSort(array);


        for (int i = 0; i < array.length; i++){
            System.out.print(array[i] + ", ");
        }
    }//end main
}//end main class
