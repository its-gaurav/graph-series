class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int v, ArrayList<ArrayList<Integer>> adj) {
        // visited array
        boolean[] vis = new boolean[v];
        Arrays.fill(vis, false);
        
        for(int i=0; i<v; i++){ // for loop, useful if there are some disconnected components in given graph
            if(!vis[i]){
                if(detectCycleUsingDFS(i, -1, vis, adj)){
                    return true;
                }
            }    
        }
        
        return false;
    }
    // 'parent' reflects node from where 'node' is coming
    boolean detectCycleUsingDFS(int node, int parent, boolean[] vis, ArrayList<ArrayList<Integer>> adj){
        vis[node] = true;
        for(int it : adj.get(node)){
            if(!vis[it]){
                if(detectCycleUsingDFS(it, node, vis, adj)==true){
                    return true;   
                }
            }else if(it != parent){ // if visited, then see if current node (node) is coming from this node only
                return true;
            }
        }
        return false;
        
    }
}