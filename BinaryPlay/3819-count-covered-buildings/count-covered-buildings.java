class Solution { 
    public int countCoveredBuildings(int n, int[][] buildings) { 
        int count = 0; 
 
        Map<Integer , int[]> xMinMaxY = new HashMap<>();
        Map<Integer , int[]> yMinMaxX = new HashMap<>();

        for(int[] building : buildings){
            int x = building[0];
            int y = building[1];

            xMinMaxY.putIfAbsent(x, new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE});
            yMinMaxX.putIfAbsent(y, new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE});

            int[] xminMax = xMinMaxY.get(x);
            xminMax[0] = Math.min(xminMax[0] , y); 
            xminMax[1] = Math.max(xminMax[1] , y);   

            int[] yminMax = yMinMaxX.get(y);
            yminMax[0] = Math.min(yminMax[0] , x);   
            yminMax[1] = Math.max(yminMax[1] , x); 


        }

        for(int[] building : buildings){
            int x = building[0];
            int y = building[1];

            int[] minMaxX = xMinMaxY.get(x); // find minimum and maximum y which bounds x 
            int[] minMaxY = yMinMaxX.get(y); // find minimum and maximum x which bounds y

            if(minMaxX[0] < y && minMaxX[1] > y && minMaxY[0] < x && minMaxY[1] > x){
                count++;
            }
        }

        return count;
    }
}