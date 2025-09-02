class Solution {
    public int numberOfPairs(int[][] points) {
        int n = points.length;

        // Arrays.sort(points , (a , b) -> a[0] - b[0]);

        int count = 0;

        for(int i = 0 ; i < n ; i++){

            int[] p1 = points[i];

            for(int j = 0 ; j < n ; j++){

                int[] p2 = points[j]; 
                if(i == j || p1[0] > p2[0] || p1[1] < p2[1]){
                    continue;
                } 
                boolean isInside = true;
                for(int k = 0 ; k < n ; k++){

                    if(k == i || k == j) continue;

                    int x = points[k][0] ;
                    int y = points[k][1];
                    // inside rectangle 
                    if(p1[0] <= x && p2[0] >= x && p1[1] >= y && p2[1] <= y){
                        isInside = false;
                        break;
                    }
                }
                
                if(isInside){
                    count++;
                }
            }
        }

        return count;
    }
}