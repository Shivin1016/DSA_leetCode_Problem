class Solution {
    int component;
    int[] parent;
    public int find(int i){
        return parent[i] = (i == parent[i] ? i : find(parent[i]));
    }
    public boolean union(int p , int child){
        //fi already have parent then not possible to assign other parent
        if(find(child) != child){
            return false;
        }

        //check for cycle 
        if(find(p) == child) return false;

        parent[child] = p;

        component--;
        return true;
    }
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        component  = n;
        parent = new int[n];
        for(int i = 0 ; i < n ; i++) parent[i] = i;
        for(int i = 0 ; i < n ; i++){ 

            if(leftChild[i] != -1 && union(i , leftChild[i]) == false){
                return false;
            }
            if(rightChild[i] != -1 && union(i , rightChild[i]) == false) return false;
        }

        return (component == 1) ? true : false;
    }

}