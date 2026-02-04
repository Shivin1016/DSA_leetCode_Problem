class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        Deque<Integer> dq = new ArrayDeque<>();
        int[] ans = new int[n - k + 1]; // n - k + 1 windows exist
        int j = 0;

        for(int i = 0 ; i < n ; i++){
            //make sure that elements must present of current window in deque
            while(!dq.isEmpty() && dq.peekFirst() <= (i - k)){
                dq.removeFirst();
            }

            // check that at front max element must present
            while(!dq.isEmpty() && nums[dq.getLast()] <= nums[i]){
                dq.removeLast();
            }

            // add current i in last
            dq.addLast(i);

            // now at front there is maxELement of current window
            if(i >= k - 1){ // window is starting
                ans[j++] = nums[dq.peekFirst()];
            }
        }

        return ans;

    }
}