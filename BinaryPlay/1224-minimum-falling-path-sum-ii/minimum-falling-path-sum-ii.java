class Solution { 
    public int minFallingPathSum(int[][] grid) {

        int min_falling_path_sum = Integer.MAX_VALUE;

        //Bottom -up appraoch
        int n = grid.length;

        // int[][] t = new int[n][n];
        //t[i][j] --> minimum falling path sum from (row = i , col = j) to row = n - 1

        int nextMinCol1 = -1; // first min value in row - 1 
        int nextMinCol2 = -1; // second min value in row - 1
        int nextMinColVal1 = -1;
        int nextMinColVal2 = -1;

        for(int col = 0 ; col < n ; col++){ 
            if(nextMinCol1 == -1 || grid[0][col] <= nextMinColVal1){
                nextMinCol2 = nextMinCol1;
                nextMinColVal2 = nextMinColVal1;
                nextMinCol1 = col;
                nextMinColVal1 = grid[0][col];
            }else if(nextMinCol2 == -1 || grid[0][col] <= nextMinColVal2){
                nextMinCol2 = col;
                nextMinColVal2 = grid[0][col];
            }
        }

        for(int i = 1 ; i < n ; i++){
            int minCol1 = -1 , minCol2 = -1;
            int minColVal1 = -1 , minColVal2 = -1;
            for(int j = 0 ; j < n ; j++){
                if(nextMinCol1 == j){
                    grid[i][j] += nextMinColVal2;
                }else{
                    grid[i][j] += nextMinColVal1;
                } 

                //update mincol1 and mincol2 for current row
                if(minCol1 == -1 || grid[i][j] <= minColVal1){
                    minCol2 = minCol1;
                    minColVal2 = minColVal1;
                    minCol1 = j;
                    minColVal1 = grid[i][j];
                }else if(minCol2 == -1 || grid[i][j] <= minColVal2){
                    minCol2 = j;
                    minColVal2 = grid[i][j];
                }
            }
            nextMinCol1 = minCol1;
            nextMinCol2 = minCol2;
            nextMinColVal1 = minColVal1;
            nextMinColVal2 = minColVal2;
        } 

        return nextMinColVal1;
    }
} 