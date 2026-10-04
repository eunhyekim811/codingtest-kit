package week08_dynamic_programming.김은혜;

// 문자열 형태로 숫자와 덧셈, 뺄셈 기호가 있는 배열 arr
// 괄호 위치에 따라 계산되는 값 중 최대값 리턴
public class 사칙연산_김은혜 {

    public int solution(String arr[]) {
        int sum=0;
        int max=0, min=0;

        int answer=0;
        for(int i=arr.length-1; i>=0; i-=2){
            if(i-1<0){
                answer=Integer.parseInt(arr[i])+max+sum;
                break;
            }

            if(arr[i-1].equals("+")){
                sum+=Integer.parseInt(arr[i]);
            } else{
                int t1=Integer.parseInt(arr[i])*(-1)+sum+max;
                int t2=(Integer.parseInt(arr[i])+sum+min)*(-1);
//                int t3=(Integer.parseInt(arr[i])+sum)*(-1)+max;

                int tt1=(Integer.parseInt(arr[i])+sum)*(-1)+min;
                int tt2=(Integer.parseInt(arr[i])+sum+max)*(-1);
//                int tt3=Integer.parseInt(arr[i])*(-1)+sum+min;

                max=Math.max(t1, t2);
//                max=Math.max(max, t3);
                min=Math.min(tt1, tt2);
//                min=Math.min(min, tt3);

                sum=0;
            }
        }

        return answer;
    }
}
