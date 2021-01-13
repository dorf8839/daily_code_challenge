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
        System.out.println("/* ===== Array Series Part 1 ===== */");
        System.out.println("Please select your program:\n" +
                "1: Frequency Counter\n" +
                "2: Count Uniques\n" +
                "3: Check Power N");
        int program = sc.nextInt();
        sc.nextLine();
        if(program == 1 || program == 2 || program == 3){
            arrayGenerator(program);
        }else{
            System.out.println("Please enter a value of 1, 2, or 3");
            programPicker();
        }
    }

    private static void arrayGenerator(int program){
        switch(program){
            case 1:
                System.out.println("Please enter your numbers, separated by a space:");
                String input = sc.nextLine();
                int[] intArray = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
                Arrays.sort(intArray);
                frequencyCounter(intArray);
                break;
            case 2:
                System.out.println("Please enter your numbers, separated by a space:");
                input = sc.nextLine();
                intArray = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
                Arrays.sort(intArray);
                countUniques(intArray);
                break;
            case 3:
                int n,p;int i,j;int k=0;
                System.out.println("Enter size of the array ");
                n=sc.nextInt();
                ArrayList<Integer> arr1 = new ArrayList<>(n);
                ArrayList<Integer> arr2 = new ArrayList<>(n);
                System.out.println("Enter elements of the first array ");
                for(i=0;i<n;i++)
                    arr1.add(sc.nextInt());
                System.out.println("Enter elements of the second array ");
                for(i=0;i<n;i++)
                    arr2.add(sc.nextInt());
                System.out.println("Enter power");
                p=sc.nextInt();
                checkPowerN(arr1, arr2, p);
                break;
            default:
                break;
        }
    }

    private static void frequencyCounter(int[] intArray){
        int count=0;
        int i;
        if(intArray.length!=1){
            if(intArray[0]==intArray[1])
                count=1;
        } else {
            System.out.println(intArray[0] + " is present " + 1 + " time");
        }
        for(i=1;i<intArray.length;i++) {
            if(intArray[i]==intArray[i-1]) {
                count++;
            } else {
                System.out.println(intArray[i-1] + " is present " + count + " times");
                count=1;
            }
        }
        if(intArray.length!=1) {
            System.out.println(intArray[i-1] + " is present " + count + " times");
        }
    }

    private static void countUniques(int[] intArray){
        int count=1;
        int i;
        for(i=1; i<intArray.length; i++){
            if(intArray[i] != intArray[i-1]){
                count++;
            }
        }
        System.out.println("Number of unique elements = " + count);
    }

    private static void checkPowerN(ArrayList<Integer> arr1, ArrayList<Integer> arr2, int p){
        int n = arr1.size();
        int count=0;
        for(int i=0;i<n;i++) {
            int t=(int)(Math.pow(arr1.get(i),p));
            if(arr2.contains(t))
                count++;
        }
        if(count==n)
            System.out.println("true");
        else
            System.out.println("false");
    }
}
