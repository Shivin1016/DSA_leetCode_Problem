class Solution {
    public long minimumDifference(int[] nums) {

        int N = nums.length;
        int n = N / 3;

        //left Minimum Array --> n elements sum --> if greater than n elements then remove largest element
        long[] leftMin = new long[N];
        var maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder()); // max heap

        //right maximum Array --> n elemnts sum --> if greater than n elements than remove smallest
        long[] rightMax = new long[N];
        var minHeap = new PriorityQueue<Integer>(); // min heap

        long leftSum = 0;
        for(int i = 0 ; i < 2*n ; i++){
            maxHeap.add(nums[i]);
            leftSum += nums[i];
            //greater than n elements
            if(maxHeap.size() > n){
                leftSum -= maxHeap.peek();
                maxHeap.poll();
            }
            leftMin[i] = leftSum;
        }

        long rightSum = 0;
        for(int i = N - 1 ; i >= n ; i--){
            minHeap.add(nums[i]);
            rightSum += nums[i];

            if(minHeap.size() > n){
                rightSum -= minHeap.peek();
                minHeap.poll();
            }
            rightMax[i] = rightSum;
        }

        long minDiff = Long.MAX_VALUE;

        for(int i = n - 1 ; i <= 2*n - 1 ; i++){
            long diff = leftMin[i] - rightMax[i + 1]; 
            minDiff = Math.min(diff , minDiff);
        }
        return minDiff;
    }
}