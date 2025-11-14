public class MinimumFallingPath {
  public int minFallingPathSum(int[][] mat) {
    int m = mat.length;
    int n = mat[0].length;
    for (int i = 1; i < m; i++) {
      for (int j = 0; j < n; j++) {
        int x = Integer.MAX_VALUE;
        int y = mat[i - 1][j];
        int z = Integer.MAX_VALUE;
        if (j - 1 >= 0)
          x = mat[i - 1][j - 1];
        if (j + 1 < n)
          z = mat[i - 1][j + 1];
        int min = Math.min(x, y);
        mat[i][j] += Math.min(min, z);
      }
    }
    int res = Integer.MAX_VALUE;
    System.out.println(Arrays.deepToString(mat));
    for (int j = 0; j < n; j++) {
      res = Math.min(mat[m - 1][j], res);
    }
    return res;
  }

  public static void main(String[] args) {

  }
}
