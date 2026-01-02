class Solution {
    public int repeatedNTimes(int[] nums) {
        int n = nums.length / 2;

        Map<Integer , Integer> mp = new HashMap<>();

        for(int i = 0 ; i < nums.length ; i++){
            mp.put(nums[i] , mp.getOrDefault(nums[i] , 0) + 1);
        }

        // ietrate over the map
        int ans = 0;
        for(int key : mp.keySet()){
            int frq = mp.get(key); 
            if(frq == n){
                ans = key;
                break;
            }
        } 
        return ans;

    }
}