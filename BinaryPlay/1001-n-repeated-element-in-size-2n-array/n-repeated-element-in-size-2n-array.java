class Solution {
    public int repeatedNTimes(int[] nums) {
        int n = nums.length ;

        // ietrate over the map
        int ans = 0;
        for(int i = 0 ; i < n - 1 ; i++){ 
            if(nums[i] == nums[i + 1] || (i + 2 < n && nums[i] == nums[i + 2])){
                return nums[i]; 
            }
        } 
        return nums[0];

    }
}