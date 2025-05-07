class Solution {
    public long maxBalancedSubsequenceSum(int[] nums) {
        //bottom up approach 
        int n = nums.length; 
        long ans = Long.MIN_VALUE;

        TreeMap<Integer , Long> mp = new TreeMap<>(); //store (nums[i] - i , sum)

        for(int i = 0 ; i < n ; i++){

            if(nums[i] <= 0){
                ans = Math.max(ans , nums[i]);
            }else{

                int nums_i = nums[i] - i;

                //find past <= nums_i in map
                // find upperBound of nums_i , then subtract it from 1 then we get <= nums_i
                long temp = nums[i];
                if(mp.floorKey(nums_i) != null){
                    temp += mp.get(mp.floorKey(nums_i));
                }

                //remove that element from mp which is greater then nums_i and whose sum is < temp
                while(mp.ceilingKey(nums_i) != null && mp.get(mp.ceilingKey(nums_i)) < temp){
                    mp.remove(mp.ceilingKey(nums_i));
                }

                if(mp.floorKey(nums_i) == null || mp.get(mp.floorKey(nums_i)) < temp){
                    mp.put(nums_i , temp);
                }
                ans = Math.max(ans ,temp);
            }


        } 

        return ans;
    }
}