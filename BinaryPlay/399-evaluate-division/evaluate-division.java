class Solution {
    double res = -1.0;
    public void dfs(Map<String , List<String[]>> adj , String u , String dest , Set<String> visited , double prod){

        if(visited.contains(u)) return ;
        visited.add(u); 

        if(u.equals(dest)){
            res = prod;
            return;
        }

        for(String[] v : adj.getOrDefault(u , new ArrayList<>())){
            double val = Double.parseDouble(v[1]); 
            dfs(adj , v[0] , dest , visited , prod * val); 
        }
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String , List<String[]>> adj = new HashMap<>();

        int m = queries.size();
        double[] ans = new double[m];

        int n = equations.size();

        for(int i = 0 ; i < n ; i++){
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            String val = Double.toString(values[i]);
            String inverse = Double.toString(1.0 / values[i]); 

            adj.computeIfAbsent(u , k -> new ArrayList<>()).add(new String[]{v , val});
            adj.computeIfAbsent(v , k -> new ArrayList<>()).add(new String[]{u , inverse});
        }

        for(int i = 0 ; i < m ; i++){
            String src = queries.get(i).get(0);
            String dest = queries.get(i).get(1);

            res = -1.0;
            if(adj.containsKey(src)){ 
                Set<String> visited = new HashSet<>();
                dfs(adj , src , dest , visited , 1.0);
            }
            ans[i] = res;
        }

        return ans;

    }
}