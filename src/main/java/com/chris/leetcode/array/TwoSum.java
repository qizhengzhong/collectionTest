package com.chris.leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Ref: https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/546/
 * Given an array of integers nums and and integer target, return the indices of the two numbers such that they add up to target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * You can return the answer in any order.
 * <p>
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Output: Because nums[0] + nums[1] == 9, we return [0, 1]
 * <p>
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 */
public class TwoSum {
  public static void main(String[] args) {
    int[] nums = {3, 2, 4};
    int target = 6;
    for (int i : twoSumPerfect(nums, target)) {
      System.out.println(i);
    }
  }

  public static int[] twoSum(int[] nums, int target) {
    int[] result = new int[2];

    List<Integer> array = new ArrayList<>();
    for (int x : nums) {
      array.add(x);
    }
    for (int i = 0; i < array.size(); i++) {
      if (array.contains(target - array.get(i))) {
        result[0] = i;
        result[1] = array.indexOf(target - array.get(i));
        if (result[1] != result[0])
          break;
      }
    }
    return result;
  }


  public static int[] twoSumPerfect(int[] nums, int target) {
    Integer[] temp = new Integer[2047 + 1];
    int diff = 0;
    Integer index = null;
    for (int i = 0; i < nums.length; i++) {
      diff = target - nums[i]; //we get the difference
      index = temp[diff & 2047]; // check if the diff already in the temp array
      if (index != null) {
        return new int[] {index, i}; // if it is, return
      }
      temp[nums[i] & 2047] = i; //else, we save the current number in the temp array
    }
    return new int[0];

  }

  public static int[] mapExercise(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap();
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(nums[i])) {
        return new int[] {map.get(nums[i]), i};
      }
      map.put((target - nums[i]), i);
    }
    return new int[] {-1, -1};
  }
}
