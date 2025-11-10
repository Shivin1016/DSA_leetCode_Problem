class Solution {
    public int minOperations(int[] nums) {

        int n = nums.length;

        Stack<Integer> st = new Stack<>();

        int operations = 0;

        for (int i = 0; i < n; i++) {
            while(!st.isEmpty() && nums[i] < st.peek()){
                st.pop();
            }
            if(nums[i] == 0) continue;
            if(st.isEmpty() || nums[i] > st.peek()){
                st.add(nums[i]);
                operations++;
            }
        }
        return operations;

    }
}