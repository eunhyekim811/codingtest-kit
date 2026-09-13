import java.util.ArrayList;
import java.util.List;

class Solution {
    List<String> dict = new ArrayList<>();
    char[] vowels = {'A', 'E', 'I', 'O', 'U'};

    public int solution(String word) {
    	func("");
        return dict.indexOf(word);
    }

    void func(String cur) {
        dict.add(cur);
        if (cur.length() == 5) return;

        for (char v : vowels) {
        	func(cur + v);
        }
    }
}