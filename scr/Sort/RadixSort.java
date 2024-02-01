package Sort;

import java.util.ArrayList;

public class RadixSort implements SortInterface{

    /**
     * The main call to sort the given array of integers
     * @param array of integers to be sorted.
     */
    @Override
    public void sort(int[] array) {
        // Determine the maximum number of digits in any of the value in the array
        int maxDigits = 0;
        for (int number: array) {
            maxDigits = Math.max(maxDigits, (int) Math.log10(number) + 1);
        }

        // Create buckets for each digit, which will store values
        ArrayList<Integer>[] buckets = createBuckets();
        // Loop through each digit starting from the far right until the last digit
        for (int i = 0; i < maxDigits; i++) {
            int temp = (int) Math.pow(10, i);
            // Iterate through an array, and add elements to buckets based on their digits
            for (int number: array) {
                int digit = (number / temp) % 10;
                buckets[digit].add(number);
            }

            // Puts values back into array in order based on the current digit
            int index = 0;
            for (int j = 0; j < 10; j++) {
                while (!buckets[j].isEmpty()){
                    array[index] = buckets[j].remove(0);
                    index++;
                }
            }
        }
    }

    /**
     * Creates 10 buckets to store value from the array into
     * @return 10 buckets
     */
    private ArrayList<Integer>[] createBuckets() {
        ArrayList<Integer>[] buckets = new ArrayList[10];
        for (int j = 0; j < buckets.length; j++) {
            buckets[j] = new ArrayList<>();
        }
        return buckets;
    }
}
