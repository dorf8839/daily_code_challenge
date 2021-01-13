package com.company;

import java.util.*;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("/* ===== Stack Data Structure ===== */");
        Deque<Integer> stack = new ArrayDeque<Integer>();
        System.out.println("Would you like to add elements to your stack?[Y/N]:");
        String answer = sc.nextLine().toLowerCase();
        if (answer.equals("y")) {
            System.out.println("Please enter your list of elements, separated by a space:");
            int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int i = input.length-1; i >= 0; i--) {
                stack.add(input[i]);
            }
        }

        //Display current stack:
        printArray(stack);

        //List of menu options:
        int menuChoice = menuOptions();
        int element;
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
                    //Check is stack is empty
                    case 1:
                        if (stack.isEmpty()) {
                            System.out.println("The stack is currently empty");
                        } else {
                            System.out.println("The stack contains " + stack.size() + " elements");
                        }
                        break;
                    //Print stack
                    case 2:
                        printArray(stack);
                        break;
                    //Push an element onto the stack
                    case 3:
                        System.out.println("Please enter your element to add:");
                        element = sc.nextInt();
                        stack.push(element);
                        System.out.println("Element added!");
                        printArray(stack);
                        break;
                    //Remove the topmost element of the stack
                    case 4:
                        if (!stack.isEmpty()) {
                            stack.pop();
                            System.out.println("Element removed!");
                            printArray(stack);
                        } else {
                            System.out.println("The stack is already empty.  No element to remove.");
                        }
                        break;
                    //Show the topmost element of the stack
                    case 5:
                        System.out.println("The topmost element is: " + stack.peek());
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

    public static void printArray(Deque<Integer> stack) {
        int count = 0;
        System.out.println("Your current stack is: ");
        System.out.print("[");
        for (Iterator itr = stack.iterator(); itr.hasNext(); ) {
            if (count != stack.size() - 1) {
                System.out.print(itr.next() + ", ");
            } else {
                System.out.print(itr.next());
            }
            count++;
        }
        System.out.print("]");
        System.out.println();
    }

    public static int menuOptions() {
        System.out.println("Please select the applicable menu option from the below list of actions:\n" +
                "1: Check whether the stack is empty\n" +
                "2: To print the elements in the stack\n" +
                "3: Add a new element to the top of the stack\n" +
                "4: Remove the topmost element from the stack\n" +
                "5: View the topmost element in the stack\n" +
                "6: See the list of menu options again\n" +
                "7: Quit the program");
        return sc.nextInt();
    }
}
