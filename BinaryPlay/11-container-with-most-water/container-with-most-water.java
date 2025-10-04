class Solution {
    public int maxArea(int[] height) {
        int n = height.length;

        long width = n - 1;
        int i = 0;
        int j = n - 1;
        int maxArea = Integer.MIN_VALUE;

        while(i < j){
            long high = Math.min(height[i] , height[j]);
            int area = (int)(high * width);
            width--;
            maxArea = Math.max(maxArea , area);
            
            if(height[i] > height[j]) j--;
            else i++;
        }
        return maxArea;
    }
}