class Solution {
    int n ;
    int[][] memo;
    public int maximumLength(int[] nums) {

        n = nums.length;

        int oddCnt = 0 , evenCnt = 0 , alterCnt = 1;
        int parity = nums[0] % 2;

        for(int i = 0 ; i < n ; i++){

            int mod = nums[i] % 2;

            if(mod == 0){
                evenCnt++;
            }else{
                oddCnt++;
            }

            if(i > 0 && mod == 1 - parity){
                alterCnt++;
                parity = 1 - parity;
            }
        }

        return Math.max(alterCnt , Math.max(evenCnt , oddCnt));

        // // Memoization
        // memo = new int[n + 1][n + 1];
        // for(int i = 0 ; i < n ; i++){
        //     Arrays.fill(memo[i] , -1);
        // }

        // int[] temp = new int[n - 1];
        // for(int i = 1 ; i < n ; i++){
        //     temp[i - 1] = ((nums[i - 1] + nums[i]) % 2);
        // }

        // return 1 + solve(temp , 0 , -1);
    }

    public int solve(int[] temp , int i , int prev){

        if(i >= (n - 1)){
            return 0;
        }

        if(prev != -1 && memo[i][prev] != -1){
            return memo[i][prev];
        }

        //take part
        int take = 0; 
        if(prev == -1 || prev == temp[i]){
            take = 1 + solve(temp , i + 1 , temp[i]);
        }

        //skip part
        int skip = 0 + solve(temp , i + 1 , prev);

        if(prev != -1){
            memo[i][prev] = Math.max(take , skip);
        }

        return Math.max(take , skip);
    } 
}