class KeyKeyboard {
  static int[][] dp;

  static int topDown(int n, int curr, int clipboard) {
    if (curr == n) return 0;
    if (curr > n) return 1000;

    if (dp[curr][clipboard] != 0) return dp[curr][clipboard];
    
    int copyPaste = 2 + topDown(n, curr * 2, curr);
    int paste = 1000; 
    if (clipboard > 0) {
        paste = 1 + topDown(n, curr + clipboard, clipboard);
    }

    return dp[curr][clipboard] = Math.min(paste, copyPaste);
  }

  public int minSteps(int n) {
      dp = new int[n+1][n+1];
      if (n == 1) return 0;
      return topDown(n, 1, 0);
  }
}
