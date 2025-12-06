class Solution {
    public int countPartitions(int[] nums, int k) {
        int n = nums.length;
        int M = (int)1e9 + 7;

        long[] dp = new long[n + 1];
        dp[0] = 1; //take whole array partition --> {} , {4,1,3} if arra is {4,1,3}

        long[] prefixSum = new long[n + 1] ;
        prefixSum[0] = 1; // commulative sum of dp array

        Deque<Integer> maxDeq = new ArrayDeque<>();
        Deque<Integer> minDeq = new ArrayDeque<>();

        int i = 0 , j = 0;
        while(j < n){
            //for monotonic decreasing deque -->maxDeque--> max element at front
            while(!maxDeq.isEmpty() && nums[j] > nums[maxDeq.peekLast()]){
                maxDeq.pollLast();
            }
            maxDeq.addLast(j);

            //for monotonic increasing deque -->minDeque--> min element at front
            while(!minDeq.isEmpty() && nums[j] < nums[minDeq.peekLast()]){
                minDeq.pollLast();
            }
            minDeq.addLast(j);

            //find valid window 
            while(i < n && (nums[maxDeq.peekFirst()] - nums[minDeq.peekFirst()]) > k){
                i++; 
                if(!minDeq.isEmpty() && minDeq.peekFirst() < i){
                    //invalid
                    minDeq.pollFirst();
                }
                if(!maxDeq.isEmpty() && maxDeq.peekFirst() < i){
                    //invalid
                    maxDeq.pollFirst();
                }
            }

            // getting valid window
            long val = (prefixSum[j] - (i > 0 ? prefixSum[i - 1] : 0) + M) % M;
            dp[j + 1] = val ;
            prefixSum[j + 1] = (dp[j + 1] + prefixSum[j]) % M ;
            j++;
        }

        return (int)dp[n]; // number of ways to partition an array from 0 to n - 1
    }
}