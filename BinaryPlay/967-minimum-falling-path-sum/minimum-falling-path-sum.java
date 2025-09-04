class Solution {
    int n ;
    int[][] t;
    public int solve(int i , int j , int[][] matrix){  

        if(i == n - 1){
            //reached last row 
            return t[i][j] = matrix[i][j]; 
        } 

        if(t[i][j] != -1) return t[i][j];

        int min_sum = Integer.MAX_VALUE;

        if(i + 1 < n && j + 1 < n){
            min_sum = Math.min(min_sum , matrix[i][j] + solve(i + 1 , j + 1 , matrix));
        }
        if(i + 1 < n && j < n){
            min_sum = Math.min(min_sum , matrix[i][j] + solve(i + 1 , j , matrix));
        }
        if(i + 1 < n && j - 1 >= 0){
            min_sum = Math.min(min_sum , matrix[i][j] + solve(i + 1 , j - 1 , matrix));
        } 

        return t[i][j] = min_sum;

        // return t[i][j] = matrix[i][j] + Math.min(bottom_right , Math.min(bottom_down , bottom_left));

    }
    public int minFallingPathSum(int[][] matrix) {

        n = matrix.length;

        int min_falling_path_sum = Integer.MAX_VALUE;

        t = new int[n + 1][n + 1];
        for(int[] r : t){
            Arrays.fill(r , -1);
        } 

        int[][] t = new int[n][n];
        for(int col = 0 ; col < n ; col++){
            t[0][col] = matrix[0][col];
        }

        for(int i = 1 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                int up_left = (j - 1) < 0 ? Integer.MAX_VALUE : t[i - 1][j - 1];
                int up = t[i - 1][j];
                int up_right = (j + 1) >= n ? Integer.MAX_VALUE : t[i - 1][j + 1];

                t[i][j] = matrix[i][j] + Math.min(up_left , Math.min(up , up_right));
            }
        }


        for(int col = 0 ; col < n ; col++){
            min_falling_path_sum = Math.min(min_falling_path_sum , t[n - 1][col]);
        }
 
        return min_falling_path_sum;
    }

}