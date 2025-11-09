public class UniquePath {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        // Base case: There is only one way to reach any cell in the first row or first column
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        // Explanation: 
        /*
         * To reach any cell (i, j), you can come either from the cell directly above it (i-1, j) or from the cell directly to the left of it (i, j-1).
         * Therefore, the number of unique paths to reach cell (i, j) is the sum of the unique paths to reach the cell above it and the cell to the left of it.
         * This leads to the recurrence relation:
         * dp[i][j] = dp[i-1][j] + dp[i][j-1]
         * We fill the dp table using this relation, starting from cell (1, 1) to cell (m-1, n-1).
         * Finally, the value at dp[m-1][n-1] will give us the total number of unique paths from the top-left corner to the bottom-right corner of the grid.  
         */
        // Fill the dp table
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }
}