package programmers.게임맵최단거리;

import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][][] inputs = {
                {
                        {1, 0, 1, 1, 1},
                        {1, 0, 1, 0, 1},
                        {1, 0, 1, 1, 1},
                        {1, 1, 1, 0, 1},
                        {0, 0, 0, 0, 1}
                },
                {
                        {1, 0, 1, 1, 1},
                        {1, 0, 1, 0, 1},
                        {1, 0, 1, 1, 1},
                        {1, 1, 1, 0, 0},
                        {0, 0, 0, 0, 1}
                }
        };
        int[] expected = {11, -1};
        
        for (int i = 0; i < expected.length; i++) {
            int result = solution.solution(inputs[i]);
            System.out.printf("테스트 %d: %s | 결과: %d | 기댓값: %d%n",
                    i + 1, result == expected[i] ? "정답" : "오답", result, expected[i]);
        }
    }
    
    // 0: 벽, 1: 이동 가능한 칸
    // 시작 칸을 포함하여 (0, 0)에서 오른쪽 아래까지 지나는 최소 칸 수 반환
    public int solution(int[][] maps) {
        int rows = maps.length;
        int cols = maps[0].length;
        
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, 1, -1};
        
        int[][] visited = new int[rows][cols];
        
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});
        visited[0][0] = 1;
        
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int row = current[0];
            int col = current[1];
            
            if (row == rows - 1 && col == cols - 1) {
                return visited[row][col];
            }
            
            for (int i = 0; i < dr.length; i++) {
                int nr = row + dr[i];
                int nc = col + dc[i];
                
                if (nr < 0 || nc < 0 || nr >= rows || nc >= cols) {
                    continue;
                }
                
                //이미 방문하거나 벽임
                if (visited[nr][nc] != 0 || maps[nr][nc] == 0) {
                    continue;
                }
                
                visited[nr][nc] = visited[row][col] + 1;
                q.offer(new int[]{nr, nc});
            }
        }
        
        return -1;
    }
}
