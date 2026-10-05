package week08_dynamic_programming.김은혜;

import java.util.ArrayList;
import java.util.HashSet;

// N과 number가 주어질 때, N과 사칙연산을 이용해 number 표현할 수 있는 방법 중
// N 사용횟수의 최솟값 리턴(N>8: -1 리턴)
public class N으로_표현_김은혜 {

    ArrayList<HashSet<Integer>> memo=new ArrayList<>();

    public int solution(int N, int number) {
        int use=-1;
        memo.add(new HashSet<>());

        int mid=N;
        memo.add(new HashSet<>());
        memo.get(1).add(mid);
        if(mid==number) return 1;

        for(int i=2; i<9; i++){
            HashSet<Integer> midset=new HashSet<>();
            mid=(mid*10)+N;
            midset.add(mid);

            for(int j=1; j<i; j++){
                for(int a: memo.get(j)){
                    for(int b: memo.get(i-j)){
                        midset.add(a+b);
                        midset.add(a-b);
                        midset.add(a*b);
                        if(b!=0) midset.add(a/b);
                    }
                }
            }

            if(midset.contains(number)){
                use=i;
                break;
            }
            memo.add(midset);
        }

        return use;
    }
}
