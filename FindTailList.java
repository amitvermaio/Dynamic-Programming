package DP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindTailList {
  static int findTailList(int[] nums) {
    List<Integer> tails = new ArrayList<>();
    for (int num : nums) {
      int i = Collections.binarySearch(tails, num);

      if (i < 0) i = -(i+1);
    }
  }
  public static void main(String[] args) {
    
  }
}
