package com.company;

import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        programPicker();
    }

    private static void programPicker(){
        System.out.println("/* ===== Recursion ===== */");
        System.out.println("What program would you like to run:\n" +
                "1: Factorial\n" +
                "2: Fibonacci");
        int program = sc.nextInt();
        if(program == 1 || program == 2){
            numberPicker(program);
        }else {
            System.out.println("Please enter a value of 1 or 2");
            programPicker();
        }
    }

    private static void numberPicker(int program){
        System.out.println("Please enter your number:");
        int num = sc.nextInt();
        if(num > 0) {
            switch (program) {
                case 1:
                    int factorial = runFactorial(num);
                    System.out.println("The factorial of " + num + " is " + factorial);
                    break;
                case 2:
                    System.out.println("\nThe " + num + "th element in fibonacci series is: " + runFibonacci(num));
                    System.out.println("The sequence is: ");
                    for(int i = 1; i <= num; i++) {
                        if(i < num) {
                            System.out.print(runFibonacci(i) + ", ");
                        }else{
                            System.out.print(runFibonacci(i));
                        }
                    }
                    break;
            }
        }else{
            System.out.println("Please enter a positive, non-zero integer");
            numberPicker(program);
        }
    }

    private static int runFactorial(int num){
        if(num > 1){
            return num * runFactorial(num - 1);
        }else{
            return 1;
        }
    }

    private static int runFibonacci(int num){
//        System.out.println("Running Fibonacci with value of " + num);
        if(num <= 2){
            return 1;
        }else {
            return runFibonacci(num - 1) + runFibonacci(num - 2);
        }
    }
}
