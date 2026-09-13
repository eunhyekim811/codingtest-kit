package week05_brute_force.김은혜;

// 가로, 세로 정보를 담은 배열이 주어졌을 때, 각 요소들을 전부 수납 가능한 최소 사이즈 리턴
public class 최소직사각형_김은혜 {

    public int solution(int[][] sizes) {
        int s1=0, s2=0;

        for(int i=0; i<sizes.length; i++){
            int w=Math.max(s1, sizes[i][0]);
            int h=Math.max(s2, sizes[i][1]);

            int rw=Math.max(s1, sizes[i][1]);
            int rh=Math.max(s2, sizes[i][0]);

            if(w*h<rw*rh){
                s1=w;
                s2=h;
            } else{
                s1=rw;
                s2=rh;
            }
        }

        return s1*s2;
    }
}
