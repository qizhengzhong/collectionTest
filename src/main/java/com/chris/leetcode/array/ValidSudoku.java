package com.chris.leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Ref: https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/769/
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 * <p>
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 */
public class ValidSudoku {
  public static void main(String[] args) {
    char[][] board = {
        {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},//0*0-2*2 -1
        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},//3*0-5*2 -2
        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},//6*0-8*2 -3
        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
    };
    System.out.println(isValidSudoku(board));
  }

  public static boolean isValidSudoku(char[][] board) {
    boolean[] row = new boolean[81];
    boolean[] col = new boolean[81];
    boolean[] box = new boolean[81];

    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (board[i][j] == '.') {
          continue;
        }
        int value = board[i][j] - '1';
        int boxLoc = 9 * ((i / 3) * 3 + (j / 3)) + value;
        if (row[9 * i + value] ||
            col[9 * j + value] ||
            box[boxLoc]) {
          return false;
        }
        row[9 * i + value] = true;
        col[9 * j + value] = true;
        box[boxLoc] = true; //only if i or j changed by 3, we increment the count, and i will change by 27, j will change by 9
      }
    }
    return true;
  }

  public static boolean myIsValidSudoku(char[][] board) {
    for (int i = 0; i < 9; i++) {
      if (!isValid(board[i]))
        return false;
    }
    for (int j = 0; j < 9; j++) {
      char[] column = new char[9];
      for (int k = 0; k < 9; k++) {
        column[k] = board[k][j];
      }
      if (!isValid(column))
        return false;
    }

    int boxcnt = 0;
    int mcount = 0;
    while (boxcnt < 9) {
      char[] subbox = new char[9];
      int cnt = 0;
      for (int x = boxcnt * 3 % 9;
           x < boxcnt * 3 % 9 + 3; x++) { //0,3,6,0,3,6,0,3,6 - 0,3,6,0,,5,6,7,8
        for (int m = mcount * 3; m < 3 * mcount + 3; m++) { // 0,1,2 - 0   3,4,5 - 3 6,7,8 - 6
          subbox[cnt] = board[x][m];
          cnt++;
        }
      }
      if (!isValid(subbox))
        return false;
      boxcnt++;
      if (boxcnt % 3 == 0)
        mcount++;
    }
    return true;
  }

  public static boolean isValid(char[] row) {
    Set s = new HashSet();
    for (int i = 0; i < row.length; i++) {
      if (row[i] != '.') {
        if (s.contains(row[i]))
          return false;
        s.add(row[i]);
      }
    }
    return true;
  }

}
