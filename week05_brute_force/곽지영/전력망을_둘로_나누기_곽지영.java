import java.util.ArrayList;
import java.util.List;

public class 전력망을_둘로_나누기_곽지영 {

    static List<Integer>[] graph;
    static int answer;

    public static int solution(int n, int[][] wires) {
        graph = new List[n + 1];
        for (int i = 0; i <= n; i++) graph[i] = new ArrayList<>();

        for (int[] wire : wires) {
            int from = wire[0];
            int to = wire[1];

            graph[from].add(to);
            graph[to].add(from);
        }

        answer = Integer.MAX_VALUE;
        dfs(n, wires[0][0], 0);

        return answer;
    }

    static int dfs(int n, int cur, int parent) {
        int cnt = 1;

        for (int next : graph[cur]) {
            if (next == parent) continue;

            int subtree = dfs(n, next, cur);
            int diff = Math.abs((n - subtree) - subtree);
            answer = Math.min(answer, diff);

            cnt += subtree;
        }

        return cnt;
    }

    public static void main(String[] args) {
        int n = 7;
        int[][] wires = {{1, 2}, {2, 7}, {3, 7}, {3, 4}, {4, 5}, {6, 7}};
        int answer = solution(n, wires);

        System.out.println(answer);
    }
}
