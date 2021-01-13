package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("/* ===== Quick Sort ===== */");
        System.out.println("Please enter your list of elements, separated by a space:");
        int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        //Display original list:
        System.out.println("Original List:");
        printArray(input);

        //Sort list:
        quickSort(input, 0, input.length-1);

        //Display sorted list:
        System.out.println("Quick Sorted List:");
        printArray(input);
    }

    public static void printArray(int[] arr){
        System.out.print("[");
        for(int i = 0; i < arr.length; i++){
            if(i != arr.length-1) {
                System.out.print(arr[i] + ", ");
            }else{
                System.out.println(arr[i] + "]");
            }
        }
    }

    //The main function that implements QuickSort()
    //arr[] --> Array to be sorted,
    //low --> Starting index,
    //high --> Ending index
    public static void quickSort(int[] arr, int low, int high){
        if(low < high){
            ////pi is the partitioning index, arr[pi] is now at the right place
            int pi = partition(arr, low, high);
            //Recursively sort elements before partition and after partition
            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1, high);
        }
    }

    //This function takes the last element as the pivot, places the pivot element at its correct
    //position in a sorted array, and places all smaller (smaller than pivot) to the left of the
    //pivot and all greater elements to the right of the pivot
    public static int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int i = (low-1); //index of smaller element
        for (int j = low; j < high; j++){
            //If current element is smaller than the pivot
            if(arr[j] < pivot){
                i++;
                //swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        //swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i+1;
    }
}
