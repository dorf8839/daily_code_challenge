package com.company;

import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("/* ===== Tower of Hanoi ===== */");
        System.out.println("Please enter a positive, non-zero integer:");
        int num = sc.nextInt();
        if((num <= 0)){
            System.out.println("Please restart the program and enter a positive, non-zero integer");
        }else{
            char from_rod = 'A';
            char to_rod = 'B';
            char aux_rod = 'C';
            towerOfHanoi(num, from_rod, to_rod, aux_rod);
        }
    }

    private static void towerOfHanoi(int num, char from_rod, char to_rod, char aux_rod){
        if(num == 1){
            System.out.println("Move disk 1 from rod " + from_rod + " to rod " + to_rod);
            return;
        }
        towerOfHanoi(num-1, from_rod, aux_rod, to_rod);
        System.out.println("Move disk " + num + " from rod " + from_rod + " to rod " + to_rod);
        towerOfHanoi(num-1, aux_rod, to_rod, from_rod);
    }
}
