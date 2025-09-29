class Solution_1039 {
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int[][] dp = new int[n][n];

        // dp[i][j] default 0 for intervals with length < 3
        for (int len = 2; len < n; ++len) { // len = j - i
            for (int i = 0; i + len < n; ++i) {
                int j = i + len;
                int best = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; ++k) {
                    int cost = dp[i][k] + dp[k][j] + values[i] * values[k] * values[j];
                    if (cost < best) best = cost;
                }
                dp[i][j] = (best == Integer.MAX_VALUE) ? 0 : best;
            }
        }
        return dp[0][n-1];
    }
}
