package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("/* ===== Linear Search ===== */");
        System.out.println("Please enter your array:");
        String input = sc.nextLine();
        int[] arr = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
        int temp;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j + 1] < arr[j]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("User Input:");
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i != arr.length - 1) {
                System.out.print(arr[i] + ", ");
            } else {
                System.out.print(arr[i] + "]");
            }
        }
        System.out.println();
        System.out.println("Please enter the element to be found:");
        int num = sc.nextInt();
        int pos = arr.length / 2;
        System.out.println("Requested Integer by Iteration:");
        int iterationResult = binaryIteration(arr, num, 0, arr.length - 1);
        if(iterationResult != -1){
            System.out.println("Element " + num + " found at index " + iterationResult);
        }else{
            System.out.println("Element not found");
        }
        System.out.println("Requested Integer by Recursion:");
        int result = binaryRecursion(arr, num, 0, arr.length-1);
        if(result != -1){
            System.out.println("Element " + num + " found at index " + result);
        }else{
            System.out.println("Element not found");
        }
    }

    private static int binaryIteration(int[] arr, int num, int l, int r) {
        while(r>=l){
            int mid = l+(r-l)/2;
            if(arr[mid] == num){
                return mid;
            }
            if(arr[mid] < num){
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return -1;
    }

    private static int binaryRecursion(int[] arr, int num, int l, int r){
        int mid=0;
        if(r>=l){
            mid=(l+r)/2;
            if(num==arr[mid]){
                return mid;
            }else if(num>arr[mid]){
                return binaryRecursion(arr, num, mid+1, r);
            }else{
                return binaryRecursion(arr, num, l, mid-1);
            }
        }
        return -1;
    }
}
