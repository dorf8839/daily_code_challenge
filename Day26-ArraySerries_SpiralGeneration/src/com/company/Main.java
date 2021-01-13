package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("/* ===== Spiral Generation ===== */");
        System.out.println("Please enter the applicable number of the program you wish to run:\n" +
                "1: Spiral Matrix Generator (1D to 2D)\n" +
                "2: Matrix Spiral Copy (2D to 1D)");
        int program = sc.nextInt();
        runProgram(program);
    }

    public static void runProgram(int program){
        switch (program){
            case 1:
                System.out.println("Please enter the length of your square tile");
                int length = sc.nextInt();
                spiralGenerator(length);
                break;
            case 2:
                System.out.println("Please enter the length of your square tile\n" +
                        "(Note: if you enter in more integers for a given row than the length you specified,\n" +
                        "the remaining integers will be used in the subsequent row):");
                length = sc.nextInt();
                int[][] spiralMatrix = new int[length][length];
                for(int i = 0; i < length; i++){
                    System.out.println("Please enter integers for row " + (i+1) + ":");
                    for (int j = 0; j < length; j++) {
                        spiralMatrix[i][j] = sc.nextInt();
                    }
                }
                System.out.println("Original Tile:");
                for (int i = 0; i < spiralMatrix.length; i++) {
                    for (int j = 0; j < spiralMatrix[i].length; j++) {
                        System.out.print(spiralMatrix[i][j] + ", ");
                    }
                    System.out.println();
                }
                matrixCopy(spiralMatrix);
        }

    }

    public static void spiralGenerator(int length){
        int[][] spiral = new int[length][length];
        int topRow = 0;
        int btmRow = length-1;
        int leftCol = 0;
        int rightCol = length-1;
        int count = 1;

        while((topRow<=btmRow) && (leftCol<=rightCol)){
            //Populate the top row
            for(int i=leftCol; i<=rightCol; i++){
                spiral[topRow][i] = count++;
            }
            topRow++;

            //Populate the right column
            for(int i=topRow; i<=btmRow; i++){
                spiral[i][rightCol]=count++;
            }
            rightCol--;

            //Populate the bottom row IF top row has not become greater than bottom row
            if(topRow <= btmRow){
                for(int i=rightCol; i>=leftCol; i--){
                    spiral[btmRow][i]=count++;
                }
                btmRow--;
            }

            //Populate the left column IF right column has not become less than left column
            if(rightCol >= leftCol){
                for(int i=btmRow; i>=topRow; i--){
                    spiral[i][leftCol]=count++;
                }
                leftCol++;
            }
        }
        System.out.println("Spiral Tile:");
        for (int i = 0; i < spiral.length; i++) {
            for (int j = 0; j < spiral[i].length; j++) {
                System.out.print(spiral[i][j] + ", ");
            }
            System.out.println();
        }
    }

    public static void matrixCopy(int[][] spiralMatrix){
        int topRow = 0;
        int btmRow = spiralMatrix.length-1;
        int leftCol = 0;
        int rightCol = spiralMatrix[0].length-1;
        ArrayList<Integer> oneDMatrix = new ArrayList<>();

        while((topRow<=btmRow) && (leftCol<=rightCol)){
            //Retrieve the top row
            for(int i=leftCol; i<=rightCol; i++){
                oneDMatrix.add(spiralMatrix[topRow][i]);
            }
            topRow++;

            //Populate the right column
            for(int i=topRow; i<=btmRow; i++){
                oneDMatrix.add(spiralMatrix[i][rightCol]);

            }
            rightCol--;

            //Populate the bottom row IF top row has not become greater than bottom row
            if(topRow <= btmRow){
                for(int i=rightCol; i>=leftCol; i--){
                    oneDMatrix.add(spiralMatrix[btmRow][i]);
                }
                btmRow--;
            }

            //Populate the left column IF right column has not become less than left column
            if(rightCol >= leftCol){
                for(int i=btmRow; i>=topRow; i--){
                    oneDMatrix.add(spiralMatrix[i][leftCol]);
                }
                leftCol++;
            }
        }
        System.out.println("1D Matrix Copy:");
        System.out.println(oneDMatrix.toString());
    }
}
