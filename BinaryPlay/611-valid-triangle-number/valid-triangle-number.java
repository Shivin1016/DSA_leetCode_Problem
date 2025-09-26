class Solution {
    public int binarySearch(int[] nums , int l , int r , int target){
        int k = -1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(nums[mid] < target){
                k = mid;
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return k;
    }
    public int triangleNumber(int[] nums) {

        int n = nums.length;
        if(n < 3) return 0;

        int count = 0;
        Arrays.sort(nums);

        for(int i = 0 ; i < n ; i++){
            if(nums[i] == 0) continue; // never be triangle
            for(int j = i + 1 ; j < n ; j++){
                int target = nums[i] + nums[j];
                int idx = binarySearch(nums , j + 1 , n - 1 , target);
                if(idx != -1){
                    count += (idx - j);
                }
            }
        }

        return count;
    }
}