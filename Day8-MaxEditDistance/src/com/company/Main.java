package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("/* ===== Max Edit Distance ===== */\n" +
                "Please enter the 1st string: ");
        Scanner input = new Scanner(System.in);
        String str1 = input.next().toLowerCase();
        System.out.println("Please enter the 2nd string: ");
        String str2 = input.next().toLowerCase();
        char[] s = str1.toCharArray();
        char[] t = str2.toCharArray();
        int dist;
        if (s.length < t.length) {
            dist = levenDist(s, t);
        } else {
            dist = levenDist(t, s);
        }
        System.out.println("Minimum # of operations are " + dist);
    }

    public static int levenDist(char[] s, char[] t) {
        int d[][] = new int[s.length + 1][t.length + 1];
        int i, j;
        int sub;
        int a, b, c;
        for (i = 0; i <= s.length; i++) {
            for (j = 0; j <= t.length; j++) {
                d[i][j] = 0;
            }
        }
        for (i = 1; i <= s.length; i++) {
            d[i][0] = i;
        }
        for (j = 1; j <= t.length; j++) {
            d[0][j] = j;
        }
        for (j = 1; j <= t.length; j++) {
            for (i = 1; i <= s.length; i++) {
                if (s[i - 1] == t[j - 1]) {
                    d[i][j] = d[i - 1][j - 1];
                } else {
                    a = d[i - 1][j - 1] + 1;
                    b = d[i][j - 1] + 1;
                    c = d[i - 1][j - 1] + 1;
                    d[i][j] = Math.min((Math.min(a, b)), c);
                }
            }
        }
        return d[s.length][t.length];
    }
}
