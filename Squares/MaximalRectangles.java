package DP.Squares;

import java.util.Arrays;
import java.util.Stack;

public class MaximalRectangles {
  public int largestRectangleArea(int[] histo) {
    Stack<Integer> st = new Stack<>();
    int maxA = 0;
    int n = histo.length;

    for (int i = 0; i <= n; i++) {
      while (!st.isEmpty() && (i == n || histo[st.peek()] >= histo[i])) {
        int height = histo[st.pop()];
        int width;

        if (st.isEmpty()) {
          width = i;
        } else {
          width = i - st.peek() - 1;
        }

        maxA = Math.max(maxA, width * height);
      }
      st.push(i);
    }
    return maxA;
  }

  public int maximalRectangle(char[][] mat) {
    int m = mat.length;
    int n = mat[0].length;
    int[][] dp = new int[m][n];
    int maxRect = 0;
    for (int j = 0; j < n; j++) {
      for (int i = 0; i < m; i++) {
        if (mat[i][j] == '1') {
          dp[i][j] = (i > 0 ? dp[i - 1][j] : 0) + 1;
        }
      }
    }

    for (int i = 0; i < m; i++) {
      maxRect = Math.max(maxRect, largestRectangleArea(dp[i]));
    }

    return maxRect;
  }

  public static void main(String[] args) {
    char[][] mat = {
        { '1', '0', '1', '0', '0' },
        { '1', '0', '1', '1', '1' },
        { '1', '1', '1', '1', '1' },
        { '1', '0', '0', '1', '0' }
    };

    MaximalRectangles obj = new MaximalRectangles();
    System.out.println("The area of the largest rectangle is: " + obj.maximalRectangle(mat));
  }
}
