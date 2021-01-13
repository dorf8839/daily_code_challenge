package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        programPicker();
    }

    private static void programPicker(){
        System.out.println("/* ===== Array Series Part 2 ===== */");
        System.out.println("Please select your program:\n" +
                "1: Cartesian Product\n" +
                "2: Fisher-Yates Shuffle");
        int program = sc.nextInt();
        sc.nextLine();
        if(program == 1 || program == 2){
            arrayGenerator(program);
        }else{
            System.out.println("Please enter a value of 1 or 2");
            programPicker();
        }
    }

    private static void arrayGenerator(int program){
        switch(program){
            case 1:
                System.out.println("Please enter your first array numbers, separated by a space:");
                String input = sc.nextLine();
                int[] arr1 = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
                System.out.println("Please enter your second array numbers, separated by a space:");
                input = sc.nextLine();
                int[] arr2 = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
                cartesianProduct(arr1, arr2);
                break;
            case 2:
                System.out.println("Please enter your numbers, separated by a space:");
                input = sc.nextLine();
                int[] arr = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
                fisherYates(arr);
                break;
            default:
                break;
        }
    }

    private static void cartesianProduct(int[] arr1, int[] arr2){
        for(int i = 0; i < arr1.length; i++){
            for(int j = 0; j< arr2.length; j++){
                System.out.print("[" + arr1[i] + ", " + arr2[j] + "]");
                System.out.println();
            }
        }
    }

    private static void fisherYates(int[] arr){
        ArrayList<Integer> inArr = new ArrayList<>(arr.length);
        ArrayList<Integer> outArr = new ArrayList<>(arr.length);
        int k;
        for(int i = 0; i < arr.length; i++){
            inArr.add(arr[i]);
        }
        while(inArr.size() > 0){
            k = (int) (Math.random() * inArr.size());
            outArr.add(inArr.get(k));
            inArr.remove(k);
        }
        System.out.println(outArr.toString());
    }
}
