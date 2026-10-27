package programmers.두큐합같게만들기;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] queue1 = {
                {3, 2, 7, 2},
                {1, 2, 1, 2},
                {1, 1}
        };
        int[][] queue2 = {
                {4, 6, 5, 1},
                {1, 10, 1, 2},
                {1, 5}
        };
        int[] expected = {2, 7, -1};
        
        for (int i = 0; i < expected.length; i++) {
            int result = solution.solution(queue1[i], queue2[i]);
            System.out.printf("테스트 %d: %s | 결과: %d | 기댓값: %d%n",
                    i + 1, result == expected[i] ? "정답" : "오답", result, expected[i]);
        }
    }
    
    public int solution(int[] queue1, int[] queue2) {
        // TODO: 풀이 작성
        return -2;
    }
}
