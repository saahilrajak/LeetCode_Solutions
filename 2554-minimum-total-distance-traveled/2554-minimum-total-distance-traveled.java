import java.util.*;

class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, Comparator.comparingInt(a -> a[0]));

        int m = robot.size();
        int n = factory.length;

        long[][] dp = new long[m + 1][n + 1];
        for (long[] row : dp) Arrays.fill(row, Long.MAX_VALUE);
        dp[0][0] = 0;

        for (int j = 1; j <= n; j++) {
            dp[0][j] = 0;
            int factoryPos = factory[j - 1][0];
            int limit = factory[j - 1][1];

            for (int i = 1; i <= m; i++) {
                dp[i][j] = dp[i][j - 1];
                long sumDistance = 0;

                for (int k = 1; k <= Math.min(i, limit); k++) {
                    sumDistance += Math.abs(robot.get(i - k) - factoryPos);
                    if (dp[i - k][j - 1] != Long.MAX_VALUE) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - k][j - 1] + sumDistance);
                    }
                }
            }
        }

        return dp[m][n];
    }
}
