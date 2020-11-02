package com.chris.leetcode.array;

/**
 * Ref: https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/770/
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 * <p>
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 * <p>
 * Input: matrix = [[1,2],[3,4]]
 * Output: [[3,1],[4,2]]
 * <p>
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[7,4,1],[8,5,2],[9,6,3]]
 * <p>
 * Input: matrix = {5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}
 * Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 * <p>
 * Constraints:
 * <p>
 * matrix.length == n
 * matrix[i].length == n
 * 1 <= n <= 20
 * -1000 <= matrix[i][j] <= 1000
 */
public class RotateImage {
  public static void main(String[] args) {
    int[][] matrix = {
        {5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}
    };

    rotate(matrix);


    for (int i = 0; i < matrix.length; i++) {
      System.out.print("[");
      for (int j = 0; j < matrix[0].length; j++) {
        System.out.print(matrix[i][j]+ ",");
      }
      System.out.print("]\n");
    }
  }

  public static void rotate(int[][] matrix) {
    int len = matrix.length-1;
    for(int i=0; i< len; i++) {
      for(int j=i; j< len-i;j++) {
        int top = matrix[i][j];
        int rig = matrix[j][len-i];
        int bot = matrix[len-i][len-j];
        int lef = matrix[len-j][i];

        matrix[i][j] = lef;
        matrix[j][len-i] = top;
        matrix[len-i][len-j] = rig;
        matrix[len-j][i] = bot;
      }
    }
  }
  public static void rotateMyBadExample(int[][] matrix) {
    int[][] temp = new int[matrix.length][matrix[0].length];
    for (int i=0;i<matrix.length;i++) {
      for (int j=0;j<matrix.length;j++) {
        temp[j][matrix.length-1-i] = matrix[i][j];
      }
    }
    for (int i=0;i<matrix.length;i++) {
      for (int j=0;j<matrix.length;j++) {
        matrix[i][j] = temp[i][j];
      }
    }
  }
}
