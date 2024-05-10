import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Advantages of using an Adjacency list:
----------------------------
An adjacency list is simple and easy to understand.
Adding or removing edges from a graph is quick and easy.

Disadvantages of using an Adjacency list:
----------------------------------
In adjacency lists accessing the edges can take longer than the adjacency matrix.
It requires more memory than the adjacency matrix for dense graphs.


Applications of the Adjacency List:
Graph algorithms: Many graph algorithms like Dijkstra’s algorithm, Breadth First Search, and Depth First Search use adjacency lists to represent graphs.
Image Processing: Adjacency lists can be used to represent the adjacency relationships between pixels in an image.
Game Development: These lists can be used to store information about the connections between different areas or levels the game developers use graphs to represent game maps or levels.
 */
public class GraphUsingAdjacencyList {
	
	//no of vertices
	int V;
	LinkedList<Integer> adListArray[];
	GraphUsingAdjacencyList(int V)
	{
		this.V = V;
		adListArray = new LinkedList[V];
		
		for(int i=0;i < V;i++)
		{
			adListArray[i] = new LinkedList<>();
		}
	}
	//Below is addEdge for undirected graph
	public void addUndirectedEdge(GraphUsingAdjacencyList graph,int src,int dest)
	{
		//Add an edge from src to dest
		graph.adListArray[src].add(dest);
		
		//for undirected graph,add edge for dest to src
		graph.adListArray[dest].add(src);
	}
	
	void addDirectedEdge(GraphUsingAdjacencyList graph,int src,int dest)
	{
		graph.adListArray[src].add(dest);
	}
	void printGraph(GraphUsingAdjacencyList graph)
	{
		for(int i =0; i <V;i++)
		{
			System.out.print("Vertice "+ i );
			for(int vertices : adListArray[i])
			{
				System.out.print("--> " + vertices);
			}
			System.out.println();
		}
	}
	/*
	 * Time Complexity: O(V+E) where V is number of vertices in the graph and E is number of edges in the graph.
	 */
	void BFS(int src)
	{
		boolean visited[] = new boolean[V];
		
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(src);
		visited[src] = true;
		
		while(!queue.isEmpty())
		{
			src = queue.poll();
			System.out.print(src + " ");
			
			// Get all adjacent vertices of the dequeued vertex s 
            // If a adjacent has not been visited, then mark it 
            // visited and enqueue it 

			for(int n : adListArray[src])
			{
				if(!visited[n])
				{
					visited[n] = true;
					queue.add(n);
				}
			}
		}
		
	}


	//
	// bfs for disconnected graph
	//
	void bfs(int src, boolean visited[]){
		Queue<Integer> queue = new LinkedList<>();

		queue.add(src);
		visited[src] = true;

		while(!queue.isEmpty()){
			int vertex = queue.poll();
			System.out.print(vertex + " ");
			for(int v : adListArray[vertex]){
				if(!visited[v]){
					visited[v] = true;
					queue.add(v);
				}
			}
		}
	}
	void bfsHelper(){
		boolean visited[] = new boolean[V];
		for(int i =V-1;i>= 0; i--){
			if(!visited[i])
			bfs(i,visited);
		}
	}
	
	/*
	 * Time Complexity: O(V+E) where V is number of vertices in the graph and E is number of edges in the graph.
	 */
	void DFSRec(int src,boolean visited[])
	{
		visited[src] = true;
		System.out.print(src + " ");
		Iterator<Integer> i = adListArray[src].listIterator();
		
		while(i.hasNext())
		{
			int n = i.next();
			
			if(!visited[n])
				DFSRec(n, visited);
			
		}
	}
	void DFS(int src)
	{
		boolean visited[] = new boolean[V];
		//Use below to cover disconnected graph
		//for(int i =0; i< V; i++)
		//if(!visited[i])
		DFSRec(src,visited);
	}
	
	
	//
    //
    // Check cycle for a directed graph
    //
    
