class Solution {
    public boolean binarySearch(int target , int[] nums){
        int low = 0;
        int high = nums.length - 1;

        while(low <= high){
            int mid = low + ( high - low) / 2; //
            if(nums[mid] == target){
                return true;
            }else if(nums[mid] < target){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return false;
    }
    public int countTriples(int n) {
        int[] sqArr = new int[n + 1]; //sq array 

        for(int i = 1 ; i <= n ; i++){
            int sq = i * i;
            sqArr[i] = sq;
        }
        int count = 0;
        for(int i = 1 ; i <= n ; i++){
            for(int j = i + 1 ; j <= n ; j++){
                int target = sqArr[i] + sqArr[j];
                if(binarySearch(target , sqArr)){
                    count++; // 3, 4 , 5 == > 4 , 3 , 5
                }
            }
        }

        return count * 2;
    }
}