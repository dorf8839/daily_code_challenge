package com.company;

public class MinHeap {

    private int[] heap;
    private int size;
    private int maxSize;

    private static final int FRONT = 1;

    public MinHeap(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        heap = new int[this.maxSize + 1];
        heap[0] = Integer.MIN_VALUE;
    }

    public int getSize() {
        return size;
    }

    //Function to return the position of the parent for the node currently at pos
    private int parent(int pos){
        return pos/2;
    }

    //Function to return the position fo the left child for the node currently at pos
    private int leftChild(int pos){
        return (2 * pos);
    }

    //Function to return the position of the right child for the node currently at pos
    private int rightChild(int pos){
        return (2 * pos) + 1;
    }

    //Function that returns true if the passed node is a leaf node
    private boolean isLeaf(int pos){
        if(pos >= (size / 2) && pos <= size){
            return true;
        }
        return false;
    }

    //Function to swap two nodes of the heap
    private void swap(int fpos, int spos){
        int tmp;
        tmp = heap[fpos];
        heap[fpos] = heap[spos];
        heap[spos] = tmp;
    }

    //Function to heapify the node at pos
    private void minHeapify(int pos){
        //If the node is a non-leaf and greater than any of its children
        if(!isLeaf(pos)){
            if(heap[pos] > heap[leftChild(pos)] || heap[pos] > heap[rightChild(pos)]){
                //Swap with the left child and heapify the left child
                if(heap[leftChild(pos)] < heap[rightChild(pos)]){
                    swap(pos, leftChild(pos));
                    minHeapify(leftChild(pos));
                }else{
                    //Swap with the right child and heapify the right child
                    swap(pos, rightChild(pos));
                    minHeapify(rightChild(pos));
                }
            }
        }
    }

    //Function to insert a node into the heap
    public void insert(int element){
        if(size >= maxSize){
            System.out.println("You have already exceeded the max size of this heap");
            return;
        }
        heap[++size] = element;
        int current = size;

        while(heap[current] < heap[parent(current)]){
            swap(current, parent(current));
            current = parent(current);
        }
        System.out.println("Element " + element + " added!");
    }

    //Function to print the contents of the heap
    public void print(){
        System.out.println("The Min Heap is");
        if(this.size == 0){
            System.out.println("EMPTY");
        }else if(this.size == 1){
            System.out.println(" PARENT : " + heap[1] +
                    " LEFT CHILD : 0 RIGHT CHILD : 0");
        }
        else {
            for (int i = 1; i <= size / 2; i++) {
                System.out.print(" PARENT : " + heap[i] +
                        " LEFT CHILD : " + heap[2 * i] +
                        " RIGHT CHILD : " + heap[2 * i + 1]);
                System.out.println();
            }
        }
    }

    //Function to build the min heap using the minHeapify
    public void minHeap(){
        for(int pos = (size/2); pos >= 1; pos--){
            minHeapify(pos);
        }
    }

    //function to remove and return the minimum element from the heap
    public int remove(){
        int popped = heap[FRONT];
        heap[FRONT] = heap[size--];
        minHeapify(FRONT);
        return popped;
    }
}
