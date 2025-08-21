class Solution {
    public int numSubmat(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int res = 0;

        for(int startRow = 0 ; startRow < m ; startRow++){
            //make 1-d array from startRow to endRow
            int[] colOnes = new int[n];
            Arrays.fill(colOnes , 1);
            for(int endRow = startRow ; endRow < m ; endRow++){

                for(int col = 0 ; col < n ; col++){
                    colOnes[col] = colOnes[col] & mat[endRow][col];
                }
                //check for submatrices in 1-d arrray
                int consecutive = 1;
                for(int k = 0 ; k < n ; k++){
                    if(colOnes[k] == 0){
                       consecutive = 0;
                    } 
                    res += consecutive;
                    consecutive++;
                }
            }
        }
        return res;
    }
}