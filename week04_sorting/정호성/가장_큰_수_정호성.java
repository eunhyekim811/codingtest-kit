import java.io.*;
import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] strNumbs = new String[numbers.length];
        
        for(int i = 0; i < numbers.length; ++i) {
            strNumbs[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(strNumbs, (a, b) -> (b + a).compareTo(a + b));
        
        if(strNumbs[0].equals("0")) return "0";
        
        StringBuilder sb = new StringBuilder();
        for(String s : strNumbs) {
            sb.append(s);
        }
        
        return sb.toString();
    }
}