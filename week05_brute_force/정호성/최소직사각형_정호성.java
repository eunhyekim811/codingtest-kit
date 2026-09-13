import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] sizes) {
        int maxW = -1;
        int maxH = -1;
        
        for(int i = 0; i < sizes.length; ++i) {
            int w = 0;
            int h = 0;
            
            if(sizes[i][0] > sizes[i][1]) {
                w = sizes[i][0];
                h = sizes[i][1];
            } else {
                w = sizes[i][1];
                h = sizes[i][0];
            }
            
            if(maxW < w) {
                maxW = w;
            }
            if(maxH < h) {
                maxH = h;
            }
        }
        
        
        
        return maxW * maxH;
    }
}