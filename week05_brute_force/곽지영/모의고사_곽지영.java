import java.util.Arrays;

public class 모의고사_곽지영 {

    public static int[] solution(int[] answers) {
        int[] num1 = {1, 2, 3, 4, 5}; // 5
        int[] num2 = {2, 1, 2, 3, 2, 4, 2, 5}; // 8
        int[] num3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; // 10

        int ans1 = 0; int ans2 = 0; int ans3 = 0;

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == num1[i % num1.length]) ans1++;
            if (answers[i] == num2[i % num2.length]) ans2++;
            if (answers[i] == num3[i % num3.length]) ans3++;
        }

        int max = Math.max(ans1, Math.max(ans2, ans3));

        int[] answer = new int[3];
        int cnt = 0;

        if (ans1 == max) answer[cnt++] = 1;
        if (ans2 == max) answer[cnt++] = 2;
        if (ans3 == max) answer[cnt++] = 3;

        return Arrays.copyOf(answer, cnt);
    }

    public static void main(String[] args) {
        int[] answers = {1, 2, 3, 4, 5};
        int[] answer = solution(answers);

        System.out.println(Arrays.toString(answer));
    }
}