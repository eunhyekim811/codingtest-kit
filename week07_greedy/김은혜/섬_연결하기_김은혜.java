package week07_greedy.김은혜;

import java.util.ArrayList;
import java.util.Collections;

// n개의 섬 사이 다리 건설 비용 주어질 때, 최소 비용으로 모든 섬이 통행 가능하도록
class Node implements Comparable<Node>{
    int from, to;
    int cost;

    Node(int from, int to, int cost){
        this.from=from;
        this.to=to;
        this.cost=cost;
    }

    public int compareTo(Node o){
        return Integer.compare(this.cost, o.cost);
    }
}
public class 섬_연결하기_김은혜 {

    int[] p;
    ArrayList<Node> bridges=new ArrayList<>();

    public int solution(int n, int[][] costs) {
        p=new int[n];
        for(int i=0; i<costs.length; i++){
            bridges.add(new Node(costs[i][0], costs[i][1], costs[i][2]));
        }

        Collections.sort(bridges);
        int cnt=0;
        for(int i=0; i<n; i++){
            p[i]=-1;
        }

        int answer=0;
        for(int i=0; i< bridges.size(); i++){
            if(union(bridges.get(i).from, bridges.get(i).to)){
                cnt++;
                answer+=bridges.get(i).cost;
            }

            if(cnt==n-1) break;
        }

        return answer;
    }

    int find(int a){
        if(p[a]<0) return a;
        return p[a]=find(p[a]);
    }

    boolean union(int a, int b){
        int tmp1=find(a);
        int tmp2=find(b);
        if(tmp1==tmp2) return false;

        if(p[tmp1]<=p[tmp2]){
            p[tmp1]+=p[tmp2];
            p[tmp2]=tmp1;
        } else{
            p[tmp2]+=p[tmp1];
            p[tmp1]=tmp2;
        }
        return true;
    }
}
