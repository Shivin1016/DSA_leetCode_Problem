class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;

        int i = 0 , j = 0 ;
        int result = 0;
        int zero_cnt = 0;

        while(j < n){
            if(nums[j] == 0){
                zero_cnt++;
            }

            while(i < n && zero_cnt > k){
                if(nums[i] == 0){
                    zero_cnt--;
                }
                i++;
            }
            result = Math.max(result , (j - i + 1));
            j++;
        }
        return result;
    }
}