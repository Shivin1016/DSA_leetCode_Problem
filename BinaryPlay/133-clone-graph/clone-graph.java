/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public void dfs(Node node , Node clone_node , Map<Node , Node> map){
        for(Node neigh : node.neighbors){
            //check that clone node present or not 
            //if not present then make and add it
            if(!map.containsKey(neigh)){
                Node clone = new Node(neigh.val);

                //add in map
                map.put(neigh , clone);

                //add in neighbors of clone_node
                clone_node.neighbors.add(clone);

                //call dfs for futher
                dfs(neigh , clone , map);
            }else{
                //present then simply add in neighbors of clone_node
                clone_node.neighbors.add(map.get(neigh));
            }
        }
    }
    public Node cloneGraph(Node node) {
        if(node == null) return null;

        //first make clone of node that is given 
        Node clone_node = new Node(node.val);

        //make map which stores the original_node --> clone_node
        // if clone_node already present then for that we require a map
        Map<Node , Node> map = new HashMap<>();
        map.put(node , clone_node);

        //call dfs for further
        dfs(node , clone_node , map);

        return clone_node;
    }
}