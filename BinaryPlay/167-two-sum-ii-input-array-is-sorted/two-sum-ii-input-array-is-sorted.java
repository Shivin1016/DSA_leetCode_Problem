class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        
        for(int i = 0 ; i < n ; i++){
            int remain = target - numbers[i];
            int idx = binarySearch(numbers , remain , n);
            if(idx != -1){
                return new int[]{i + 1 , idx + 1};
            }
        }
        return new int[]{};
    }

    public int binarySearch(int[] nums , int target , int n){
        int low = 0;
        int high = n - 1; 
        int res = -1;
        while(low <= high){
            int mid  = low + (high - low) / 2;
            if(nums[mid] == target){
                res = mid;
                low = mid + 1;
            }
            else if(nums[mid] < target) low = mid + 1;
            else{
                high = mid - 1;
            }
        }
        return res;
    }
}