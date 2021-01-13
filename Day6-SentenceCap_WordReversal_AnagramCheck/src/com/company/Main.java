package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Please select the program to run\n" +
                "by typing in the appropriate number:\n" +
                "1=Sentence Capitalization\n" +
                "2=Word Reversal\n" +
                "3=Anagram Check");
        Scanner input = new Scanner(System.in);
        String str = input.next();
        switch(str){
            case "1":
                sentenceCap();
                break;
            case "2":
                wordReversal();
                break;
            case "3":
                anagramCheck();
                break;
        }
    }

    public static void sentenceCap() {
        System.out.println("/* ===== Sentence Capitalization ===== */");
        System.out.println("\nPlease enter your sentence: ");
        Scanner input = new Scanner(System.in);
        String s = input.nextLine().toLowerCase();
        StringBuilder stringCapped = new StringBuilder();
        String[] words = s.split(" ");
        for (String word : words) {
            String wordCapped = word.substring(0, 1).toUpperCase() + word.substring(1);
//            System.out.println(word);
            stringCapped.append(wordCapped + " ");
        }
        System.out.println(stringCapped.toString());
    }

    public static void wordReversal() {
        System.out.println("/* ===== Word Reversal ===== */");
        System.out.println("\nPlease enter your sentence: ");
        Scanner input = new Scanner(System.in);
        StringBuilder stringReversed = new StringBuilder();
        String[] words = input.nextLine().split(" ");
        for (int i = 0; i < words.length; i++) {
            stringReversed.insert(0, words[i] + " ");
        }
        System.out.println(stringReversed.toString());
    }

    public static void anagramCheck() {
        System.out.println("/* ===== Anagram Check ===== */");
        System.out.println("\nPlease enter your first word: ");
        Scanner input = new Scanner(System.in);
        String str1 = input.next();
        System.out.println("Please enter your second word: ");
        String str2 = input.next();
        String str1Sorted = stringSorter(str1);
        String str2Sorted = stringSorter(str2);
        if(str1Sorted.equals(str2Sorted)){
            System.out.println(str1 + " and " + str2 + " are anagrams");
        }else{
            System.out.println(str1 + " and " + str2 + " are NOT anagrams");
        }
    }

    public static String stringSorter(String str){
        char[] arr = str.toCharArray();
        char temp;
        for(int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j] < arr[j - 1]) {
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
        return new String(arr);
    }
}
