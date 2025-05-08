class Solution {
    int[][] memo; 
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if(n == 1) return 1;

        // memo = new int[2501][2501]; 
        // for(int i = 0 ; i < n ; i++){
        //     Arrays.fill(memo[i] , -1);
        // }

        // return solve(nums , 0 , -1, n);

        //bottom up approach
        // int[] t = new int[n];
        // Arrays.fill(t , 1); // as every single element itself a single length subsequence 
        // //t[i] --> indicate that largest lis which is end at ith idx
        // int maxLIS = 1;
        // for(int i = 0 ; i < n ; i++){
        //     for(int j = 0 ; j < i ; j++){
        //         if(nums[j] < nums[i]){
                    
        //             t[i] = Math.max(t[i] , (t[j] + 1));
        //             maxLIS = Math.max(maxLIS , t[i]);
        //         }
        //     }
        // }

        // return  maxLIS;

        //using Patience sorting
        TreeSet<Integer> bucket = new TreeSet<>();
        for(int num : nums){

            Integer val = bucket.ceiling(num);
            
            if(val != null){
                bucket.remove(val);
            } 
            //if found then add or not then also add
            bucket.add(num); 
        }
        return bucket.size();
    } 

    public int solve(int[] nums , int idx , int prev , int n){ 

        if(idx >= n) return 0;

        if(prev != -1 && memo[idx][prev] != -1) return memo[idx][prev];

        //take operation
        int take = 0;
        if(prev == -1 || (nums[prev] < nums[idx]))
            take = 1 + solve(nums , idx + 1 , idx , n);

        //skip operation
        int skip = solve(nums , idx + 1 , prev , n);

        if(prev != -1) memo[idx][prev] = Math.max(take , skip);

        return  Math.max(take , skip);

    }

}