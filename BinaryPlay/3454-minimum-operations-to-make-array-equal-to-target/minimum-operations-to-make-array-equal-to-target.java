class Solution {
    public long minimumOperations(int[] nums, int[] target) {
        int n = nums.length;

        int[] diff = new int[n];
        for(int i = 0 ; i < n ; i++){
            diff[i] = target[i] - nums[i];
        }

        long operation = Math.abs(diff[0]);
        for(int i = 1 ; i < n ; i++){
            int prev = diff[i - 1];
            int curr = diff[i];
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