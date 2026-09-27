package week07_greedy.김은혜;

// number에서 k개의 수 제거했을 때 얻을 수 있는 가장 큰 숫자
public class 큰_수_만들기_김은혜 {

    boolean[] del;

    public String solution(String number, int k) {
        del=new boolean[number.length()];

        for(int i=0; i<number.length(); i++){
            for(int j=i+1; j<=i+k; j++){
                if(j>=number.length()) break;
                if(number.charAt(i)<number.charAt(j)){
                    del[i]=true;
                    k--;
                    break;
                }
            }

            if(k==0) break;
        }

        int fin=number.length()-1;
        while(k>0){
            del[fin--]=true;
            k--;
        }

        String answer="";
        for(int i=0; i<number.length(); i++){
            if(del[i]) continue;

            answer+=number.charAt(i);
        }

        return answer;
    }
}
