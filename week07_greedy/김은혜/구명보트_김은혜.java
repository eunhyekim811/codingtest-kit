package week07_greedy.김은혜;

import java.util.Arrays;

// 최대 2명, 무게 제한 limit의 구명보트 -> people을 모두 구출하기 위한 구명보트 최소 개수
public class 구명보트_김은혜 {

    boolean[] save;

    public int solution(int[] people, int limit) {
        save=new boolean[people.length];
        int answer=0;

        Arrays.sort(people);
        int left=0; int right=people.length-1;
        while(left<=right){
            if(left!=right && people[left]+people[right]<=limit){
                save[left++]=true;
                save[right--]=true;
                answer++;
            } else{
                save[right--]=true;
                answer++;
            }
        }

        return answer;
    }
}
