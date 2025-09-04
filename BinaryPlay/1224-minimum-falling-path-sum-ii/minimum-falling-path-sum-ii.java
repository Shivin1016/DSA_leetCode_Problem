class Solution {
    int n ;
    int[][] t;
    public int solve(int row , int col , int[][] grid , int current_col){
        if(row == n - 1){
            return grid[row][col];
        }

        if(t[row][col] != Integer.MAX_VALUE){
            return t[row][col];
        }

        int min_sum = Integer.MAX_VALUE;
        for(int shift = 0 ; shift < n ; shift++){
            //don't take element with adjacent rows
            if(shift == current_col) continue;

            if(row + 1 < n){
                min_sum = Math.min(min_sum , grid[row][col] + solve(row + 1 , shift , grid , shift));
            }
        }

        return t[row][col] = min_sum;
    }
    public int minFallingPathSum(int[][] grid) {

        int min_falling_path_sum = Integer.MAX_VALUE;
        n = grid.length;

        t = new int[n + 1][n + 1];
        for(int[] r : t) Arrays.fill(r , Integer.MAX_VALUE);

        for(int col = 0 ; col < n ; col++){
            min_falling_path_sum = Math.min(min_falling_path_sum , solve(0 , col , grid , col));
        }

        return min_falling_path_sum;
    }
} 