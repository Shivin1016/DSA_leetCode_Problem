class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[] ans = new int[2];

        Map<Integer , Integer> mp = new HashMap<>();

        for(int i = 0 ; i < n ; i++){
            int remain = target - nums[i];
            if(mp.containsKey(remain)){
                int j = mp.get(remain);
                return new int[]{i , j};
            }else{
                mp.put(nums[i] , i);
            }
        }
        return new int[]{};
    }
}