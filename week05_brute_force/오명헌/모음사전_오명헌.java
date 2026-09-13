package week5_brute_force;

/** [ 모음사전 ]
 * Algorithm : 완전탐색(깊이 우선 탐색)
 * Time Complexity : O(N^N)
 * N = 5
 */

class 모음사전_오명헌 {
	
	static String[] dictionary = { "A", "E", "I", "O", "U" };
	static int ans;
	static int count;
	
	
    public int solution(String word) {
    	ans = 0;
    	count = 0;
    	
    	dfs(0, "", word);
    	
        return ans;
    }
    
    static void dfs(int depth, String s, String word) {
    	
    	if (ans > 0) return;
    	
    	if (s.equals(word)) {
    		ans = count;
    		return;
    	}
    	
    	if (depth == 5) return;
    	
    	for (int i = 0; i < 5; i++) {
    		count++;
    		dfs(depth + 1, s + dictionary[i], word);
    	}
    }
}