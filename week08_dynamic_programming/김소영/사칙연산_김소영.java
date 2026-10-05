import java.util.*;

class Solution {
    public int solution(String arr[]) {
        int n = arr.length / 2 + 1;
        int[][] maxArr = new int[n][n];
        int[][] minArr = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(maxArr[i], Integer.MIN_VALUE);
            Arrays.fill(minArr[i], Integer.MAX_VALUE);
            int val = Integer.parseInt(arr[i * 2]);
            maxArr[i][i] = val;
            minArr[i][i] = val;
        }

        for (int len = 1; len < n; len++) {
            for (int i = 0; i < n - len; i++) {
                int j = i + len;
                for (int k = i; k < j; k++) {
                    String op = arr[k * 2 + 1];
                    if (op.equals("+")) {
                        maxArr[i][j] = Math.max(maxArr[i][j], maxArr[i][k] + maxArr[k + 1][j]);
                        minArr[i][j] = Math.min(minArr[i][j], minArr[i][k] + minArr[k + 1][j]);
                    } else {
                        maxArr[i][j] = Math.max(maxArr[i][j], maxArr[i][k] - minArr[k + 1][j]);
                        minArr[i][j] = Math.min(minArr[i][j], minArr[i][k] - maxArr[k + 1][j]);
                    }
                }
            }
        }

        return maxArr[0][n - 1];
    }
}