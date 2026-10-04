package week08_dynamic_programming.김은혜;

// m*n 크기의 지역의 좌상단에 집이, 우하단에 학교가 있을 때
// 물에 잠기지 않은 곳을 피해 집->학교 가는 (최단 경로 개수)/1,000,000,007의 나머지 리턴
// 물에 잠긴 곳의 좌표 정보는 puddles에 들어있음
// 오른쪽 or 아래로만 이동 가능
public class 등굣길_김은혜 {

    int[][] map;

    public int solution(int m, int n, int[][] puddles) {
        map=new int[n][m];
        for(int i=0; i< puddles.length; i++){
            map[puddles[i][1]-1][puddles[i][0]-1]=-1;
        }

        map[0][0]=1;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(i==0 && j==0) continue;
                if(map[i][j]==-1) continue;

                int up=-0, left=0;
                if(i-1>=0 && map[i-1][j]>=0) up=map[i-1][j];
                if(j-1>=0 && map[i][j-1]>=0) left=map[i][j-1];

                map[i][j]=(up+left)%1000000007;
            }
        }

        return map[n-1][m-1];
    }
}
