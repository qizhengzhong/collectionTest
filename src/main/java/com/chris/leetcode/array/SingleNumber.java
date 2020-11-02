package com.chris.leetcode.array;

/**
 * Ref: https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/549/
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 * <p>
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * <p>
 * Input: [2,2,1]
 * Output: 1
 * <p>
 * Input: [4,1,2,1,2]
 * Output: 4
 */
public class SingleNumber {
  public static void main(String[] args) {
    int[] nums = {4, 1, 2, 1, 2};
    System.out.println(singleNumber(nums));
  }

  public static int singleNumber(int[] nums) {
    int len = nums.length;
    int a = 0;
    for (int i = 0; i < len; i++) {
      a = a ^ nums[i];
    }
    System.gc();
    return a;
  }
}
