package week8_dynamic_programming;

class 등굣길_오명헌 {
    public int solution(int m, int n, int[][] puddles) {
        boolean[][] water = new boolean[n + 2][m + 2];
        
        for (int[] puddle : puddles) {
        	int y = puddle[1];
        	int x = puddle[0];
        	
        	water[y][x] = true;
        }
        
        int[][] dp = new int[n + 2][m + 2];
        dp[1][1] = 1;
        
        for (int i = 1; i <= n; i++) {
        	for (int j = 1; j <= m; j++) {
        		if (i == 1 && j == 1) continue;
        		if (water[i][j]) continue;
        		
        		dp[i][j] = (dp[i - 1][j] % 1_000_000_007) + (dp[i][j - 1] % 1_000_000_007);
        	}
        }
        
        return dp[n][m] % 1_000_000_007;
    }
}
