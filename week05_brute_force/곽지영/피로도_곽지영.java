public class 피로도_곽지영 {
    static boolean[] visited;

    public static int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];

        return dfs(k, dungeons, 0);
    }

    static int dfs(int k, int[][] dungeons, int cnt) {
        int max = cnt;

        for (int i = 0; i < dungeons.length; i++) {
            if (visited[i]) continue;
            if (k < dungeons[i][0]) continue;

            visited[i] = true;
            max = Math.max(max, dfs(k - dungeons[i][1], dungeons, cnt + 1));

            visited[i] = false;
        }

        return max;
    }

    public static void main(String[] args) {
        int k = 80;
        int[][] dungeons = {{80,20}, {50,40}, {30,10}};
        int answer = solution(k, dungeons);

        System.out.println(answer);
    }
}
