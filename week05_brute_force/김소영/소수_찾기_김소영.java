import java.util.*;

class Solution {
    Set<Integer> set = new HashSet<>();
    boolean[] visited;
    char[] arr;

    public int solution(String numbers) {
        arr = numbers.toCharArray();
        visited = new boolean[arr.length];

        func(0);

        int count = 0;
        for (int num : set) {
            if (isPrime(num)) count++;
        }
        return count;
    }

    void func(int currentNum) {
        if (currentNum > 0) set.add(currentNum);

        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                func(currentNum * 10 + (arr[i] - '0'));
                visited[i] = false;
            }
        }
    }

    boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}