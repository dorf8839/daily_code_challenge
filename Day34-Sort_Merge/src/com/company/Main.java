package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("/* ===== Merge Sort ===== */");
        System.out.println("Please enter your list of elements, separated by a space:");
        int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        //Display original list:
        System.out.println("Original List:");
        printArray(input);

        //Sort list:
        mergeSort(input, 0, input.length-1);

        //Display sorted list:
        System.out.println("Merge Sorted List:");
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

    public static void mergeSort(int[] arr, int l, int r){
        if(l<r){
            //Find the middle point
            int m = (l+r)/2;
            //Sort first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr, m+1, r);
            //Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    public static void merge(int[] arr, int l, int m, int r){
        //Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        //Create temp arrays
        int[] L = new int[n1];
        int[] R = new int[n2];

        //Copy data to temp arrays
        for(int i = 0; i < n1; i++){
            L[i] = arr[l+i];
        }
        for(int j = 0; j < n2; j++){
            R[j] = arr[m + 1 + j];
        }

        //Merge the temp arrays
        //Initial indexes of first and second subarrays
        int i = 0, j = 0;

        //Initial index of merged subarray array
        int k = l;
        while ( i < n1 && j < n2){
            if(L[i] <= R[j]){
                arr[k] = L[i];
                i++;
            }else{
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        //Copy remaining elements of L[], if any
        while(i < n1){
            arr[k] = L[i];
            i++;
            k++;
        }

        //Copy remaining elements of R[], if any
        while(j < n2){
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
