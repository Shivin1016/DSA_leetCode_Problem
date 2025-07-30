class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;

        int maxAND = 0;
        for(int num : nums) maxAND = Math.max(maxAND , num);

        int maxLen = 0 , len = 0;

        for(int num : nums){
            if(num == maxAND){
                len++;
                maxLen = Math.max(maxLen , len);
            }else{
                len = 0;
            }
        }

        return maxLen;
    }
}