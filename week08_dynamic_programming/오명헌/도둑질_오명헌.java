package week8_dynamic_programming;

class 도둑질_오명헌 {
    public int solution(int[] money) {
        int answer = 0;
        
        int n = money.length;
       
        // 0번 집을 터는 경우
        int[] dp = new int[n];
        dp[0] = money[0];
        dp[1] = money[0];
        
        for (int i = 2; i < n - 1; i++) {
        	dp[i] = Math.max(dp[i - 1], dp[i - 2] + money[i]);
        }
        
        answer = dp[n - 2];
        
        // 0번 집을 털지 않는 경우
        dp = new int[n];
        dp[1] = money[1];
        
        for (int i = 2; i < n; i++) {
        	dp[i] = Math.max(dp[i - 1], dp[i - 2] + money[i]);
        }
        
        answer = Math.max(answer, dp[n - 1]);
        
        return answer;
    }
}