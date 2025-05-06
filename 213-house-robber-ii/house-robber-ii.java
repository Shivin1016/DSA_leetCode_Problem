class Solution {
    int[] memo;
    public int solve_constant_space(int l , int r , int[] nums){
        int prev = 0 ;
        int prevPrev = 0;

        for(int i = l ; i <= r ; i++){
            int steal = nums[i] + prevPrev;
            int skip = prev;
            int temp = Math.max(steal , skip);

            prevPrev = prev;
            prev = temp;
        }
        return prev;
    } 

    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0] , nums[1]);

        //Using constant space 
        int take_first_house = solve_constant_space(0 , n - 2 , nums);
        int not_take_first_house = solve_constant_space(1 , n - 1 , nums);

        return Math.max(take_first_house , not_take_first_house);

        //Using recur + memo
        // memo = new int[n];
        // Arrays.fill(memo , -1);

        // //take from 0 to n -2
        // int take1 = solve(0 , n - 2 , nums);

        // //take from 1 to n - 1
        // Arrays.fill(memo , -1);
        // int take2 = solve(1 , n - 1 , nums);

        // return Math.max(take1 , take2);

        //using Bottom - Up Approach
        // int[] t = new int[n]; 
        // // t[i] = money stolen till ith houses
        // t[0] = 0;
        // for(int i = 1 ; i < n ; i++){
        //     int skip = t[i - 1];
        //     int steal = nums[i - 1] + (i >= 2 ? t[i - 2] : 0);
        //     t[i] = Math.max(skip , steal);
        // } 
        
        // int[] t2 = new int[n + 1];
        // t[1] = nums[1];
        // for(int i = 2 ; i <= n ; i++){
        //     int skip = t2[i - 1];
        //     int steal = nums[i - 1] + (i >= 2 ? t2[i - 2] : 0);
        //     t2[i] = Math.max(skip , steal);
        // } 

        // return Math.max(t[n - 1] , t2[n]); 
         
    }

    public int solve(int start , int end , int[] nums){
        if(start > end) return 0;

        if(memo[start] != -1) return memo[start];

        return memo[start] =  Math.max(solve(start + 2 , end , nums) + nums[start] , solve(start + 1 , end , nums));
    }

}