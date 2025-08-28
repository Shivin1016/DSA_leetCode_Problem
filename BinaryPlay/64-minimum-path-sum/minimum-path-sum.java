class Solution {
    int m , n;
    int[][] t;
    public int solve(int i , int j , int[][] grid){
         

        if(i == m - 1 && j == n - 1){
            return grid[i][j]; //last cell
        }

        if(t[i][j] != -1) return t[i][j]; 

        if(i == m - 1){ // last row ->only go right
            //we can't go down
            return t[i][j] = grid[i][j] + solve(i , j + 1 , grid);
        }
        else if(j == n - 1){ // last col --> only go down
            return t[i][j] = grid[i][j] + solve(i + 1 , j , grid);
        }
        else{
            return  t[i][j] = grid[i][j] + Math.min(solve(i + 1 , j , grid) , solve(i , j + 1 , grid)); 
        } 
  
 
    }
    public int minPathSum(int[][] grid) {
        m = grid.length;
        n = grid[0].length;  

        t = new int[201][201];
        for(int[] r : t) Arrays.fill(r , -1);

        return solve(0 , 0 , grid);
    }
}