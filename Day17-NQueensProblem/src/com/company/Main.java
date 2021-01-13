package com.company;

import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);
    static int n;

    public static void main(String[] args) {
        System.out.println("/* ===== N Queens ===== */");
        System.out.println("Please enter a positive, non-zero integer:");
        n = sc.nextInt();
        if((n <= 0)){
            System.out.println("Please restart the program and enter a positive, non-zero integer");
        }else{
            int[][] arr = new int[n][n];
            if(!placeQueen(arr, 0)){
                System.out.println("All the queens cannot be placed");
            }else{
                print(arr);
            }
        }
    }

    public static void print(int[][] arr){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(arr[i][j] == 0){
                    System.out.print("* ");
                }else{
                    System.out.print("Q ");
                }
            }
            System.out.println();
        }
    }

    public static boolean safe(int[][] arr, int r, int c){
        int i,j;
        for(i = 0; i < c; i++){
            if(arr[r][i]==1){
                return false;
            }
        }
        for(i = r, j = c; i >= 0 && j >=0; i--, j--){
            if(arr[i][j] == 1){
                return false;
            }
        }
        for(i = r, j = c; i < n && j >=0; i++, j--){
            if(arr[i][j] == 1){
                return false;
            }
        }
        return true;
    }

    public static boolean placeQueen(int[][] arr, int c){
        int i;
        if(c >= n){
            return true;
        }
        for(i = 0; i < n; i++){
            if(safe(arr, i, c)){
                arr[i][c] = 1;
                if(placeQueen(arr, c + 1)){
                    return true;
                }
                arr[i][c] = 0;
            }
        }
        return false;
    }
}