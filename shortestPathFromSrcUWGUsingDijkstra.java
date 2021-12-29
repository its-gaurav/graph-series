import java.util.*; 
// Dijkstra's Algorithm
    /*
    Prepare a min-heap that contains (dist, node)
    Keep a distance[numVertices] and initialized all with INTEGER.MAX_VALUE
    Add (0, srcNode) to heap and update distance[srcNode] = 0
    Remove the top element from heap and look for all adjacent vertices using BFS
    Compare the distance with new one and updte accordingly 
    Dijkstra’s algorithm doesn’t work for graphs with negative weight cycles.
     It may give correct results for a graph with negative edges but you must allow 
     a vertex can be visited multiple times and that version will lose its fast time 
     complexity. For graphs with negative weight edges and cycles, 
     Bellman–Ford algorithm can be used ---*/

class Node implements Comparator<Node>
{
    private int v;
    private int weight;
    
    Node(int _v, int _w) { v = _v; weight = _w; }
    
    Node() {}
    
    int getV() { return v; }
    int getWeight() { return weight; }
    
    @Override
    public int compare(Node node1, Node node2) 
    { 
        if (node1.weight < node2.weight) 
            return -1; 
        if (node1.weight > node2.weight) 
            return 1; 
        return 0; 
    } 
}

void shortestPath(int s, ArrayList<ArrayList<Node>> adj, int N)
    {
        int dist[] = new int[N];
        
        for(int i = 0;i<N;i++) dist[i] = 100000000;
        dist[s] = 0; 
        
        PriorityQueue<Node> minHeap = new PriorityQueue<Node>();
        minHeap.add(new Node(s, 0));
        
        while(minHeap.size() > 0) {
            Node node = minHeap.poll();
            
            for(Node it: adj.get(node.getV())) {
                if(dist[node.getV()] + it.getWeight() < dist[it.getV()]) {
                    dist[it.getV()] = dist[node.getV()] + it.getWeight(); 
                    minHeap.add(new Node(it.getV(), dist[it.getV()]));
                }
            }
        }
        
        for (int i = 0; i < N; i++)
        {
            System.out.print( dist[i] + " ");
        }
    }