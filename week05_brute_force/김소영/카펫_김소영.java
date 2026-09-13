import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;
        
        for(int totalH = 3; totalH * totalH <= total; totalH++) {
        	if(total % totalH == 0) {
        		int totalW = total/totalH;
        		
        		if((totalH-2) * (totalW-2) == yellow) {
        			return new int[] {totalW, totalH};
        		}
        	}
        }
        return new int[0];
    }
}