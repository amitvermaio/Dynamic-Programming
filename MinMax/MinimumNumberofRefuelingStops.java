import java.util.PriorityQueue;

public class MinimumNumberofRefuelingStops {
  public int minRefuelStops(int target, int tank, int[][] stations) {
    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
    int res = 0, prev = 0;

    for (int[] s : stations) {
      int loc = s[0];
      int fuel = s[1];
      tank -= loc - prev;
      while (!pq.isEmpty() && tank < 0) {
        tank += pq.poll();
        res++;
      }

      if (tank < 0)
        return -1;
      pq.offer(fuel);
      prev = loc;
    }

    tank -= target - prev;
    while (!pq.isEmpty() && tank < 0) {
      tank += pq.poll();
      res++;
    }

    if (tank < 0)
      return -1;
    return res;
  }
}