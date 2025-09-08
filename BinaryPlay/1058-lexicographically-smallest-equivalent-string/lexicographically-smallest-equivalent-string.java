class Solution {
    public char dfs(Map<Character , List<Character>> adj , char ch , boolean[] visited){
        visited[ch - 'a'] = true;
        char minChar = ch; 
        for(char currChar : adj.getOrDefault(ch , new ArrayList<>())){
            
            if(!visited[currChar - 'a']){
                char nextChar = dfs(adj , currChar , visited);
                if(nextChar < minChar){
                    minChar = nextChar;
                }
            }
        }
        return minChar;
    }
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int m = s1.length();
        int n = baseStr.length();

        //using DFS
        Map<Character , List<Character>> adj = new HashMap<>();

        for(int i = 0 ; i < m ; i++){
            char u = s1.charAt(i);
            char v = s2.charAt(i); 

            adj.computeIfAbsent(u , k -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v , k -> new ArrayList<>()).add(u);
        }

        //dfs call for each charater of baseStr
        char[] ans = new char[n];
        for(int i = 0 ; i < n ; i++){
            boolean[] visited = new boolean[26];
            char ch = baseStr.charAt(i);
            ans[i] = dfs(adj , ch , visited);
        }
        return new String(ans);
    }
}