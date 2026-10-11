import java.util.*;

class Solution {
    int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};

    public int solution(int[] arrows) {
        int answer = 0;

        Set<Point> visitedPoints = new HashSet<>();
        Set<Edge> visitedEdges = new HashSet<>();

        Point current = new Point(0, 0);
        visitedPoints.add(current);

        for (int arrow : arrows) {
            for (int i = 0; i < 2; i++) {
                Point next = new Point(current.x + dx[arrow], current.y + dy[arrow]);

                if (visitedPoints.contains(next)) {
                    if (!visitedEdges.contains(new Edge(current, next))) {
                        answer++;
                    }
                } else {
                    visitedPoints.add(next);
                }

                visitedEdges.add(new Edge(current, next));
                visitedEdges.add(new Edge(next, current));

                current = next;
            }
        }

        return answer;
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Point)) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    static class Edge {
        Point from, to;

        Edge(Point from, Point to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Edge)) return false;
            Edge edge = (Edge) o;
            return Objects.equals(from, edge.from) && Objects.equals(to, edge.to);
        }

        @Override
        public int hashCode() {
            return Objects.hash(from, to);
        }
    }
}