class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] rowSum = new int[m];
        int[] colSum = new int[n];

        for(int i = 0 ; i < m ; i++){
            int sum1 = 0;
            for(int j = 0 ; j < n ; j++){
                sum1 += grid[i][j];  
            } 
            rowSum[i] = sum1;  
        } 

        for(int j = 0 ; j < n ; j++){
            int sum2 = 0;
            for(int i = 0 ; i < m ; i++){
                sum2 += grid[i][j];
            }
            colSum[j] = sum2;
        } 

        //now this problem arises as --> partition to array into equal sum of elements
        // ex--> [4 , 6 , 10]--> divide it in [4,6] and [10] now they both have equal sum
        //HorizontalCuts
        boolean horizonCut = canSplit(rowSum);
        boolean verticalCut = canSplit(colSum);
         
        return horizonCut || verticalCut;
    }
    
    public boolean canSplit(int arr[]) {
        int n = arr.length;

        //find sum from leftSide
        int leftSideSum = 0;
        for(int num : arr) leftSideSum += num;

        //iterate from rightside and subtract leftSide sum from rightSide elements
        int rightSideSum = 0;
        for(int i = n - 1 ; i >= 0 ; i--){
            rightSideSum += arr[i];
            //subtract arr[i] from leftside
            leftSideSum -= arr[i];

            if(rightSideSum == leftSideSum) return true;
        }
        return false;
    }
    
}