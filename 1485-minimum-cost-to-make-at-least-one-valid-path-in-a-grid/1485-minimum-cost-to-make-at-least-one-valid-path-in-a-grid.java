import java.util.*;
//T.C : O((m*n) * log(m*n)) 
//S.C : O(m*n)

class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        int[][] result = new int[m][n];
        
        for (int[] row : result) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        pq.offer(new int[] {0, 0, 0});
        result[0][0] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currCost = curr[0];
            int i = curr[1];
            int j = curr[2];
            
            if (result[i][j] < currCost) {
                continue;
            }
            
            for (int dir_i = 0; dir_i < 4; dir_i++) {
                int i_ = i + dir[dir_i][0];
                int j_ = j + dir[dir_i][1];
                
                if (i_ >= 0 && j_ >= 0 && i_ < m && j_ < n) {
                    int gridDir = grid[i][j];
                    int dirCost = ((gridDir - 1 != dir_i) ? 1 : 0);
                    int newCost = currCost + dirCost;
                    
                    if (newCost < result[i_][j_]) {
                        result[i_][j_] = newCost;
                        pq.offer(new int[] {newCost, i_, j_});
                    }
                }
            }
        }
        return result[m - 1][n - 1];
    }
}
