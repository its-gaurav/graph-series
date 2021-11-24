
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
                int c = 1;
                if(!checkBipartiteUsingDFS(i, adj, color, c)){ // if any component is not bipartite
                    return false;
                }
            }
        }
        
        return true;
    }
    
    boolean checkBipartiteUsingDFS(int v, ArrayList<ArrayList<Integer>>adj, int[] color, int c){
        color[v] = c;
        for(int it: adj.get(v)){
            if(color[it]==-1){ // if adjacent vertex is not colored yet
                if(!checkBipartiteUsingDFS(it, adj, color, 1 - c)){
                    return false;
                }
            }else{ // if adjacent vertex is already colored
                if(color[it]==c){
                    return false;
                }
            }
        }
        return true;
    }
}