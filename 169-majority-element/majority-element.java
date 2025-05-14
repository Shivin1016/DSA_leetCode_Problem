class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;

        Map<Integer , Integer> mp = new HashMap<>();
        for(int num : nums) mp.put(num , mp.getOrDefault(num , 0) + 1);

        int maxKey = 0; //majority elem
        int maxVal = 0;
        for(int key : mp.keySet()){
            int val = mp.get(key);
            if(maxVal < val){
                maxVal = val;
                maxKey = key; 
            }
        }

        return maxVal >= n / 2 ? maxKey : -1;
    }
}