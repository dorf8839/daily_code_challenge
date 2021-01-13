package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("/* ===== Array Series Part 6: Combination Sum===== */");
        System.out.println("Please enter your first array of numbers, separated by a space:");
        String input = sc.nextLine();
        int[] arr = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println("Please enter the number to sum to:");
        int num = sc.nextInt();
        ArrayList<ArrayList<Integer>> res = combinationSum(arr, num);
        System.out.println(res.toString());
    }

    public static ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(candidates);
        combinationSumHelper(candidates, 0, target, new ArrayList<Integer>(), res);
        return res;
    }

    public static void combinationSumHelper(int[] candidates, int start, int target, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> res){
        if(target < 0 || start < 0 || start >= candidates.length)
            return;
        if(target == 0) {
            ArrayList<Integer> result = new ArrayList<Integer>(path);
            res.add(result);
        }else {
            for(int i = start; i < candidates.length && candidates[i] <= target; i++){
                path.add(candidates[i]);
                combinationSumHelper(candidates, i, target - candidates[i], path, res);
                path.remove(path.size() - 1); //reset the variable.
            }
        }
    }

//    // another readable version
//    public List<List<Integer>> combinationSumAnother(int[] candidates, int target) {
//        List<List<Integer>> res = new ArrayList<List<Integer>>();
//        if(candidates == null || candidates.length == 0) return res;
//        Arrays.sort(candidates);
//        helper(candidates, 0, target, new ArrayList<Integer>(), res);
//        return res;
//    }
//    public void helper(int[] candidates, int start, int target, List<Integer> path, List<List<Integer>> res) {
//        if(target < 0) return;
//        else if(target == 0) {
//            // found one!
//            res.add(path);
//        } else {
//            // go on the recursion
//            for(int i = start; i < candidates.length; i++) {
//                // ignore the duplicate one.
//                if( i > start && candidates[i] == candidates[i - 1]) continue;
//                int curr = candidates[i];
//                if(target - curr >= 0) {
//                    List<Integer> temp = new ArrayList<Integer>(path);
//                    temp.add(curr);
//                    helper(candidates, i, target - curr, temp, res);
//                }
//            }
//        }
//    }
}
