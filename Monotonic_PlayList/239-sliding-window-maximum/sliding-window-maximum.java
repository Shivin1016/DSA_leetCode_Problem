class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        Deque<Integer> dq = new ArrayDeque<>();
        int[] res = new int[n - k + 1];
        int j = 0;

        for(int i = 0 ; i < n ; i++){
            //to make window valid
            while(!dq.isEmpty() && dq.peekFirst() <= (i - k)){
                dq.removeFirst();
            }

            //to make monotonic decreasing queue 
            while(!dq.isEmpty() && nums[dq.getLast()] < nums[i]){
                dq.removeLast();
            }

            dq.addLast(i);
            if(i >= k - 1){
                int maxELem = nums[dq.peekFirst()]; 
                res[j] = maxELem; // get front element that is max element in given window
                j++;
            }
        }

        return res;
    }
}