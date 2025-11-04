package DP.LIS;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class LongestIncreasingSubsequence {
   public int lengthOfLISOptimizedUsingBinarySearch(int[] nums) {
        List<Integer> tails = new ArrayList<>();
        for (int num : nums) {
            int i = Collections.binarySearch(tails, num);

            // If not found, binarySearch return (-(insertion_point)-1);
            if (i < 0) i = -(i + 1);

            if (i == tails.size()) {
                tails.add(num); // extend LIS
            } else {
                tails.set(i, num); // replace existing tail
            }
        }
        return tails.size();
    }

  public int lengthOfLIS(int[] nums) {
    int n = nums.length;
    int[] dp = new int[n];
    Arrays.fill(dp, 1);
    int max = 1;
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[j] < nums[i]) {
          dp[i] = Math.max(dp[j] + 1, dp[i]);
          max = Math.max(max, dp[i]);
        }
      }
    }
    return max;
  }

  public static void main(String[] args) {

  }
}

class Solution {
  public int lengthOfLIS(int[] nums) {
    int n = nums.length;
    int[] dp = new int[n];
    Arrays.fill(dp, 1);

    int[] parent = new int[n];
    for (int i = 0; i < n; i++) {
      parent[i] = i;
    } // considering every element is parent of itself.

    int lastIndex = 0;
    int max = 1;
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[j] < nums[i] && dp[j] + 1 > dp[i]) {
          dp[i] = dp[j] + 1;
          parent[i] = j; // mark previous element in sequence
        }
      }
      if (dp[i] > max) { // update overall LIS
        max = dp[i];
        lastIndex = i;
      }
    }

    ArrayList<Integer> res = new ArrayList<>();
    while (parent[lastIndex] != lastIndex) {
      res.add(nums[lastIndex]);
      lastIndex = parent[lastIndex];
    }
    res.add(nums[lastIndex]);
    Collections.reverse(res);

    System.out.println("LIS sequence: " + res);
    return max;
  }
}
