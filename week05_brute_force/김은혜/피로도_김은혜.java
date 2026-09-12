package week05_brute_force.김은혜;

// 최소 필요 피로도 + 소모 피로도(던전 후)
// 현재 피로도 k 주어졌을 때 최대 던전 수 리턴
public class 피로도_김은혜 {

    boolean[] visit;
    int max=0;

    public int solution(int k, int[][] dungeons) {
        visit=new boolean[dungeons.length];
        explore(k, 0, dungeons);
        return max;
    }

    public void explore(int k, int n, int[][] dungeons){
        if(k<=0){
            max=Math.max(max, n);
            return;
        }

        for(int i=0; i<dungeons.length; i++){
            if(visit[i]) continue;

            if(dungeons[i][0]<=k){
                visit[i]=true;
                explore(k-dungeons[i][1], n+1, dungeons);
                visit[i]=false;
            }
        }
        max=Math.max(max, n);
    }
}
