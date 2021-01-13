package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("/* ===== Radix Sort ===== */");
        System.out.println("Please enter your list of elements, separated by a space:");
        int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        //Display original list:
        System.out.println("Original List:");
        printArray(input);

        //Sort list:
        radixSort(input, input.length);

        //Display sorted list:
        System.out.println("Radix Sorted List:");
        printArray(input);
    }

    public static void printArray(int[] arr){
        System.out.print("[");
        for(int i = 0; i < arr.length; i++){
            if(i != arr.length-1) {
                System.out.print(arr[i] + ", ");
            }else{
                System.out.println(arr[i] + "]");
            }
        }
    }

    //The main function that sorts int[] using Radix Sort
    public static void radixSort(int[] arr, int n){
        //Find the maximum number to know number of significant digits
        int m = getMax(arr, n);
        //Do counting sort for every digit.  Note that instead of passing digit number,
        //exp is passed.  exp is 10^1, where i is current digit number.
        for(int exp=1; m/exp>0; exp *=10){
            countSort(arr, n, exp);
        }
    }

    //A utility function to get maximum value in the array
    public static int getMax(int[] arr, int n){
        int mx = arr[0];
        for (int i = 1; i < n; i++){
            if(arr[i]>mx){
                mx=arr[i];
            }
        }
        return mx;
    }

    //A function to do counting sort of the array according to the digit represented by exp
    public static void countSort(int[] arr, int n, int exp){
        int[] output = new int[n];//output array
        int i;
        int[] count = new int[10];
        Arrays.fill(count, 0);
        //Store count of occurrences in count array
        for(i = 0; i<n; i++){
            count[(arr[i]/exp) % 10]++;
        }
        //Change count[i] so that count[i] now contains actual position of this digit in output array
        for(i = 1; i<10; i++){
            count[i] += count[i-1];
        }
        //Build the output array
        for(i = n-1; i>=0; i--){
            output[count[(arr[i]/exp)%10]-1] = arr[i];
            count[(arr[i]/exp)%10]--;
        }
        //Copy the output array to arr array so that arr array now contains sorted numbers according to current digit
        for(i = 0; i < n; i++){
            arr[i] = output[i];
        }
    }


}
