class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        int[] frq = new int[101];
        for(int num : nums){
            frq[num]++;
        }

        for(int i = 0 ; i < n ; i++){
            int count = 0; 
            for(int j = 0 ; j < nums[i] ; j++){
                if(frq[j] != 0){
                    count += frq[j];
                }
            }
            ans[i] = count;
        }
        return ans;
    }
}