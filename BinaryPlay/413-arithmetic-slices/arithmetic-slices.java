class Solution {
    public int numberOfArithmeticSlices(int[] nums) { 
        int n = nums.length;
        
        // length must be at least 3
        if(n < 3) return 0;
 
        int sub = 0;  
        int count = 0;

        for(int i = 2 ; i < n ; i++){
            int diff1 = nums[i] - nums[i - 1];
            int diff2 = nums[i - 1] - nums[i - 2];
            if(diff1 == diff2){
                count++;
                sub += count;
            }else{
                //intilise for new slice
                count = 0;
            }
        }
        return sub;

    }
}