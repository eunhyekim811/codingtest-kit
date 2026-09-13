package week05_brute_force.김은혜;

import java.util.ArrayDeque;

// 트리 형태로 연결된 n개 송전탑에서 전선 하나 끊어서 분할(각 송전탑 개수 비슷하게)
// 송전탑 개수 n, 전선 정보 wires -> 전력망이 갖는 송전탑 개수 차이(절대값) 반환
class Node{
    int num;
    Node next;

    Node(int num, Node next){
        this.num=num;
        this.next=next;
    }
}

public class 전력망을_둘로_나누기_김은혜 {

    Node[] conn;
    ArrayDeque<Integer> deq=new ArrayDeque<>();
    boolean[] visit;
    int answer=Integer.MAX_VALUE;

    public int solution(int n, int[][] wires) {
        conn=new Node[n];
        for(int i=0; i<wires.length; i++){
            int to=wires[i][0]-1;
            int from=wires[i][1]-1;

            conn[to]=new Node(from, conn[to]);
            conn[from]=new Node(to, conn[from]);
        }

        // 하나씩 끊어보기
        for(int i=0; i< wires.length; i++){
            deq.add(0);
            int cnt=0;
            visit=new boolean[n];
            visit[0]=true;

            while(!deq.isEmpty()){
                int cur=deq.poll();
                cnt++;

                for(Node node=conn[cur]; node!=null; node=node.next){
                    if(cur==wires[i][0]-1 && node.num==wires[i][1]-1) continue;
                    if(cur==wires[i][1]-1 && node.num==wires[i][0]-1) continue;

                    if(visit[node.num]) continue;
                    deq.add(node.num);
                    visit[node.num]=true;
                }
            }

            answer=Math.min(answer, Math.abs(n-cnt*2));
        }

        return answer;
    }
}
