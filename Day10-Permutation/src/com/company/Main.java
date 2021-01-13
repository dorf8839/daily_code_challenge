package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("/* ===== Permutation ===== */\n" +
                "Please enter string: ");
        Scanner input = new Scanner(System.in);
        char[] arr = input.next().toCharArray();
        System.out.println("The permutations are:");
        permute(arr, arr.length, arr.length);
    }

    public static void permute(char[] arr, int size, int n){
        char b;
        if(size == 1){
            for(int i=0; i<n; i++){
                System.out.print(arr[i]);
            }
            System.out.println();
        }
        for(int i=0; i<size; i++){
            permute(arr, size-1, n);
            if(size%2 == 1){
                b=arr[0];
                arr[0]=arr[size-1];
            }else{
                b=arr[i];
                arr[i]=arr[size-1];
            }
            arr[size-1]=b;
        }
    }
}
