class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        //bottom up appraoch
        int[][] t = new int[m][n];
        int res = 0;

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(matrix[i][j] == 1){
                    int up = (i - 1 < 0) ? 0 : t[i - 1][j];
                    int left = (j - 1 < 0) ? 0 : t[i][j - 1];
                    int diagonally_up = (i - 1 < 0 || j - 1 < 0) ? 0 : t[i - 1][j - 1];

                    t[i][j] = 1 + Math.min(up , Math.min(left , diagonally_up));
                    res += t[i][j];
                }
            }
        }
        return res;
    }
}