public class 모음_사전_곽지영 {
    static String vowel = "AEIOU";
    static int answer;

    public static int solution(String word) {
        answer = 0;
        return dfs("", word);
    }

    static int dfs(String cur, String word) {
        if (cur.equals(word)) return answer;
        if (cur.length() == 5) return -1;

        for (int i = 0; i < 5; i++) {
            answer++;

            int result = dfs(cur + vowel.charAt(i), word);
            if (result != -1) return answer;
        }

        return -1;
    }

    public static void main(String[] args) {
        String word = "AAAAE";
        int answer = solution(word);

        System.out.println(answer);
    }
}