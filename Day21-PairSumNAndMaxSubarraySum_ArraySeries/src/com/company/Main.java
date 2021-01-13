package com.company;

 /**
 * @author: <dorf8839>
 * @date: <11/17/2020>
 **/

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);
    private static final int[] NO_ARRAY = {};

    public static void main(String[] args) {
        programPicker();
    }

    private static void programPicker() {
        System.out.println("/* ===== Array Series Part 4 ===== */");
        System.out.println("Please select your program:\n" +
                "1: Pair Sum N\n" +
                "2: Max Subarray Sum");
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
        System.out.println("Please enter your array numbers, separated by a space:");
        String input = sc.nextLine();
        int[] arr = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println("Please enter your number:");
        int num = sc.nextInt();
        switch (program) {
            case 1:
                Arrays.sort(arr);
                int[] sumArr = pairSumN(arr, num);
                if(sumArr.length > 0) {
                    System.out.println("[" + sumArr[0] + ", " + sumArr[1] + "]");
                }else{
                    System.out.println("[]");
                }
                break;
            case 2:
                maxSubArraySum(arr, num);
                break;
            default:
                break;
        }
    }

    private static int[] pairSumN(int[] arr, int num){
        int[] sumArr = new int[2];
        for(int i = 0; i < arr.length - 1; i++){
            for(int j = i + 1; j < arr.length; j++){
                if(arr[i] + arr[j] == num){
                    sumArr[0] = arr[i];
                    sumArr[1] = arr[j];
                    return sumArr;
                }
            }
        }
        return NO_ARRAY;
    }

    private static void maxSubArraySum(int[] arr, int num){
        int max = Integer.MIN_VALUE;
        StringBuilder strIntBuilder = new StringBuilder();
        String strInts = "";
        for(int i = 0; i <= arr.length - num; i++){
            int sum = 0;
            strIntBuilder.setLength(0);
            for(int j = i; j < i+num; j++){
                sum += arr[j];
                if(j == i+num-1) {
                    strIntBuilder.append(arr[j]);
                }else{
                    strIntBuilder.append(arr[j] + " + ");
                }
            }
            if(sum > max){
                max = sum;
                strInts = strIntBuilder.toString();
            }
        }
        System.out.println(max + " (" + strInts + ")");
    }
}
