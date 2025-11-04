package DP.Memorization;

public class MaxSumWoAdjacents {
  int findMaxSum(int arr[]) {
        int n = arr.length;
        if (n == 1) return arr[0];
        if (n == 2) return Math.max(arr[0], arr[1]);
        
        int[] res = new int[n];
        res[0] = arr[0];
        res[1] = Math.max(arr[0], arr[1]);
        // first find the max of arr of length 1 store it then of 2 then store and then do comparison.
        // try to run on this -> [5, 5, 10, 100, 10, 5]
        for (int i=2; i<n; i++) {
            res[i] = Math.max(arr[i]+res[i-2], res[i-1]);
        }
        return res[n-1];
    }
}
