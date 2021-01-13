package com.company;

import java.util.*;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("/* ===== Queue Data Structure ===== */");
        Queue queue = new Queue(1000);
        System.out.println("Would you like to add elements to your queue?[Y/N]:");
        String answer = sc.nextLine().toLowerCase();
        if (answer.equals("y")) {
            System.out.println("Please enter your list of elements, separated by a space:");
            int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int value : input) {
                queue.enqueue(value);
            }
        }

        //Display current queue:
        System.out.println(queue.toString());

        //List of menu options:
        int menuChoice = menuOptions();
        int element;
        //Switch statement to handle chosen option
        while (menuChoice != 8) {
            //Invalid choice handler
            if (menuChoice < 1 || menuChoice > 8) {
                System.out.println("Please select an available option by entering the appropriate number");
                menuChoice = menuOptions();
                //reprint the menu
            }else if(menuChoice == 7) {
                menuChoice = menuOptions();
            }else {
                switch (menuChoice) {
                    //Check if queue is empty
                    case 1:
                        if (queue.isEmpty(queue)) {
                            System.out.println("The queue is currently empty");
                        } else {
                            System.out.println("The stack contains " + queue.size + " elements");
                        }
                        break;
                    //Print queue
                    case 2:
                        System.out.println(queue.toString());
                        break;
                    //Enqueue an element onto the queue
                    case 3:
                        System.out.println("Please enter your element to add:");
                        element = sc.nextInt();
                        queue.enqueue(element);
                        System.out.println("Element added!");
                        System.out.println(queue.toString());
                        break;
                    //Dequeue an element from the queue
                    case 4:
                        element = queue.dequeue();
                        if (element > Integer.MIN_VALUE) {
                            System.out.println(element + " removed");
                            System.out.println(queue.toString());
                        } else {
                            System.out.println("The stack is already empty.  No element to remove.");
                        }
                        break;
                    //Show the front element of the queue
                    case 5:
                        element = queue.front();
                        if (element > Integer.MIN_VALUE) {
                            System.out.println(element + " is at the front of the queue");
                        } else {
                            System.out.println("The stack is empty.  No element to show.");
                        }
                        break;
                    //Show the rear element of the queue
                    case 6:
                        element = queue.rear();
                        if (element > Integer.MIN_VALUE) {
                            System.out.println(element + " is at the rear of the queue");
                        } else {
                            System.out.println("The stack is empty.  No element to show.");
                        }
                        break;
                    default:
                        break;
                }
                System.out.println("Please select your next action from the list of menu options (7 for menu):");
                menuChoice = sc.nextInt();
            }
        }
        System.out.println("Have a great day!");
    }

    public static int menuOptions() {
        System.out.println("Please select the applicable menu option from the below list of actions:\n" +
                "1: Check whether the queue is empty\n" +
                "2: To print the elements in the queue\n" +
                "3: Queue and element onto the queue\n" +
                "4: Dequeue an element from the queue\n" +
                "5: View the front element of the queue\n" +
                "6: View the rear element of the queue\n" +
                "7: See the list of menu options again\n" +
                "8: Quit the program");
        return sc.nextInt();
    }
}

//A class to represent a queue
class Queue {
    int front, rear, size;
    int capacity;
    int[] array;

    public Queue(int capacity){
        this.capacity = capacity;
        front = this.size = 0;
        rear = capacity-1;
        array = new int[this.capacity];
    }

    //Queue is full when size becomes equal to the capacity
    boolean isFull(Queue queue){
        return (queue.size == queue.capacity);
    }

    //Queue is empty when size is 0
    boolean isEmpty(Queue queue){
        return (queue.size == 0);
    }

    //Method to add an item to the queue.  It changes rear and size
    void enqueue(int item){
        if(isFull(this)){
            return;
        }
        this.rear = (this.rear + 1) % this.capacity;
        this.array[this.rear] = item;
        this.size = this.size + 1;
        System.out.println(item + " enqueued in queue");
    }

    //Method to remove an item from queue.  It changes front and size
    int dequeue(){
        if(isEmpty(this)){
            return Integer.MIN_VALUE;
        }
        int item = this.array[this.front];
        this.front = (this.front + 1) % this.capacity;
        this.size = this.size -1;
        return item;
    }

    //Method to get front of queue
    int front(){
        if(isEmpty(this)){
            return Integer.MIN_VALUE;
        }
        return this.array[this.front];
    }

    //Method to get rear of queue
    int rear(){
        if(isEmpty(this)){
            return Integer.MIN_VALUE;
        }
        return this.array[this.rear];
    }

    //Printing only the elements added to the queue
    @Override
    public String toString() {
        int[] printArray = new int[this.size];
        for(int i = 0; i < this.size; i++){
            printArray[i] = this.array[this.front + i];
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for(int i = 0; i < printArray.length; i++){
            if(i < printArray.length - 1) {
                stringBuilder.append(printArray[i] + ", ");
            }else{
                stringBuilder.append(printArray[i]);
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
