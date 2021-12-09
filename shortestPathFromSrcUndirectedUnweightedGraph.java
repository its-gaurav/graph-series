/**
 * Approach:
 * Since given graph is unweighted, so assuming each edge having weight of 1
 * Taking a distance array of size n (no of nodes) and initializing all with verylarge value
 * dist[i] would store minimum cost to cover from given source to i
 * Since we will be using BFS mechanism, hence at every node i, we will be checking all adjacent nodes
 * And using greedy approach we will be choosing the best one
 */

private void shortestPath(ArrayList<ArrayList<Integer>> adj,int N,int src){ 
		
    int[] dist = new int[N]; // N no of nodes
    // initializing all with a verylarge value
    for(int i = 0; i < N; i++) 
        dist[i] = 1000000000; 
    // queue to implement bfs mechanism
    Queue<Integer> q=new LinkedList<>();
    
    // reaching from src to src itself would take 0 cost
    dist[src] = 0;
    q.add(src); 

    while(!q.isEmpty()) 
    { 
        int node = q.poll();  
            
        for(int it:adj.get(u)){
            // checking if visiting `it` from `node` (src) which takes dist[node] + 1 is
            // better than existing dist[it] calculated to reach from `node` to `it`
            // if better, then we will update dist[it] and add `it` to our queue as
            // now path will include `it` 
            if(dist[node] + 1 < dist[it]){
                dist[it] = dist[node] + 1;
                q.add(it);
            }
        } 
    }
    
    for(int i = 0;i < N;i++) {
        System.out.print(dist[i] + " "); 
    }
} 