class Solution {
    int[] memo;
    public int rob(int[] nums) {
        int n = nums.length;

        // using recusrion + memoization
        memo = new int[n + 1];
        Arrays.fill(memo , -1);
        return solve(nums , n - 1);

        //Using bottom Approach
        /* int[] t = new int[n + 1];
        //t[i] --> max profit till i Houses
        t[0] = 0;
        t[1] = nums[0];

        for(int i = 2 ; i <= n ; i++){
            //if we steal ith house then we can't take it's previous house 
            int take = nums[i - 1] + t[i - 2];
            //if we skip this house then we have to take max money till (i-1)th house
            int skip = t[i - 1];
            t[i] = Math.max(take , skip);
        }
        return t[n];
        */


        // //using two variables like fibbonacci series in constant space complexity
        // if(n == 0) return 0;
        // int prev1 = 0 , prev2 = 0;
        // for(int num : nums){
        //     int temp = prev1;
        //     prev1 = Math.max(prev2 + num , prev1);
        //     prev2 = temp;
        // }
        // return prev1;

         
    }

    public int solve(int[] nums , int i){
        if(i < 0) return 0;

        if(memo[i] != -1){
            return memo[i];
        }
        int res = Math.max(solve(nums , i - 2) + nums[i] , solve(nums , i - 1));
        memo[i] = res;
        return res;
    }

}