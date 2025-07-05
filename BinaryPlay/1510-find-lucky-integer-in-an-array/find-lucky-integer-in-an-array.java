class Solution {
    public int findLucky(int[] arr) {
        int n = arr.length;

        Map<Integer , Integer> mp = new HashMap<>();

        for(int num : arr){
            mp.put(num , mp.getOrDefault(num , 0) + 1);
        }

        int lucky = -1;
        for(int key : mp.keySet()){
            int val = mp.get(key);
            if(val == key){
                lucky = Math.max(lucky , val);
            }
        }

        return lucky;
    }
}