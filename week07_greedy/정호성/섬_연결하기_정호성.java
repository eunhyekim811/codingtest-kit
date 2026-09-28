import java.util.*;

class Solution {
    private static int[] ufmap;

    private static int find(int x) {
        if (ufmap[x] == x) return x;
        return ufmap[x] = find(ufmap[x]);
    }

    private static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            ufmap[rootB] = rootA;
            return true;
        }
        return false;
    }

    public int solution(int n, int[][] costs) {
        int answer = 0;

        Arrays.sort(costs, (o1, o2) -> Integer.compare(o1[2], o2[2]));

        ufmap = new int[n];
        for (int i = 0; i < n; i++) {
            ufmap[i] = i;
        }

        int count = 0;
        for (int[] c : costs) {
            if (union(c[0], c[1])) {
                answer += c[2];
                count++;
                if (count == n - 1) break;
            }
        }

        return answer;
    }
}