package com.company;

import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("/* ===== Naive Search ===== */");
        System.out.println("Please enter your sentence:");
        String str = sc.nextLine().toLowerCase();
        System.out.println("Please enter your pattern to search for:");
        String pat = sc.nextLine().toLowerCase();
        int count=0;

        //Using substring functionality of String
        for(int i = 0; i <= str.length()-pat.length(); i++){
            String strSearch=str.substring(i, i+pat.length());
            if(strSearch.equals(pat)){
                System.out.println(pat + " found at index of " + i);
                count++;
            }
        }
        if(count==0){
            System.out.println("Pattern not found");
        }

        //Using brute force:
        for(int i = 0; i<=str.length()-pat.length(); i++){
            int j;
            for(j=0; j<pat.length(); j++){
                if(str.charAt(i+j) != pat.charAt(j)){
                    break;
                }
            }
            if(j==pat.length()){
                System.out.println(pat + " found at index of " + i);
            }
        }
    }
}
