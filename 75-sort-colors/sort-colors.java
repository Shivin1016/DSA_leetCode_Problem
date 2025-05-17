class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;

        int[] mp = new int[3];

        for(int num : nums){
            mp[num]++;
        }
        int j = 0;
        for(int i = 0 ; i < 3 ; i++){
            while(mp[i] != 0){
                nums[j] = i;
                j++;
                mp[i]--;
            }
        }
    }
}