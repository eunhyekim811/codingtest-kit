package week8_dynamic_programming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class N으로_표현_오명헌 {
    public int solution(int N, int number) {
        List<HashSet<Integer>> dp = new ArrayList<HashSet<Integer>>();
        for (int i = 0; i <= 8; i++) {
        	dp.add(new HashSet<Integer>());
        }
        
        int repeat = 0;
        
        for (int i = 1; i <= 8; i++) {
        	repeat = repeat * 10 + N;
        	
        	dp.get(i).add(repeat);
        	
        	for (int j = 1; j < i; j++) {
        		// dp[j]와 dp[i - j]의 원소를 사칙연산으로 조합
        		for (int num1 : dp.get(j)) {
        			for (int num2 : dp.get(i - j)) {
        				dp.get(i).add(num1 + num2);
        				dp.get(i).add(num1 - num2);
        				dp.get(i).add(num1 * num2);        				
        				if (num2 != 0) {
        					dp.get(i).add(num1 / num2);
        				}
        			}
        		}
        	}
        }
        
        boolean flag = false;
        int answer = -1;
        
        for (int i = 1; i <= 8; i++) {
        	if (flag) break;
        	
        	for (int x : dp.get(i)) {
        		if (x == number) {
        			answer = i;
        			flag = true;
        			break;
        		}
        	}
        }
        
        return answer;
    }
}