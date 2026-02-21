class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;

        Arrays.sort(nums);

        int maxSum = 0;
        int minDiff = Integer.MAX_VALUE;

        for(int i = 0 ; i < n - 2 ; i++){
            int j = i + 1 ;
            int k = n - 1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum < target){
                    j++;
                }
                else{
                    k--;
                }
                int diff = Math.abs(target - sum);
                if(diff < minDiff){
                    minDiff = diff;
                    maxSum = sum;
                }
            }
        }


        return maxSum;
    }
}