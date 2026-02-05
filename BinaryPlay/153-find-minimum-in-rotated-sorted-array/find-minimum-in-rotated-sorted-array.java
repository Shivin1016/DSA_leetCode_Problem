class Solution {
    public int solve(int[] nums ,int n){
        int l = 0 , r = n - 1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(nums[mid] >= nums[0]){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return l;
    }
    public int findMin(int[] nums) {
        int n = nums.length;
        int pivot = solve(nums , n);
        return pivot == n ? nums[0] : nums[pivot];
    }
}