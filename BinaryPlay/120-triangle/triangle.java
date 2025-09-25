class Solution { 
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        List<Integer> t = triangle.get(n - 1); //stors the last row 
        //t.get(c) --> stores minimum path sum from c to bottom

        for(int r = n - 2 ; r >= 0 ; r--){ 
            for(int c = 0 ; c <= r ; c++){
                int val = triangle.get(r).get(c) + Math.min(t.get(c) , t.get(c + 1));
                t.set(c , val);
            }
        }

        return t.get(0); //minimum path sum from top to bottom
    
    }
}