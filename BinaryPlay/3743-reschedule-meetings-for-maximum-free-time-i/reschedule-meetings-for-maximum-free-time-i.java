class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;

        List<Integer> gap = new ArrayList<>(); // store duration of freeGaps

        //gap-> startTIme[i] - endTime[i - 1]
        gap.add(startTime[0]);  // for start gap
        for(int i = 1 ; i < n ; i++){
            gap.add(startTime[i] - endTime[i - 1]); 
        } 

        //for last event
        gap.add(eventTime - endTime[n -1]);

        //apply Siliding window for size K + 1
        int sum = 0 , i = 0 , j = 0;
        int res = 0;
        while(j < gap.size()){

            sum += gap.get(j);

            while(i < n && (j - i + 1) > (k + 1)){
                sum -= gap.get(i);
                i++;
            }

            res = Math.max(res , sum);

            j++;
        }  
        return res;
    }
}