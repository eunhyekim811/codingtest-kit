package week5_brute_force;

/** [ 전력망을 둘로 나누기 ]
 * Algorithm : 완전탐색, 트리
 * Time Complexity : O(N^2)
 * Space Complexity : O(N)
 * N <= 100
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

class 전력망을_둘로_나누기_오명헌 {
	
    public int solution(int n, int[][] wires) {
        
        ArrayList<Integer>[] tree = new ArrayList[n + 1];
        
        for (int i = 1; i <= n; i++) {
        	tree[i] = new ArrayList<Integer>();
        }
        
        for (int i = 0; i < wires.length; i++) {
        	int a = wires[i][0];
        	int b = wires[i][1];
        	
        	tree[a].add(b);
        	tree[b].add(a);
        }
        
        int answer = 100;
        
        for (int i = 0; i < wires.length; i++) {
        	int a = wires[i][0];
        	int b = wires[i][1];
        	
        	tree[a].remove((Integer) b);
        	tree[b].remove((Integer) a);
        	
        	
        	int sub = getNetworkSize(n, tree);
        	answer = Math.min(answer, Math.abs(sub - (n - sub)));
        	
        	tree[a].add(b);
        	tree[b].add(a);
        }
        
        return answer;
    }
    
    int getNetworkSize(int n, ArrayList<Integer>[] tree) {
    	int cnt = 0;
    	
    	Queue<Integer> q = new ArrayDeque<Integer>();
    	boolean[] visited = new boolean[n + 1];
    	
    	q.add(1);
    	visited[1] = true;
    	
    	while (!q.isEmpty()) {
    		cnt++;
    		
    		int node = q.poll();
    		
    		for (int next : tree[node]) {
    			if (visited[next]) continue;
    			
    			visited[next] = true;
    			q.add(next);
    		}
    	}
    	
    	return cnt;
    }
}