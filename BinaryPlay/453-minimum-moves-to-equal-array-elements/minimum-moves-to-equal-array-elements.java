class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;
        /*
            In starting we have array [1,2,3] -->[2,3,3] -->[3,4,3] -->[4,4,4]
            so total increament is (n - 1) * number of operations
            so final sum can be weitten as final sum = Intital sum + (n - 1) * number of operations

            As at last the array will be [x,x,x....n times]
            so final sum will be n * x

            //as --> minimum element + number of operations = x  => example -> 1(miniEle) + 3(number of operations) --> 4 

            so => n * x = InitialSum + (n - 1) * number of operations
            =>  (minimum element + number of operations) * n = InitialSum + (n - 1) * number of operations
            => lets take number of operations = m
            => min * n + m * n = InitialSum + n * m - m;
            => min * n = InitialSum  - m;

            =>[ m = InitialSum - min * n ] ==> last equation that we got, where m is number of operations 
        */

        int minEle = Integer.MAX_VALUE; // minimum element from the array
        int intitalSum = 0; // Intital sum of an array
        for(int i = 0 ; i < n ; i++){
            minEle = Math.min(minEle , nums[i]);
            intitalSum += nums[i];
        }

        return intitalSum - minEle * n;
    }
}