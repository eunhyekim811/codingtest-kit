package week08_dynamic_programming.김은혜;

import java.util.ArrayList;

// 삼각형 모양으로 이루어진 숫자 배열(triangle)에서 꼭대기->바닥 경로 중
// 거쳐간 숫자 합이 최댓값인 경우(최댓값 리턴)
public class 정수_삼각형_김은혜 {

    ArrayList<int[]> memo=new ArrayList<>();

    public int solution(int[][] triangle) {
        memo.add(triangle[0]);

        for(int i=1; i<triangle.length; i++){
            int[] up=memo.get(i-1);
            int [] down=triangle[i];
            int[] mid=new int[down.length];

            for(int j=0; j<up.length; j++){
                int left=j;
                int right=j+1;

                mid[left]=Math.max(down[left]+up[j], mid[left]);
                if(right<down.length){
                    mid[right]=Math.max(down[right]+up[j], mid[right]);
                }
            }

            memo.add(mid);
        }

        int answer=0;
        for(int i: memo.get(triangle.length-1)){
            answer=Math.max(answer, i);
        }

        return answer;
    }
}
