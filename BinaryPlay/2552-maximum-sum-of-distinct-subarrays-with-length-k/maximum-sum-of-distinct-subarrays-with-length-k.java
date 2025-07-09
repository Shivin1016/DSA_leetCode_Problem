class Solution {
    public long maximumSubarraySum(int[] nums, int k) {

        int n = nums.length;

        Set<Integer> st = new HashSet<>();

        int i = 0 , j = 0 ;
        long sum = 0 , res = 0 ;

        while(j < n){
            while(i < n && st.contains(nums[j])){
                sum -= nums[i];
                st.remove(nums[i]);
                i++;
            }

            sum += nums[j];
            st.add(nums[j]);

            if((j - i + 1) == k){
                res = Math.max(res , sum);
                sum -= nums[i];
                st.remove(nums[i]);
                i++;
            }
            j++;
        }
        return res;
    }
}