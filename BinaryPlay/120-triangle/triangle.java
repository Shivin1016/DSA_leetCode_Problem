class Solution { 
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size(); 

        for(int r = 1 ; r < n ; r++){
            for(int c = 0 ; c <= r ; c++){
                int size = triangle.get(r - 1).size();
                int rowLeft = triangle.get(r - 1).get(Math.max(c - 1 , 0));
                int rowRight = triangle.get(r - 1).get(Math.min(c , size - 1));
                int val = triangle.get(r).get(c) + Math.min(rowLeft , rowRight);

                triangle.get(r).set(c , val);
            }
        }

        Collections.sort(triangle.get(n - 1));
        return triangle.get(n - 1).get(0);
    
    }
}