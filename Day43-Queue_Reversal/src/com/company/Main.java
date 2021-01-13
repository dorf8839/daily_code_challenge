package com.company;

import java.util.*;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("/* ===== Queue Reversal ===== */");
        Queue queue1 = new Queue(1000);
        Stack<Integer> tempStack = new Stack<>();
        System.out.println("Please enter your list of elements, separated by a space:");
        int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int value : input) {
            queue1.enqueue(value);
        }

        //Display current queue:
        System.out.println("Queue #1: " + queue1.toString());

        //Reverse queue:
        int length = queue1.size;
        for(int i = 0; i < length; i++){
            tempStack.push(queue1.dequeue());
        }
        length=tempStack.size();
        for(int i = 0; i < length; i++){
            queue1.enqueue(tempStack.pop());
        }

        //Display reversed queue:
        System.out.println("Reversed Queue #1: " + queue1.toString());

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
