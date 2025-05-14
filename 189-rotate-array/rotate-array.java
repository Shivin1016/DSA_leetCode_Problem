class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int i = 0;
        // while(i < k){
        //     int idx = (i + k) % n;
        //     int temp = nums[i];
        //     nums[i] = nums[idx];
        //     nums[idx] = temp;
        //     i++;
        // }
        // if(n % 2 != 0){
        //     //swap last and first ele
        //     int temp = nums[0];
        //     nums[0] = nums[n - 1];
        //     nums[n - 1] = temp;
        // }

        //make k in range 
        k =  k % n;
        //reverse whole array
        reverse(nums , 0 , n - 1); // t.c --> O(n/2)

        //now reverse subarray of 0 to k - 1 and subarray of k to n - 1;
        reverse(nums , 0 , k - 1);
        reverse(nums , k , n - 1);

    }

    public void reverse(int[] nums , int l , int r){
        while(l <= r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }
}