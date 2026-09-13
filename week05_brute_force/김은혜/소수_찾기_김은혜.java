package week05_brute_force.김은혜;

import java.util.HashSet;

// 한 자리 숫자가 적힌 종이 조각을 붙여서 만들 수 있는 소수 개수
public class 소수_찾기_김은혜 {

    HashSet<Integer> answer=new HashSet<>();
    char[] nums;
    boolean[] visit;

    public int solution(String numbers) {
        visit=new boolean[numbers.length()];
        nums=new char[numbers.length()];

        make(0, numbers);
        return answer.size();
    }

    public void make(int n, String numbers){
        if(n>numbers.length()) return;
        if(n>0) {
            String s="";
            for(int i=0; i<n; i++){
                s+=nums[i];
            }
            int k=Integer.parseInt(s);

            boolean flag=false;
            for(int i=2; i<=k/2; i++){
                if(k%i==0) {
                    flag=true;
                    break;
                }
            }

            if(!flag && k>1) answer.add(k);
        }

        for(int i=0; i<numbers.length(); i++){
            if(visit[i]) continue;

            nums[n]=numbers.charAt(i);
            visit[i]=true;
            make(n+1, numbers);
            visit[i]=false;
        }
    }
}
