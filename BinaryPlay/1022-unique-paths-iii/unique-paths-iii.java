class Solution {
    int m , n;
    int[][] dir = {{0 , 1} , {1 , 0} , {0 , -1} , {-1 , 0}}; 

    private int solve(int[][] grid , int i, int j , int remaining){
        if(i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == -1){
            return 0;
        }

        // if no cells remians for visiting 
        if(grid[i][j] == 2){
            return remaining == -1 ? 1 : 0;
        }

        int ways = 0;
        int temp = grid[i][j];
        // mark as visited
        grid[i][j] = -1;

        for(int[] d : dir){ 
            // call recusrsion and decrement remain
            ways += solve(grid , i + d[0] , j + d[1] , remaining - 1); 
        }

        // backtrack
        grid[i][j] = temp;

        return ways;
    }
    public int uniquePathsIII(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        int startX = 0;
        int startY = 0;
        int empty = 0;

        // find startI and startJ
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 0) empty++;
                if(grid[i][j] == 1){
                    startX = i;
                    startY = j;
                }
            }
        }



        return solve(grid , startX , startY , empty);
    }
}