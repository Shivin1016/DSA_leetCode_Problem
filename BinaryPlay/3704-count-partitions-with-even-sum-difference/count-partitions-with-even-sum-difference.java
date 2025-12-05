class Solution {
    public int countPartitions(int[] nums) {
        int n = nums.length;
        int sum = 0;

        for(int i = 0 ; i < n ; i++){ 
            sum += nums[i]; //total sum
        }  

        int leftSum = 0;  
        int count = 0;

        for(int i = 0 ; i < n - 1 ; i++){
            leftSum += nums[i];
            int rightSum = sum - leftSum;

            if((leftSum % 2) == (rightSum % 2)) count++;
        }

        return count;
    }
}