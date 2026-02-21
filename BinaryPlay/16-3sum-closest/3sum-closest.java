class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;

        int maxSum = 0;
        int minDiff = Integer.MAX_VALUE;

        for(int i = 0 ; i < n - 2 ; i++){
            for(int j = i + 1 ; j < n - 1 ; j++){ 
                for(int k = j + 1 ; k < n ; k++){ 
                    int sum = nums[i] + nums[j] + nums[k];
                    int diff = Math.abs(target - sum);
                    if(diff < minDiff){
                        minDiff = diff;
                        maxSum = sum;
                    }
                }
            }
        }


        return maxSum;
    }
}