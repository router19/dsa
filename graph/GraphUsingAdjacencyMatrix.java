import java.util.LinkedList;
import java.util.Queue;

/*
Advantages of using Adjacency Matrix:
-----------------------------------------
An adjacency matrix is simple and easy to understand.
Adding or removing edges from a graph is quick and easy.
It allows constant time access to any edge in the graph.

Disadvantages of using Adjacency Matrix:
------------------------------------------
It is inefficient in terms of space utilisation for sparse graphs because it takes up O(N2) space.
Computing all neighbors of a vertex takes O(N) time.


Applications of the Adjacency Matrix:
Graph algorithms: Many graph algorithms like Dijkstra’s algorithm, Floyd-Warshall algorithm, and Kruskal’s algorithm use adjacency matrices to represent graphs.
Image processing: Adjacency matrices are used in image processing to represent the adjacency relationship between pixels in an image.
Finding the shortest path between two nodes: By performing matrix multiplication on the adjacency matrix, one can find the shortest path between any two nodes in a graph.


 */
public class GraphUsingAdjacencyMatrix {

    private int adjMatrix[][];
    private int numVertices;

    public GraphUsingAdjacencyMatrix(int numVertices){
        this.numVertices = numVertices;
        adjMatrix = new int[numVertices][numVertices];
    }

    public void addEdge(int i, int j){
        adjMatrix[i][j] = 1;
        adjMatrix[j][i] = 1;

    }
    public void removeEdge(int i, int j){
        adjMatrix[i][j] = 0;
        adjMatrix[j][i] = 0;
    }
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < numVertices; i++) {
            s.append(i + ": ");
            for (int j : adjMatrix[i]) {
                s.append((j) + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }

    public void BFS(int src){
        boolean[] visited = new boolean[numVertices];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(src);
        visited[src] = true;
        while (!queue.isEmpty()){
            int node =  queue.poll();
            System.out.print(" " + node);
            for(int i =0; i < numVertices;i++)
            {
                if(!visited[i] && adjMatrix[node][i] != 0) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    public void DFSUtil(int src, boolean[] visited){
        visited[src] = true;
        System.out.print(" " + src);
        for (int i=0; i < numVertices;i++){
            if(!visited[i] && adjMatrix[src][i] !=0)
            {
                DFSUtil(i,visited);
            }
        }
    }
    public void DFS(int src){
        boolean[] visited = new boolean[numVertices];
        DFSUtil(src,visited);
    }


    public static void main(String[] args) {
        GraphUsingAdjacencyMatrix g = new GraphUsingAdjacencyMatrix(4);


         /*
         *        0 --- 1 --- 2
         *         \        /
         *          \    /
         *            3
         *
         * */
        g.addEdge(0, 1);
        g.addEdge(0, 3);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        System.out.print("BFS is ");
        g.BFS(0);

        System.out.print("\nDFS :");
        g.DFS(0);
        System.out.print("\n" + g.toString());
    }
}
