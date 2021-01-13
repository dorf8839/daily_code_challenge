package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("/* ===== Smallest Substring ===== */");
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a string");
        String s = sc.next().toLowerCase();
        System.out.println("Enter an array");
        char[] a = sc.next().toLowerCase().toCharArray();
        generate(s, a);
    }

    public static void generate(String str,char c[]) {
        String s;
        int min;
        min=str.length();
        String s1="";
        for(int i=0; i<=str.length()-1; i++) {
            for(int j=i+1; j<=str.length(); j++) {
                s=str.substring(i, j);
                if(check(s, c)==true) {
                    if(min>=s.length()) {
                        min=s.length();
                        s1=s;
                    }
                }
            }
        }
        if(s1.length() > 0) {
            System.out.println(s1);
        }else{
            System.out.println("No matching substring could be found");
        }
    }

    public static boolean check (String s,char []c) {
        String str=new String(c);
        int k=0;
        for(int i=0; i<c.length; i++) {
            if(s.contains(str.substring(i, i+1))) {
                k++;
            }
        }
        if(k ==c.length) {
            return true;
        }else {
            return false;
        }
    }
}
