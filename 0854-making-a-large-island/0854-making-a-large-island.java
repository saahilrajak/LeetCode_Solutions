class Solution {

   private final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int maxArea = 0;

        for(int i = 0; i<n ; i++){
          for( int j = 0;j<n;j++){
            if(grid[i][j]==0){
              // change the value of 0 into 1 so that we can have the maximum number of island
              grid[i][j] = 1;

              boolean[][] visited = new boolean[n][n];
              int largest = 0;

              // compute the largest island from scratch

              for(int x = 0; x<n ;x++){
                for(int y = 0; y<n ;y++){
                  if(grid[x][y]==1 && !visited[x][y]){
                    largest = Math.max(largest, dfs(grid,x,y,visited,n));
                  }
                }
              }
              maxArea = Math.max(maxArea, largest);
              grid[i][j] = 0; // backtrack 
            }
          }
        }
        return (maxArea == 0) ? n*n : maxArea; // when the grid has full of 1's and doesn't contain any 0's
    }

    //implementing dfs

    private int dfs(int[][] grid, int i, int j, boolean[][] visited, int n){
      if(i<0 || i>=n || j<0 || j>=n || grid[i][j]==0 || visited[i][j]){
        return 0;
      }
      visited[i][j] = true;
      int count = 1;

      for(int[] dir: directions){
        count += dfs(grid,i+dir[0],j+dir[1],visited,n);
      }
      return count;
    }
}