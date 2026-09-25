package week07_greedy.김은혜;

// A로만 이루어진 알파벳을 조이스틱을 최소로 움직혀 이름 완성하기
// 위: 다음 알파벳 | 아래: 이전 알파벳 | 왼: 커서 왼쪽 이동 | 오른쪽: 커서 오른쪽 이동
public class 조이스틱_김은혜 {

    public int solution(String name) {
        int total='Z'-'A'+1;
        int answer=0;
        int move=name.length()-1;

        for(int i=0; i<name.length(); i++){
            int cur=name.charAt(i)-'A';
            if(cur<=total/2){
                answer+=cur;
            } else{
                answer+=(total-cur);
            }

            int next=i+1;
            while(next<name.length() && name.charAt(next)=='A'){
                next++;
            }

            move=Math.min(move, i*2+(name.length()-next));
            move=Math.min(move, (name.length()-next)*2+i);
        }

        return answer+move;
    }
}
