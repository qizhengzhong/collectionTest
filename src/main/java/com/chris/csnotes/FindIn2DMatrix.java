package com.chris.csnotes;

/**
 * 给定一个二维数组，其每一行从左到右递增排序，从上到下也是递增排序。给定一个数，判断这个数是否在该二维数组中。
 * Consider the following matrix:
 * [
 * [1, 4, 7, 11, 15],
 * [2, 5, 8, 12, 19],
 * [3, 6, 9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * <p>
 * Given target = 5, return true.
 * Given target = 20, return false.
 */
public class FindIn2DMatrix {
  public static void main(String[] args) {
    int[][] matrix = {
        {1, 4, 7, 11, 15},
        {2, 5, 8, 12, 19},
        {3, 6, 9, 16, 22},
        {10, 13, 14, 17, 24},
        {18, 21, 23, 26, 30}
    };

    int target = 16;
    System.out.println(findTargetBest(matrix, target));
  }

  /**
   * Best method:
   * my try
   * 要求时间复杂度 O(M + N)，空间复杂度 O(1)。其中 M 为行数，N 为 列数。
   * <p>
   * 该二维数组中的一个数，小于它的数一定在其左边，大于它的数一定在其下边。因此，从右上角开始查找，就可以根据 target 和当前元素的大小关系来缩小查找区间，当前元素的查找区间为左下角的所有元素。
   */
  private static boolean findTargetBest(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
      return false;
    int rightColumn = matrix[0].length - 1;
    for (int i = 0; i < matrix.length; i++) {
      for (int j = rightColumn; j >= 0; j--) {
        if (target == matrix[i][j])
          return true;
        if (target > matrix[i][j]) {
          rightColumn = j;
          break;
        }
      }
    }

    return false;
  }

  /**
   * Best method:
   * Answer!
   * @param target
   * @param matrix
   * @return
   */
  public static boolean find(int target, int[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
      return false;
    int rows = matrix.length, cols = matrix[0].length;
    int r = 0, c = cols - 1; // 从右上角开始
    while (r <= rows - 1 && c >= 0) {
      if (target == matrix[r][c])
        return true;
      else if (target > matrix[r][c])
        r++;
      else
        c--;
    }
    return false;
  }

  /**
   * My method:
   * Loop through two dim array list and check each element one by one
   * However, we stop looking if (matrix[0] > target), return false
   * if  matrix[i][matrix.length-1] > target, we do the inner array checks
   * if matrix[i][j] > target, we skip the rest of inner array checks
   */
  private static boolean findTarget(int[][] matrix, int target) {
    for (int i = 0; i < matrix.length; i++) {
      if (matrix[i][0] > target)
        return false;
      if (matrix[i][matrix.length - 1] > target) {
        for (int j = 0; j < matrix[i].length; j++) {
          if (matrix[i][j] > target)
            break;
          if (target == matrix[i][j]) {
            return true;
          }
        }
      }
    }
    return false;
  }
}
