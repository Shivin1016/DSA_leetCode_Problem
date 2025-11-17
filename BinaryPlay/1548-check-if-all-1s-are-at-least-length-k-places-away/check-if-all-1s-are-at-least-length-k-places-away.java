class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int n = nums.length;
        int count_0 = 0;
        int i = 0;
        while(i < n && nums[i] == 0){
            i++;
        }
        if(i < n && nums[i] == 1) i++;
        for( ; i < n ; i++){
            if(i != 0 && nums[i] == 1){
                if(count_0 < k) return false;
                count_0 = 0;
            }
            else if(nums[i] == 0){
                count_0++;
            }
        } 
        return true;
    }
}