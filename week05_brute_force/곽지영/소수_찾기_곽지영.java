import java.util.*;

public class 소수_찾기_곽지영 {

    static Set<Integer> set = new HashSet<>();
    static boolean[] visited;

    public static int solution(String numbers) {
        visited = new boolean[numbers.length()];

        dfs(numbers, "");

        int ans = 0;

        for (int n : set) {
            if (isPrime(n)) ans++;
        }

        return ans;
    }

    static void dfs(String numbers, String cur) {
        for (int i = 0; i < numbers.length(); i++) {
            if (visited[i]) continue;

            visited[i] = true;
            String next = cur + numbers.charAt(i);
            set.add(Integer.parseInt(next));

            dfs(numbers, next);
            visited[i] = false;
        }
    }

    static boolean isPrime(int n) {
        if (n == 0 || n == 1) return false;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String numbers = "17";
        int answer = solution(numbers);

        System.out.println(answer);
    }
}