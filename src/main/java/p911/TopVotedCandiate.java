package p911;

import java.util.HashMap;
import java.util.Map;

class TopVotedCandidate {

  int[] voted;
  int[] times;

  public TopVotedCandidate(int[] persons, int[] times) {
    voted = new int[times.length];

    this.times = times;
    // id -> tickets
    Map<Integer, Integer> map = new HashMap<>();
    int max = -1;
    int maxPid = -1;
    for (int i = 0; i < times.length; i++) {
      int pid = persons[i];

      int ticket = map.getOrDefault(pid, 0) + 1;
      map.put(pid, ticket);
      if (ticket >= max) {
        voted[i] = pid;
        max = ticket;
        maxPid = pid;
      } else {
        voted[i] = maxPid;
      }
    }
  }

  public int q(int t) {

    int l = 0;
    int r = times.length;
    while (l < r) {
      int mid = l + (r - l) / 2;
      if (t == times[mid]) {
        return voted[mid];
      } else if (t < times[mid]) {
        r = mid;
      } else {
        l = mid + 1;
      }
    }

    return voted[l - 1];
  }

  public static void main(String[] args) {
    //    TopVotedCandidate obj =
    //        new TopVotedCandidate(
    //            new int[] {0, 1, 1, 0, 0, 1, 0}, new int[] {0, 5, 10, 15, 20, 25, 30});
    //    System.out.println(obj.q(3));
    //    System.out.println(obj.q(12));
    //    System.out.println(obj.q(25));
    //    System.out.println(obj.q(15));
    //    System.out.println(obj.q(24));
    //    System.out.println(obj.q(8));
    TopVotedCandidate obj =
        new TopVotedCandidate(new int[] {0, 0, 0, 0, 1}, new int[] {0, 6, 39, 52, 75});
    System.out.println(obj.q(45));
    System.out.println(obj.q(49));
    System.out.println(obj.q(59));
    System.out.println(obj.q(68));
    System.out.println(obj.q(42));
    System.out.println(obj.q(37));
    System.out.println(obj.q(99));
    System.out.println(obj.q(26));
    System.out.println(obj.q(78));
    System.out.println(obj.q(43));
  }
}
