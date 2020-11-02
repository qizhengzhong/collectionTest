package com.chris.csnotes;

/**
 * The number in the array should be within {0,n-1}
 * <p>
 * Input:
 * {2, 3, 1, 0, 2, 5}
 * <p>
 * Output:
 * 2
 */


public class FindDuplicatesInArray {
  public static void main(String[] args) {
    int[] input = {2, 3, 1, 0, 2, 5};

    /**
     * Most efficient way
     * Consider we have an array includes positions of each number
     * if we get the position where already filled with some value, then its a duplicate
     */
    duplicate(input, input.length);

    /**
     * My method: use HashMap to count the number of appearance for certain number
     * This could work for all scenarios, including different types of input
     */
    //    Map<Integer, Integer> inputCountMap = new HashMap<>();
    //    for (int i : input) {
    //      int count = inputCountMap.get(i) == null ? 0 : inputCountMap.get(i);
    //      inputCountMap.put(i, ++count);
    //    }
    //    for (Map.Entry<Integer, Integer> mapElement : inputCountMap.entrySet()) {
    //      if (mapElement.getValue() > 1) {
    //        System.out.println(mapElement.getKey());
    //      }
    //    }
  }

  public static boolean duplicate(int[] nums, int length) {
    if (nums == null || length <= 0)
      return false;
    for (int i = 0; i < length; i++) {
      while (nums[i] != i) {
        if (nums[i] == nums[nums[i]]) {
          System.out.println(nums[i]);
          return true;
        }
        swap(nums, i, nums[i]);
      }
    }

    return false;
  }

  private static void swap(int[] nums, int i, int j) {
    int t = nums[i];
    nums[i] = nums[j];
    nums[j] = t;
  }
}
