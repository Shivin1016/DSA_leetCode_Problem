class Solution {
    int n ;
    int[] position;
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        n = fruits.length;

        //prefix Sum of fruits
        int[] prefixSum = new int[n]; 
        position = new int[n];
        for(int i = 0 ; i < n ; i++){
            //position array for finding lowerBOund and UpperBound
            position[i] = fruits[i][0];

            //prefix sum
            prefixSum[i] = fruits[i][1] + (i > 0 ? prefixSum[i - 1] : 0);
        }
        int maxFruit = 0;
        for(int d = 0 ; d <= k / 2 ; d++){
            //moved d steps to the left
            int remain = k - 2 * d;
            int i = startPos - d;
            int j = startPos + remain;

            // Find the range [i, j] using binary search
            int left = lower_bound(i);
            int right = upper_bound(j) - 1;

            if(left <= right){
                int res = prefixSum[right] - (left > 0 ? prefixSum[left - 1] : 0);
                maxFruit = Math.max(maxFruit , res);
            }

            //moved to the right hand side
            remain = k - 2 * d;
            i = startPos - remain;
            j = startPos + d;

            left = lower_bound(i);
            right = upper_bound(j) - 1;

            if(left <= right){
                int res = prefixSum[right] - (left > 0 ? prefixSum[left - 1] : 0);
                maxFruit = Math.max(maxFruit , res);
            }

        }
        return maxFruit ;
    }

    public int lower_bound(int target ){
        int l = 0 , r = n;

        while(l < r){
            int mid = (l + r)/2;

            if(position[mid] < target){
                l = mid + 1;
            }else{
                r = mid;
            }
        }
        return l;
    }

    public int upper_bound(int target ){
        int l = 0 , r = n ;

        while(l < r){
            int mid = (l + r)/2;

            if(position[mid] <= target){
                l = mid + 1;
            }else{
                r = mid;
            }
        }
        return l;
    }
}