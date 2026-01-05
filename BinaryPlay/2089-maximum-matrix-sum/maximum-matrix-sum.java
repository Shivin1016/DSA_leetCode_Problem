class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        long sum = 0;

        int minNum = Integer.MAX_VALUE;
        int count = 0 ; // count of negative numbers

        for(int i =0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                int num = Math.abs(matrix[i][j]);

                if(matrix[i][j] < 0){
                    count++;
                }
                sum += num;
                minNum = Math.min(minNum , num);
            }
        }

        if(count % 2 == 0){
            // negative numbers are even
            return sum;
        }

        // odd negative 
        // subtract smallest numbers from sum 
        sum -= minNum; // add kr lia tha isisliye subtract kro
        sum -= minNum; // subtract because it is negative number

        return sum;
    }
}