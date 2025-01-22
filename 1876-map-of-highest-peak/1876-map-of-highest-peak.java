class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;

        int[][] height = new int[m][n];

        Queue<int[]> que = new LinkedList<>();
        for(int i=0;i<m;i++){
          for(int j=0;j<n;j++){
            if(isWater[i][j]==1){
              que.offer(new int[]{i,j});
              height[i][j]=0;
            }
            else{
              height[i][j] = -1;
            }
          }
        }

        //now perform multi-source Breadth first search 
        // where you are taking multi source origin and start from all the origin points and start filling the index or neighbour of that source origin
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        while(!que.isEmpty()){
          int N = que.size();
          while(N-- > 0){
            int[] curr = que.poll();
            int i = curr[0];
            int j = curr[1];
            for(int[] dir : directions){
              int i_ = i+dir[0];
              int j_ = j+dir[1];

              if(i_ >= 0 && i_ < m && j_ >= 0 && j_ < n && height[i_][j_] == -1){
              height[i_][j_] = height[i][j]+1;
              que.offer(new int[]{i_,j_});
              }
            }
          }
        }
        return height;
    }
}