package com.company;

import java.util.*;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("/* ===== Binary Search Tree ===== */");
//        SearchTree tree = new SearchTree(null);
//        System.out.println("Would you like to add elements to your Binary Search Tree?[Y/N]:");
//        String answer = sc.nextLine().toLowerCase();
//        if (answer.equals("y")) {
//            System.out.println("Please enter your list of elements, separated by a space:");
//            String stringData = sc.nextLine();
//            String[] data = stringData.split(" ");
//            for (String s : data) {
//                tree.addItem(new Node(s));
//            }
//            //Display current search tree:
//            tree.traverse(tree.getRoot());
//            System.out.println();
//        }

        Node station1 = new Node("Westminster", null, null);
        Node station2 = new Node("Waterloo", station1, null);
        Node station3 = new Node("Trafalgar Square", station1, station2);
        Node station4 = new Node("Canary Wharf", station2, station3);
        Node station5 = new Node("London Bridge", station4, station3);
        Node station6 = new Node("Tottenham Court Road", station5, station4);

        BreadthFirstSearch bfs = new BreadthFirstSearch(station6, station1);

        if(bfs.compute())
            System.out.print("Path Found!");

//        //List of menu options:
//        int menuChoice = menuOptions();
//        String element;
//        boolean result;
//        //Switch statement to handle chosen option
//        while (menuChoice != 8) {
//            //Invalid choice handler
//            if (menuChoice < 1 || menuChoice > 8) {
//                System.out.println("Please select an available option by entering the appropriate number");
//                menuChoice = menuOptions();
//                //reprint the menu
//            }else if(menuChoice == 7) {
//                menuChoice = menuOptions();
//            }else {
//                switch (menuChoice) {
//                    //Check if search tree is empty
//                    case 1:
//                        if (tree.getRoot() == null) {
//                            System.out.println("The list is currently empty");
//                        } else {
//                            System.out.println("The list contains " + tree.getSize() + " elements");
//                        }
//                        break;
//                    //Print search tree
//                    case 2:
//                        tree.traverse(tree.getRoot());
//                        System.out.println();
//                        break;
//                    //Add an element to the search tree
//                    case 3:
//                        System.out.println("Please enter your element to add:");
//                        element = String.valueOf(sc.nextInt());
//                        result = tree.addItem(new Node(element));
//                        if(result) {
//                            System.out.println("Element " + element + " added!");
//                        }
//                        tree.traverse(tree.getRoot());
//                        System.out.println();
//                        break;
//                    //Remove an element from the search tree
//                    case 4:
//                        System.out.println("Please enter your element to remove:");
//                        element = String.valueOf(sc.nextInt());
//                        result = tree.removeItem(new Node(element));
//                        if(result) {
//                            System.out.println("Element " + element + " removed!");
//                        }else{
//                            System.out.println("Element " + element + " could not be found");
//                        }
//                        tree.traverse(tree.getRoot());
//                        System.out.println();
//                        break;
//                    //Find an element in the search tree
//                    case 5:
//                        System.out.println("Please enter your element to find:");
//                        element = String.valueOf(sc.nextInt());
//                        result = tree.findItem(new Node(element));
//                        if(result){
//                            System.out.println("Element " + element + " found!");
//                        }else{
//                            System.out.println("Element " + element + " could not be found.  Would you like to add it to the tree?[Y/N]");
//                            answer = sc.next().toLowerCase();
//                            if(answer.equals("y")){
//                                result = tree.addItem(new Node(element));
//                                if(result) {
//                                    System.out.println("Element " + element + " added!");
//                                }
//                                tree.traverse(tree.getRoot());
//                                System.out.println();
//                            }
//                        }
//                        break;
//                    //Find an element in the search tree using Breadth First Search:
//                    case 6:
//                    default:
//                        break;
//                }
//                System.out.println("Please select your next action from the list of menu options (7 for menu):");
//                menuChoice = sc.nextInt();
//            }
//        }
//        System.out.println("Have a great day!");
    }

    public static int menuOptions() {
        System.out.println("Please select the applicable menu option from the below list of actions:\n" +
                "1: Check whether the search tree is empty\n" +
                "2: To print the elements in the search tree\n" +
                "3: Add an element to the search tree\n" +
                "4: Remove an element from the search tree\n" +
                "5: Find an element in the search tree\n" +
                "6: Use Breadth First Search to find an element\n" +
                "7: See the list of menu options again\n" +
                "8: Quit the program");
        return sc.nextInt();
    }
}

//        tree.removeItem(new Node("3"));
//        tree.traverse(tree.getRoot());
//
//        tree.removeItem(new Node("5"));
//        tree.traverse(tree.getRoot());
//
//        tree.removeItem(new Node("0"));
//        tree.removeItem(new Node("4"));
//        tree.removeItem(new Node("2"));
//        tree.traverse(tree.getRoot());
//
//        tree.removeItem(new Node("9"));
//        tree.traverse(tree.getRoot());
//        tree.removeItem(new Node("8"));
//        tree.traverse(tree.getRoot());
//        tree.removeItem(new Node("6"));
//        tree.traverse(tree.getRoot());
//        tree.removeItem(tree.getRoot());
//        tree.traverse(tree.getRoot());
//        tree.removeItem(tree.getRoot());
//        tree.traverse(tree.getRoot());