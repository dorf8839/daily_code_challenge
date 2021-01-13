package com.company;

import java.util.*;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("/* ===== Alternate Queue Combination ===== */");
        Queue queue1 = new Queue(1000);
        Queue queue2 = new Queue(1000);
        System.out.println("Please enter your list of elements for Queue 1, separated by a space:");
        int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int value : input) {
            queue1.enqueue(value);
        }
        System.out.println("Please enter your list of elements for Queue 2, separated by a space:");
        input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int value : input) {
            queue2.enqueue(value);
        }

        //Display current queues:
        System.out.println("Queue #1: " + queue1.toString());
        System.out.println("Queue #2: " + queue2.toString());

        //Create 3rd queue and combine:
        int q3cap = queue1.size + queue2.size;
        Queue queue3 = new Queue(q3cap);
        int length;
        if(queue1.size > queue2.size){
            length = queue2.size;
        }else{
            length = queue1.size;
        }
        for(int i = 0; i < length; i++){
            queue3.enqueue(queue2.dequeue());
            queue3.enqueue(queue1.dequeue());
        }
        System.out.println("Queue #3: " + queue3.toString());

        System.out.println("Have a great day!");
    }
}

//A class to represent a queue
class Queue {
    int front, rear, size;
    int capacity;
    int[] array;

    public Queue(int capacity) {
        this.capacity = capacity;
        front = this.size = 0;
        rear = capacity - 1;
        array = new int[this.capacity];
    }

    //Queue is full when size becomes equal to the capacity
    boolean isFull(Queue queue) {
        return (queue.size == queue.capacity);
    }

    //Queue is empty when size is 0
    boolean isEmpty(Queue queue) {
        return (queue.size == 0);
    }

    //Method to add an item to the queue.  It changes rear and size
    void enqueue(int item) {
        if (isFull(this)) {
            return;
        }
        this.rear = (this.rear + 1) % this.capacity;
        this.array[this.rear] = item;
        this.size = this.size + 1;
    }

    //Method to remove an item from queue.  It changes front and size
    int dequeue() {
        if (isEmpty(this)) {
            return Integer.MIN_VALUE;
        }
        int item = this.array[this.front];
        this.front = (this.front + 1) % this.capacity;
        this.size = this.size - 1;
        return item;
    }

    //Printing only the elements added to the queue
    @Override
    public String toString() {
        int[] printArray = new int[this.size];
        for (int i = 0; i < this.size; i++) {
            printArray[i] = this.array[this.front + i];
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < printArray.length; i++) {
            if (i < printArray.length - 1) {
                stringBuilder.append(printArray[i] + ", ");
            } else {
                stringBuilder.append(printArray[i]);
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
