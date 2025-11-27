class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;

        int currSum = nums[0];
        int maxSubSum = nums[0];

        for(int i = 1 ; i < n ; i++){
            currSum = Math.max(nums[i] , nums[i] + currSum);
            maxSubSum = Math.max(maxSubSum , currSum);
        }
        return maxSubSum;
    }
}