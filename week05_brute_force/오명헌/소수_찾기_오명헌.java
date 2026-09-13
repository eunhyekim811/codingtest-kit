package week5_brute_force;

/** [ 소수 찾기 ]
 * Idea
 * 1. 순열로 모든 숫자 조합을 만든다.
 * 2. 각 숫자를 set에 저장한다.
 * 3. 저장된 set에서 소수의 개수를 구한다.
 * 
 * Algorithm : 완전탐색(순열)
 * Time Complexity : O(N * N! + U * M^(1/2))
 * Space Complexity : O(N!)
 * 
 * N <= 7
 * M <= 9,999,999
 * U <= 13,699
 */

import java.util.HashSet;

class 소수_찾기_오명헌 {
	
	char[] arr;
	boolean[] visited;
	HashSet<Integer> set;
	
    public int solution(String numbers) {
    	
    	arr = numbers.toCharArray();
    	visited = new boolean[numbers.length()];
    	set = new HashSet<Integer>();
    	
    	permutation(0, "");
    	
        int answer = 0;
        for (int num : set) {
        	if (is_prime(num)) answer++;
        }
        
        return answer;
    }
    
    void permutation(int depth, String currentStr) {
    	if (!currentStr.isEmpty()) {
    		set.add(Integer.parseInt(currentStr));
    	}
    	
    	if (depth == arr.length) return;
    	
    	for (int i = 0; i < arr.length; i++) {
    		if (visited[i]) continue;
    		
    		visited[i] = true;
    		
    		permutation(depth + 1, currentStr + arr[i]);
    		
    		visited[i] = false;
    	}
    }
    
    boolean is_prime(int n) {
    	
    	if (n == 0 || n == 1) return false;
    	
    	for (int i = 2; i <= Math.sqrt(n); i++) {
    		if (n % i == 0) return false;
    	}
    	
    	return true;
    }
}