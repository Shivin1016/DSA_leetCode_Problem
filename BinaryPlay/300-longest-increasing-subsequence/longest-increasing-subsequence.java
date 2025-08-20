class Solution {
    int n ; 
    public int lengthOfLIS(int[] nums) {
        n = nums.length;

        int[] t = new int[n];
        Arrays.fill(t , 1);

        int maxLis = 1;

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < i ; j++){
                if(nums[j] < nums[i]){
                    t[i] = Math.max(t[i] , t[j] + 1);
                    maxLis = Math.max(t[i] , maxLis);
                }
            }
        } 
        return maxLis;

    }
    
}