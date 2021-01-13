package com.company;

import java.util.*;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("/* ===== Queue From Stack ===== */");
        Queue queue1 = new Queue();
        System.out.println("Please enter your list of elements, separated by a space:");
        int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        //Enqueue Operation:
        for (int value : input) {
            queue1.enqueue(value);
        }

        //Display current queue:
        System.out.println("Queue: " + queue1.toString());

        //Dequeue Operation:
        int delEl = queue1.dequeue();
        System.out.println("Element " + delEl + " has been removed");
        System.out.println("Queue: " + queue1.toString());

        //Peek Operation:
        int nextEl = queue1.peek();
        System.out.println("Element " + nextEl + " is next in the queue");

        System.out.println("Have a great day!");
    }
}

//A class to represent a queue
class Queue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public Queue() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    //Method to add an item to the queue.  It changes rear and size
    void enqueue(int item) {
        this.stack1.push(item);
    }

    //Method to remove an item from queue.  It changes front and size
    int dequeue() {
        int length = this.stack1.size();
        for(int i = 0; i < length; i++) {
            this.stack2.push(this.stack1.pop());
        }
        int delEl = this.stack2.pop();
        length = this.stack2.size();
        for(int i = 0; i < length; i++) {
            this.stack1.push(this.stack2.pop());
        }
        return delEl;
    }

    int peek() {
        int length = this.stack1.size();
        for(int i = 0; i < length; i++) {
            this.stack2.push(this.stack1.pop());
        }
        int element = this.stack2.peek();
        length = this.stack2.size();
        for(int i = 0; i < length; i++) {
            this.stack1.push(this.stack2.pop());
        }
        return element;
    }

    //Printing only the elements added to the queue
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        int length = this.stack1.size();
        for(int i = 0; i < length; i++){
            this.stack2.push(this.stack1.pop());
        }
        length = this.stack2.size();
        stringBuilder.append("[");
        for(int i = 0; i < length; i++){
            int element = this.stack2.pop();
            this.stack1.push(element);
            if(i < length -1) {
                stringBuilder.append(element + ", ");
            }else{
                stringBuilder.append(element);
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
