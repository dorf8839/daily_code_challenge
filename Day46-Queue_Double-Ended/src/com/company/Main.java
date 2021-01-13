package com.company;

import java.util.*;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("/* ===== Double-Ended Queue ===== */");
        Dequeue dequeue = new Dequeue(1000);
        System.out.println("Would you like to add elements to your queue?[Y/N]:");
        String answer = sc.nextLine().toLowerCase();
        if (answer.equals("y")) {
            System.out.println("Please enter your list of elements, separated by a space:");
            int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int value : input) {
                dequeue.enqueueFront(value);
            }
        }

        //Display current dequeue:
        System.out.println(dequeue.toString());

        //List of menu options:
        int menuChoice = menuOptions();
        int element;
        //Switch statement to handle chosen option
        while (menuChoice != 10) {
            //Invalid choice handler
            if (menuChoice < 1 || menuChoice > 10) {
                System.out.println("Please select an available option by entering the appropriate number");
                menuChoice = menuOptions();
                //reprint the menu
            }else if(menuChoice == 9) {
                menuChoice = menuOptions();
            }else {
                switch (menuChoice) {
                    //Check if dequeue is empty
                    case 1:
                        if (dequeue.isEmpty(dequeue)) {
                            System.out.println("The queue is currently empty");
                        } else {
                            System.out.println("The stack contains " + dequeue.size + " elements");
                        }
                        break;
                    //Print dequeue
                    case 2:
                        System.out.println(dequeue.toString());
                        break;
                    //Enqueue an element onto the front of the dequeue
                    case 3:
                        System.out.println("Please enter your element to add:");
                        element = sc.nextInt();
                        dequeue.enqueueFront(element);
                        System.out.println(element + " enqueued in front of the dequeue");
                        System.out.println(dequeue.toString());
                        break;
                    //Enqueue an element onto the rear of the dequeue
                    case 4:
                        System.out.println("Please enter your element to add:");
                        element = sc.nextInt();
                        dequeue.enqueueLast(element);
                        System.out.println(element + " enqueued in rear of the dequeue");
                        System.out.println(dequeue.toString());
                        break;
                    //Dequeue an element from the front of the dequeue
                    case 5:
                        element = dequeue.dequeueFront();
                        if (element > Integer.MIN_VALUE) {
                            System.out.println(element + " removed from the front of the dequeue");
                            System.out.println(dequeue.toString());
                        } else {
                            System.out.println("The stack is already empty.  No element to remove.");
                        }
                        break;
                    //Dequeue an element from the rear of the dequeue
                    case 6:
                        element = dequeue.dequeueLast();
                        if (element > Integer.MIN_VALUE) {
                            System.out.println(element + " removed from the rear of the dequeue");
                            System.out.println(dequeue.toString());
                        } else {
                            System.out.println("The stack is already empty.  No element to remove.");
                        }
                        break;
                    //Show the front element of the dequeue
                    case 7:
                        element = dequeue.getFront();
                        if (element > Integer.MIN_VALUE) {
                            System.out.println(element + " is at the front of the queue");
                        } else {
                            System.out.println("The stack is empty.  No element to show.");
                        }
                        break;
                    //Show the rear element of the dequeue
                    case 8:
                        element = dequeue.getRear();
                        if (element > Integer.MIN_VALUE) {
                            System.out.println(element + " is at the rear of the queue");
                        } else {
                            System.out.println("The stack is empty.  No element to show.");
                        }
                        break;
                    default:
                        break;
                }
                System.out.println("Please select your next action from the list of menu options (9 for menu):");
                menuChoice = sc.nextInt();
            }
        }
        System.out.println("Have a great day!");
    }

    public static int menuOptions() {
        System.out.println("Please select the applicable menu option from the below list of actions:\n" +
                "1: Check whether the queue is empty\n" +
                "2: To print the elements in the queue\n" +
                "3: Queue an element onto the front of the queue\n" +
                "4: Queue an element onto the rear of the queue\n" +
                "5: Dequeue an element from the front of the queue\n" +
                "6: Dequeue an element from the rear of the queue\n" +
                "7: View the front element of the queue\n" +
                "8: View the rear element of the queue\n" +
                "9: See the list of menu options again\n" +
                "10: Quit the program");
        return sc.nextInt();
    }
}

//A class to represent a dequeue
class Dequeue {
    int front, rear, size;
    int capacity;
    int[] array;

    public Dequeue(int capacity){
        this.capacity = capacity;
        front = this.size = 0;
        rear = capacity-1;
        array = new int[this.capacity];
    }

    //Dequeue is full when size becomes equal to the capacity
    boolean isFull(Dequeue dequeue){
        return (dequeue.size == dequeue.capacity);
    }

    //Dequeue is empty when size is 0
    boolean isEmpty(Dequeue dequeue){
        return (dequeue.size == 0);
    }

    //Method to add an item to the front of the dequeue.  It changes front and size
    void enqueueFront(int item){
        if(isFull(this)){
            return;
        }
        int temp;
        int tempItem = item;
        for(int i = this.front; i < this.size; i++){
            temp = this.array[i];
            this.array[i] = tempItem;
            tempItem = temp;
        }
        enqueueLast(tempItem);
    }

    //Method to add an item to the rear of the dequeue.  It changes rear and size
    void enqueueLast(int item){
        if(isFull(this)){
            return;
        }
        this.rear = (this.rear + 1) % this.capacity;
        this.array[this.rear] = item;
        this.size = this.size + 1;
    }

    //Method to remove an item from the front of the dequeue.  It changes front and size
    int dequeueFront(){
        if(isEmpty(this)){
            return Integer.MIN_VALUE;
        }
        int item = this.array[this.front];
        this.front = (this.front + 1) % this.capacity;
        this.size = this.size -1;
        return item;
    }

    //Method to remove an item from rear of the dequeue.  It changes rear and size
    int dequeueLast(){
        if(isEmpty(this)){
            return Integer.MIN_VALUE;
        }
        int item = this.array[this.rear];
        this.rear = (this.rear - 1) % this.capacity;
        this.size = this.size -1;
        return item;
    }

    //Method to get front of dequeue
    int getFront(){
        if(isEmpty(this)){
            return Integer.MIN_VALUE;
        }
        return this.array[this.front];
    }

    //Method to get rear of dequeue
    int getRear(){
        if(isEmpty(this)){
            return Integer.MIN_VALUE;
        }
        return this.array[this.rear];
    }

    //Printing only the elements added to the dequeue
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
