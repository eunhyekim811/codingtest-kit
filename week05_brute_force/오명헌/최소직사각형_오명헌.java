package week5_brute_force;

/** [ 최소직사각형 ]
 * Idea
 * - 가로, 세로 중 더 큰 값을 한 쪽에 몰아 넣는다.
 * 
 * Algorithm : 완전탐색
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 * N <= 10,000
 */

class 최소직사각형_오명헌 {
    public int solution(int[][] sizes) {
        
        int w = 0;
        int h = 0;
        
        for (int[] size : sizes) {
        	
        	int v1 = size[0];
        	int v2 = size[1];
        	
        	w = Math.max(w, Math.max(v1, v2));
        	h = Math.max(h, Math.min(v1, v2));
        }
        
        return w * h;
    }
}