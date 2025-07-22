class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        int i = 0 , j = 0;

        Set<Integer> st = new HashSet<>();
        long sum = 0 , maxSum = 0;

        while(j < n){
            //check that set must contains unique elements
            while(i < n && st.contains(nums[j])){
                st.remove(nums[i]);
                sum -= nums[i];
                i++;
            }

            //add element in set
            st.add(nums[j]);
            sum += (long)nums[j];
            maxSum = Math.max(sum , maxSum);
            j++;
        }
        return (int)maxSum;
    }
}