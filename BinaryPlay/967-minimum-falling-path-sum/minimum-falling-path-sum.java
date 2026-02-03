class Solution {
    int m , n;
    int[][] t;

    private int solve(int[][] grid , int i , int j){
        if(i < 0 || j < 0 || i >= m || j >= n) return Integer.MAX_VALUE;

        if(i == m - 1){
            return grid[i][j];
        }

        if(t[i][j] != Integer.MAX_VALUE) return t[i][j];

        int ans = grid[i][j] + Math.min(solve(grid , i + 1 , j - 1) , Math.min(solve(grid , i + 1 , j) , solve(grid , i + 1 , j + 1)));

        return t[i][j] = ans;
    }
    public int minFallingPathSum(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;  

        t = new int[m][n];
        for(int[] r : t) Arrays.fill(r  , Integer.MAX_VALUE);

        int ans = Integer.MAX_VALUE;
        for(int j = 0 ; j < n ; j++){

            ans = Math.min(ans , solve(matrix , 0 , j));
        }

        return ans;
    }
}