	// This function is a variation of DFSUtil() in
    // https://www.geeksforgeeks.org/archives/18212
    private boolean isCyclicUtilDirectedGraph(int i, boolean[] visited,
												boolean[] recStack)
    {
        if (recStack[i])
            return true;
 
        if (visited[i])
            return false;
        
        // Mark the current node as visited and
        // part of recursion stack     
        visited[i] = true;
 
        recStack[i] = true;
        List<Integer> children = adListArray[i];
         
        for (Integer c: children)
            if (isCyclicUtilDirectedGraph(c, visited, recStack))
                return true;
                 
        recStack[i] = false;
 
        return false;
    }
 
    
    /*
     * Time Complexity: O(V+E). 
	Time Complexity of this method is same as time complexity of DFS traversal which is O(V+E).
	Space Complexity: O(V). 
     */
    // Returns true if the graph contains a
    // cycle, else false.
    // This function is a variation of DFS() in
    // https://www.geeksforgeeks.org/archives/18212
    private boolean isCyclicDirectedGraph()
    {
         
        // Mark all the vertices as not visited and
        // not part of recursion stack
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];
         
         
        // Call the recursive helper function to
        // detect cycle in different DFS trees
        for (int i = 0; i < V; i++)
            if (isCyclicUtilDirectedGraph(i, visited, recStack))
                return true;
 
        return false;
    }
    
    
    //
    //
    // Check cycle for a undirected graph
    //
    
    
    // A recursive function that
    // uses visited[] and parent to detect
    // cycle in subgraph reachable
    // from vertex v.
    Boolean isCyclicUtilUnDirectedGraph(int v,
										Boolean visited[], int parent)
    {
        // Mark the current node as visited
        visited[v] = true;
        Integer i;
 
        // Recur for all the vertices
        // adjacent to this vertex
        Iterator<Integer> it =
                adListArray[v].iterator();
        while (it.hasNext())
        {
            i = it.next();
 
            // If an adjacent is not
            // visited, then recur for that
            // adjacent
            if (!visited[i])
            {
                if (isCyclicUtilUnDirectedGraph(i, visited, v))
                    return true;
            }
 
            // If an adjacent is visited
            // and not parent of current
            // vertex, then there is a cycle.
            else if (i != parent)
                return true;
        }
        return false;
    }
 
    // Returns true if the graph
    // contains a cycle, else false.
    Boolean isCyclicUndirectedGraph()
    {
         
        // Mark all the vertices as
        // not visited and not part of
        // recursion stack
        Boolean visited[] = new Boolean[V];
        for (int i = 0; i < V; i++)
            visited[i] = false;
 
        // Call the recursive helper
        // function to detect cycle in
        // different DFS trees
        for (int u = 0; u < V; u++)
        { 
         
            // Don't recur for u if already visited
            if (!visited[u])
                if (isCyclicUtilUnDirectedGraph(u, visited, -1))
                    return true;
        }
 
        return false;
    }
 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int V = 5; 
        GraphUsingAdjacencyList graph = new GraphUsingAdjacencyList(V); 
        graph.addUndirectedEdge(graph, 0, 1); 
        graph.addUndirectedEdge(graph, 0, 4); 
        graph.addUndirectedEdge(graph, 1, 2); 
        graph.addUndirectedEdge(graph, 1, 3); 
        graph.addUndirectedEdge(graph, 1, 4); 
        graph.addUndirectedEdge(graph, 2, 3); 
        graph.addUndirectedEdge(graph, 3, 4); 
       
        // print the adjacency list representation of  
        // the above graph 
       // graph.printGraph(graph); 
        
        //Traversal algorithms
        
        
        
        //1. BFS
        GraphUsingAdjacencyList g = new GraphUsingAdjacencyList(4); 
        
        g.addDirectedEdge(g,0, 1); 
        g.addDirectedEdge(g,0, 2); 
        g.addDirectedEdge(g,1, 2); 
        g.addDirectedEdge(g,2, 0); 
        g.addDirectedEdge(g,2, 3); 
        g.addDirectedEdge(g,3, 3); 
        System.out.println("Graph is ");
        g.printGraph(g);
        System.out.println("Following is Breadth First Traversal "+ 
                           "(starting from vertex 2)"); 
  
        g.BFS(2);
        System.out.println();
        //
        //DFS
        System.out.println("Following is Depth First Traversal "+ 
                "(starting from vertex 2)"); 

        g.DFS(2);




		GraphUsingAdjacencyList g1 = new GraphUsingAdjacencyList(6);

		g.addDirectedEdge(g1,5, 2);
		g.addDirectedEdge(g1,5, 0);
		g.addDirectedEdge(g1,4, 0);
		g.addDirectedEdge(g1,4, 1);
		g.addDirectedEdge(g1,2, 3);
		g.addDirectedEdge(g1,3, 1);
		System.out.println("Graph is ");
		g.printGraph(g1);
		System.out.println("Following is Breadth First Traversal "+
				"(starting from vertex 5)");

		g1.bfsHelper();
		System.out.println();
		//
		//DFS
		System.out.println("Following is Depth First Traversal "+
				"(starting from vertex 5)");

		g1.DFS(5);
	}

}
