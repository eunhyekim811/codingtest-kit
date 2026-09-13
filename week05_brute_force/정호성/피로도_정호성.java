class Solution {
    boolean[] visited;
    int maxCnt = 0;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        
        dfs(k, 0, dungeons);
        
        return maxCnt;
    }
    
    private void dfs(int cur, int cnt, int[][] dungeons) {
        maxCnt = Math.max(maxCnt, cnt);

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && cur >= dungeons[i][0]) {
                visited[i] = true; 
                dfs(cur - dungeons[i][1], cnt + 1, dungeons); 
                visited[i] = false;
            }
        }
    }
}