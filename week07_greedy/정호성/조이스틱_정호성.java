import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = 0;
        int n = name.length();

        for (int i = 0; i < n; i++) {
            char c = name.charAt(i);
            answer += Math.min(c - 'A', 'Z' - c + 1);
        }

        int move = n - 1;

        for (int i = 0; i < n; i++) {
            int next = i + 1;
            while (next < n && name.charAt(next) == 'A') {
                next++;
            }

            int path1 = i * 2 + (n - next);

            int path2 = (n - next) * 2 + i;

            move = Math.min(move, Math.min(path1, path2));
        }

        answer += move;
        return answer;
    }
}