class FindSumPairs {
    int[] n1 , n2;
    Map<Integer , Integer> mp = new HashMap<>();
    public FindSumPairs(int[] nums1, int[] nums2) {
        n1 = nums1;
        n2 = nums2;

        for(int num : n2){
            mp.put(num , mp.getOrDefault(num , 0) + 1);
        }
    }
    
    public void add(int index, int val) {
        mp.put(n2[index] , mp.get(n2[index]) - 1);
        n2[index] += val;
        mp.put(n2[index] , mp.getOrDefault(n2[index] , 0) + 1);
    }
    
    public int count(int tot) {

        int totalCount = 0;

        for(int i = 0 ; i < n1.length ; i++){

            int find = tot - n1[i];

            if(mp.containsKey(find)){

                int val = mp.get(find);

                totalCount += val;
            }

        }

        return totalCount;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */