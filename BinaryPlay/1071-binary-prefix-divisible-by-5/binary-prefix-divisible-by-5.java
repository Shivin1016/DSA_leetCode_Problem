class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        int n = nums.length;
        List<Boolean> ans = new ArrayList<>(); 
        int num = 0;

        for(int i = 0 ; i < n ; i++){ 
            num = num * 2; // create an extra space
            num += nums[i]; // add nums[i]
            num = num % 5;
            ans.addLast(num == 0);
        }
        return ans;
    }
}