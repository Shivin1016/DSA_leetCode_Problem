class Solution {
    int[][][] dp;
    int[][] count ;
    public int solve(int len , int m, int n, int i) {
        if (i >= len || (m == 0 && n == 0)) {
            return 0;
        }
        if(dp[i][m][n] != -1) return dp[i][m][n];

        int take = 0;
        int[] c = count[i];
        if (c[0] <= m && c[1] <= n) {
            take = 1 + solve(len , m - c[0], n - c[1], i + 1);
        }
        int skip = solve(len , m, n, i + 1);

        return dp[i][m][n] = Math.max(skip, take);
    }

    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        dp = new int[len][m + 1][n + 1];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= m; j++)
                Arrays.fill(dp[i][j], -1);
        }
        count = new int[len][2];

        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            int ones = 0, zeros = 0;
            for (char ch : str.toCharArray()) {
                if (ch == '0') {
                    zeros++;
                } else {
                    ones++;
                }
            }
            count[i][0] = zeros;
            count[i][1] = ones;
        }

        return solve(len , m, n, 0);
    }
}