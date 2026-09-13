package week5_brute_force;

/** [ 카펫 ]
 * Idea
 * 1. 노란색 타일의 세로 값이 1일때 부터 완전탐색
 * 
 * Algorithm : 완전탐색
 * Time Complexity : O(N)
 * N <= 5,000
 */

class 카펫_오명헌 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        for (int i = 1; (i + 2) <= (brown - (i * 2)) / 2; i++) {
        	int y_h = i;
        	int y_w = ((brown - (i * 2)) / 2) - 2;
        	
        	if (y_h * y_w == yellow) {
        		answer[0] = (brown - (i * 2)) / 2;
        		answer[1] = i + 2;
        	}
        }
        
        return answer;
    }
}