class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length; 
        int currSubSum1 = nums[0];
        int maxSubSum = nums[0];

        int currSubSum2 = nums[0];
        int minSubSum = nums[0];
        int total = nums[0];

        for(int i = 1 ; i < n ; i++){
            currSubSum1 = Math.max(nums[i] , currSubSum1 + nums[i]);
            maxSubSum = Math.max(maxSubSum , currSubSum1);

            currSubSum2 = Math.min(nums[i] , currSubSum2 + nums[i]);
            minSubSum = Math.min(minSubSum , currSubSum2);  

            total += nums[i];
        }
        // total sum minus minimum subarray sum --> we got circulated sum
        // maxSum || minSum ==> no split
        // maxSum || minSum || Subsum == splited array ==> ex ==> 2 , -2 , 2 , 7, 8 ,0
        int circularSum = total - minSubSum; 
        if(circularSum == 0){
            //no splited 
            return maxSubSum;
        } 
        maxSubSum = Math.max(maxSubSum , circularSum);
        
        return maxSubSum;
    }
}