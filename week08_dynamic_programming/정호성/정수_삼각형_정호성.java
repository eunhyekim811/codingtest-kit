import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int n = triangle.length;

        for (int r = n - 2; r >= 0; r--) {
            for (int c = 0; c < triangle[r].length; c++) {
                triangle[r][c] += Math.max(triangle[r + 1][c], triangle[r + 1][c + 1]);
            }
        }

        return triangle[0][0];
    }
}