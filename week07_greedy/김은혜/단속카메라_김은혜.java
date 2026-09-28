package week07_greedy.김은혜;

import java.util.Arrays;

// 모든 차량이 단속 카메라를 한 번은 만나도록 카메라 설치
// 차량 경로 routes가 주어질 때, 최소 카메라 개수 리턴
class Road implements Comparable<Road>{
    int in, out;

    Road(int in, int out){
        this.in=in;
        this.out=out;
    }

    @Override
    public int compareTo(Road o) {
        return Integer.compare(this.out, o.out);
    }
}

public class 단속카메라_김은혜 {

    Road[] roads;

    public int solution(int[][] routes) {
        roads=new Road[routes.length];

        for(int i=0; i<routes.length; i++){
            roads[i]=new Road(routes[i][0], routes[i][1]);
        }

        Arrays.sort(roads);
        int answer=1;
        int cam=roads[0].out;

        for(int i=1; i<roads.length; i++){
            if(cam>=roads[i].in) continue;
            cam=roads[i].out;
            answer++;
        }

        return answer;
    }
}
