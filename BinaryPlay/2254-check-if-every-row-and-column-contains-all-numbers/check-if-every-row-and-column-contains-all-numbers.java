class Solution {
    public boolean checkValid(int[][] matrix) {

        int n = matrix.length; 

        for(int i = 0 ; i < n ; i++){
            Set<Integer> num1 = new HashSet<>();
            Set<Integer> num2 = new HashSet<>();
            for(int j = 0 ; j < n ; j++){
                //col - wise
                if(num1.contains(matrix[i][j])){
                   return false;
                }else{
                    num1.add(matrix[i][j]);
                }
                //row wise
                if(num2.contains(matrix[j][i])){
                    return false;
                }else{
                    num2.add(matrix[j][i]);
                }
            } 
        }  
        return true;
    }
}