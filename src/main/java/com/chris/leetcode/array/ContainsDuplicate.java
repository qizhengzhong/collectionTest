package com.chris.leetcode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Ref: https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/578/
 * Given an array of integers, find if the array contains any duplicates.
 * <p>
 * Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 * <p>
 * Input: [1,2,3,1]
 * Output: true
 * <p>
 * Input: [1,2,3,4]
 * Output: false
 */
public class ContainsDuplicate {

  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 4, 5, 6, 7};
    System.out.println(containsDuplicate(nums));
  }

  public static boolean containsDuplicate(int[] nums) {
    Arrays.sort(nums);
    Set s = new HashSet();
    for (int i : nums) {
      if (s.contains(i))
        return true;
      s.add(i);
    }
    return false;
  }
}
