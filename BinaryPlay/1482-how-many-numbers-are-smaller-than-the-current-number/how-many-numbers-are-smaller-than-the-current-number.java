class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        int[] frq = new int[101];
        for(int num : nums){
            frq[num]++;
        }

        //prefix sum of freq
        for(int i = 1 ; i < 101 ; i++){
            frq[i] += frq[i - 1];
        }

        for(int i = 0 ; i < n ; i++){
            ans[i] = nums[i] == 0 ? 0 : frq[nums[i] - 1];
        }
        return ans;
    }
}