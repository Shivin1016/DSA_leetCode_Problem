class Solution {
    public int countHillValley(int[] nums) {
        int n = nums.length;

        int hillVelly = 0;
        int i = 0 , j = 1;
        while(j < n - 1){
            if((nums[i] < nums[j] && nums[j] > nums[j + 1]) || (nums[i] > nums[j] && nums[j] < nums[j + 1])){
                hillVelly++;
                i = j;
            }
            j++;
        }

        return hillVelly;
    }
}