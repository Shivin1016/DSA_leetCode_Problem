class Solution { 
    public int[][] merge(int[][] intervals) { 
        int n = intervals.length;

        Arrays.sort(intervals , (a , b) -> a[0] - b[0]);
        List<int[]> temp = new ArrayList<>();
        int[] prev = intervals[0];

        for(int i = 1 ; i < n ; i++){
            int[] curr = intervals[i]; 

            if(curr[0] <= prev[1]){ 
                prev[1] = Math.max(prev[1] , curr[1]);
            }else{ 
                temp.add(prev);
                prev = curr;
            }
        }
        temp.add(prev);

        return temp.toArray(new int[temp.size()][]);
    }
}