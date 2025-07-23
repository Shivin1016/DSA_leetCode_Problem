class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        int i = 0 , j = 0;

        //using Set
        /*Set<Integer> st = new HashSet<>();
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
        */

        //using map store value with idx for jumping i to the last seen idx
        //find commulative sum --> when jumping from ith to last seen value idx 
        int[] cumSum = new int[n];
        cumSum[0] = nums[0];
        for(int k = 1 ; k < n ; k++){
            cumSum[k] = cumSum[k - 1] + nums[k];
        }
        int[] mp = new int[10001];
        //intially all have -1 idx
        Arrays.fill(mp , -1);
        int maxSum = 0;
        while(j < n){

            i = Math.max(i , mp[nums[j]] + 1); // jumping to i so that i to j is valid

            //subArray sum to ith to jth
            int jthSum = cumSum[j];
            int ithSum = i - 1 < 0 ? 0 : cumSum[i - 1]; 

            maxSum = Math.max(maxSum , jthSum - ithSum);

            mp[nums[j]] = j;
            j++; 
        }
        return maxSum;
    }
}