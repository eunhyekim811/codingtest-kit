import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if (N == number) {
            return 1;
        }
        
        Set<Integer>[] dp = new HashSet[9];

        for (int i = 1; i <= 8; i++) {
            dp[i] = new HashSet<>();
        }
        
        int base = 0;
        for (int i = 1; i <= 8; i++) {
            base = base * 10 + N;
            dp[i].add(base);
        }
        
        for (int k = 1; k <= 8; k++) {
            for (int i = 1; i < k; i++) {
                for (int a : dp[i]) {
                    for (int b : dp[k - i]) {
                        dp[k].add(a + b);
                        dp[k].add(a - b);
                        dp[k].add(a * b);

                        if (b != 0) {
                            dp[k].add(a / b);
                        }
                    }
                }
            }

            if (dp[k].contains(number)) {
                return k;
            }
        }
        
        return -1;
    }
}