class Solution {
    public int maxSum(int[] nums) {
        int n = nums.length;

        //if all values are negative then greater value will be athe answer
        // int maxVal = Integer.MIN_VALUE;
        // for(int num : nums){
        //     maxVal = Math.max(maxVal , num);
        // }
        // if(maxVal < 0) return maxVal;

        var st = new HashSet<Integer>();
        int sum = 0 , neg = Integer.MIN_VALUE;
        for(int i = 0 ; i < n ; i++){
            if(nums[i] <= 0 || st.contains(nums[i])){
                //store negative max value --> if all the values are negative then we use it
                neg = Math.max(neg , nums[i]);
                continue; // skip those value which are negative or already present in set
            }
            //else take values and add in set
            sum += nums[i]; 
            st.add(nums[i]);
        }

        return sum == 0 ? neg : sum;
    }
}