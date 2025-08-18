class Solution {
    int n ;
    long[][] memo;
    public long maxAlternatingSum(int[] nums) {
        n = nums.length;

        memo = new long[n + 1][2];
        for(int i = 0 ; i < memo.length ; i++) Arrays.fill(memo[i] , -1);

        return solve(nums , 0 , 0);
    }
    public long solve(int[] nums , int idx , int evenOdd){
        if(idx >= n) return 0;

        if(memo[idx][evenOdd] != -1) return memo[idx][evenOdd];

        long skip = solve(nums , idx + 1 , evenOdd);

        int val = (evenOdd == 0) ? nums[idx] : -nums[idx];
        long take = val + solve(nums , idx + 1 , 1- evenOdd);

        return memo[idx][evenOdd] = Math.max(take , skip);
    }
}