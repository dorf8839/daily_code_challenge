package com.company;

import java.util.*;

//Note: I've been using the Deque Object when I should have been using Stack. Not much of the code will change but it is important to know.

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("/* ===== Stack Data Structure ===== */");
        Deque<Integer> stack = new ArrayDeque<>();
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
                    //Find the maximum element of the stack
                    case 4:
                        int max = Integer.MIN_VALUE;
                        int temp;
                        for (Integer integer : stack) {
                            temp = Integer.parseInt(integer.toString());
                            if (temp > max) {
                                max = temp;
                            }
                        }
                        System.out.println("The maximum element in your stack is : " + max);
                        break;
                    //Reverse the order of the stack
                    case 5:
                        Deque<Integer> reversedStack = new ArrayDeque<>();
                        for (Integer integer : stack) {
                            reversedStack.push(stack.pop());
                        }
                        stack.addAll(reversedStack);
                        printArray(stack);
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
                "4: Find the maximum element of the stack\n" +
                "5: Reverse the order of the stack\n" +
                "6: See the list of menu options again\n" +
                "7: Quit the program");
        return sc.nextInt();
    }

//    public static Deque<Integer> reverseOrder (Deque<Integer> stack){
//
//    }
}
