class Solution { 
    public int maxSumDivThree(int[] nums) {
        int n = nums.length;
        int[][] t = new int[n + 1][3]; 
        // t[0][rem] ==> stores sum from 0 to n- 1  with reminder rem

        for(int i = 0 ; i <= n ; i++){
            Arrays.fill(t[i] , Integer.MIN_VALUE);
        } 

        t[n][0] = 0 ; // index outofbound and rem = 0 

        for(int i = n - 1 ; i >= 0 ; i--){
            for(int rem = 0 ; rem < 3 ; rem++){
                int newRem = (rem + nums[i]) % 3;
                int take = nums[i] + t[i + 1][newRem];
                int skip = t[i + 1][rem];

                t[i][rem] = Math.max(take , skip);
            }
        }

        return t[0][0] ;
    }
}