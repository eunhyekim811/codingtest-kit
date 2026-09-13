import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        boolean[][] graph = new boolean[n + 1][n + 1];
        
        for (int[] wire : wires) {
            graph[wire[0]][wire[1]] = true;
            graph[wire[1]][wire[0]] = true;
        }

        int answer = n;

        for (int[] wire : wires) {
            int v1 = wire[0];
            int v2 = wire[1];

            graph[v1][v2] = false;
            graph[v2][v1] = false;

            int cnt = bfs(v1, n, graph);
            
            answer = Math.min(answer, Math.abs(cnt - (n - cnt)));

            graph[v1][v2] = true;
            graph[v2][v1] = true;
        }

        return answer;
    }

    private int bfs(int start, int n, boolean[][] graph) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];

        q.add(start);
        visited[start] = true;
        int cnt = 1;

        while (!q.isEmpty()) {
            int curr = q.poll();

            for (int i = 1; i <= n; i++) {
                if (graph[curr][i] && !visited[i]) {
                    visited[i] = true;
                    q.add(i);
                    cnt++;
                }
            }
        }
        return cnt;
    }
}