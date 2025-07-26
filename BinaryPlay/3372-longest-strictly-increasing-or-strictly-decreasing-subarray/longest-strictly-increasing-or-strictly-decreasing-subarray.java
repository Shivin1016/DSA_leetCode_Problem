class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        int len = 1;
        int maxLen1 = 1;

        //for strictly decreasing
        for(int i = 1 ; i < n ; i++){
            if(nums[i - 1] < nums[i]){
                len += 1;
                maxLen1 = Math.max(maxLen1 , len);
            }else{
                //new subarray found
                len = 1;
            }
        } 

        //for strictly decreasing
        len = 1;
        int maxLen2 = 1;
        for(int i = 1 ; i < n ; i++){
            if(nums[i - 1] > nums[i]){
                len += 1;
                maxLen2 = Math.max(maxLen2 , len);
            }else{
                len = 1;
            }
        }

        return Math.max(maxLen1 , maxLen2);
    }
}