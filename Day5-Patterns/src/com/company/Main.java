package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("/* ===== Pattern Generator ===== */\n" +
                "Please enter a number 1 thru 8 for your pattern:");
        Scanner input = new Scanner(System.in);
        int pattern = input.nextInt();
        input.nextLine();
        System.out.println("Please enter your input number for the chosen pattern:");
        input = new Scanner(System.in);
        int count = input.nextInt();
        patternGenerator(pattern, count);
    }

    public static void patternGenerator(int pattern, int count){
        switch(pattern){
            case 1:
                for(int i = 1; i <= count; i++){
                    for(int j = 1; j <= i; j++){
                        System.out.print(j + " ");
                    }
                    System.out.println();
                }
                break;
            case 2:
                int number = 1;
                for(int i = 1; i <= count; i++){
                    for(int j = 1; j <= i; j++) {
                        System.out.print(number + " ");
                        number++;
                    }
                    System.out.println();
                }
                break;
            case 3:
                for(int i = 1; i <= count; i++){
                    for(int j = 1; j <= i; j++){
                        System.out.print(j + " ");
                    }
                    System.out.println();
                }
                for(int i = count-1; i >= 1; i--){
                    for(int j = 1; j <= i; j++){
                        System.out.print(j + " ");
                    }
                    System.out.println();
                }
                break;
            case 4:
                for(int i = 1; i <= count; i++){
                    for(int j = count; j > i; j--){
                        System.out.print("  ");
                    }
                    for(int j = i; j <= (2*i-1); j++){
                        System.out.print(j + " ");
                    }
                    for(int j = (2*i-1)-1; j >= i; j--){
                        System.out.print(j + " ");
                    }
                    System.out.println();
                }
                break;
            case 5:
                for(int i = 1; i <= count; i++){
                    for(int j = 1; j < i; j++){
                        System.out.print("  ");
                    }
                    for(int j = 1; j <= (2 * count - (2 * i - 1)); j++){
                        System.out.print("* ");
                    }
                    System.out.println();
                }
                break;
            case 6:
                for(int i = 1; i <= count; i++){
                    for(int j = 1; j <= count - i; j++){
                        System.out.print("  ");
                    }
                    for(int j = 1; j <= (2*i-1); j++){
                        System.out.print("* ");
                    }
                    System.out.println();
                }
                for(int i = count-1; i >= 1; i--){
                    for(int j = 1; j <= count - i; j++){
                        System.out.print("  ");
                    }
                    for(int j = 1; j <= (2*i-1); j++){
                        System.out.print("* ");
                    }
                    System.out.println();
                }
                break;
            case 7:
                for(int i = 1; i < count; i++){
                    for(int j = 1; j <= count - i; j++){
                        System.out.print("* ");
                    }
                    for(int j = 1; j <= (2*i-1); j++){
                        System.out.print("  ");
                    }
                    for(int j = 1; j <= count - i; j++){
                        System.out.print("* ");
                    }
                    System.out.println();
                }
                for(int i = count-1; i >= 1; i--){
                    for(int j = 1; j <= count - i; j++){
                        System.out.print("* ");
                    }
                    for(int j = 1; j <= (2*i-1); j++){
                        System.out.print("  ");
                    }
                    for(int j = 1; j <= count - i; j++){
                        System.out.print("* ");
                    }
                    System.out.println();
                }
                break;
            case 8:
                for(int i = 1; i <= count; i++){
                    for(int j = 1; j <= 2*count; j++){
                        if(j <= count){
                            if(i < j){
                                System.out.print("  ");
                            }else{
                                System.out.print("* ");
                            }
                        }else{
                            if((i+j) < (2*count+1)){
                                System.out.print("  ");
                            }else{
                                System.out.print("* ");
                            }
                        }
                    }
                    System.out.println();
                }
                for(int i = 1; i <= count; i++){
                    for(int j = 1; j <= 2*count; j++){
                        if(j <= count){
                            if(i+j > count+1){
                                System.out.print("  ");
                            }else{
                                System.out.print("* ");
                            }
                        }else{
                            if(i > j-count){
                                System.out.print("  ");
                            }else{
                                System.out.print("* ");
                            }
                        }
                    }
                    System.out.println();
                }
                break;
        }
    }
}
