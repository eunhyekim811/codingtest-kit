import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;

        Arrays.sort(routes, (o1, o2) -> Integer.compare(o1[1], o2[1]));

        int cam = -30001;

        for (int[] route : routes) {
            int in = route[0];
            int out = route[1];

            if (cam < in) {
                cam = out;
                answer++;
            }
        }

        return answer;
    }
}