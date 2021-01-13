package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Please select the program to run\n" +
                "by typing in the appropriate number:\n" +
                "1=Number of Vowels\n" +
                "2=Max Characters");
        Scanner input = new Scanner(System.in);
        String str = input.next();
        switch(str){
            case "1":
                numVowels();
                break;
            case "2":
                maxChars();
                break;
        }
    }

    public static void numVowels(){
        System.out.println("Please enter the string: ");
        Scanner input = new Scanner(System.in);
        String str = input.next();
        String lowerstr = str.toLowerCase();
        int count = 0;
        for(int i = 0; i < lowerstr.length(); i++){
            if(lowerstr.charAt(i) == 'a' || lowerstr.charAt(i) == 'e' || lowerstr.charAt(i) == 'i' || lowerstr.charAt(i) == 'o' || lowerstr.charAt(i) == 'u' || lowerstr.charAt(i) == 'y'){
                count++;
            }
        }
        System.out.println(str + " contains " + count + " vowels");
    }

    public static void maxChars(){
        System.out.println("Please enter the string: ");
        Scanner input = new Scanner(System.in);
        String str = input.next();
        String lowerstr = str.toLowerCase();
        char maxChar = 'z';
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < lowerstr.length(); i++){
            int count = 0;
            for(int j = 0; j < lowerstr.length(); j++){
                if (str.charAt(j) == str.charAt(i)){
                    count++;
                }
            }
            if(count > max){
                max = count;
                maxChar = str.charAt(i);
            }
        }
        System.out.println("For " + str + ", the max character of " + maxChar + " occurs " + max + " times");
    }
}
