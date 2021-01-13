package com.corydorfner;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("/* ===== Fizz Buzz ===== */");
        Scanner input = new Scanner(System.in);
        System.out.println("\nEnter a number: ");
        int n = input.nextInt();
        for(int i = 1; i <= n; i++){
            if(i%3 == 0 && i%5 == 0){
                System.out.println("FizzBuzz");
            }else if(i%3 == 0){
                System.out.println("Fizz");
            }else if(i%5 == 0){
                System.out.println("Buzz");
            }else{
                System.out.println(i);
            }
        }
    }
}
