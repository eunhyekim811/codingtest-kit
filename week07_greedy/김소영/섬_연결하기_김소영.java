import java.util.Arrays;

class Solution {
    private int[] parent;

    private int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    private boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB) return false;
        parent[rootB] = rootA;
        return true;
    }

    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, (a, b) -> Integer.compare(a[2], b[2]));

        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        int answer = 0;
        int edges = 0;

        for (int[] edge : costs) {
            if (union(edge[0], edge[1])) {
                answer += edge[2];
                edges++;
                if (edges == n - 1) break;
            }
        }

        return answer;
    }
}