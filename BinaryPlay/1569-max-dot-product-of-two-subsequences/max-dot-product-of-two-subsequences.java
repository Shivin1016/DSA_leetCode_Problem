class Solution {
    int m , n ;
    int[][] t ;

    public int solve(int[] nums1 , int[] nums2 , int i , int j){
        // base condition
        if(i == m || j == n){
            return (int)(-1e9);
        }

        if(t[i][j] != -1) return t[i][j];

        int take_both = nums1[i] * nums2[j];
        int take_both_further_check = (nums1[i] * nums2[j]) + solve(nums1 , nums2 , i + 1 , j + 1);
        int take_ith_further_jth = solve(nums1 , nums2 , i , j + 1);
        int take_jth_futher_ith = solve(nums1 , nums2 , i + 1 , j);

        return t[i][j] = Math.max(take_both , Math.max(take_both_further_check , Math.max(take_ith_further_jth , take_jth_futher_ith)));

    }
    public int maxDotProduct(int[] nums1, int[] nums2) {
        m = nums1.length;
        n = nums2.length;

        t = new int[m][n];

        for(int[] r : t) Arrays.fill(r , -1);

        return solve(nums1 , nums2 , 0 , 0);
    }
}