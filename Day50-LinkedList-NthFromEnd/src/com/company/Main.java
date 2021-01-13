package com.company;

import org.w3c.dom.Node;

import java.util.*;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("/* ===== Circular Linked List ===== */");
        Node last = null;

        //Display current list:
        traverse(last);

        //List of menu options:
        int menuChoice = menuOptions();
        int element, index;
        //Switch statement to handle chosen option
        while (menuChoice != 7) {
            //Invalid choice handler
            if (menuChoice < 1 || menuChoice > 7) {
                System.out.println("Please select an available option by entering the appropriate number");
                menuChoice = menuOptions();
                //reprint the menu
            }else if(menuChoice == 6) {
                menuChoice = menuOptions();
            }else {
                switch (menuChoice) {
                    //Traverse the list and print the elements
                    case 1:
                        traverse(last);
                        break;
                    //Add an element to the start of the list
                    case 2:
                        System.out.println("Please enter the element to add to the beginning of the list:");
                        element = sc.nextInt();
                        last = addBegin(last, element);
                        traverse(last);
                        break;
                    //Add an element to the end of the list
                    case 3:
                        System.out.println("Please enter your element to add to the end of the list:");
                        element = sc.nextInt();
                        last = addEnd(last, element);
                        traverse(last);
                        break;
                    //Add an element after a specified element in the list
                    case 4:
                        System.out.println("Please enter your element to add:");
                        element = sc.nextInt();
                        System.out.println("Please enter the value of the element to add this after:");
                        index = sc.nextInt();
                        last = addAfter(last, element, index);
                        traverse(last);
                        break;
                    //Check if the list is circular
                    case 5:
                        if(last == null){
                            System.out.println("The list is currently empty and is not circular");
                        }else if(last.next != null){
                            System.out.println("The list is circular");
                        }else{
                            System.out.println("The list is not circular");
                        }
                        break;
                    default:
                        break;
                }
                System.out.println("Please select your next action from the list of menu options (6 for menu):");
                menuChoice = sc.nextInt();
            }
        }
        System.out.println("Have a great day!");
    }

    public static int menuOptions() {
        System.out.println("Please select the applicable menu option from the below list of actions:\n" +
                "1: To traverse and print the elements in the list\n" +
                "2: Add an element to the start of the list\n" +
                "3: Add an element to the end of the list\n" +
                "4: Add an element after a specific element in the list\n" +
                "5: Check if the list is circular\n" +
                "6: See the list of menu options again\n" +
                "7: Quit the program");
        return sc.nextInt();
    }

    //node
    static class Node {
        int data;
        Node next;
    };

    static Node addToEmpty(Node last, int data){
        //This function is only for empty list
        if(last != null){
            return last;
        }

        //Creating a node dynamically
        Node temp = new Node();

        //Assigning the data
        temp.data = data;
        last = temp;

        //Creating the link
        last.next = last;

        return last;
    }

    static Node addBegin(Node last, int data){
        if(last == null) {
            return addToEmpty(last, data);
        }

        Node temp = new Node();

        temp.data = data;
        temp.next = last.next;
        last.next = temp;

        return last;
    }

    static Node addEnd(Node last, int data){
        if(last == null){
            return addToEmpty(last, data);
        }

        Node temp = new Node();

        temp.data = data;
        temp.next = last.next;
        last.next = temp;
        last = temp;

        return last;
    }

    static Node addAfter(Node last, int data, int item){
        if(last == null){
            return null;
        }

        Node temp, p;
        p = last.next;

        do{
            if(p.data == item){
                temp = new Node();
                temp.data = data;
                temp.next = p.next;
                p.next = temp;

                if(p == last){
                    last = temp;
                }
                return last;
            }
            p = p.next;
        }while(p != last.next);

        System.out.println(item + " not present in the list");
        return last;
    }

    static void traverse(Node last){
        Node p;

        //If list is empty, return
        if(last == null){
            System.out.println("List is empty");
            return;
        }

        //Pointing to first Node of the list
        p = last.next;

        //Traversing the list
        do{
            System.out.print(p.data + " ");
            p = p.next;
        }while(p != last.next);
        System.out.println();
    }

    //Function to print Nodes in a given Circular linked list
    static void printList(Node head) {
        Node temp = head;
        if(head != null){
            do{
                System.out.print(temp.data + " ");
                temp = temp.next;
            }while(temp != head);
        }
        System.out.println();
    }
}



