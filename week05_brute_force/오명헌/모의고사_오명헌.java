package week5_brute_force;

/** [ 모의고사 ]
 * Algorithm : 완전탐색
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 * N <= 10,000
 */

import java.util.ArrayList;
import java.util.List;

class 모의고사_오명헌 {
    public int[] solution(int[] answers) {
        
        int[] method_1 = { 1, 2, 3, 4, 5 };
        int[] method_2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
        int[] method_3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
        
        int answer_count_1 = 0;
        int answer_count_2 = 0;
        int answer_count_3 = 0;
        
        for (int i = 0; i < answers.length; i++) {
        	
        	if (answers[i] == method_1[i % 5]) answer_count_1++;
        	if (answers[i] == method_2[i % 8]) answer_count_2++;
        	if (answers[i] == method_3[i % 10]) answer_count_3++;
        }
        
        int max = answer_count_1;
        max = Math.max(max, answer_count_2);
        max = Math.max(max, answer_count_3);
        
        List<Integer> answer_list = new ArrayList<Integer>();
        
        if (max == answer_count_1) answer_list.add(1);
        if (max == answer_count_2) answer_list.add(2);
        if (max == answer_count_3) answer_list.add(3);
        
        int[] answer = new int[answer_list.size()];
        
        for (int i = 0; i < answer_list.size(); i++) {
        	answer[i] = answer_list.get(i);
        }
        
        return answer;
    }
}