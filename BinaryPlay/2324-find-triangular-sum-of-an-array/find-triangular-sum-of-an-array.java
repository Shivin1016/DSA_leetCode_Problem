class Solution {
    public int triangularSum(int[] nums) {
        while(nums.length > 1){
            int newLen = nums.length - 1;
            int[] newNums = new int[newLen];
            int j = 0;
            while(j < newLen){
                newNums[j] = (nums[j] + nums[j + 1]) % 10;
                j++;
            }
            nums = newNums;
        }
        return nums[0];
    }
}