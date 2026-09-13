import java.util.*;

class Solution {
    private List<String> list = new ArrayList<>();
    private String[] vowels = {"A", "E", "I", "O", "U"};

    public int solution(String word) {
        dfs("");
        return list.indexOf(word) + 1;
    }

    private void dfs(String cur) {
        if (!cur.isEmpty()) {
            list.add(cur);
        }

        if (cur.length() == 5) {
            return;
        }

        for (int i = 0; i < 5; i++) {
            dfs(cur + vowels[i]);
        }
    }
}