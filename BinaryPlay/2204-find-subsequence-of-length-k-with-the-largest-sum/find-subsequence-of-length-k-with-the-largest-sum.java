class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        //make 
        int[][] indexWithVal = new int[n][2];
        for(int i = 0 ; i < n ; i++){
            indexWithVal[i] = new int[]{i , nums[i]};
        }

        //reverse sort the array
        Arrays.sort(indexWithVal , Comparator.comparingInt(a -> -a[1]));
        int[][] maxi = Arrays.copyOf(indexWithVal , k);
        //sort by index
        Arrays.sort(maxi , Comparator.comparingInt(a -> a[0]));
        int[] seq = new int[k];
        for(int i = 0 ; i < k ; i++){
            seq[i] = maxi[i][1];
        }
        return seq;
        
    }
}