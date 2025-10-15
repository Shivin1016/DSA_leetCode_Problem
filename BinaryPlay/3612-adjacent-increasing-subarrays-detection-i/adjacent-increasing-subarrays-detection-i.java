class Solution {
    public boolean isIncreasing(List<Integer> nums , int i , int n){
        while(i < n - 1){
            if(nums.get(i) >= nums.get(i + 1)) return false;
            i++;
        }
        return true;
    }
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();

        for(int start = 0 ; start + 2 * k <= n ; start++){
            boolean first = isIncreasing(nums , start , start + k);
            if(first == true){
                boolean second = isIncreasing(nums , start + k , start + k + k);
                if(first == true && second == true){
                    return true;
                }
            }

        }
        return false;
    }
}