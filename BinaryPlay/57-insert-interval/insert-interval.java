class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        int n = intervals.length; 

        List<int[]> temp = new ArrayList<>(Arrays.asList(intervals));
        List<int[]> res = new ArrayList<>();

        temp.add(newInterval);

        Collections.sort(temp , (a , b) -> Integer.compare(a[0] , b[0]));

        int[] prev = temp.get(0);
        for(int i = 1 ; i <= n; i++){
            int[] curr = temp.get(i);

            if(curr[0] <= prev[1]){
                prev[1] = Math.max(prev[1] , curr[1]);
            }else{ 
                res.add(prev);
                prev = curr;
            }
        }

        res.add(prev);


        return res.toArray(new int[res.size()][]);
    } 
}