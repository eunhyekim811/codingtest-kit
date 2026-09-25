package week07_greedy.김은혜;

// 앞번호/뒷번호 학생에게만 빌려줄 수 있음 -> 체육복 가진 최대 학생 수
// 전체 학생 n, 도난당한 학생들 번호 담긴 lost, 여벌 체육복 가져온 학생들 번호 담긴 reserve
public class 체육복_김은혜 {

    boolean[] stolen, plus;

    public int solution(int n, int[] lost, int[] reserve) {
        stolen=new boolean[n];
        plus=new boolean[n];

        for(int i=0; i<lost.length; i++){
            stolen[lost[i]-1]=true;
        }
        for(int i=0; i<reserve.length; i++){
            if(stolen[reserve[i]-1]){
                stolen[reserve[i]-1]=false;
                continue;
            }

            plus[reserve[i]-1]=true;
        }

        int answer=0;
        for(int i=0; i<n; i++){
            if(!stolen[i]) {
                answer++;
                continue;
            }

            if(i-1>=0 && plus[i-1]){
                plus[i-1]=false;
                answer++;
            } else if(i+1<n && plus[i+1]){
                plus[i+1]=false;
                answer++;
            }
        }

        return answer;
    }
}
