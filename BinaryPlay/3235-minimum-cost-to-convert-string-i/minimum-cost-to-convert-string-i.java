class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int inf = (int)1e9;
        int[][] dist = new int[26][26];
        for(int i = 0 ; i < 26 ; i++){
            Arrays.fill(dist[i] , inf);
            dist[i][i] = 0;
        }
        int n = original.length;
        for(int i = 0 ; i < n ; i++){
            int o = original[i] - 'a';
            int c = changed[i] - 'a';

            dist[o][c] = Math.min(dist[o][c] , cost[i]);
        }

        for(int v = 0 ; v < 26 ; v++){
            for(int s = 0 ; s < 26 ; s++){
                for(int t = 0 ; t < 26 ; t++){
                    dist[s][t] = Math.min(dist[s][t] , dist[s][v] + dist[v][t]);
                }
            }
        }

        int m = source.length();
        long totalCost = 0;
        for(int i = 0 ; i < m ; i++){
            int s = source.charAt(i) - 'a';
            int t = target.charAt(i) - 'a';

            if(s == t) continue;

            if(dist[s][t] == inf) return -1;
            totalCost += dist[s][t];
        }

        return totalCost;



    }
}