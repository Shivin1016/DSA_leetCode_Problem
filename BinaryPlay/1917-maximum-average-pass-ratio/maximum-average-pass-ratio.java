class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        int n = classes.length;

        var max_delta = new PriorityQueue<double[]>((a,b) -> Double.compare(b[0] , a[0]));

        for(int i = 0 ; i < n ;i++){
            double currentPr = (double)classes[i][0] / classes[i][1];
            double newPr = (double)(classes[i][0] + 1) / (classes[i][1] + 1);
            double delta = newPr - currentPr;
            max_delta.offer(new double[]{delta , i});
        }

        int extra = extraStudents;
        while(extra-- > 0){

            double[] curr_delta = max_delta.poll();

            double delta = curr_delta[0];
            int idx = (int)curr_delta[1];
            //update classes
            classes[idx][0]++;
            classes[idx][1]++;

            //new PR will be 
            double currentPr = (double)classes[idx][0] / classes[idx][1];
            double newPr = (double)(classes[idx][0] + 1) / (classes[idx][1] + 1);
            double new_delta = newPr - currentPr;
            max_delta.offer(new double[]{new_delta , idx});

        }

        //final avg ratio
        double ans = 0.0;
        for(int[] c :classes){
            ans += (double)c[0]/c[1];
        }  
        return ans / n;
    }
}