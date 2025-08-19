class Solution {
    public long zeroFilledSubarray(int[] nums) {
        int n = nums.length;

        long subArrayCnt = 0;
        int i = 0 , j = 0;

        while(j < n){
            if(nums[j] == 0){
                subArrayCnt += (j - i + 1); 
            }else{
                i = j;
                i++;
            }
            j++;

        } 
        return subArrayCnt;
    }
}