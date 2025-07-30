class Solution {
    int n;
    public int longestSquareStreak(int[] nums) {
        n = nums.length;
        Arrays.sort(nums);  

        //using Map
        int maxStreak = 1;
        Map<Integer , Integer> mp = new HashMap<>();

        for(int num : nums){
            int sq = (int)Math.sqrt(num); 
            int streak = 1;
            if(sq * sq == num && mp.containsKey(sq)){
                //perfect square
                streak = 1 + mp.get(sq);
                mp.put(num , streak);
            }else{
                mp.put(num , 1);
            }
            maxStreak = Math.max(maxStreak , streak);
        }
        return maxStreak > 1 ? maxStreak : -1;

        // int longSqStreak = solve(nums , 0 , -1); 

        // return longSqStreak > 1 ? longSqStreak : -1;
    }

    public int solve(int[] nums , int i , int prev){
        if(i >= n) return 0;

        int take = 0;
        if(prev == -1 || (prev*prev) == nums[i]){ 
            take = 1 + solve(nums , i + 1 , i);
        } 

        int skip = solve(nums , i + 1 , prev);
        System.out.println(skip  + " " + take);
        return Math.max(take , skip);
    }
}