package com.company;

import java.util.*;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("/* ===== Binary Search Tree - Depth First Search ===== */");
        SearchTree tree = new SearchTree(null);
        System.out.println("Would you like to add elements to your Binary Search Tree?[Y/N]:");
        String answer = sc.nextLine().toLowerCase();
        if (answer.equals("y")) {
            System.out.println("Please enter your list of elements, separated by a space:");
            String stringData = sc.nextLine();
            String[] data = stringData.split(" ");
            for (String s : data) {
                tree.addItem(new Node(s));
            }
            //Display current search tree:
            tree.traverseInOrder(tree.getRoot());
            System.out.println();
        }

        //List of menu options:
        int menuChoice = menuOptions();
        String element;
        boolean result;
        //Switch statement to handle chosen option
        while (menuChoice != 9) {
            //Invalid choice handler
            if (menuChoice < 1 || menuChoice > 9) {
                System.out.println("Please select an available option by entering the appropriate number");
                menuChoice = menuOptions();
                //reprint the menu
            }else if(menuChoice == 8) {
                menuChoice = menuOptions();
            }else {
                switch (menuChoice) {
                    //Check if search tree is empty
                    case 1:
                        if (tree.getRoot() == null) {
                            System.out.println("The list is currently empty");
                        } else {
                            System.out.println("The list contains " + tree.getSize() + " elements");
                        }
                        break;
                    //Print search tree using Preorder Traversal
                    case 2:
                        tree.traversePreOrder(tree.getRoot());
                        System.out.println();
                        break;
                    //Print search tree using Inorder Traversal
                    case 3:
                        tree.traverseInOrder(tree.getRoot());
                        System.out.println();
                        break;
                    //Print search tree using Postorder Traversal
                    case 4:
                        tree.traversePostOrder(tree.getRoot());
                        System.out.println();
                        break;
                    //Add an element to the search tree
                    case 5:
                        System.out.println("Please enter your element to add:");
                        element = String.valueOf(sc.nextInt());
                        result = tree.addItem(new Node(element));
                        if(result) {
                            System.out.println("Element " + element + " added!");
                        }
                        tree.traverseInOrder(tree.getRoot());
                        System.out.println();
                        break;
                    //Remove an element from the search tree
                    case 6:
                        System.out.println("Please enter your element to remove:");
                        element = String.valueOf(sc.nextInt());
                        result = tree.removeItem(new Node(element));
                        if(result) {
                            System.out.println("Element " + element + " removed!");
                        }else{
                            System.out.println("Element " + element + " could not be found");
                        }
                        tree.traverseInOrder(tree.getRoot());
                        System.out.println();
                        break;
                    //Find an element in the search tree
                    case 7:
                        System.out.println("Please enter your element to find:");
                        element = String.valueOf(sc.nextInt());
                        result = tree.findItem(new Node(element));
                        if(result){
                            System.out.println("Element " + element + " found!");
                        }else{
                            System.out.println("Element " + element + " could not be found.  Would you like to add it to the tree?[Y/N]");
                            answer = sc.next().toLowerCase();
                            if(answer.equals("y")){
                                result = tree.addItem(new Node(element));
                                if(result) {
                                    System.out.println("Element " + element + " added!");
                                }
                                tree.traverseInOrder(tree.getRoot());
                                System.out.println();
                            }
                        }
                        break;
                    default:
                        break;
                }
                System.out.println("Please select your next action from the list of menu options (8 for menu):");
                menuChoice = sc.nextInt();
            }
        }
        System.out.println("Have a great day!");
    }

    public static int menuOptions() {
        System.out.println("Please select the applicable menu option from the below list of actions:\n" +
                "1: Check whether the search tree is empty\n" +
                "2: To print the elements in the search tree using Preorder Traversal\n" +
                "3: To print the elements in the search tree using Inorder Traversal\n" +
                "4: To print the elements in the search tree using Postorder Traversal\n" +
                "5: Add an element to the search tree\n" +
                "6: Remove an element from the search tree\n" +
                "7: Find an element in the search tree\n" +
                "8: See the list of menu options again\n" +
                "9: Quit the program");
        return sc.nextInt();
    }
}