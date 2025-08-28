class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;

        //brute force appraoch
        int count = 0;
        Map<Integer , Integer> mp = new HashMap<>();
        int sum = 0;
        mp.put(sum , 1); // for zero reminder
        for(int i = 0 ; i < n ;i++){

            sum += nums[i];

            int mod = ((sum % k) + k) % k ; 

            count += mp.getOrDefault(mod , 0);

            mp.put(mod , mp.getOrDefault(mod , 0) + 1);
        }

        return count;

    }
}