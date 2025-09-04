class Solution { 
    public int minFallingPathSum(int[][] grid) {

        int min_falling_path_sum = Integer.MAX_VALUE;

        //Bottom -up appraoch
        int n = grid.length;

        int[][] t = new int[n][n];
        //t[i][j] --> minimum falling path sum from (row = i , col = j) to row = n - 1

        for(int col = 0 ; col < n ; col++){
            t[0][col] = grid[0][col];
        }

        for(int i = 1 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                int sum = Integer.MAX_VALUE;
                for(int shift = 0 ; shift < n ; shift++){
                    if(j != shift){
                        sum = Math.min(sum , t[i - 1][shift]);
                    }
                }
                t[i][j] = grid[i][j] + sum;
            }
        }

        for(int col = 0 ; col < n ; col++){
            min_falling_path_sum = Math.min(min_falling_path_sum , t[n - 1][col]);
        }

        //Approach --> recursion and memo
        // n = grid.length;

        // t = new int[n + 1][n + 1];
        // for(int[] r : t) Arrays.fill(r , Integer.MAX_VALUE);

        // for(int col = 0 ; col < n ; col++){
        //     min_falling_path_sum = Math.min(min_falling_path_sum , solve(0 , col , grid , col));
        // }

        return min_falling_path_sum;
    }
} 