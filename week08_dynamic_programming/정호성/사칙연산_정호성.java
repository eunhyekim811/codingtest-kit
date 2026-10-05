import java.util.*;

class Solution {
    public int solution(String arr[]) {
        int n = arr.length / 2 + 1;
        
        int[] nums = new int[n];
        char[] ops = new char[n - 1];

        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                nums[i / 2] = Integer.parseInt(arr[i]);
            } else {
                ops[i / 2] = arr[i].charAt(0);
            }
        }

        int[][] maxDP = new int[n][n];
        int[][] minDP = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(maxDP[i], Integer.MIN_VALUE);
            Arrays.fill(minDP[i], Integer.MAX_VALUE);
            maxDP[i][i] = nums[i];
            minDP[i][i] = nums[i];
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;

                for (int k = i; k < j; k++) {
                    if (ops[k] == '+') {
                        maxDP[i][j] = Math.max(maxDP[i][j], maxDP[i][k] + maxDP[k + 1][j]);
                        minDP[i][j] = Math.min(minDP[i][j], minDP[i][k] + minDP[k + 1][j]);
                    } else {
                        maxDP[i][j] = Math.max(maxDP[i][j], maxDP[i][k] - minDP[k + 1][j]);
                        minDP[i][j] = Math.min(minDP[i][j], minDP[i][k] - maxDP[k + 1][j]);
                    }
                }
            }
        }

        return maxDP[0][n - 1];
    }
}