package com.company;

import java.util.*;

//public class Main {
//
//    private static Scanner sc = new Scanner(System.in);
//
//    public static void main(String[] args) {
//        System.out.println("/* ===== Singly Linked List ===== */");
//        LinkedList<Integer> linkedList = new LinkedList<>();
//        System.out.println("Would you like to add elements to your linked list?[Y/N]:");
//        String answer = sc.nextLine().toLowerCase();
//        if (answer.equals("y")) {
//            System.out.println("Please enter your list of elements, separated by a space:");
//            int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//            for (int value : input) {
//                linkedList.add(value);
//            }
//        }
//
//        //Display current list:
//        System.out.println(linkedList.toString());
//
//        //List of menu options:
//        int menuChoice = menuOptions();
//        int element;
//        //Switch statement to handle chosen option
//        while (menuChoice != 11) {
//            //Invalid choice handler
//            if (menuChoice < 1 || menuChoice > 11) {
//                System.out.println("Please select an available option by entering the appropriate number");
//                menuChoice = menuOptions();
//                //reprint the menu
//            }else if(menuChoice == 10) {
//                menuChoice = menuOptions();
//            }else {
//                switch (menuChoice) {
//                    //Check if list is empty
//                    case 1:
//                        if (linkedList.isEmpty()) {
//                            System.out.println("The list is currently empty");
//                        } else {
//                            System.out.println("The list contains " + linkedList.size() + " elements");
//                        }
//                        break;
//                    //Print list
//                    case 2:
//                        System.out.println(linkedList.toString());
//                        break;
//                    //Add an element to the start of the list
//                    case 3:
//                        System.out.println("Please enter your element to add:");
//                        element = sc.nextInt();
//                        linkedList.addFirst(element);
//                        System.out.println("Element " + element + " added!");
//                        System.out.println(linkedList.toString());
//                        break;
//                    //Add an element to the end of the list
//                    case 4:
//                        System.out.println("Please enter your element to add:");
//                        element = sc.nextInt();
//                        linkedList.addLast(element);
//                        System.out.println("Element " + element + " added!");
//                        System.out.println(linkedList.toString());
//                        break;
//                    //Remove an element from the start of the list
//                    case 5:
//                        try {
//                            element = linkedList.removeFirst();
//                            System.out.println(element + " removed");
//                            System.out.println(linkedList.toString());
//                        }catch (NoSuchElementException e){
//                            System.out.println("The list is already empty.  No element to remove." + e.getLocalizedMessage());
//                        }
//                        break;
//                    //Remove an element from the end of the list
//                    case 6:
//                        try {
//                            element = linkedList.removeLast();
//                            System.out.println(element + " removed");
//                            System.out.println(linkedList.toString());
//                        }catch (NoSuchElementException e){
//                            System.out.println("The list is already empty.  No element to remove." + e.getLocalizedMessage());
//                        }
//                        break;
//                    //Get the first element in the list
//                    case 7:
//                        if (linkedList.peekFirst() != null) {
//                            element = linkedList.peekFirst();
//                            System.out.println(element + " is at the front of the list");
//                        } else {
//                            System.out.println("The list is empty.  No element to show.");
//                        }
//                        break;
//                    //Get the last element in the list
//                    case 8:
//                        if (linkedList.peekLast() != null) {
//                            element = linkedList.peekLast();
//                            System.out.println(element + " is at the end of the list");
//                        } else {
//                            System.out.println("The list is empty.  No element to show.");
//                        }
//                        break;
//                    //Find the middlemost element
//                    case 9:
//                        int middleNode = middleNodeSearch(linkedList);
//                        System.out.println("The middle element is " + middleNode);
//                        break;
//                    default:
//                        break;
//                }
//                System.out.println("Please select your next action from the list of menu options (10 for menu):");
//                menuChoice = sc.nextInt();
//            }
//        }
//        System.out.println("Have a great day!");
//    }
//
//    public static int menuOptions() {
//        System.out.println("Please select the applicable menu option from the below list of actions:\n" +
//                "1: Check whether the list is empty\n" +
//                "2: To print the elements in the list\n" +
//                "3: Add an element to the start of the list\n" +
//                "4: Add an element to the end of the list\n" +
//                "5: Remove an element from the start of the list\n" +
//                "6: Remove an element from the end of the list\n" +
//                "7: View the first element of the list\n" +
//                "8: View the last element of the list\n" +
//                "9: Find the middle-most element\n" +
//                "10: See the list of menu options again\n" +
//                "11: Quit the program");
//        return sc.nextInt();
//    }
//}

class LinkedList {
    Node head; //head of linked list
    //Linked list node
    class Node {
        int data;
        Node next;
        Node (int d){
            data = d;
            next = null;
        }
    }

    //Function to print the middle of the linked list
    void printMiddle(){
        Node slow_ptr = head;
        Node fast_ptr = head;
        if(head != null){
            while(fast_ptr != null && fast_ptr.next != null){
                fast_ptr = fast_ptr.next.next;
                slow_ptr = slow_ptr.next;
            }
            System.out.println("The middle element is " + slow_ptr.data);
        }
    }

    //Inserts a new Node at the front of the list
    public void push(int new_data){
        //1&2: Allocate the Node & put in the data
        Node new_node = new Node(new_data);
        //3: Make next of new node as head
        new_node.next = head;
        //4: Move the head to point to the new Node
        head = new_node;
    }

    //Prints contents of the linked list starting from the given node
    public void printList(){
        Node tnode = head;
        while (tnode != null) {
            System.out.print(tnode.data + "->");
            tnode = tnode.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args){
        LinkedList llist = new LinkedList();
        for(int i = 5; i > 0; i--){
            llist.push(i);
            llist.printList();
            llist.printMiddle();
        }
    }
}
