package com.company;

import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("/* ===== Minesweeper Board Generator ===== */");
        System.out.println("Please enter the singular dimension of width/height for your board");
        int length = sc.nextInt();
        int[][] board = boardGenerator(length);
        System.out.println("Minesweeper Board:");
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                System.out.print(board[i][j] + ", ");
            }
            System.out.println();
        }
    }

    public static int[][] boardGenerator(int length) {
        int[][] board = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                board[i][j] = 0;
            }
        }
        int x;
        int y;
        System.out.println("Please enter the row and column integers of a bomb, separated by a space.\n" +
                "Allowed integers are between 0 and " + (board.length-1) +
                "\nType any letter to exit");
        while (true) {
            if (sc.hasNextInt() == false) {
                return board;
            } else {
                x = sc.nextInt();
                y = sc.nextInt();
                if (x > board.length - 1 || y > board.length - 1) {
                    System.out.println("Please enter positions between 0 and " + (board.length-1) + " for the bomb placement.\n" +
                            "You will be restarted with a blank board");
                    boardGenerator(length);
                } else {
                    board[x][y] = -1;
                    for (int i = -1; i <= 1; i++) {
                        for (int j = -1; j <= 1; j++) {
                            if (((x + i >= 0) && (x + i < length)) && ((y + j >= 0) && (y + j < length))) {
                                if (board[x + i][y + j] != -1) {
                                    board[x + i][y + j]++;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
