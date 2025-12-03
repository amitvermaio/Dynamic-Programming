public class UniqueBinarySearchTree {
  static int numTrees(int n) {
    if (n == 1)
      return 1;
    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;
    dp[2] = 2;
    for (int i = 3; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        dp[i] += dp[j - 1] * dp[i - j]; // += coz we're addind all the possible treee structure count from 1 to i
      }
    }
    /**
     * Right subtree me hamesha i-j nodes honge
     * (because j+1…i go right → total = i-j)
     */
    return dp[n];
  }

  public static void main(String[] args) {
    int n = 3;
    System.out.println(numTrees(n));
  }
}