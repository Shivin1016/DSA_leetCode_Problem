class Solution {
    public long maxSubarrays(int n, int[][] conflictingPairs) { 

        //make conflictingPoints list
        List<List<Integer>> conflictingPoints = new ArrayList<>();
        for(int i = 0 ; i <= n ; i++){
            conflictingPoints.add(new ArrayList<>());
        }

        for(int[] p : conflictingPairs){
            int a = Math.min(p[0] , p[1]);
            int b = Math.max(p[0] , p[1]);
            conflictingPoints.get(b).add(a);
        }

        long validSubArray = 0 ;
        int maxConflictPoint = 0 , secondMaxConflictPoint = 0;
        //extra[i] -> number of subArray by removing the conflicting point
        long[] extra = new long[n + 1];

        //visiting each point and treating them subarrays ending at this point
        for(int end = 1 ; end <= n ; end++){
            //subArray ending at end
            //check all conflicting point of end 
            for(int point : conflictingPoints.get(end)){
                //update maxConflicts and secondmaxConflict 
                if(point >= maxConflictPoint){
                    secondMaxConflictPoint = maxConflictPoint;
                    maxConflictPoint = point;
                }else if(point > secondMaxConflictPoint){
                    secondMaxConflictPoint = point;
                }
            }


            validSubArray += end - maxConflictPoint;
            //if we remove maxConflictPoint then how much extra subArray we got
            extra[maxConflictPoint] += maxConflictPoint - secondMaxConflictPoint;
        } 
        long maxExtra = 0;
        for(long ex : extra){
            System.out.println(ex);
            if(maxExtra < ex) maxExtra = ex;
        }
        long res = validSubArray + maxExtra;
        return res;
    }
}