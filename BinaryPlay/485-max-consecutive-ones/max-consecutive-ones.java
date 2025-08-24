class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int i = 0 , j = 0;
        int result = 0;
        while(j < n){
            if(nums[j] == 0){
                i = j + 1;
            }else{
                result = Math.max(result , (j - i + 1));
            }
            j++;
        }
        return result;
    }
}