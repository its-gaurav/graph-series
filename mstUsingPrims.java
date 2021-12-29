class Solution
{
    /*
    Starting from first node and adding that into minHeap (based on weight),
    we will pop the min (v, av, weight) from heap and if v is unvisited then
        v will be marked visited and v will be included in our MST and MST edge will be from av to v
        Now we will see all neighbours of v, and if a neighbour is unvisited we will add that
        neighbour(v, av, weight) into our minHeap
    */
    static int spanningTree(int numVertices, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
    {
        boolean[] vis = new boolean[numVertices]; // visited array
        Arrays.fill(vis, false);
        PriorityQueue<Node> minHeap = new PriorityQueue<Node>();
        
        minHeap.add(new Node(0, -1, 0));
        
        int weight = 0;
        
        while(minHeap.size() > 0){
            Node node = minHeap.poll();
            if(vis[node.v]){
                continue;
            }
            vis[node.v] = true;
            if(node.av != -1){
                weight += node.w;
                System.out.print(node.av+"----"+node.v);
            }
            
            ArrayList<ArrayList<Integer>> edgeWeightList = adj.get(node.v);
            for(ArrayList<Integer> edgeWeight: edgeWeightList){
                int dNode = edgeWeight.get(0);
                int dNodeWeight = edgeWeight.get(1);
                minHeap.add(new Node(dNode, node.v, dNodeWeight));
            }
        }
        return weight;
    }
}

class Node implements Comparable<Node>{
    int v;
    int av; // arriving-from vertex
    int w; // weight
    
    Node(int v, int av, int w){
        this.v = v;
        this.av = av;
        this.w = w;
    }
    
    public int compareTo(Node n){
        return this.w - n.w;
    }
}