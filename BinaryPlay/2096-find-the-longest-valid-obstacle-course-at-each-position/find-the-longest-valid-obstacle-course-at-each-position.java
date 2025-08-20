class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int n = obstacles.length;

        List<Integer> LIS = new ArrayList<>(); //lis[i] = x --> (i + 1) subseq with ending elemnt x

        int[] result = new int[n];

        for(int i = 0 ; i < n ; i++){
            //find just bada element idx from nums[i]
            int idx = upper_bound(LIS , obstacles[i]);
            // System.out.println(idx);
            if(idx == LIS.size()){
                //there is no element just greater than nums[i]
                LIS.add(obstacles[i]);   
            }else{
                LIS.set(idx , obstacles[i]);
            }
            result[i] = idx + 1;
            
        } 
        return result;
    }

    public int upper_bound(List<Integer> nums , int target){
        int l = 0 , r = nums.size() - 1; 
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(nums.get(mid) <= target){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return l;
    }

}