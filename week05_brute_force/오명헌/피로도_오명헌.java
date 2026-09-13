package week5_brute_force;

/** [ 피로도 ]
 * Idea
 * 던전 탐험할 수 있는 모든 순서를 구하고, 탐험 가능 수를 계산한다.
 * 
 * Algorithm : 완전탐색(순열)
 * Time Complexity : O(N!)
 * Space Complexity : O(N)
 * N <= 8
 */

class 피로도_오명헌 {
	
	static int n;
	static boolean[] visited;
	static int cnt;
	
    public int solution(int k, int[][] dungeons) {
        n = dungeons.length;
        visited = new boolean[n];
        cnt = 0;
        
        adventure(0, k, dungeons);
        
        return cnt;
    }
    
    static void adventure(int depth, int hp, int[][] dungeons) {
    	
    	cnt = Math.max(cnt, depth);
    	
    	if (depth == n) return;
    	
    	for (int i = 0; i < n; i++) {
    		if (visited[i] || hp < dungeons[i][0]) continue;
    		
			visited[i] = true;
			adventure(depth + 1, hp - dungeons[i][1], dungeons);
			
    		visited[i] = false;
    	}
    }
}