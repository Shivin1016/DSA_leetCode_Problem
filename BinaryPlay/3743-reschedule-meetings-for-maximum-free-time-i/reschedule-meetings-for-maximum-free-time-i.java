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
        int sum = 0 , i = 0 , j = 0;
        int res = 0;
        while(j < gap.size()){ 

            sum += gap.get(j);

            if((j - i + 1) == (k + 1)){
                res = Math.max(res , sum); 
                sum -= gap.get(i);
                i++;
            }

            j++;
        }  
        return res;
    }
}