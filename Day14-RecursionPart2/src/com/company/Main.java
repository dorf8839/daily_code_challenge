package com.company;

import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        programPicker();
    }

    private static void programPicker() {
        System.out.println("/* ===== Recursion Part 2 ===== */");
        System.out.println("What program would you like to run:\n" +
                "1: Sum\n" +
                "2: Product");
        int program = sc.nextInt();
        if (program == 1 || program == 2) {
            numberPicker(program);
        } else {
            System.out.println("Please enter a value of 1 or 2");
            programPicker();
        }
    }

    private static void numberPicker(int program) {
        switch (program) {
            case 1:
                System.out.println("Please enter a number");
                int num = sc.nextInt();
                int sum = runSum(num);
                System.out.println("The sum of " + num + " is " + sum);
                break;
            case 2:
                System.out.println("Enter the first number:");
                int num1 = sc.nextInt();
                System.out.println("Enter the second number:");
                int num2 = sc.nextInt();
                int product = runProduct(num1, num2);
                System.out.println("The product of " + num1 + " and " + num2 + " is " + product);
                break;
        }
    }

    private static int runSum(int num){
        int sum = 0;
        if(num/10 < 1){
            return num;
        }else{
            return (num%10) + runSum(num/10);
        }
    }

    private static int runProduct(int num1, int num2){
        if(num1 == 1){
            return num2;
        }
        if(num1 == 0 || num2 == 0){
            return 0;
        }
        if(num1 < 0 && num2 < 0){
            return runProduct(num1*-1, num2*-1);
        }else if(num2 < 0){
            return runProduct(num2, num1);
        }else{
            return num1 + runProduct(num1, num2 - 1);
        }
    }
}
