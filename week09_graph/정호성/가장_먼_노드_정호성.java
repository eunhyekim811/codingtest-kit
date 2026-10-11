import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        
        int[] distance = new int[n + 1];
        Arrays.fill(distance, -1);
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        distance[1] = 0;
        
        int maxDistance = 0;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            for (int next : graph.get(current)) {
                if (distance[next] == -1) {
                    distance[next] = distance[current] + 1;
                    queue.offer(next);
                    maxDistance = Math.max(maxDistance, distance[next]);
                }
            }
        }
        
        int answer = 0;
        for (int d : distance) {
            if (d == maxDistance) {
                answer++;
            }
        }
        
        return answer;
    }
}