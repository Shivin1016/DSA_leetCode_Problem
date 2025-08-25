class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int k = 0;
        int[] ans = new int[m * n];

        if(m == 0) return mat[0]; // single row

        if(n == 0){
            //single col
            for(int i = 0 ; i < m ; i++){
                ans[k++] = mat[i][0];
            }
            return 
            ans;
        } 
        int total = m*n;
  
        int i = 0 ,j = 0 ;
 
        boolean down = false; //for down directions
        while(k < total){ 
            ans[k++] = mat[i][j];  
            if(down == true){  
                if(i == m - 1){ // reach last row
                    j++;
                    down = false;
                }else if(j == 0){
                    i++;
                    down = false;
                }else{
                    i++;
                    j--;
                }
            }
            else{
                if(j == n - 1){
                    i++;
                    down = true;
                }else if(i == 0){
                    j++;
                    down = true;
                }else{
                    i--;
                    j++;
                }
            } 
        } 
        return ans;

    }
}