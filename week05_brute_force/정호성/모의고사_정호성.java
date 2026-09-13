import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        
        int[] p1 = {1, 2, 3, 4, 5};
        int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] corrects = new int[3];
        int maxCorr = -1;
        
        for(int i = 0; i < answers.length; ++i) {
            if(p1[i % p1.length] == answers[i]) {
                corrects[0]++;
                if(maxCorr < corrects[0]) {
                    maxCorr = corrects[0];
                }
            }
            if(p2[i % p2.length] == answers[i]) {
                corrects[1]++;
                if(maxCorr < corrects[1]) {
                    maxCorr = corrects[1];
                }
            }
            if(p3[i % p3.length] == answers[i]) {
                corrects[2]++;
                if(maxCorr < corrects[2]) {
                    maxCorr = corrects[2];
                }
            }
        }
        
        List<Integer> arr = new ArrayList<>();
        
        for(int i = 0; i < 3; ++i) {
            if(corrects[i] == maxCorr) {
                arr.add(i + 1);
            }
        }
        
        return arr.stream().mapToInt(i -> i).toArray();
    }
}