import java.util.*;

class Solution {
    public int solution(int N, int number) {
    	
        if (N == number) return 1;

        List<Set<Integer>> s = new ArrayList<>();
        for (int i = 0; i < 9; i++) s.add(new HashSet<>());

        for (int i = 1; i < 9; i++) {
            int base = 0;
            for (int j = 0; j < i; j++) base = base * 10 + N;
            s.get(i).add(base);

            for (int j = 1; j < i; j++) {
                for (int a : s.get(j)) {
                    for (int b : s.get(i - j)) {
                        s.get(i).add(a + b);
                        s.get(i).add(a - b);
                        s.get(i).add(a * b);
                        if (b != 0) s.get(i).add(a / b);
                    }
                }
            }

            if (s.get(i).contains(number)) return i;
        }

        return -1;
    }
}