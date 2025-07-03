class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;

        //spproach 01 -> by doubling the array
        int[] newNums = new int[2 * n];
        for(int i = 0 ; i < 2 * n ; i++){
            newNums[i] = nums[i % n]; 
        }

        int[] next = nextGreaterEle(newNums);
        int[] ans = new int[n];
        for(int i = 0 ; i < n ; i++){
            ans[i] = next[i];
        }
        return ans;
    }

    public int[] nextGreaterEle(int[] nums){
        int n = nums.length;

        Stack<Integer> st = new Stack<>();

        int[] ans = new int[n];

        for(int i = n - 1; i>= 0 ; i--){
            while(!st.isEmpty() && st.peek() <= nums[i]){
                st.pop();
            }
            if(st.isEmpty()) ans[i] = -1;
            else ans[i] = st.peek();

            st.add(nums[i]);
        }
        return ans;
    }
}