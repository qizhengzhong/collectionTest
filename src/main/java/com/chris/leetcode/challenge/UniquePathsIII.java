package com.chris.leetcode.challenge;

/**
 * On a 2-dimensional grid, there are 4 types of squares:
 * <p>
 * 1 represents the starting square.  There is exactly one starting square.
 * 2 represents the ending square.  There is exactly one ending square.
 * 0 represents empty squares we can walk over.
 * -1 represents obstacles that we cannot walk over.
 * Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
 * Output: 2
 * Explanation: We have the following two paths:
 * 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
 * 2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
 * Example 2:
 * <p>
 * Input: [[1,0,0,0],[0,0,0,0],[0,0,0,2]]
 * Output: 4
 * Explanation: We have the following four paths:
 * 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
 * 2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
 * 3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
 * 4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)
 * Example 3:
 * <p>
 * Input: [[0,1],[2,0]]
 * Output: 0
 * Explanation:
 * There is no path that walks over every empty square exactly once.
 * Note that the starting and ending square can be anywhere in the grid.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= grid.length * grid[0].length <= 20
 */
public class UniquePathsIII {
  static int rows, cols;

  static int path_count;

  public static void main(String[] args) {
    int[][] grid = {
        {1,0,0,0},
        {0,0,0,0},
        {0,0,2,-1}
    };
    System.out.println(uniquePathsIII(grid));
  }
  protected static void backtrack(int row, int col, int remain, int[][] grid) {
    // base case for the termination of backtracking
    if (grid[row][col] == 2 && remain == 1) {
      // reach the destination
      path_count += 1;
      return;
    }

    // mark the square as visited. case: 0, 1, 2
    int temp = grid[row][col];
    grid[row][col] = -4;
    remain -= 1; // we now have one less square to visit

    // explore the 4 potential directions around
    int[] row_offsets = {0, 0, 1, -1};
    int[] col_offsets = {1, -1, 0, 0};
    for (int i = 0; i < 4; ++i) {
      int next_row = row + row_offsets[i];
      int next_col = col + col_offsets[i];

      if (0 > next_row || next_row >= rows ||
          0 > next_col || next_col >= cols)
        // invalid coordinate
        continue;

      if (grid[next_row][next_col] < 0)
        // either obstacle or visited square
        continue;

      backtrack(next_row, next_col, remain, grid);
    }

    // unmark the square after the visit
    grid[row][col] = temp;
  }

  public static int uniquePathsIII(int[][] grid) {
    int non_obstacles = 0, start_row = 0, start_col = 0;

    rows = grid.length;
    cols = grid[0].length;

    // step 1). initialize the conditions for backtracking
    //   i.e. initial state and final state
    for (int row = 0; row < rows; ++row)
      for (int col = 0; col < cols; ++col) {
        int cell = grid[row][col];
        if (cell >= 0)
          non_obstacles += 1;
        if (cell == 1) {
          start_row = row;
          start_col = col;
        }
      }

    path_count = 0;

    // kick-off the backtracking
    backtrack(start_row, start_col, non_obstacles, grid);

    return path_count;
  }
}
