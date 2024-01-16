package Sort;

public class BucketSort implements SortInterface {
    private Node [] buckets;
    private int [] negativeArray;
    private static final int LARGESTNUMBER = 40000;

       /**
     * this will initialize the array used in the class
     * @param array array of integers
     */
    public BucketSort(int [] array ){
        this.sort(array);
    }//end bucket sort constructor

    /**
     * The sort the given array of integers
     *
     * @param array of integers to be sorted.
     */
    @Override
    public void sort(int [] array) {
        //create n buckets []
        createBuckets(array.length);
        //insert into buckets and sort buckets with linkedlist
        insert(array);
        //concatenate the buckets.
        concat(array);
    }

    /**
     * create the bucket array that will be used to sort the integers
     *
     * @param arrayLength
     */
    public void createBuckets(int arrayLength){
        buckets = new Node[arrayLength];
    }

    private void insert(int [] array){
        int negCount = 0;
        Node rootNode = new Node(0);
        Node lastNode = rootNode;
        for(int i = 0; i < array.length; i++){
            if (array[i] < 0 ){
                negCount++;
                Node negNode = new Node(array[i], lastNode);
            }else{
                int num = array[i];
                placeNode(num, array.length);
            }
        }
    }

    /**
     * method to place the node in the bucket array
     * @param num is the data to be sorted.
     */
    private void placeNode(int num, int arrayLength){
        //check if a node is empty
        double tempnum  = num * arrayLength/LARGESTNUMBER;
        int index = (int) Math.round(tempnum);
       //System.out.println("Bucket #" + index + " and number is " + num);
        if(buckets[index] == null){ //node empty, we can store our number
            buckets[index] = new Node(num);
        }else{

            Node currentBucket = buckets[index];
            Node previousBucket = null;

            //****Here is the internal sorting for the buckets,****
            // by doing an insertion sort with local list link class
            if(currentBucket.getData() > num){
                //set new first node
                Node n = new Node(num, currentBucket);
                buckets[index] = n;
            }else{
                previousBucket = currentBucket;
                currentBucket = currentBucket.getNextNode();
                while(currentBucket != null && currentBucket.getData() < num){
                    previousBucket = currentBucket;
                    currentBucket = currentBucket.getNextNode();
                }//end while
                Node n = new Node(num, currentBucket);
                previousBucket.setNextLink(n);
            }


        }
    }

    /**
     * Method to pull from the bucket and resort the array
     * @param array that will be resorted
     */
    private void concat(int [] array){
        int arrayIndex = 0;
        int bucketIndex = 0;
        while( bucketIndex < buckets.length){

                if(buckets[bucketIndex] != null){
                    array[arrayIndex] = buckets[bucketIndex].getData();
                    arrayIndex++;
                    Node currentBucket = buckets[bucketIndex].getNextNode();
                    while (currentBucket != null) {
                        array[arrayIndex] = currentBucket.getData();
                        arrayIndex++;
                        currentBucket = currentBucket.getNextNode();
                    }//end while
                }//end if
            bucketIndex++;
        }// end for

    }//end concat
    /**
     *
     */
    private class Node{
        private int data;
        Node nextLink;

        /**
         * node constructor with only data supplies
         * @param data int type data to store
         *
         */
        public Node(int data){

            this(data, null);
        }//end node constructor

        public Node(int data, Node nextLink){
            this.data = data;
            this.setNextLink(nextLink);
        }//end constructor 2

        /**
         * Getter for the data in the node
         * @return
         */
        public int getData(){
            return data;
        }

        /**
         * Set Data
         * @param data to set into the node
         * @return the data that was in the node
         */
        public int setData(int data){
            int temp = this.data;
            this.data = data;
            return temp;
        }

        /***
         * the getter for the next node
         * @return the next node that is linked to this node
         */
        public Node getNextNode(){
            return nextLink;
        }

        /**
         * set the next link in the node.
         * @param nextLink is the pointer to the next node in the chain.
         */
        public void setNextLink(Node nextLink){
            this.nextLink = nextLink;
        }
    }
}
