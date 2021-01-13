package com.company;

import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("/* ===== Array Circular Rotation ===== */");
        System.out.println("Please enter the length of your square tile\n" +
                "(Note: if you enter in more integers for a given row than the length you specified,\n" +
                "the remaining integers will be used in the subsequent row):");
        int length = sc.nextInt();
        int[][] squareTile = new int[length][length];
        for(int i = 0; i < length; i++){
            System.out.println("Please enter integers for row " + (i+1) + ":");
            for (int j = 0; j < length; j++) {
                squareTile[i][j] = sc.nextInt();
            }
        }
        System.out.println("Original Tile:");
        for (int i = 0; i < squareTile.length; i++) {
            for (int j = 0; j < squareTile[i].length; j++) {
                System.out.print(squareTile[i][j] + ", ");
            }
            System.out.println();
        }
        rotateTile(squareTile);
    }


    public static void rotateTile(int[][] squareTile) {
        int[][] rotatedTile = new int[squareTile.length][squareTile.length];
        int k = 0;
        for (int j = rotatedTile.length - 1; j >= 0; j--) {
            int l = 0;
            for (int i = 0; i < rotatedTile.length; i++) {
                rotatedTile[i][j] = squareTile[k][l];
                l++;
            }
            k++;
        }
        System.out.println("Rotated Tile:");
        for (int i = 0; i < rotatedTile.length; i++) {
            for (int j = 0; j < rotatedTile[i].length; j++) {
                System.out.print(rotatedTile[i][j] + ", ");
            }
            System.out.println();
        }
    }
}
