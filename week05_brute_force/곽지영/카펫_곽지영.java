import java.util.Arrays;

public class 카펫_곽지영 {

    public static int[] solution(int brown, int yellow) {
        int area = brown + yellow;
        int x = 0; int y =0;

        for (int i = 3; i <= Math.sqrt(area); i++) {
            if (area % i == 0 && (i - 2) * (area / i - 2) == yellow) {
                x = Math.max(i, area / i);
                y = Math.min(i, area / i);
                break;
            }
        }

        return new int[] {x, y};
    }

    public static void main(String[] args) {
        int brown = 24;
        int yellow = 24;
        int[] answer = solution(brown, yellow);

        System.out.println(Arrays.toString(answer));
    }
}
