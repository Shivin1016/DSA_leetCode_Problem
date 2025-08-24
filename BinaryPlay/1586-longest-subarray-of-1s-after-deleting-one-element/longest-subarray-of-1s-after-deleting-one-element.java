class Solution {
    public int longestSubarray(int[] nums) {
        //better sliding window approach

        int n = nums.length;

        int i = 0 , j = 0; 
        int result =0;
        int last_time_zero =-1;
        while(j < n){
            if(nums[j] == 0){
                i = last_time_zero + 1;
                last_time_zero = j;
            }
            result = Math.max(result , j - i);
            j++;
        }
        return result;
    }
}