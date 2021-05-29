package com.company.Graphs;

public class MapClient {

    public static void main(String[] args) {

        Adjacencymap<String> graph = new Adjacencymap<>();

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");

        graph.addEdge("A","D",1);
        graph.addEdge("B","D",2);
        graph.addEdge("A","C",2);
        graph.addEdge("C","D",3);


        Adjacencymap<String> map = graph.Kruskal();

        System.out.println();
        Adjacencymap<String> map2 = graph.prims();

        map.display();

        map2.display();


    }
}
