class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length; 
        long[] prefixSum = new long[n];
        prefixSum[0] = (long)nums[0];
        for(int i = 1 ; i < n ; i++){
            prefixSum[i] = prefixSum[i - 1] + (long)nums[i];
        }

        long maxSubSum =  Long.MIN_VALUE;  
        for(int start = 0 ; start < k ; start++){
            int i = start;
            long currSum = 0;
            while(i < n && i + k - 1 < n){
                int j = i + k - 1;
                long subSum = prefixSum[j] - (i > 0 ? prefixSum[i - 1] : 0);
                currSum = Math.max(subSum , subSum + currSum);
                maxSubSum = Math.max(maxSubSum , currSum);
                i = i + k;
            }
        }
        return maxSubSum ;
    }
}