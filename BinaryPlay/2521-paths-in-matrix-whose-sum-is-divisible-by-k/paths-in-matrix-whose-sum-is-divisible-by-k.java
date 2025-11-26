class Solution {
    int n , m ; 
    int K ;
    long M = 1000000007;
    int[][][] dp ; //declared
    public int solve(int[][] grid , int i , int j , int reminder ){
        if(i >= m || j >= n ) return 0; 
        int newReminder = (reminder + grid[i][j]) % K;

        if(i == m - 1 && j == n - 1){ 
            return newReminder == 0 ? 1 : 0; 
        }

        if(dp[i][j][newReminder] != -1){
            return dp[i][j][newReminder];
        }
        
        
        long path1 = 0 , path2 = 0;
        path1 += solve(grid , i + 1 , j , newReminder); //down 
        path2 += solve(grid , i , j + 1 , newReminder); //right 

        return dp[i][j][newReminder] = (int)((path1 + path2) % M);
    }
    public int numberOfPaths(int[][] grid, int k) {
        m = grid.length;
        n = grid[0].length;
        K = k;
        //intilisinig the 3d array
        dp = new int[m + 1][n + 1][k];
        for(int[][] r : dp){ 
            for(int[] t : r){
                Arrays.fill(t , -1);
            }
        }
        return solve(grid , 0 , 0 , 0); 


        // bottom up approach
        // int[][][] t = new int[m + 1][n + 1][K];

        // for(int remain = 0 ; remain < k ; remain++){
        //     t[m - 1][n - 1][remain] = (remain + grid[m - 1][n - 1]) % k == 0 ? 1 : 0;
        // }

        // for(int i = m - 1 ; i >= 0 ; i--){
        //     for(int j = n - 1 ; j >= 0 ; j--){
        //         for(int remain = 0 ; remain < k ; remain++){
        //             if(i == m - 1 && j == n - 1) continue;

        //             int R = (remain + grid[i][j]) % k;
        //             long p = 0;
        //             p += t[i + 1][j][R];
        //             p += t[i][j + 1][R];

        //             t[i][j][remain] = (int)(p % M);
        //         }
        //     }
        // }
        // return t[0][0][0];
    }
}