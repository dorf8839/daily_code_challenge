package com.company;

import java.util.Scanner;

public class Main {

    static int max=0;
    static String sm;
    public static void main(String[] args) {
        System.out.println("/* ===== Longest Common Substring ===== */");
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the first string");
        String str1 = sc.next().toLowerCase();
        System.out.println("Enter the second string");
        String str2 = sc.next().toLowerCase();
        longestSubstring(str1, str2);
        longestSubstring(str2, str1);
        System.out.println("The longest common substring is " + sm);
    }

    public static void longestSubstring(String str1, String str2){
        String str;
        for(int i=0;i<=str1.length()-1;i++)
        {
            for(int j=i+1;j<=str1.length();j++)
            {
                str=str1.substring(i,j);
                if(str2.contains(str))
                {
                    if(max<str.length())
                    {
                        max=str.length();
                        sm=str;
                    }
                }
            }
        }
    }
}
