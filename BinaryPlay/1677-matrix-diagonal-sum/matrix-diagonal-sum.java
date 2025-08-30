class Solution {
    public int diagonalSum(int[][] mat) {
        int n = mat.length;

        int sum = 0; 

        int i = 0 , j = n - 1;

        while(i < n && j < n){ 
            //primary diagonals
            sum += mat[i][i];

            //secondary diagonals 
            //in secondary diagonal don't add i == j wala form because already add in primary 
            sum += (i == j) ? 0 : mat[i][j];
            i++;
            j--;
        }
        return sum;
    }
}