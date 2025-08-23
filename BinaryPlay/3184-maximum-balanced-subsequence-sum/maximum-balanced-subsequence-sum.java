class Solution {
    public long maxBalancedSubsequenceSum(int[] nums) {
        int n = nums.length;

        //stores val ->(nums[i] - i) and key ->sum ending at this (nums[i] - i)
        TreeMap<Integer , Long> mp = new TreeMap<>(); 
        long ans = Integer.MIN_VALUE;

        for(int i = 0 ; i < n ; i++){

            if(nums[i] <= 0){
                ans = Math.max(nums[i] , ans);
            }else{
                int currKey = nums[i] - i;
                //find key that is just less than or equal to ho is currkey se
                long sum = nums[i];

                if(mp.floorKey(currKey) != null){
                    sum += mp.get(mp.floorKey(currKey));
                }

                //remove those keys which is greater than currKey and it's value is less then currKey value
                while(mp.ceilingKey(currKey) != null && mp.get(mp.ceilingKey(currKey)) < sum){
                    mp.remove(mp.ceilingKey(currKey));
                }

                mp.put(currKey , sum);

                ans = Math.max(ans , sum);

            }
        }

        return ans;

    }
}