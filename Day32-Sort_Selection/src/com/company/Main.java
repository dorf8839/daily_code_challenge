package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("/* ===== Selection Sort ===== */");
        System.out.println("Please enter your list of elements, separated by a space:");
        int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        //Display original list:
        System.out.println("Original List:");
        System.out.print("[");
        for(int i = 0; i < input.length; i++){
            if(i != input.length-1) {
                System.out.print(input[i] + ", ");
            }else{
                System.out.println(input[i] + "]");
            }
        }
        //Sort list:
        int i=0;
        while(i < input.length-1){
            int min = Integer.MAX_VALUE;
            int temp;
            int index = 0;
            for(int j = i; j < input.length; j++){
                if(input[j] < min){
                    min = input[j];
                    index = j;
                }
            }
            temp = input[i];
            input[i] = min;
            input[index] = temp;
            i++;
        }
        //Display sorted list:
        System.out.println("Selection Sorted List:");
        System.out.print("[");
        for(i = 0; i < input.length; i++){
            if(i != input.length-1) {
                System.out.print(input[i] + ", ");
            }else{
                System.out.println(input[i] + "]");
            }
        }
    }
}
