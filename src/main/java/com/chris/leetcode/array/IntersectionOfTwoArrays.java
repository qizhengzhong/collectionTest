package com.chris.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Ref: https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/674/
 * Given two arrays, write a function to compute their intersection.
 * <p>
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 * <p>
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 * <p>
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 */
public class IntersectionOfTwoArrays {
  public static void main(String[] args) {
    int[] nums1 = {3, 1, 2}; //if 2 is in nums1, if 2 is in nums1
    int[] nums2 = {1, 1};

    for (int i : intersect(nums1, nums2)) {
      System.out.println(i);
    }
  }

  public static int[] intersect(int[] nums1, int[] nums2) {
    Map<Integer, Integer> map = new HashMap();
    List<Integer> r = new ArrayList<>();
    for (int n : nums1) {
      map.put(n, map.getOrDefault(n, 0) + 1);
    }

    for (int x : nums2) {
      if (map.containsKey(x)) {
        r.add(x);
        map.put(x, map.get(x) - 1);
        map.remove(x, 0);
      }
    }
    int[] result = new int[r.size()];
    for (int i = 0; i < r.size(); i++) {
      result[i] = r.get(i);
    }
    return result;
  }

  public int[] myIntersect(int[] arr1, int[] arr2) {
    Arrays.sort(arr1);
    Arrays.sort(arr2);
    ArrayList result = new ArrayList();
    int i = 0;
    int j = 0;
    while (i < arr1.length && j < arr2.length) {
      if (arr1[i] > arr2[j]) {
        j++;
      } else if (arr1[i] < arr2[j]) {
        i++;
      } else {
        result.add(arr1[i]);
        i++;
        j++;
      }
    }
    return result.stream().mapToInt(x -> (int) x).toArray();
  }
}
