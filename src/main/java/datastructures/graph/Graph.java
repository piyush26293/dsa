package datastructures.graph;

import java.util.*;

/**
 * Graph Implementation using Adjacency List
 * Supports both directed and undirected graphs
 */
public class Graph {
    
    private int vertices;
    private LinkedList<Integer>[] adjacencyList;
    private boolean isDirected;
    
    /**
     * Constructor
     * @param vertices Number of vertices in the graph
     * @param isDirected Whether the graph is directed or undirected
     */
    @SuppressWarnings("unchecked")
    public Graph(int vertices, boolean isDirected) {
        this.vertices = vertices;
        this.isDirected = isDirected;
        adjacencyList = new LinkedList[vertices];
        
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }
    
    /**
     * Add an edge to the graph
     */
    public void addEdge(int source, int destination) {
        adjacencyList[source].add(destination);
        
        // If undirected, add edge in both directions
        if (!isDirected) {
            adjacencyList[destination].add(source);
        }
    }
    
    /**
     * Breadth-First Search (BFS) traversal
     */
    public void BFS(int startVertex) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();
        
        visited[startVertex] = true;
        queue.add(startVertex);
        
        System.out.print("BFS Traversal: ");
        
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");
            
            for (int neighbor : adjacencyList[vertex]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }
    
    /**
     * Depth-First Search (DFS) traversal
     */
    public void DFS(int startVertex) {
        boolean[] visited = new boolean[vertices];
        System.out.print("DFS Traversal: ");
        DFSUtil(startVertex, visited);
        System.out.println();
    }
    
    private void DFSUtil(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(vertex + " ");
        
        for (int neighbor : adjacencyList[vertex]) {
            if (!visited[neighbor]) {
                DFSUtil(neighbor, visited);
            }
        }
    }
    
    /**
     * Check if there is a path between two vertices
     */
    public boolean hasPath(int source, int destination) {
        if (source == destination) {
            return true;
        }
        
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();
        
        visited[source] = true;
        queue.add(source);
        
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            
            for (int neighbor : adjacencyList[vertex]) {
                if (neighbor == destination) {
                    return true;
                }
                
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        
        return false;
    }
    
    /**
     * Display the graph
     */
    public void display() {
        System.out.println("\nGraph Adjacency List:");
        for (int i = 0; i < vertices; i++) {
            System.out.print("Vertex " + i + " -> ");
            for (int neighbor : adjacencyList[i]) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        System.out.println("Graph Implementation Demo\n");
        
        // Create an undirected graph with 5 vertices
        Graph graph = new Graph(5, false);
        
        // Add edges
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        
        graph.display();
        
        System.out.println();
        graph.BFS(0);
        graph.DFS(0);
        
        System.out.println("\nPath exists between 0 and 3: " + graph.hasPath(0, 3));
        System.out.println("Path exists between 0 and 4: " + graph.hasPath(0, 4));
        
        // Create a directed graph
        System.out.println("\n\nDirected Graph Demo:");
        Graph directedGraph = new Graph(4, true);
        
        directedGraph.addEdge(0, 1);
        directedGraph.addEdge(0, 2);
        directedGraph.addEdge(1, 2);
        directedGraph.addEdge(2, 0);
        directedGraph.addEdge(2, 3);
        directedGraph.addEdge(3, 3);
        
        directedGraph.display();
        
        System.out.println();
        directedGraph.BFS(2);
        directedGraph.DFS(2);
    }
}
