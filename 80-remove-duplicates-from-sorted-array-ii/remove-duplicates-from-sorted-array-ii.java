class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(n <= 2) return n;

        int currIdx = 2;
        for(int i = 2 ; i < n ; i++){
            if(nums[i] != nums[currIdx - 2]){
                nums[currIdx] = nums[i];
                currIdx++;
            }
        }
        return currIdx;
    }
}