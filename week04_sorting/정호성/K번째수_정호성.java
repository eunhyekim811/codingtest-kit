import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int cmd = 0; cmd < commands.length; ++cmd) {
            int i = commands[cmd][0];
            int j = commands[cmd][1];
            int k = commands[cmd][2];
            
            int[] copy = Arrays.copyOfRange(array, i - 1, j);
            Arrays.sort(copy);
            
            answer[cmd] = copy[k - 1];
        }
        
        return answer;
    }
}