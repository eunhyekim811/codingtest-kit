class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        int total = brown + yellow;
        
        for (int height = 3; height <= Math.sqrt(total); height++) {
            if (total % height == 0) {
                int width = total / height;
                
                if ((width - 2) * (height - 2) == yellow) {
                    answer = new int[]{width, height};
                }
            }
        }
        
        return answer;
    }
}