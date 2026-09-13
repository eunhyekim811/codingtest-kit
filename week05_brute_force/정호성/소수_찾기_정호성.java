import java.util.*;

class Solution {
    Set<Integer> numberSet = new HashSet<>();

    public int solution(String numbers) {
        boolean[] visited = new boolean[numbers.length()];
        dfs(numbers, "", visited);

        int cnt = 0;
        for (int num : numberSet) {
            if (isPrime(num)) {
                cnt++;
            }
        }

        return cnt;
    }

    private void dfs(String numbers, String current, boolean[] visited) {
        if (!current.isEmpty()) {
            numberSet.add(Integer.parseInt(current));
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(numbers, current + numbers.charAt(i), visited);
                visited[i] = false;
            }
        }
    }

    private boolean isPrime(int n) {
        if (n < 2) return false;
        
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}