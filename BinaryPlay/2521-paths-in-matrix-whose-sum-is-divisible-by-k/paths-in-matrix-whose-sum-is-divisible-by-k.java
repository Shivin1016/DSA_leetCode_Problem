class Solution {
    int n , m ; 
    int K ;
    long modulas = 1000000007;
    int[][][] dp ;
    public int solve(int[][] grid , int i , int j , int mod ){
        if(i >= m || j >= n ) return 0;

        int newMod = (mod + grid[i][j]) % K;

        if(i == m - 1 && j == n - 1){ 
            return newMod == 0 ? 1 : 0; 
        }

        if(dp[i][j][newMod] != -1){
            return dp[i][j][newMod];
        }
        
        long path1 = 0 , path2 = 0;
        path1 += solve(grid , i + 1 , j , newMod);
        path2 += solve(grid , i , j + 1 , newMod);

        return dp[i][j][newMod] = (int)((path1 + path2) % modulas);
    }
    public int numberOfPaths(int[][] grid, int k) {
        m = grid.length;
        n = grid[0].length;
        K = k;
        dp = new int[m + 1][n + 1][k];
        for(int[][] r : dp){ 
            for(int[] t : r){
                Arrays.fill(t , -1);
            }
        }
        return solve(grid , 0 , 0 , 0); 
    }
}