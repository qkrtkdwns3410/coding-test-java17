package programmers.두큐합같게만들기;

import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] queue1 = {
                {3, 2, 7, 2},
                {1, 2, 1, 2},
                {1, 1},
                {1, 1, 7, 1},
                {1_000_000_000, 1_000_000_000, 1_000_000_000}
        };
        int[][] queue2 = {
                {4, 6, 5, 1},
                {1, 10, 1, 2},
                {1, 5},
                {1, 1, 1, 1},
                {1_000_000_000, 1_000_000_000, 1_000_000_000}
        };
        int[] expected = {2, 7, -1, 9, 0};
        
        for (int i = 0; i < expected.length; i++) {
            int result = solution.solution(queue1[i], queue2[i]);
            System.out.printf("테스트 %d: %s | 결과: %d | 기댓값: %d%n",
                    i + 1, result == expected[i] ? "정답" : "오답", result, expected[i]);
        }
    }
    
    public int solution(int[] queue1, int[] queue2) {
        // 큐로 만들기
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        
        for (int i = 0; i < queue1.length; i++) {
            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
        }
        
        long leftSum = q1.stream().mapToLong(Integer::longValue).sum();
        long rightSum = q2.stream().mapToLong(Integer::longValue).sum();
        
        if ((leftSum + rightSum) % 2 != 0) {
            return -1;
        }
        
        int count = 0;
        
        int limit = (queue1.length + queue2.length) * 2;
        for (int i = 0; i < limit; i++) {
            if (leftSum == rightSum) {
                return count;
            }
            
            if (leftSum > rightSum) {
                Integer poll = q1.poll();
                q2.offer(poll);
                leftSum -= poll;
                rightSum += poll;
            } else {
                Integer poll = q2.poll();
                q1.offer(poll);
                rightSum -= poll;
                leftSum += poll;
            }
            
            count++;
            
        }
        
        return leftSum == rightSum ? count : -1;
    }
}
