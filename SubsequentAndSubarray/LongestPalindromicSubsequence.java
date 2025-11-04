package DP.SubsequentAndSubarray;

public class LongestPalindromicSubsequence {
  public static void main(String[] args) {
    
  }
}

class Solution {
    public int longestPalindromeSubseq(String s) {
        String t = new StringBuilder(s).reverse().toString(); // coz palindrome
        int m = s.length();        
        int[] dp = new int[m+1];
        for (int i=1; i<=m; i++) {
            int[] temp = new int[m+1];
            for (int j=1; j<=m; j++) {
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    temp[j] = dp[j-1] + 1;
                } else {
                    temp[j] = Math.max(temp[j-1], dp[j]);
                }
            }
            dp = temp;
        }
        return dp[m];
    }
}
