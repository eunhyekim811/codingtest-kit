import java.util.*;

class Solution {
    public int solution(int[] money) {
        int n = money.length;
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

        arr1[0] = money[0];
        arr1[1] = money[0];
        for (int i = 2; i < n - 1; i++) {
            arr1[i] = Math.max(arr1[i - 1], arr1[i - 2] + money[i]);
        }

        arr2[1] = money[1];
        for (int i = 2; i < n; i++) {
            arr2[i] = Math.max(arr2[i - 1], arr2[i - 2] + money[i]);
        }

        return Math.max(arr1[n - 2], arr2[n - 1]);
    }
}