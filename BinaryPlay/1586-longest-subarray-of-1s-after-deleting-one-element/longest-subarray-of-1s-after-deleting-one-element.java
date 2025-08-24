class Solution {
    public int longestSubarray(int[] nums) {
        //sliding window 
        int n = nums.length;
        int i = 0 , j = 0;

        int result = 0 , zero_cnt = 0;
        while(j < n){
            if(nums[j] == 0){
                zero_cnt++;
            }

            while(i < n && zero_cnt > 1){
                if(nums[i] == 0){
                    zero_cnt--;
                }
                i++;
            }
            //we take length of (j - i) because we have to delete one element
            result = Math.max(result , (j - i)); 
            j++;
        }
        return result;
    }
}