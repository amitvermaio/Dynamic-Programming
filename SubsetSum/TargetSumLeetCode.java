package DP.SubsetSum;

public class TargetSumLeetCode {
    public int findTargetSumWays(int[] nums, int target) {
        /*
         * with intution of S1 & S2
         * S1 - S2 = target (where S1 is sum and S2 is other sum of unique elems)
         * S1 + S2 = total
         * if we solve these equations then
         * 2S1 = target + total
         * S1 = (target+total)/2
         * if it exists
         */
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }
        int sum = target + total;
        if (sum < 0)
            return 0;
        if (sum % 2 == 1)
            return 0;
        int[] dp = new int[(sum / 2) + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = sum / 2; j >= nums[i]; j--) {
                dp[j] = dp[j] + dp[j - nums[i]];
            }
        }
        return dp[sum / 2];
    }
}


// Using Recursion.
public class InnerTargetSumLeetCode {
    static int sum;

    static int ways(int[] nums, int target, int res, int[][] dp, int i) {
        if (i == nums.length) {
            if (res == target)
                return 1;
            return 0;
        }
        if (dp[i][res + sum] != -1)
            return dp[i][res + sum];
        int add = ways(nums, target, res + nums[i], dp, i + 1);
        int sub = ways(nums, target, res - nums[i], dp, i + 1);
        return dp[i][res + sum] = add + sub;
    }

    public int findTargetSumWays(int[] nums, int target) {
        // i -> 0 to n-1 | target range -> -sum to sum (array ke saare elems ka minus
        // and ek baar add wala bhi aayega!)
        // we can use HashMap too but can also do it using dp array of size 2*sum;
        int n = nums.length;
        sum = Arrays.stream(nums).sum();
        int[][] dp = new int[n][2 * sum + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return ways(nums, target, 0, dp, 0);
    }

}
