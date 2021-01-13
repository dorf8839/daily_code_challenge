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
        System.out.println("User Input:");
        System.out.print("[");
        for (int i = 0; i<arr.length; i++){
            if(i != arr.length-1) {
                System.out.print(arr[i] + ", ");
            }else{
                System.out.print(arr[i] + "]");
            }
        }
        System.out.println();
        System.out.println("Please enter the element to be found:");
        int num = sc.nextInt();
        System.out.println("Requested Integer:");
        int c = -1;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == num){
                c=i;
                break;
            }
        }
        if(c != -1){
            System.out.println("Element " + num + " found at index " + c);
        }else {
            System.out.println("No such element found");
        }
    }
}
