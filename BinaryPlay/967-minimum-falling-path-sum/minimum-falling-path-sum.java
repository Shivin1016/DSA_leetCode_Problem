class Solution { 
    int n;
    int[][] t;
    public int solve(int i , int j , int[][] grid){
        if(i == n - 1){
            return t[i][j] = grid[i][j];
        }

        if(t[i][j] != Integer.MAX_VALUE){
            return t[i][j];
        }
        /*
        col - 1 =>left
        col + 0 => up
        col + 1 =>right
        */
        int min_sum = Integer.MAX_VALUE;
        for(int shift = -1 ; shift <= 1 ; shift++){
            if(i + 1 < n && j + shift < n && j + shift >= 0){
                min_sum = Math.min(min_sum , grid[i][j] + solve(i + 1 , j + shift , grid));
            }
        }
        return t[i][j] = min_sum;
    }
    public int minFallingPathSum(int[][] matrix) {
        int min_falling_path_sum = Integer.MAX_VALUE; 

        //recusion pluse memo
        n = matrix.length;
        t = new int[n + 1][n + 1];
        for(int[] r : t) Arrays.fill(r , Integer.MAX_VALUE);

        for(int col = 0 ; col < n ; col++){
            min_falling_path_sum = Math.min(min_falling_path_sum , solve(0 , col , matrix));
        }

        //bottom up appraoch
        // int n = matrix.length;


        // int[][] t = new int[n][n];
        // for(int col = 0 ; col < n ; col++){
        //     t[0][col] = matrix[0][col];
        // }

        // for(int i = 1 ; i < n ; i++){
        //     for(int j = 0 ; j < n ; j++){
        //         int up_left = (j - 1) < 0 ? Integer.MAX_VALUE : t[i - 1][j - 1];
        //         int up = t[i - 1][j];
        //         int up_right = (j + 1) >= n ? Integer.MAX_VALUE : t[i - 1][j + 1];

        //         t[i][j] = matrix[i][j] + Math.min(up_left , Math.min(up , up_right));
        //     }
        // }


        // for(int col = 0 ; col < n ; col++){
        //     min_falling_path_sum = Math.min(min_falling_path_sum , t[n - 1][col]);
        // }
 
        return min_falling_path_sum;
    }

}