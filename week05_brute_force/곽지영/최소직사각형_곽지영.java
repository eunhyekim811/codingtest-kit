public class 최소직사각형_곽지영 {

    public static int solution(int[][] sizes) {
        int maxH = 0; int maxW = 0;

        for (int i = 0; i < sizes.length; i++) {
            int h = Math.max(sizes[i][0], sizes[i][1]);
            int w = Math.min(sizes[i][0], sizes[i][1]);

            maxH = Math.max(h, maxH);
            maxW = Math.max(w, maxW);
        }

        return maxH * maxW;
    }

    public static void main(String[] args) {
        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        int answer = solution(sizes);

        System.out.println(answer);
    }
}