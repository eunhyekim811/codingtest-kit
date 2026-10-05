class 사칙연산_오명헌 {
    public int solution(String arr[]) {
        int n = arr.length / 2 + 1;
        int[] nums = new int[n];
        char[] ops = new char[n - 1];

        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) nums[i / 2] = Integer.parseInt(arr[i]);
            else ops[i / 2] = arr[i].charAt(0);
        }

        int[][] max = new int[n][n];
        int[][] min = new int[n][n];

        for (int i = 0; i < n; i++) {
            max[i][i] = nums[i];
            min[i][i] = nums[i];
        }

        for (int len = 1; len < n; len++) {
            for (int i = 0; i + len < n; i++) {
                int j = i + len;
                max[i][j] = Integer.MIN_VALUE;
                min[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    int curMax, curMin;
                    if (ops[k] == '+') {
                        curMax = max[i][k] + max[k + 1][j];
                        curMin = min[i][k] + min[k + 1][j];
                    } else {
                        curMax = max[i][k] - min[k + 1][j];
                        curMin = min[i][k] - max[k + 1][j];
                    }
                    max[i][j] = Math.max(max[i][j], curMax);
                    min[i][j] = Math.min(min[i][j], curMin);
                }
            }
        }

        return max[0][n - 1];
    }
}