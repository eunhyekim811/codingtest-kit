package week05_brute_force.김은혜;

import java.util.Arrays;

// 1번 문제부터 마지막까지 정답 배열 주어졌을 때, 가장 많은 문제 맞힌 사람
// 1번: 1-2-3-4-5-1-2-3-...
// 2번: 2-1-2-3-2-4-2-5-2-1-...
// 3번: 3-3-1-1-2-2-4-4-5-5-3-3-1-1-...
public class 모의고사_김은혜 {

    int[] one={1, 2, 3, 4, 5};
    int[] two={2, 1, 2, 3, 2, 4, 2, 5};
    int[] three={3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    public int[] solution(int[] answers) {
        int a1=0, a2=0, a3=0;

        for(int i=0; i<answers.length; i++){
            if(one[i%5]==answers[i]) a1++;
            if(two[i%8]==answers[i]) a2++;
            if(three[i%10]==answers[i]) a3++;
        }

        int max=Math.max(a1, a2);
        max=Math.max(max ,a3);

        int[] high=new int[3];
        int idx=0;
        if(max==a1) high[idx++]=1;
        if(max==a2) high[idx++]=2;
        if(max==a3) high[idx++]=3;

        return Arrays.copyOfRange(high, 0, idx);
    }
}
