class Solution {
    public long zeroFilledSubarray(int[] nums) {
        int n = nums.length;

        long subArrayCnt = 0; 

        long cnt = 0;
        for(int i = 0 ; i < n ; i++){
            if(nums[i] == 0){
                cnt++;
            }else{
                cnt = 0;
            }
            subArrayCnt += cnt;
        }
 
        return subArrayCnt;
    }
}