class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int m = dimensions.length; 

        int maxArea = 0;
        double maxDiagonal = 0.0;

        for(int i = 0 ; i < m ; i++){
            int length = dimensions[i][0];
            int width = dimensions[i][1];

            double diagonalLen = Math.sqrt((length * length) + (width * width));
            int area = length * width; 
            if(diagonalLen > maxDiagonal){
                maxArea = area;
                maxDiagonal = diagonalLen;
            }else if(diagonalLen == maxDiagonal){
                maxArea = Math.max(maxArea , area);
            }
        }
        return maxArea;
    }
}