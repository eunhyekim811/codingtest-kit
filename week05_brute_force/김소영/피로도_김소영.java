class Solution {
	int maxCount = 0;
    boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        func(k, dungeons, 0);
        return maxCount;
    }

    void func(int curK, int[][] dungeons, int count) {
        maxCount = Math.max(maxCount, count);

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && curK >= dungeons[i][0]) {
                visited[i] = true;
                func(curK - dungeons[i][1], dungeons, count + 1);
                visited[i] = false;
            }
        }
    }
}