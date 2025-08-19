class Solution {
    public long zeroFilledSubarray(int[] nums) {
        int n = nums.length;

        long subArrayCnt = 0;
        int i = 0 , j = 0;

        while(j < n){
            while(j < n && nums[j] != 0){
                j++;
                i = j;
            }
            if(j < n){
                subArrayCnt += (j - i + 1);
                j++;
            }
        }
        return subArrayCnt;
    }
}