import java.util.Arrays;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));

        int answer = 0;
        int lastCamera = -30001;

        for (int[] route : routes) {
            if (route[0] > lastCamera) {
                answer++;
                lastCamera = route[1];
            }
        }

        return answer;
    }
}