package com.company.Graphs;

public class GraphClient {

    public static void main(String[] args) {

        AdjacencyList graph = new AdjacencyList();

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");

//        graph.addVertex("E");
//        graph.addVertex("F");


        graph.addEdge("A","B");
        graph.addEdge("B","D");
        graph.addEdge("A","C");
        graph.addEdge("C","D");

        System.out.println(graph.bipartite());
        
//        graph.addEdge("E", "F");
//
//        System.out.println(graph.isConnected());
////        graph.BFT();
//        System.out.println(graph.connectedComponents());
//        graph.DFT();
//        graph.display();
    }
}
