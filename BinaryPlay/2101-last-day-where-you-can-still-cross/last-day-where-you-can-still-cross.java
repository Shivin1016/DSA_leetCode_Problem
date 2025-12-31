class Solution {
    int m , n;
    int[][] direction = {{1 , 0} , {0 , 1} , {-1 , 0} , {0 , -1}};
    public boolean DFS(int[][] grid , int i , int j){
        if(i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 1){
            return false;
        }

        if(i == m - 1) return true;
        grid[i][j] = 1; // visit 
        for(int[] dir : direction){
            int i_ = dir[0] + i;
            int j_ = dir[1] + j;

            if(DFS(grid , i_ , j_)){
                return true;
            }
        }
        return false;
    }
    public boolean canGo(int[][] cells , int mid){
        int[][] grid = new int[m][n];

        for(int i = 0 ; i <= mid ; i++){
            int r = cells[i][0] - 1;
            int c = cells[i][1] - 1;

            grid[r][c] = 1;
        }

        // dfs
        for(int col = 0 ; col < n ; col++){
            if(grid[0][col] == 0 && DFS(grid , 0 , col)){
                return true;
            }
        }
        return false;
    }
    public int latestDayToCross(int row, int col, int[][] cells) {
        m = row;
        n = col;

        // binary search
        int l = 0;
        int r = cells.length - 1;
        int lastDay = 0;
        while(l <= r){
            int mid = l + ( r- l) / 2;
            if(canGo(cells , mid)){
                lastDay = mid + 1;
                l = mid + 1;
            }
            else{
                r = mid - 1;
            }
        }
        return lastDay;
    }
}