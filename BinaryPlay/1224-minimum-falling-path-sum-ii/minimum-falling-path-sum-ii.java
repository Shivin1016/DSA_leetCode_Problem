class Solution { 
    public int minFallingPathSum(int[][] grid) {

        int min_falling_path_sum = Integer.MAX_VALUE;

        //Bottom -up appraoch
        int n = grid.length;

        int[][] t = new int[n][n];
        //t[i][j] --> minimum falling path sum from (row = i , col = j) to row = n - 1

        int nextMinCol1 = -1; // first min value in row - 1 
        int nextMinCol2 = -1; // second min value in row - 1
        for(int col = 0 ; col < n ; col++){
            t[0][col] = grid[0][col];
            if(nextMinCol1 == -1 || t[0][col] <= t[0][nextMinCol1]){
                nextMinCol2 = nextMinCol1;
                nextMinCol1 = col;
            }else if(nextMinCol2 == -1 || t[0][col] <= t[0][nextMinCol2]){
                nextMinCol2 = col;
            }
        }

        for(int i = 1 ; i < n ; i++){
            int minCol1 = -1 , minCol2 = -1;
            for(int j = 0 ; j < n ; j++){
                if(nextMinCol1 == j){
                    t[i][j] = t[i - 1][nextMinCol2];
                }else{
                    t[i][j] = t[i - 1][nextMinCol1];
                }
                t[i][j] += grid[i][j];

                //update mincol1 and mincol2 for current row
                if(minCol1 == -1 || t[i][j] <= t[i][minCol1]){
                    minCol2 = minCol1;
                    minCol1 = j;
                }else if(minCol2 == -1 || t[i][j] <= t[i][minCol2]){
                    minCol2 = j;
                }
            }
            nextMinCol1 = minCol1;
            nextMinCol2 = minCol2;
        } 

        return t[n - 1][nextMinCol1];
    }
} 