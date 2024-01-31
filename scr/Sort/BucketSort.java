package Sort;

public class BucketSort implements SortInterface {
    private Node [] buckets; //where to store the sorted items
    private int [] negativeArray; // for future use
    private static final int LARGESTNUMBER = 40000; // the largest number that will be pulled

    /**
     * The sort the given array of integers
     * @param array of integers to be sorted.
     */
    @Override
    public void sort(int [] array) {
        //create n buckets []
        createBuckets(array.length + 1);
        //insert into buckets and sort buckets with a linked list
        insert(array);
        //concatenate the buckets.
        concat(array);
    }//end sort constructor

    /**
     * create the bucket array that will be used to sort the integers
     * @param arrayLength
     */
    public void createBuckets(int arrayLength){
        buckets = new Node[arrayLength];
    }//end createBuckets

    /**
     * The private method to insert the numbers from the array into the bucket
     * @param array
     */
    private void insert(int [] array){
        Node rootNode = new Node(0);
        Node lastNode = rootNode;
        for(int i = 0; i < array.length; i++){
                int num = array[i];
                placeNode(num, array.length);
        }//end for
    }//end insert

    /**
     * method to place the node in the bucket array
     * @param num is the data to be sorted.
     */
    private void placeNode(int num, int arrayLength){
        //check if a node is empty
        double tempNum  = num * arrayLength/LARGESTNUMBER;
        int index = (int) Math.round(tempNum);
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
            }//end if
        }//end if
    }//end place node

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
     * Class for the nodes that will be used in each bucket
     * They will be linked list nodes with only a link to the next node
     * The first node in the bucket will be the node linked in the array
     */
    private class Node{
        private int data;
        Node nextLink;

        /**
         * node constructor with only data supplies
         * @param data int type data to store
         */
        public Node(int data){
            this(data, null);
        }//end node constructor

        /**
         * The second node constructor which allows for assignment
         * of the next link.
         * @param data that will be stored in the node
         * @param nextLink is the pointer to the next node
         */
        public Node(int data, Node nextLink){
            this.data = data;
            this.setNextLink(nextLink);
        }//end constructor 2

        /**
         * Getter for the data in the node
         * @return data
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
        }//end setData

        /***
         * the getter for the next node
         * @return the next node that is linked to this node
         */
        public Node getNextNode(){
            return nextLink;
        }//end getNextNode

        /**
         * set the next link in the node.
         * @param nextLink is the pointer to the next node in the chain.
         */
        public void setNextLink(Node nextLink){
            this.nextLink = nextLink;
        }//end setNextLink
    }
}
