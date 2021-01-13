package com.company;

import java.util.*;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("/* ===== Array Circular Rotation ===== */");
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        System.out.println("Please enter your first array of numbers, separated by a space:");
        String in = sc.nextLine();
        String[] input = in.split(" ");
        for(int i = 0; i < input.length; i++){
            arr1.add(Integer.parseInt(input[i]));
        }
        Set<Integer> set = new LinkedHashSet<>();
        set.addAll(arr1);
        arr1.clear();
        arr1.addAll(set);
        set.clear();
        System.out.println("Please enter your second array of numbers, separated by a space:");
        in = sc.nextLine();
        input = in.split(" ");
        for(int i = 0; i < input.length; i++){
            arr2.add(Integer.parseInt(input[i]));
        }
        set.addAll(arr2);
        arr2.clear();
        arr2.addAll(set);
        boolean output = circularRotator(arr1, arr2);
        System.out.print("output = " + output);
    }

    public static boolean circularRotator(ArrayList<Integer> arr1, ArrayList<Integer> arr2){
        int p;
        int c = 0;
        int i;
        int j = 0;
        if(arr1.size() != arr2.size()){
            return false;
        }else{
            p = arr2.indexOf(arr1.get(0));
            if(p != -1){
                for(i = p; i < arr2.size(); i++){
                    if(arr2.get(i) == arr1.get(j)){
                        c++;
                        j++;
                    }else{
                        break;
                    }
                }
                for(i = 0; i < p; i++){
                    if(arr2.get(i) == arr1.get(j)){
                        c++;
                        j++;
                    }else{
                        break;
                    }
                }
            }
            if(c == arr1.size()){
                return true;
            }else{
                return false;
            }
        }
    }
}
