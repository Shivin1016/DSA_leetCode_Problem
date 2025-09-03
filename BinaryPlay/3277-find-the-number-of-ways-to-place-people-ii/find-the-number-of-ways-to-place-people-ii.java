class Solution {
    public int numberOfPairs(int[][] points) {
        int n = points.length;

        //aort the array on x-basis in ascending order , if x -axis equal then sort on y-axis in desending order
        Arrays.sort(points , new Comparator<int[]>(){
            public int compare(int[] a , int[] b){
                if(a[0] == b[0]){
                    return b[1] - a[1];
                }
                return a[0] - b[0];
            }
        });

        int count = 0;

        for(int i = 0 ; i < n ; i++){
            
            int x1 = points[i][0];
            int y1 = points[i][1];

            int maxY = Integer.MIN_VALUE;

            for(int j = i + 1 ; j < n ; j++){

                int x2 = points[j][0];
                int y2 = points[j][1];

                if(y1 < y2){
                    continue ; //upper chala gaya y2
                }

                if(y2 > maxY){
                    count++;
                    maxY = y2;
                }

            }
        }

        return count;

    }
}