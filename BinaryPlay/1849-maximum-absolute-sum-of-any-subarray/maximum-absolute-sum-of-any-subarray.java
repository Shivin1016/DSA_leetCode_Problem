class Solution {

    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;

        //find maxSubSum and minSubSum
        int maxSubSum = solve1(nums , n);
        int minSubSum = solve2(nums , n);

        //then return max(abs(maxSubSum) , abs(minSubSum))
        return Math.max(Math.abs(maxSubSum) , Math.abs(minSubSum));
    }

    public int solve1(int[] nums , int n){
        int currSubSum = nums[0];
        int maxSubSum = nums[0];

        for(int i = 1 ; i < n ; i++){
            currSubSum = Math.max(nums[i] , nums[i] + currSubSum);
            maxSubSum = Math.max(maxSubSum , currSubSum);
        }
        return maxSubSum;
    }
    public int solve2(int[] nums , int n){
        int currSubSum = nums[0];
        int minSubSum = nums[0];

        for(int i = 1 ; i < n ; i++){
            currSubSum = Math.min(nums[i] , nums[i] + currSubSum);
            minSubSum = Math.min(minSubSum , currSubSum);
        }
        return minSubSum;
    }

}