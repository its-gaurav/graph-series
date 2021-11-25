class Solution {
    // Function to detect cycle in a directed graph.
    // video to refer https://youtu.be/uzVUw90ZFIg
    // Intuition: if the same vertex comes again and that too in same recursion call then its a cycle.
    // If visited vertex comes again but not in same recursion call, then its not a cycle
    public boolean isCyclic(int v, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[v];
        boolean[] visDFS = new boolean[v];
        Arrays.fill(vis, false);
        Arrays.fill(visDFS, false);
        
        for(int i=0; i<v; i++){
            if(!vis[i]){
                if(checkCycleUsingDFS(i, adj, vis, visDFS)){ // if cycle is found at any vertex, then return true there itself
                    return true;
                }   
            }
        }
        // if all vertex are visited and there is no cycle
        return false;
    }
    
    boolean checkCycleUsingDFS(int v, ArrayList<ArrayList<Integer>> adj, boolean[] vis, boolean[] visDFS){
        vis[v] = true;
        visDFS[v] = true; // assuming v has cycle
        
        for(int it: adj.get(v)){
            if(!vis[it]){
                if(checkCycleUsingDFS(it, adj, vis, visDFS)){ // if cycle is found at any vertex, then return true there itself
                    return true;
                }
            }else{ // if node already visited and visited in the same dfs recursion call, then it is a cycle
                if(vis[it] && visDFS[it]){
                    return true;
                }
            }
        }
        
        visDFS[v] = false; // it tells there is no cycle having vertex v
        return false;
        
    }
}