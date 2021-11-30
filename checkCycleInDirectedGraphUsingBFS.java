class Solution
{
    /*
    Topological sort: Traversal of all vertices of a graph, such that if an edge exists from u to v,
    then u must come before v.
    Topological sort is possible only for Directed Acyclic Graph (DAG).
    Reasons: For undirected graph, edge (u,v) we cant say if it is from u to v or v to u
    Also if a graph has cycle (say u to v, v to t and t to u ) then its not possible to write its topological sort
    Intuition:
    SInce topological sort is possible only if graph is Directed Acyclic in nature.
    Hence if we are unable to do topological sort, then graph is cyclic
    
    */ 
    static boolean isCycle(int v, ArrayList<ArrayList<Integer>> adj) // v is no of vertices/nodes
    {
        // 0-based nodes are given in problem
        int[] indegree = new int[v];
        Arrays.fill(indegree, 0);
        // calculating indegree of each vertex
        for(int i=0; i<v; i++){
            for(int it: adj.get(i)){
                indegree[it]++;
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<v; i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }
        
        int[] res = new int[v];
        int k = 0;
        int countVertices = 0;
        while(!queue.isEmpty()){
            int node = queue.remove();
            countVertices++;
            res[k++] = node;
            for(int it: adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0){
                    queue.add(it);
                }
            }
        }

        if(countVertices == v){ // countVertices = no of vertices then cycle does not exist
            return false; 
        }
        
        return true;
    }
    
}