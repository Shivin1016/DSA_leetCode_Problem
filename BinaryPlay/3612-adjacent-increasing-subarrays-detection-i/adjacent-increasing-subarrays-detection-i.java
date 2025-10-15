class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();

        int prevLen = 0;
        int currLen = 1;

        int maxResult = 0;

        for(int i = 1 ; i < n ; i++){
            if(nums.get(i) > nums.get(i - 1)){
                currLen++;
            }
            else{ // increasing order breaks
                prevLen = currLen;
                currLen = 1;
            }

            if(currLen / 2 >= k) return true;
            else if(Math.min(currLen , prevLen) >= k) return true;
        }
        return false;
    }
}