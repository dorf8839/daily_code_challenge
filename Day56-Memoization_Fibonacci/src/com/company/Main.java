package com.company;

import java.util.*;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("/* ===== Memoization - Fibonacci Sequence ===== */");
        System.out.println("Please enter the value to create a Fibonacci Sequence for:");
        int index = sc.nextInt();
        System.out.println("Creating Fibonnaci Sequence for a value of " + index);
        Fibber fib = new Fibber();
        fib.fibonacci(index);
    }
}

class Fibber {

    private Map<Integer, Integer> memo = new HashMap<>();

    public int fibonacci(int n) {
        if(n < 0){
            throw new IllegalArgumentException(
                    "Index was negative.  No such thing as a negative index in a series");
        }
        //base cases
        if(n == 0 || n == 1) {
            return n;
        }
        //see if we've already calculated this
        if(memo.containsKey(n)){
            System.out.printf("grabbing memo[%d]\n", n);
            return memo.get(n);
        }
        System.out.printf("computing fib(%d)\n", n);
        int result = fibonacci(n -1) + fibonacci(n -2);
        //memoize
        memo.put(n, result);
        return result;
    }
}
