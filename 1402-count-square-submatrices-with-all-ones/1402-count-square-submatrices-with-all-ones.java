class Solution {
    public int countSquares(int[][] matrix) {
        Vector<Integer> dp = new Vector<>(m,0);
            for(int j=0;j<m,j++) dp[0][j] = matrix[0][j];
            for(int i=0;i<n,i++) dp[0][i] = matrix[0][i];
            for(int i=0;i<n,i++){
                for(int j=0;j<m;j++){
                    if(matrix[i][j] == 0) {
                        dp[i][j] = 0
                    }
                    else{
                        dp[i][j] = 1+min(dp[i-1][j],
                        min(dp[i-1][j-1],dp[i][j-1]))
                    }
                }
            }
            int sum = 0;
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    sum +=dp[i][j];
                }
            }
        return sum;
    }
}