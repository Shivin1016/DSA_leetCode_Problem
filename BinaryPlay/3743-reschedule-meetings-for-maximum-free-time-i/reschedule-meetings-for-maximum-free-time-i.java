class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;

        List<Integer> gap = new ArrayList<>();
        int prev = 0;
        for(int i = 0 ; i < n ; i++){
            gap.add(startTime[i] - prev);
            prev = endTime[i];
        }
        //for last gap
        gap.add(eventTime - prev);

        //apply Siliding window for size K + 1
        int sum = 0 , i = 0 , j = k; 
        for(int p = 0 ; p <= n && p <= k ; p++){
            sum += gap.get(p);
        } 
        int res = 0;
        res = Math.max(sum , res);
        while(j < n){
            sum -= gap.get(i++);
            sum += gap.get(++j);
            res = Math.max(sum , res);
        }

        return res;
    }
}