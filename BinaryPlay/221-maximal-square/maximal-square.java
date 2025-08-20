class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] t = new int[m][n];
        int res = 0;

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(i == 0 || j == 0){
                    t[i][j] = matrix[i][j] - '0'; //agr ek hua to ek side sqaure matrix ban jayega  
                }
                else if(matrix[i][j] == '1'){
                    t[i][j] = 1 + Math.min(t[i - 1][j] , Math.min(t[i][j - 1] , t[i - 1][j - 1]));
                }
                res = Math.max(res , t[i][j]);  
            }
        }
        return res * res;
    }
}