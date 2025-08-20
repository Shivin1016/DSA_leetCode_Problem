class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        //bottom up appraoch
        int[][] t = new int[m][n];
        int res = 0;

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(i == 0 || j == 0){
                    //agr cell me 0 hai to 0 square matrix agr ek hai to 1 sqaure ban hi jayega
                    t[i][j] = matrix[i][j];
                }
                else if(matrix[i][j] == 1){  
                    t[i][j] = 1 + Math.min(t[i - 1][j] , Math.min(t[i][j - 1] , t[i - 1][j - 1]));
                }
                res += t[i][j];
            }
        }
        return res;
    }
}