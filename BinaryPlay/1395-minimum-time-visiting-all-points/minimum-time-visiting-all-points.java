class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int n = points.length;

        int time = 0;

        for(int i = 1 ; i < n ; i++){
            int[] point1 = points[i];
            int[] point2 = points[i - 1];

            int dx = Math.abs(point1[0] - point2[0]);
            int dy = Math.abs(point1[1] - point2[1]);

            time += Math.max(dx , dy); 
        }

        return time;
    }
}