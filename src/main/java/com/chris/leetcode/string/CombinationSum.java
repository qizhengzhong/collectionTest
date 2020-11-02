package com.chris.leetcode.string;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Ref: https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/555/week-2-september-8th-september-14th/3457/
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 * <p>
 * Note:
 * <p>
 * All numbers will be positive integers.
 * The solution set must not contain duplicate combinations.
 * <p>
 * Input: k = 3, n = 7
 * Output: [[1,2,4]]
 * <p>
 * Input: k = 3, n = 9
 * Output: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class CombinationSum {
  public static void main(String[] args) {
    int k = 4;
    int n = 10;
    System.out.println(combinationSum3(k, n));
  }

  public static List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> results = new ArrayList<List<Integer>>();
    LinkedList<Integer> comb = new LinkedList<Integer>();
    int largestValue = (19 - k) * k / 2;
    int smallestValue = (1 + k) * k / 2;
    if (k > 10 || k < 0 || n > largestValue || n < smallestValue)
      return results;
    backtrack(n, k, comb, 0, results);
    return results;
  }

  protected static void backtrack(int remain, int k,
      LinkedList<Integer> comb, int next_start,
      List<List<Integer>> results) {

    if (remain == 0 && comb.size() == k) {
      // Note: it's important to make a deep copy here.
      results.add(new ArrayList<Integer>(comb));
      return;
    } else if (remain < 0 || comb.size() == k) {
      // Exceed the scope, no need to explore further.
      return;
    }

    // Iterate through the reduced list of candidates.
    for (int i = next_start; i < 9; ++i) {
      comb.add(i + 1);
      backtrack(remain - i - 1, k, comb, i + 1, results);
      comb.removeLast();
    }
  }
}
