import java.util.*;

class Solution {
    private int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    private int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};

    public int solution(int[] arrows) {
        int answer = 0;
        
        int x = 0, y = 0;
        
        Set<String> visitedNodes = new HashSet<>();
        Set<String> visitedEdges = new HashSet<>();
        
        visitedNodes.add(x + "," + y);
        
        for (int arrow : arrows) {
            for (int i = 0; i < 2; i++) {
                int nextX = x + dx[arrow];
                int nextY = y + dy[arrow];
                
                String currentPos = x + "," + y;
                String nextPos = nextX + "," + nextY;
                
                String edge1 = currentPos + "-" + nextPos;
                String edge2 = nextPos + "-" + currentPos;
                
                if (visitedNodes.contains(nextPos)) {
                    if (!visitedEdges.contains(edge1)) {
                        answer++;
                    }
                } else {
                    visitedNodes.add(nextPos);
                }
                
                visitedEdges.add(edge1);
                visitedEdges.add(edge2);
                
                x = nextX;
                y = nextY;
            }
        }
        
        return answer;
    }
}