class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int v, ArrayList<ArrayList<Integer>> adj) {
        // visited array
        boolean[] vis = new boolean[v];
        Arrays.fill(vis, false);
        
        for(int i=0; i<v; i++){
            if(!vis[i]){
                if(detectCycleUsingBFS(i, vis, adj)){
                    return true;
                }
            }    
        }
        
        return false;
    }
    
    boolean detectCycleUsingBFS(int i, boolean[] vis, ArrayList<ArrayList<Integer>> adj){
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(-1, i));
        vis[i] = true; 
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            int from = pair.from;
            int to = pair.to; // to reflects current node
            
            for(int node: adj.get(to)){
                if(!vis[node]){
                    queue.add(new Pair(to, node));
                    vis[node] = true;
                }else if(node != from){  // if node is visited
                        return true;
                }
            }
        }
        return false;
        
    }
}
// from , to reflects start and end of edge
// Pair(2,4) reflects we are at node 4 reached from node 2
class Pair{
    int from;
    int to;
    
    Pair(int from, int to){
        this.from = from;
        this.to = to;
    }
}