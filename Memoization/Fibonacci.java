package DP;

public class Fibonacci {

  static int fibonacci(int n, int[] arr) {
    if (n==0 || n==1) return n;

    // If solution already exists don't calculate it again just return!
    if (arr[n] != 0) {
      return arr[n];
    }

    // figure out and mermorize its solution
    arr[n] = fibonacci(n-1, arr) + fibonacci(n-2, arr);
    return arr[n];
  }

  public static void main(String[] args) {
    int n = 30;
    int[] arr = new int[n+1];
    System.out.println(fibonacci(n, arr));
  }
}
