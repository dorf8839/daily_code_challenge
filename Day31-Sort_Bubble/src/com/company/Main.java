package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("/* ===== Bubble Sort ===== */");
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
        int temp;
        for(int i = 0; i < input.length; i++){
            for(int j=0; j < input.length-1; j++){
                if(input[j] > input[j+1]){
                    temp = input[j+1];
                    input[j+1]=input[j];
                    input[j] = temp;
                }
            }
        }
        //Display sorted list:
        System.out.println("Bubble Sorted List:");
        System.out.print("[");
        for(int i = 0; i < input.length; i++){
            if(i != input.length-1) {
                System.out.print(input[i] + ", ");
            }else{
                System.out.println(input[i] + "]");
            }
        }
    }
}
