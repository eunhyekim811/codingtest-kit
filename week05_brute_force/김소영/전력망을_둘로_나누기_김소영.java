import java.util.*;

class Solution {
    List<Integer>[] adj;

    public int solution(int n, int[][] wires) {
        int minDiff = n;

        for (int i = 0; i < wires.length; i++) {
            // 인접 리스트 초기화
            adj = new ArrayList[n + 1];
            for (int j = 1; j <= n; j++) {
                adj[j] = new ArrayList<>();
            }

            // i번째 전선 빼고 그래프 만들기
            for (int j = 0; j < wires.length; j++) {
                if (i == j) continue;
                int u = wires[j][0];
                int v = wires[j][1];
                adj[u].add(v);
                adj[v].add(u);
            }

            // 한쪽 네트워크의 노드 개수 구하기
            int count = bfs(1, n);

            int diff = Math.abs(count - (n - count));
            minDiff = Math.min(minDiff, diff);
        }

        return minDiff;
    }

    int bfs(int start, int n) {
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);
        visited[start] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : adj[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                    count++;
                }
            }
        }
        return count;
    }
}