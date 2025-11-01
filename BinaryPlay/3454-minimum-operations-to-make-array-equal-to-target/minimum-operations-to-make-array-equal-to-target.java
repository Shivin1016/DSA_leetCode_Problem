class Solution {
    public long minimumOperations(int[] nums, int[] target) {
        int n = nums.length; 

        long operation = Math.abs(target[0] - nums[0]);
        for(int i = 1 ; i < n ; i++){
            int prev = target[i - 1] - nums[i - 1];
            int curr = target[i] - nums[i];
            //check sign changed
            if(curr < 0 && prev > 0 || curr > 0 && prev < 0){
                operation += (long)Math.abs(curr);
            }
            else{
                if(Math.abs(curr) > Math.abs(prev)){
                    operation += (long)Math.abs(curr) - (long)Math.abs(prev);
                }
            }
        }

        return operation;

    }
}