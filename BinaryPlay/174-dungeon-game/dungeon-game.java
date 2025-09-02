class Solution {
    int m ,n ;
    int[][] t = new int[201][201];
    public int solve(int i , int j , int[][] grid){

        if(i >= m || j >= n){  
            return Integer.MAX_VALUE;
        }   

        if(t[i][j] != -1) return t[i][j];

        if(i == m - 1 && j == n - 1){
            //base case
            if(grid[i][j] <= 0){
                return t[i][j] = Math.abs(grid[i][j]) + 1;
            }
            return 1; // already have positive power so minimum 1 required
        } 
 

        int requireMnt = Math.min(solve(i , j + 1 , grid) , solve(i + 1 , j , grid)) - grid[i][j];
        //if ans less then 0 mtln reuiremnt se jada hi hai to one bhej do
        int ans = requireMnt <= 0 ? 1 : requireMnt;
       
        return t[i][j] = ans;
    }
    public int calculateMinimumHP(int[][] dungeon) {
        m = dungeon.length;
        n = dungeon[0].length;  

        for(int[] r : t) Arrays.fill(r , -1);

        return solve(0 ,0 , dungeon);
    }


}