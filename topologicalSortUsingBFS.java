class Solution
{
    /*
    Topological sort: Traversal of all vertices of a graph, such that if an edge exists from u to v,
    then u must come before v.
    Topological sort is possible only for Directed Acyclic Graph (DAG).
    Reasons: For undirected graph, edge (u,v) we cant say if it is from u to v or v to u
    Also if a graph has cycle (say u to v, v to t and t to u ) then its not possible to write its topological sort
    Intuition:
    We will be using BFS mechanism.
    We will be using indegree array that will keep count of edges coming to a vertex
    First we will insert all vertices having 0 degree. 
    Thn we will start deleting element 'ele' from front and adding that to our answer.
    For ele, we will see all adjacent elements and reduce degree of each element
    Also if degree is 0 of adjacent element then we will insert that into queue.
    
    */ 
    static int[] topoSort(int v, ArrayList<ArrayList<Integer>> adj) // v is no of vertices/nodes
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
        while(!queue.isEmpty()){
            int node = queue.remove();
            res[k++] = node;
            for(int it: adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0){
                    queue.add(it);
                }
            }
        }
        
        return res;
    }
    
}