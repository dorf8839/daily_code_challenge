package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("/* ===== Hamming Distance ===== */\n" +
                            "Please enter the 1st string: ");
        Scanner input = new Scanner(System.in);
        String str1 = input.next().toLowerCase();
        System.out.println("Please enter the 2nd string: ");
        String str2 = input.next().toLowerCase();
        int distance = 0;

        if(str1.length() != str2.length()){
            System.out.println("Please enter strings of matching length");
            return;
        }else{
            for(int i = 0; i < str1.length(); i++){
                if(str1.charAt(i) != str2.charAt(i)){
                    distance++;
                }
            }
        }
        System.out.println("The Hamming Distance between " + str1 + " and " + str2 + " is " + distance);
    }
}
