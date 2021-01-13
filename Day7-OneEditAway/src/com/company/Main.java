package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("/* ===== One Edit Away ===== */\n" +
                "Please enter the 1st string: ");
        Scanner input = new Scanner(System.in);
        String str1 = input.next().toLowerCase();
        System.out.println("Please enter the 2nd string: ");
        String str2 = input.next().toLowerCase();
        int distance = 0;
        int l;

        if (Math.abs(str1.length()-str2.length()) <= 1) {
            if(str1.length() < str2.length()){
                l = str1.length();
            }else{
                l = str2.length();
            }
            for (int i = 0; i < l; i++) {
                if (str1.charAt(i) != str2.charAt(i)) {
                    distance++;
                }
            }
            if ((distance == 1) || (distance + 1) == 1) {
                System.out.println("yes");
            }else{
                System.out.println("no");
            }
        }else {
            System.out.println("no");
        }
    }
}

