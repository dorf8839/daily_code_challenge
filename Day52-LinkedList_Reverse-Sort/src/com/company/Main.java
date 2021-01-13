package com.company;

import java.util.*;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("/* ===== Singly Linked List ===== */");
        LinkedList<Integer> linkedList = new LinkedList<>();
        System.out.println("Would you like to add elements to your linked list?[Y/N]:");
        String answer = sc.nextLine().toLowerCase();
        if (answer.equals("y")) {
            System.out.println("Please enter your list of elements, separated by a space:");
            int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int value : input) {
                linkedList.add(value);
            }
        }

        //Display current list:
        System.out.println(linkedList.toString());

        //List of menu options:
        int menuChoice = menuOptions();
        int element, index;
        //Switch statement to handle chosen option
        while (menuChoice != 14) {
            //Invalid choice handler
            if (menuChoice < 1 || menuChoice > 14) {
                System.out.println("Please select an available option by entering the appropriate number");
                menuChoice = menuOptions();
                //reprint the menu
            }else if(menuChoice == 13) {
                menuChoice = menuOptions();
            }else {
                switch (menuChoice) {
                    //Check if list is empty
                    case 1:
                        if (linkedList.isEmpty()) {
                            System.out.println("The list is currently empty");
                        } else {
                            System.out.println("The list contains " + linkedList.size() + " elements");
                        }
                        break;
                    //Print list
                    case 2:
                        System.out.println(linkedList.toString());
                        break;
                    //Add an element to the start of the list
                    case 3:
                        System.out.println("Please enter your element to add:");
                        element = sc.nextInt();
                        linkedList.addFirst(element);
                        System.out.println("Element " + element + " added!");
                        System.out.println(linkedList.toString());
                        break;
                    //Add an element to the end of the list
                    case 4:
                        System.out.println("Please enter your element to add:");
                        element = sc.nextInt();
                        linkedList.addLast(element);
                        System.out.println("Element " + element + " added!");
                        System.out.println(linkedList.toString());
                        break;
                    //Remove an element from the start of the list
                    case 5:
                        try {
                            element = linkedList.removeFirst();
                            System.out.println(element + " removed");
                            System.out.println(linkedList.toString());
                        }catch (NoSuchElementException e){
                            System.out.println("The list is already empty.  No element to remove.");
                        }
                        break;
                    //Remove an element from the end of the list
                    case 6:
                        try {
                            element = linkedList.removeLast();
                            System.out.println(element + " removed");
                            System.out.println(linkedList.toString());
                        }catch (NoSuchElementException e){
                            System.out.println("The list is already empty.  No element to remove.");
                        }
                        break;
                    //Get the first element in the list
                    case 7:
                        if (linkedList.peekFirst() != null) {
                            element = linkedList.peekFirst();
                            System.out.println(element + " is at the front of the list");
                        } else {
                            System.out.println("The list is empty.  No element to show.");
                        }
                        break;
                    //Get the last element in the list
                    case 8:
                        if (linkedList.peekLast() != null) {
                            element = linkedList.peekLast();
                            System.out.println(element + " is at the end of the list");
                        } else {
                            System.out.println("The list is empty.  No element to show.");
                        }
                        break;
                    //Insert the specified element at the specified index of the list
                    case 9:
                        System.out.println("Please enter the element to add:");
                        element = sc.nextInt();
                        System.out.println("Please enter the index to add element " + element + " at:");
                        index = sc.nextInt();
                        linkedList.add(index, element);
                        System.out.println("Element " + element + " successfully added at index " + index);
                        System.out.println(linkedList.toString());
                        break;
                    //Remove the element at the specified index of the list
                    case 10:
                        System.out.println("Please enter the index of the element to remove:");
                        index = sc.nextInt();
                        element = linkedList.remove(index);
                        System.out.println("Successfully removed element " + element + " from index " + index);
                        System.out.println(linkedList.toString());
                        break;
                    //Reverse the given list
                    case 11:
                        linkedList = reverseList(linkedList);
                        System.out.println(linkedList.toString());
                        break;
                    //Sort the given list
                    case 12:
                        Collections.sort(linkedList);
                        System.out.println(linkedList.toString());
                        break;
                    default:
                        break;
                }
                System.out.println("Please select your next action from the list of menu options (13 for menu):");
                menuChoice = sc.nextInt();
            }
        }
        System.out.println("Have a great day!");
    }

    public static int menuOptions() {
        System.out.println("Please select the applicable menu option from the below list of actions:\n" +
                "1: Check whether the list is empty\n" +
                "2: To print the elements in the list\n" +
                "3: Add an element to the start of the list\n" +
                "4: Add an element to the end of the list\n" +
                "5: Remove an element from the start of the list\n" +
                "6: Remove an element from the end of the list\n" +
                "7: View the first element of the list\n" +
                "8: View the last element of the list\n" +
                "9: Insert a specified element at a specified index in the list\n" +
                "10: Remove an element at a specified index of the list\n" +
                "11: Reverse the given list\n" +
                "12: Sort the given list\n" +
                "13: See the list of menu options again\n" +
                "14: Quit the program");
        return sc.nextInt();
    }

    public static LinkedList<Integer> reverseList(LinkedList<Integer> linkedList){
        LinkedList<Integer> revLinkedList = new LinkedList<>();
        for(int i = linkedList.size() - 1; i >= 0; i--){
            revLinkedList.add(linkedList.get(i));
        }
        return revLinkedList;
    }
}
