package com.chris.leetcode.array;

/**
 * Ref: https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/567/
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * <p>
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * <p>
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */
public class MoveZeroes {
  public static void main(String[] args) {
    int[] digits = {12, 3, 0, 0, 0, 1, 0}; //12,3,0,1,0

    for (int i : moveZeroes(digits)) {
      System.out.println(i);
    }
  }

  public static int[] moveZeroes(int[] nums) {
    int index = 0; //the index of expected non-zero
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        int temp = nums[i];
        nums[i] = nums[index];
        nums[index] = temp;
        index++;
      }
    }
    return nums;

  }
}
