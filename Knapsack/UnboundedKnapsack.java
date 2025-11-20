package DP.Knapsack;

public class UnboundedKnapsack {
  

  public static void main(String[] args) {
    int[] weights = {1, 3, 4};
    int[] values = {10, 40, 50};
    int capacity = 7;
    int n = weights.length;

    int maxValue = unboundedKnapsack(weights, values, capacity, n);
    System.out.println("Maximum value in Unbounded Knapsack = " + maxValue);
  }
}
