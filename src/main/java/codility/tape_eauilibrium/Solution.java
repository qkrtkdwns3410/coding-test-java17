package codility.tape_eauilibrium;// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] inputs = {
                //{3, 1, 2, 4, 3}, // 공식 예제
                //{1, 2},          // 최소 길이
                //{-10, -20},      // 음수만 있는 경우
                {-5, 5},         // 음수와 양수
                //{0, 0},          // 합이 0인 경우
                //{1, 1, 1, 1},    // 양쪽 합이 같은 경우
                //{10, 1, 1},      // 첫 번째 분할이 최적인 경우
                //{1, 1, 10}       // 마지막 분할이 최적인 경우
        };
        int[] expected = {
                //1,
                //1,
                //10,
                10,
                //0,
                //0,
                //8,
                //8
        };
        
        for (int i = 0; i < inputs.length; i++) {
            int result = solution.solution(inputs[i]);
            System.out.printf("테스트 %d: %s | 결과: %d | 기댓값: %d%n",
                    i + 1, result == expected[i] ? "정답" : "오답", result, expected[i]);
        }
    }
    
    public int solution(int[] A) {
        System.out.println("A = " + Arrays.toString(A));
        
        int min = Integer.MAX_VALUE;
        
        for (int i = 1; i < A.length; i++) {
            int leftSum = Arrays.stream(A, 0, i).sum();
            int rightSum = Arrays.stream(A, i, A.length).sum();
            
            int diff = Math.abs(leftSum - rightSum);
            
            min = Math.min(min, diff);
        }
        
        return min;
    }
}
