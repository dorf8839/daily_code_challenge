package com.company;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("/* ===== Binary Heap ===== */");
        MinHeap minHeap;
        System.out.println("Would you like to add elements to your heap?[Y/N]:");
        String answer = sc.nextLine().toLowerCase();
        if (answer.equals("y")) {
            System.out.println("Please enter your list of elements, separated by a space:");
            int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            minHeap = new MinHeap(input.length*2);
            for (int value : input) {
                minHeap.insert(value);
            }
            minHeap.minHeap();
        }else{
            minHeap = new MinHeap(3);
        }

        //Display current list:
        minHeap.print();

        //List of menu options:
        int menuChoice = menuOptions();
        int element;
        //Switch statement to handle chosen option
        while (menuChoice != 6) {
            //Invalid choice handler
            if (menuChoice < 1 || menuChoice > 6) {
                System.out.println("Please select an available option by entering the appropriate number");
                menuChoice = menuOptions();
                //reprint the menu
            }else if(menuChoice == 5) {
                menuChoice = menuOptions();
            }else {
                switch (menuChoice) {
                    //Check if heap is empty
                    case 1:
                        if (minHeap.getSize() == 0) {
                            System.out.println("The heap is currently empty");
                        } else {
                            System.out.println("The heap contains " + minHeap.getSize() + " elements");
                        }
                        break;
                    //Print heap
                    case 2:
                        minHeap.print();
                        break;
                    //Add an element to the heap
                    case 3:
                        System.out.println("Please enter your element to add:");
                        element = sc.nextInt();
                        minHeap.insert(element);
                        minHeap.minHeap();
                        minHeap.print();
                        break;
                    //Remove the minimum element from the heap
                    case 4:
                        element = minHeap.remove();
                        System.out.println("Element " + element + " removed!");
                        minHeap.minHeap();
                        minHeap.print();
                        break;
                    default:
                        break;
                }
                System.out.println("Please select your next action from the list of menu options (5 for menu):");
                menuChoice = sc.nextInt();
            }
        }
        System.out.println("Have a great day!");
    }

    public static int menuOptions() {
        System.out.println("Please select the applicable menu option from the below list of actions:\n" +
                "1: Check whether the heap is empty\n" +
                "2: To print the elements in the heap\n" +
                "3: Add an element to the heap\n" +
                "4: Remove the minimum element from the heap\n" +
                "5: See the list of menu options again\n" +
                "6: Quit the program");
        return sc.nextInt();
    }
}