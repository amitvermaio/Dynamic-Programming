package DP.Squares;

// Leetcode 1277. Count Square Submatrices with All Ones
public class CountSquareSubmatrice {
  static int countSquares(int[][] arr) {
    int m = arr.length;
    int n = arr[0].length;
    int count = 0;
   
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (arr[i][j] == 0)
          continue;

        if (i>0 && j>0) {
          arr[i][j] = Math.min(arr[i - 1][j - 1], Math.min(arr[i - 1][j], arr[i][j - 1])) + 1;
        }
        count += arr[i][j];
      }
    }

    return count;
  }

  public static void main(String[] args) {
    int[][] matrix = {
        { 0, 1, 1, 1 },
        { 1, 1, 1, 1 },
        { 0, 1, 1, 1 }
    };
    System.out.println(countSquares(matrix));
  }
}
