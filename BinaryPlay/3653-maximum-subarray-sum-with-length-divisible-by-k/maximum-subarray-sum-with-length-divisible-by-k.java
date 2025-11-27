class Solution {
    /**
    // Based Kadens algo 
     [-1 , -2 , 3 , 4 , -5]  currSum = nums[0] , maxSubSum = nums[0]
                         i
          currSum = max(nums[i] , nums[i] + currSum)
            max(-5 , -5 + 7) ==> 2
            currSum = 2
            maxSubSum = max(maxSubSum , currSum) ==> 7
       

    */
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length; 
        long[] prefixSum = new long[n];

        prefixSum[0] = (long)nums[0];  //o(1)
        for(int i = 1 ; i < n ; i++){
            prefixSum[i] = prefixSum[i - 1] + (long)nums[i];
        }

        long maxSubSum =  Long.MIN_VALUE;  
        for(int start = 0 ; start < k ; start++){  //O(n)
            int i = start;
            long currSum = 0;
            while(i < n && i + k - 1 < n){   // k = 2 --> 2 , 4 , 8, upto < n 
                int j = i + k - 1; // subarray from i to j
                long subSum = prefixSum[j] - (i > 0 ? prefixSum[i - 1] : 0); //O(1)
                currSum = Math.max(subSum , subSum + currSum);
                maxSubSum = Math.max(maxSubSum , currSum);
                i = i + k; // multiple of k => this is condition 
            }
        }
        return maxSubSum ;
    }
}