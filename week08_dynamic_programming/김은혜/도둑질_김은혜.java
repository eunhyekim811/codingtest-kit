package week08_dynamic_programming.김은혜;

// 원 모양으로 배치되어 있는 집들 중 인접한 두 집을 털면 경보가 울린다.
// 경보가 울리는 것 없이 도둑이 훔칠 수 있는 돈의 최댓값은?
public class 도둑질_김은혜 {

    public int solution(int[] money) {
        if(money.length==3){
            int answer=Math.max(money[0], money[1]);
            return Math.max(answer, money[2]);
        }

        int[] dp_first=new int[money.length];
        dp_first[0]=money[0];
        dp_first[1]=money[0];

        for(int i=2; i< money.length-1; i++){
            dp_first[i]=Math.max(dp_first[i-2]+money[i], dp_first[i-1]);
        }

        int[] dp_last=new int[money.length];
        dp_last[money.length-1]=money[money.length-1];
        dp_last[money.length-2]=money[money.length-1];

        for(int i=money.length-3; i>0; i--){
            dp_last[i]=Math.max(dp_last[i+2]+money[i], dp_last[i+1]);
        }

        return Math.max(dp_first[money.length-2], dp_last[1]);
    }
}
