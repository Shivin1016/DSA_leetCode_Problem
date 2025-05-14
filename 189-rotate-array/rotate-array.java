class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
         //make k in range 
        k =  k % n;

        //Approach 02-> using extra space
        List<Integer> ls = new ArrayList<>();
        //store last k elements in ls
        for(int i = n - k ; i < n ; i++){
            ls.add(nums[i]);
        }
        //put 0 to k - 1 elem at right place
        for(int i = n - k - 1 ; i >= 0 ; i--){
            nums[i + k] = nums[i];
        }
        //now put k to n - 1 elem at right place
        for(int i = 0 ; i < k ; i++){
            nums[i] = ls.get(i);
        }


        //Approach 02-> using Reversing the array
        //reverse whole array
        // reverse(nums , 0 , n - 1); // t.c --> O(n/2)

        // //now reverse subarray of 0 to k - 1 and subarray of k to n - 1;
        // reverse(nums , 0 , k - 1);
        // reverse(nums , k , n - 1);

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