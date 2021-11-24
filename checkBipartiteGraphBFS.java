class Solution
{
    /*
    coloring vertex with red/blue (0/1). If coloring of a graph using 2 colors 
    is possible in a way such that no two adjacent vertices are of same color, 
    then the graph is bipartite
    
    If a graph has an odd cycle (having odd no. of vertices), then it is not bipartite
    Else the graph is bipartite
    */
    public boolean isBipartite(int v, ArrayList<ArrayList<Integer>>adj)
    {
        // this array tells a node i has been colored with 0 or 1.
        int[] color = new int[v];
        for(int i=0; i<v; i++){
            color[i] = -1; // initially not colored
        }
        
        for(int i=0; i<v; i++){
            if(color[i]==-1){ // if vertex i has not been colored yet
                if(!isBipartite(i, adj, color)){ // if any component is not bipartite
                    return false;
                }
            }
        }
        
        return true;
    }
    
    boolean isBipartite(int v, ArrayList<ArrayList<Integer>>adj, int[] color){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        color[v] = 1;
        
        while(!queue.isEmpty()){
            int node = queue.poll(); // deletes from front and return that
            for(int it: adj.get(node)){
                if(color[it]==-1){ // if adjacent 'it' vertex is not colored
                    color[it] = 1 - color[node];
                    queue.add(it);
                }else{ // if adjacent vertex 'it' is already colored
                    if(color[it]==color[node]){ // if adjacent vertex is of same color
                        return false;
                    }
                }
            }
        }
        return true;
    }
}