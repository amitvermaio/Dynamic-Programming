public class ShortestCommonSupersequence {
  public static void main(String[] args) {
    Solution sol = new Solution();
    String str1 = "abac", str2 = "cab";
    System.out.println("The Shortest Common Supersequence is: " + sol.shortestCommonSupersequence(str1, str2));
  }
}

class Solution {
  static String lcs(String str1, String str2) {
    int m = str1.length();
    int n = str2.length();
    int[][] dp = new int[m + 1][n + 1];
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }
    StringBuilder sb = new StringBuilder();
    int i = m, j = n;
    while (i > 0 && j > 0) {
      if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
        sb.append(str1.charAt(i - 1));
        i--;
        j--;
      } else if (dp[i - 1][j] > dp[i][j - 1]) {
        i--;
      } else {
        j--;
      }
    }
    sb.reverse();
    return sb.toString();
  }

  public String shortestCommonSupersequence(String str1, String str2) {
    String lcs = lcs(str1, str2);
    int i = 0, j = 0, k = 0;
    StringBuilder res = new StringBuilder();
    while (k < lcs.length()) { // coz lcs will always be <= str1's & str2's length
      while (str1.charAt(i) != lcs.charAt(k)) {
        res.append(str1.charAt(i++));
      }
      while (str2.charAt(j) != lcs.charAt(k)) {
        res.append(str2.charAt(j++));
      }
      res.append(lcs.charAt(k));
      i++;
      j++;
      k++;
    }

    while (i < str1.length())
      res.append(str1.charAt(i++));
    while (j < str2.length())
      res.append(str2.charAt(j++));
    return res.toString();
  }
}