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
                // make clone for neighbornode
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
    // using bfs
    public void bfs(Node node , Node clone_node , Map<Node , Node> map){
        var queue = new LinkedList<Node>();
        queue.add(node);

        while(!queue.isEmpty()){
            Node neigh = queue.pop();
            Node cloneNode = map.get(neigh);

            for(Node v : neigh.neighbors){
                if(!map.containsKey(v)){
                    //add in Queue
                    Node clone = new Node(v.val);
                    map.put(v , clone);
                    cloneNode.neighbors.add(clone);
                    queue.add(v);
                }else{
                    cloneNode.neighbors.add(map.get(v));
                }
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
        // dfs(node , clone_node , map);

        //call bfs for further
        bfs(node , clone_node , map);

        return clone_node;
    }
}