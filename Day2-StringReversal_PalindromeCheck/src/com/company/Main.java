package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Please select the program to run\n" +
                            "by typing in the appropriate number:\n" +
                            "1=String Reversal\n" +
                            "2=Palindrome Check");
        Scanner input = new Scanner(System.in);
        String str = input.next();
        switch(str){
            case "1":
                stringReversal();
                break;
            case "2":
                palindromeCheck();
                break;
        }
    }

    public static void stringReversal(){
        System.out.println("/* ===== String Reversal ===== */");
        System.out.println("\nPlease enter the string: ");
        Scanner input = new Scanner(System.in);
        String str = input.next().toLowerCase();
        String reversed = "";

        for(int i = 0; i < str.length(); i++){
            reversed = str.charAt(i) + reversed;
        }

        System.out.println("Reversed String: " + reversed);
    }

    public static void palindromeCheck(){
        System.out.println("/* ===== Palindrome Check ===== */");
        System.out.println("\nPlease enter the string: ");
        Scanner input = new Scanner(System.in);
        String str = input.next().toLowerCase();
        int size = str.length(), flag = 1;

        for(int i = 0, j=size-1; i <= size/2; i++, j--){
            if(str.charAt(i) != str.charAt(j)){
                flag = 0;
                break;
            }
        }

        if(flag == 0){
            System.out.println(str + " is NOT a palindrome :(");
        }else{
            System.out.println(str + " is a palindrome!");
        }
    }
}
