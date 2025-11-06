import java.util.Scanner;

public class FriendsPairingProblem {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] dp = new int[n + 1];
    // System.out.println(friendsPairing(n, dp));
    System.out.println(friendsPairingTab(n));
    sc.close();
  }

  static int friendsPairing(int n, int[] dp) {
    if (n <= 2) {
      return n;
    }
    if (dp[n] != 0) {
      return dp[n];
    }
    int single = friendsPairing(n - 1, dp);
    int pairUp = friendsPairing(n - 2, dp) * (n - 1);
    dp[n] = single + pairUp;
    return dp[n];
  }

  static int friendsPairingTab(int n) {
    int[] dp = new int[n+1];
    dp[1] = 1;
    dp[2] = 2;
    for (int i=3; i<=n; i++) {
      dp[i] = dp[i-1] + dp[i-2]*(i-1);
    }
    return dp[n];
  }
}
