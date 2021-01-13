package com.company;

import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("/* ===== Recursion Part 3 ===== */");
        System.out.println("Please enter a positive, non-zero integer:");
        int num = sc.nextInt();
        if(!(num > 0)){
            System.out.println("Please restart the program and enter a positive, non-zero integer");
        }else{
            print(num);
        }
    }

    private static void print(int num){
        for(int i = 0; i < num; i++){
            for(int j = 0; j <= i; j++){
                System.out.print(pascal(i,j) + " ");
            }
            System.out.println();
        }
    }

    private static int pascal(int r, int c){
        if(r==c || c==0){
            return 1;
        }else{
            return pascal(r-1,c)+pascal(r-1,c-1);
        }
    }
}
