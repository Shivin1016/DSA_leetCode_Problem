class Solution {
    int[][] direction = {{1 , 0} , {0 , 1} , {-1 , 0} ,{0 ,-1}};
    int n ;
    boolean canMove(int x , int y , int time , int[][] grid){
        return (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] <= time);
    }
    public boolean possibleToReach(int[][] grid , int i , int j , int time , boolean[][] visited){
        visited[i][j] = true;

        if(i == n - 1 && j == n - 1) return true;

        for(int[] dir : direction){
            int x = i + dir[0];
            int y = j + dir[1];

            if(canMove(x , y , time , grid) && !visited[x][y]){
                if(possibleToReach(grid , x , y , time , visited)){
                    return true;
                }
            }
        }
        return false;
    }
    public int swimInWater(int[][] grid) {

        n = grid.length; 

        int l = grid[0][0];
        int r = n * n - 1;
        int result = 0;

        while(l <= r){
            int mid = l + (r - l) / 2;
            boolean[][] visited = new boolean[n][n];
            if(possibleToReach(grid ,  0 , 0 , mid , visited)){
                result = mid;
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }

        return result;


    }
}