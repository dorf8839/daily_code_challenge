package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Please enter your set of array numbers, separated by a space:");
        String input = sc.nextLine();
        int[] arr = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println("Please enter your partition size:");
        int partitionSize = sc.nextInt();
        arrayPartition(arr, partitionSize);
    }

    private static void arrayPartition(int[] arr, int partitionSize){
        for(int i = 0; i < arr.length; i++){
            int[] partedArray = new int[partitionSize];
            System.out.print("[");
            for(int j = 0; j <= partitionSize-1; j++){
                if(i == arr.length){
                    System.out.print("null]");
                    break;
                }else {
                    partedArray[j] = arr[i];
                    System.out.print(partedArray[j]);
                    if (j < partitionSize - 1) {
                        System.out.print(", ");
                        i++;
                    } else {
                        System.out.print("], ");
                    }
                }
            }
        }
    }
}
