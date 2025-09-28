class Solution {
    public int largestPerimeter(int[] nums) {
        int n = nums.length;

        int largest = Integer.MIN_VALUE;
        Arrays.sort(nums);
        for (int i = n - 1 ; i >= 2 ; i--) {

            if (nums[i - 1] + nums[i - 2] > nums[i] && nums[i - 1] + nums[i] > nums[i - 2] && nums[i - 2] + nums[i] > nums[i - 1]) {
                largest = Math.max(largest, nums[i] + nums[i - 1] + nums[i - 2]);
            }
        }

        return largest != Integer.MIN_VALUE ? largest : 0;
    }
}