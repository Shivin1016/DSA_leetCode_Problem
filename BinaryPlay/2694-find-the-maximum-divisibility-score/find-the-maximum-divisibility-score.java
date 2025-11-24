class Solution {
    public int maxDivScore(int[] nums, int[] divisors) {
        int n = nums.length; 

        Arrays.sort(divisors);

        int res = 0;
        int ans = divisors[0] ;

        for(int divisor : divisors){ 
            int count = 0;
            for(int i = 0 ; i < n ; i++){
                if(nums[i] % divisor == 0){
                    count++;
                }
            } 
            if(res < count){
                res = count;
                ans = divisor;
            } 
        }
        return ans;
    }
}