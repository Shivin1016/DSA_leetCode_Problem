class Solution {
    public int minimumCost(int[] nums) {
        int n = nums.length;

        int firstCost = nums[0];

        int minCost = Integer.MAX_VALUE; // last tqo subarray ki cost

        for(int i = 1 ; i < n - 1 ; i++){
            for(int j = i + 1 ; j < n ; j++){
                minCost = Math.min(minCost , nums[i] + nums[j]);
            }
        }
        return firstCost + minCost;
    }
}