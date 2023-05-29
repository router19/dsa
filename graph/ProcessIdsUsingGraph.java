import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/*
 * 
 * Given the Process ids in array and the parent of these Process ids in separate array, and the process id we need to kill. Find the List of the process which would get killed on killing the given process.
Example:

pid {1,2,3,4,5,6,7,8,9} 
parentpid {2,0,2,3,3,3,3,4,5} 
Killing Process: 3
Output :{4,5,6,7,8,9}
 */
public class ProcessIdsUsingGraph {

	//Basically as BFS only 
	static List<Integer> listOfProcessesKilled(GraphUsingAdjacencyList graph, int src)
	{
		boolean[] visited = new boolean[graph.adListArray.length];
		LinkedList<Integer> queue = new LinkedList<Integer>();
		List<Integer> processesKilled = new ArrayList<Integer>();
		
		queue.add(src);
		visited[src] = true;
		while(!queue.isEmpty())
		{
			src = queue.poll();
			processesKilled.add(src);
			
			Iterator<Integer> i = graph.adListArray[src].listIterator();
			
			while(i.hasNext())
			{
				int n = i.next();
				if(!visited[n])
				{
					queue.add(n);
					visited[n] = true;
				}
			}
		}
		
		return processesKilled;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int pid[] = {1,2,3,4,5,6,7,8,9};
		int parentId[] = {2,0,2,3,3,3,3,4,5};
		
		GraphUsingAdjacencyList graph = new GraphUsingAdjacencyList(pid.length +1);
		
		for ( int i =0;i < pid.length; i++)
		{
			graph.addDirectedEdge(graph, parentId[i], pid[i]);
		}
		/*
		 * Create a Directed Graph between the parent and Child process and perform BFS (Breadth First search)
		 */
		//killed process are BFS from 3
		List<Integer> killedProcesses = listOfProcessesKilled(graph, 3);
		for(int i : killedProcesses)
		{
			System.out.print( i + " ");
		}
		
		
	}

}
