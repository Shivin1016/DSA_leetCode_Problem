class Solution {
    public int countTrapezoids(int[][] points) {
        int n = points.length;
        int result = 0; 

        // store (m , Intecept)
        Map<Double , List<Double>> mIntercpts = new HashMap<>();
        
        // midpoint -> m list
        Map<Integer, List<Double>> midPointMap = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            int x1 = points[i][0];
            int y1 = points[i][1];
            for(int j = i + 1 ; j < n ; j++){
                int x2 = points[j][0];
                int y2 = points[j][1];
                
                int dy = y2 - y1;
                int dx = x2 - x1;

                double m = 0 , c = 0; // m and c
                if(dx == 0){
                    // perpendicular line (vertical)
                    m = 1000000007; // store max value
                    c = x1; // c at x-axis; 
                }else{
                    m = (double)dy / dx;
                    c = (double)(y1 * dx - x1 * dy) / dx;
                }

                // normalize negative zero
                if (m == -0.0) m = 0.0;
                if (c == -0.0) c = 0.0;

                int midPointKey = (x1 + x2) * 10000 + (y1 + y2);

                mIntercpts
                    .computeIfAbsent(m, k -> new ArrayList<>())
                    .add(c);

                midPointMap
                    .computeIfAbsent(midPointKey, k -> new ArrayList<>())
                    .add(m);
            }
        }



        for(double m : mIntercpts.keySet()){
            if (mIntercpts.size() <= 1) continue;
            TreeMap<Double , Integer> count = new TreeMap<>();
            for(double c : mIntercpts.get(m)){
                count.put(c , count.getOrDefault(c , 0) + 1);
            }
            int previousLine = 0;
            for(int cnt : count.values()){
                result += cnt * previousLine;
                previousLine += cnt; 
            }
        }

          // Remove parallelogram duplicates
        for (List<Double> mList : midPointMap.values()) {
            if (mList.size() <= 1) continue;

            TreeMap<Double, Integer> freq = new TreeMap<>();
            for (double s : mList)
                freq.put(s, freq.getOrDefault(s, 0) + 1);

            int prefix = 0;
            for (int count : freq.values()) {
                result -= prefix * count;
                prefix += count;
            }
        }
        return result;
    }
}