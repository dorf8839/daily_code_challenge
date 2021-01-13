package com.company;

/**
 * @author: <dorf8839>
 * @date: <11/18/2020>
 **/

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        programPicker();
    }

    private static void programPicker() {
        System.out.println("/* ===== Array Series Part 5: Common Elements Search===== */");
        System.out.println("Please select your program:\n" +
                "1: Two Array Comparator\n" +
                "2: Three Array Comparator");
        int program = sc.nextInt();
        sc.nextLine();
        if (program == 1 || program == 2) {
            arrayGenerator(program);
        } else {
            System.out.println("Please enter a value of 1 or 2");
            programPicker();
        }
    }

    private static void arrayGenerator(int program) {
        System.out.println("Please enter your first array of numbers, separated by a space:");
        String input = sc.nextLine();
        int[] arr1 = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr1);
        System.out.println("Please enter your second array of numbers, separated by a space:");
        input = sc.nextLine();
        int[] arr2 = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr2);
        switch (program) {
            case 1:
                System.out.println("Common elements are: ");
                ArrayComparator(arr1, arr2);
                break;
            case 2:
                System.out.println("Please enter your third array of numbers, separated by a space:");
                input = sc.nextLine();
                int[] arr3 = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
                Arrays.sort(arr3);
                System.out.println("Common elements are: ");
                ArrayComparator(arr1, arr2, arr3);
                break;
            default:
                break;
        }
    }

    private static void ArrayComparator(int[] arr1, int[] arr2){
        int i = 0;
        int j = 0;
        while(true){
            if(arr1[i] > arr2[j]){
                j++;
            }else if (arr1[i] < arr2[j]){
                i++;
            }else{
                if(i==0 || j==0){
                    System.out.print(arr1[i] + " ");
                }
                if(i!=0 && arr1[i]!=arr1[i-1] && j!=0 && arr2[j]!=arr2[j-1]){
                    System.out.print(arr1[i] + " ");
                    i++;
                    j++;
                }else{
                    i++;
                    j++;
                }
            }
            if(i==arr1.length || j==arr2.length){
                break;
            }
        }
    }

    private static void ArrayComparator(int[] arr1, int[] arr2, int[] arr3){
        int i = 0;
        int j = 0;
        int k = 0;
        while(true){
            if(arr1[i]==arr2[j] && arr2[j]==arr3[k]){
                System.out.print(arr1[i] + " ");
            }
            if(arr1[i] < arr2[j]){
                i++;
            }else if(arr2[j] < arr3[k]){
                j++;
            }else{
                k++;
            }
            if(i== arr1.length || j==arr2.length || k==arr3.length){
                break;
            }
        }
    }
}
