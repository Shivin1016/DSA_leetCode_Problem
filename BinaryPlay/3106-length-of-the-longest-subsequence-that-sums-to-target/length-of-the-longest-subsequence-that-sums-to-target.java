class Solution {
    int n ;
    int[][] memo;
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        n = nums.size();

        memo = new int[n + 1][target + 1];
        for(int i = 0 ; i < memo.length ; i++){
            Arrays.fill(memo[i] , -1);
        }
        int ans = solve(nums , 0 , 0 , target); 
        return (ans <= 0) ? -1 : ans;
    }

    public int solve(List<Integer> nums , int i , int sum , int target){
        //base condition
        if(sum == target){ // sum upto target 
            return 0;
        } 

        if(sum > target || i >= n){ // if sum greater or i out of bound then return minValue
            return Integer.MIN_VALUE;
        }

        if(memo[i][sum] != -1) return memo[i][sum];

        //skip part
        int skip = 0 + solve(nums , i + 1 , sum , target);
        //take part
        int take = 1 + solve(nums , i + 1 , sum + nums.get(i) , target);


        return memo[i][sum] = Math.max(take , skip);
    }
}