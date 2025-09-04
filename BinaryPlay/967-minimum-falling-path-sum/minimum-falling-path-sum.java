class Solution { 
    public int minFallingPathSum(int[][] matrix) {

        int n = matrix.length;

        int min_falling_path_sum = Integer.MAX_VALUE; 

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