package com.chris.leetcode.array;

/**
 * Ref: https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/646/
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 *
 * Input: nums = [-1,-100,3,99], k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 *
 * Constraints:
 * 1 <= nums.length <= 2 * 10^4
 * It's guaranteed that nums[i] fits in a 32 bit-signed integer.
 * k >= 0
 */
public class RotateArray {

  public static void main(String[] args) {
    int[] nums = {1,2,3,4,5,6,7};

    rotate(nums, 8);
    for(int i=0; i<nums.length;i++) {
      System.out.println(nums[i]);
    }
  }
  public static void rotate(int[] nums, int k) {
      if(k == 0) {
        return;
      }
      k = k%nums.length;

      reverse(nums, 0, nums.length-1); //reverse whole array
      reverse(nums, 0, k-1); // reverse the first few ones that needed
      reverse(nums, k, nums.length-1); // reverse the reset of them
    }

    public static void reverse(int[] nums, int start, int end) {
    while(start < end) {
      int temp = nums[end];
      nums[end--] = nums[start];
      nums[start++] = temp;
    }
  }
}
