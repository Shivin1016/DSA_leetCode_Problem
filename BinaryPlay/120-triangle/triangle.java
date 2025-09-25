class Solution { 
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        List<List<Integer>> t = triangle;

        for(int r = n - 2 ; r >= 0 ; r--){ 
            for(int c = 0 ; c < t.get(r).size() ; c++){
                int val = t.get(r).get(c) + Math.min(t.get(r + 1).get(c) , t.get(r + 1).get(c + 1));
                t.get(r).set(c , val);
            }
        }

        return t.get(0).get(0);
    
    }
}