# Graph Data Structure & Algorithms in Java

This project demonstrates a custom implementation of a **Graph Data Structure** in Java. It is built from scratch, including manual implementations of helper structures like **Stack** and **Queue**, to demonstrate a deep understanding of core algorithmic concepts without relying heavily on Java's built-in collections framework.

## 🚀 Features

The project includes the following functionalities:

* **Graph Representation:** Adjacency List implementation using linked nodes.
* **Traversal Algorithms:**
    * **BFS (Breadth-First Search):** Iterative implementation using a custom Queue.
    * **DFS (Depth-First Search):** Iterative implementation using a custom Stack.
* **Analysis Methods:**
    * `inDegree(id)` & `outDegree(id)` calculation.
    * `isAdjacent(v1, v2)` check.
    * Adjacency Matrix generation.
    * Cycle detection logic.
    * **Topological Sort:** Sorting algorithm for directed acyclic graphs.
* **Custom Data Structures:**
    * `MyStack`: A generic LIFO stack implementation.
    * `MyQueue`: A generic FIFO queue implementation.

## 📂 Project Structure

* `Graph.java`: The main graph logic and algorithms.
* `Vertex.java`: Represents the nodes in the graph.
* `Edge.java`: Represents the connections between nodes.
* `MyStack.java` & `MyQueue.java`: Helper data structures.
* `GraphsTrain.java`: Main class to run and test the implementation.

## 🛠️ Usage

You can run the `GraphsTrain.java` file to see the algorithms in action.

```java
// Example usage from the main class
Graph<Integer> graf = new Graph();

// Adding Vertices
graf.addVertex(1);
graf.addVertex(2);
// ...

// Adding Edges
graf.addEdge(1, 2);
graf.addEdge(1, 3);

// Running Traversals
graf.breadthFirstSearch(1); // Output: BFS traversal path
graf.depthFirstSearch(1);   // Output: DFS traversal path
