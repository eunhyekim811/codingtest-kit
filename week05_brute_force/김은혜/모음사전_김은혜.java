package week05_brute_force.김은혜;

// A, E, I, O, U만을 사용해 5글자 이하의 단어가 수록된 사전
// 단어 하나(word)가 주어질 때, 사전에서 몇 번째 단어인지 리턴
public class 모음사전_김은혜 {

    char[] dic={'A', 'E', 'I', 'O', 'U'};
    char[] cur=new char[5];
    int cnt=0;
    int answer=0;
    boolean flag=false;

    public int solution(String word) {
        permutation(0, word);
        return answer;
    }

    public void permutation(int n, String word){
        if(n>0){
            cnt++;
            String str=String.valueOf(cur, 0, n);
            if(str.equals(word)){
                answer=cnt;
                flag=true;
                return;
            }
        }
        if(n>4) return;
        if(flag) return;

        for(int i=0; i<5; i++){
            if(flag) return;
            cur[n]=dic[i];
            permutation(n+1, word);
        }
    }
}
