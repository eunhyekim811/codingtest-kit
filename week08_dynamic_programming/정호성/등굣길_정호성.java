class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int MOD = 1_000_000_007;

        int[][] dp = new int[n + 1][m + 1];

        for (int[] puddle : puddles) {
            int x = puddle[0];
            int y = puddle[1];
            dp[y][x] = -1;
        }

        dp[1][1] = 1;

        for (int y = 1; y <= n; y++) {
            for (int x = 1; x <= m; x++) {
                
                if ((y == 1 && x == 1) || dp[y][x] == -1) {
                    continue;
                }

                int fromUp = 0;
                int fromLeft = 0;

                if (y > 1 && dp[y - 1][x] != -1) {
                    fromUp = dp[y - 1][x];
                }

                if (x > 1 && dp[y][x - 1] != -1) {
                    fromLeft = dp[y][x - 1];
                }

                dp[y][x] = (fromUp + fromLeft) % MOD;
            }
        }

        return dp[n][m];
    }
}