class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();

        //stores Y-cnt
        int[] yCnt = new int[n];
        int nCnt = 0;
        int panality = Integer.MAX_VALUE;
        int closingTime = Integer.MAX_VALUE;
        int cnt = 0;
        for(int i = n - 1 ; i >= 0 ; i--){
            if(customers.charAt(i) == 'Y'){
                cnt++;
            }
            yCnt[i] = cnt;
        }

        for(int i = 0 ; i <= n ; i++){ // for closing time
            //in starting ncnt is zero
            //ycnt from ith position
            int tempPanality = (i == n ? 0 : yCnt[i]) + nCnt;
            // System.out.println(panality + " " + tempPanality + " " + nCnt);
            if(tempPanality < panality){
                panality = tempPanality;
                closingTime = i;
            }

            //check for nCnt 
            if(i < n && customers.charAt(i) == 'N'){
                nCnt++;
            }
        }
        return closingTime;
    }
}