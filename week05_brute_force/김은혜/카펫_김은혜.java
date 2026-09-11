package week05_brute_force.김은혜;

// 갈색+노란색 칸을 통해 전체 사각형 가로, 세로 반환(가로>=세로)
// 갈색: 테두리, 노랑: 가운데
public class 카펫_김은혜 {

    public int[] solution(int brown, int yellow) {
        int[] answer=new int[2];
        int total=brown+yellow;

        for(int i=3; i<=total/2; i++){
            if(total%i==0){
                int h=i;
                int w=total/i;

                int b=w*2+(h-2)*2;
                if(b==brown){
                    answer[0]=w;
                    answer[1]=h;
                    break;
                }
            }
        }

        return answer;
    }
}
