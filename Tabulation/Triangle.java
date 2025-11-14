package DP.Tabulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Triangle {
  static int minimumTotal(List<List<Integer>> tri) {
    int n = tri.size();
    if (n == 0)
      return 0;
    for (int i = 1; i < n; i++) {
      List<Integer> row = tri.get(i);
      int sz = row.size();
      for (int j = 0; j < sz; j++) {
        int num = row.get(j);
        if (j == 0) {
          row.set(j, tri.get(i - 1).get(0) + num);
        } else if (j == sz - 1) {
          row.set(j, tri.get(i - 1).get(j - 1) + num);
        } else {
          int prev1 = tri.get(i - 1).get(j);
          int prev2 = tri.get(i - 1).get(j - 1);
          row.set(j, Math.min(prev1 + num, prev2 + num));
        }
      }
    }
    int res = Collections.min(tri.get(n - 1));
    return res;
  }

  public static void main(String[] args) {
    List<List<Integer>> list = new ArrayList<>();
    list.add(Arrays.asList(1));
    list.add(Arrays.asList(3, 2));
    list.add(Arrays.asList(4, 5, 6));
    list.add(Arrays.asList(7, 8, 9, 10));

    System.out.println(minimumTotal(list));
  }
}
