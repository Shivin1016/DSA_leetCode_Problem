class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;

        //using dutch flag algo
        int low = 0 , mid = 0 , high = n -1;

        while(mid <= high){
            if(nums[mid] == 0){
                //swap low and mid
                int temp = nums[mid];
                nums[mid] = nums[low];
                nums[low] = temp;
                low++ ;
                mid++;
            }else if(nums[mid] == 1) mid++;
            else{
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }



        //using map
        // int[] mp = new int[3];

        // for(int num : nums){
        //     mp[num]++;
        // }

        // int j = 0;

        // for(int i = 0 ; i < 3 ; i++){
        //     while(mp[i] != 0){
        //         nums[j] = i;
        //         j++;
        //         mp[i]--;
        //     }
        // }

        
    }
}