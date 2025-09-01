class Solution {
    int m , n;  
    int[][] t ;
    public int solve(int i , int j , int[][] grid){

        if(i == m - 1 && j == n - 1) return t[i][j] = grid[i][j];

        if(i >= m || j >= n) return Integer.MAX_VALUE;

        if(t[i][j] != -1) return t[i][j];

        return t[i][j] = grid[i][j] + Math.min(solve(i , j + 1 , grid) , solve(i + 1 , j , grid));
    }
    public int minPathSum(int[][] grid) {

        m = grid.length;
        n = grid[0].length; 

        t = new int[m + 1][n + 1];
        for(int[] r : t) Arrays.fill(r , -1);  

        return solve(0 , 0 , grid);
    }

}