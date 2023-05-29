import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

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
			adListArray[i] = new LinkedList<Integer>();
		}
	}
	//Below is addEdge for undirected graph
	void addUndirectedEdge(GraphUsingAdjacencyList graph,int src,int dest)
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
			Iterator<Integer> i = adListArray[src].listIterator();
			while(i.hasNext())
			{
				int n = i.next();
				if(!visited[n])
				{
					visited[n] = true;
					queue.add(n);
				}
			}
			
			
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
		
		DFSRec(src,visited);
	}
	
	
	//
    //
    // Check cycle for a directed graph
    //
    
	// This function is a variation of DFSUtil() in
    // https://www.geeksforgeeks.org/archives/18212
    private boolean isCyclicUtil(int i, boolean[] visited,
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
            if (isCyclicUtil(c, visited, recStack))
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
            if (isCyclicUtil(i, visited, recStack))
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
    Boolean isCyclicUtil(int v,
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
                if (isCyclicUtil(i, visited, v))
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
                if (isCyclicUtil(u, visited, -1))
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
	}

}
