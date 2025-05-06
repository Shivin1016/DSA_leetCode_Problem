class Solution {
    int[][] memo;

    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;

        // memo = new int[n + 1][n + 1];
        // for(int i = 0 ; i < n ; i++){
        //     Arrays.fill(memo[i] , -1);
        // }

        //sort pairs , as we got longest chain , and in any order so longest chain will find when the array is sorted
        Arrays.sort(pairs ,(a, b) -> Integer.compare(a[0] , b[0]));

        //bottom up Approach
        int maxChain = 1;
        int[] t = new int[n];
        Arrays.fill(t , 1);
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < i ; j++){
                if(pairs[j][1] < pairs[i][0]){
                    t[i] = Math.max(t[i] , t[j] + 1);
                    maxChain = Math.max(maxChain , t[i]);
                }
            }
        }
        return maxChain;

        // return solve(pairs , 0 , -1 , n);
    }

    public int solve(int[][] nums , int idx , int prev , int n){
        if(idx >= n) return 0;

        if(prev != -1 && memo[idx][prev] != -1) return memo[idx][prev];

        int take = 0;
        if(prev == -1 || (nums[prev][1] < nums[idx][0])){
            take = 1 + solve(nums , idx + 1 , idx , n);
        }
        //skip
        int skip = solve(nums ,idx + 1 ,prev , n);

        if(prev != -1){
            memo[idx][prev] = Math.max(take , skip);
        }

        return Math.max(take , skip);
    }
}