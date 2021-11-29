class Solution
{
    /*
    Topological sort: Traversal of all vertices of a graph, such that if an edge exists from u to v,
    then u must come before v.
    Topological sort is possible only for Directed Acyclic Graph (DAG).
    Reasons: For undirected graph, edge (u,v) we cant say if it is from u to v or v to u
    Also if a graph has cycle (say u to v, v to t and t to u ) then its not possible to write its topological sort
    Intuition:
    We will be using DFS mechanism.
    When we are at node n1, we will go to adj(n1) if it is not visited and again call our method
    If we are not left with any adj(n1), then we will mark n1 as visited and push into a stack
    At last when all nodes are processed, popping stack from top and adding element in our resultset would give our answer
    */ 
    static int[] topoSort(int v, ArrayList<ArrayList<Integer>> adj) // v is no of vertices/nodes
    {
        // 0-based nodes are given in problem
        boolean[] vis = new boolean[v];
        Arrays.fill(vis, false);
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<v; i++){
            if(!vis[i]){
                findTopoSort(i, adj, vis, stack); // findTopoSort would add all elements of resultset into stack
            }
        }
        
        int[] res = new int[stack.size()];
        int k = 0;
        while(!stack.isEmpty()){
            res[k++] = stack.pop();
        }
        
        return res;
    }
    
    static void findTopoSort(int v, ArrayList<ArrayList<Integer>> adj, boolean[] vis, Stack<Integer> stack){
        vis[v] = true;
        for(int it: adj.get(v)){
            if(!vis[it]){
                findTopoSort(it, adj, vis, stack);
            }
        }
        // once all adjacent of v has been processed, then add v into the stack
        stack.push(v);
    }
}