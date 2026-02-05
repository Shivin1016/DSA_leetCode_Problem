class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        for(int i = 0 ; i < n ; i++){
            if(nums[i] > 0){ 
                //for right ->move (i + nums[i]) step forward
                res[i] = nums[(nums[i] + i) % n];
            }else if(nums[i] < 0){ 
                //for left-> move (i - abs(nums[i])) step backward
                int steps = Math.abs(nums[i]) % n;
                //for go backward we have to subtract it from i 
                //and for in index range plus it to length of the array
                res[i] = nums[(i - steps + n) % n]; 
                
            }else{
                res[i] = nums[i];
            }
        }
        return res;
    }
}