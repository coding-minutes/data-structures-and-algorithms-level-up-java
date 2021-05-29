package com.company.Graphs;

import com.company.Heaps.Heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Adjacencymap<T> {

    HashMap<T,Vertex> vertexMap = new HashMap<>();
    HashMap<Vertex,Vertex> parent = new HashMap<>();

    public void addVertex(T value){

        vertexMap.put(value, new Vertex(value));
    }

    public void addEdge(T first, T second){

        if(vertexMap.containsKey(first) && vertexMap.containsKey(second)){

            Vertex f = vertexMap.get(first);
            Vertex s = vertexMap.get(second);
            f.neighbours.put(s,1);
            s.neighbours.put(f,1);
        }
    }

    public void addEdge(T first, T second, int weight){

        if(vertexMap.containsKey(first) && vertexMap.containsKey(second)){

            Vertex f = vertexMap.get(first);
            Vertex s = vertexMap.get(second);
            f.neighbours.put(s,weight);
            s.neighbours.put(f,weight);
        }
    }



    public void display(){

        for (Vertex vertex: vertexMap.values()) {

            System.out.print(vertex.value + " => ");

            for (Vertex padosi: vertex.neighbours.keySet()) {

                System.out.print(padosi.value + " ");
            }
            System.out.println();
        }

        System.out.println();
    }

    public Adjacencymap<T> Kruskal(){

        setparent();

        Adjacencymap<T> finalmap = new Adjacencymap<>();

        ArrayList<Edge> edges = new ArrayList<>();

        for (T vertex: vertexMap.keySet()) {
            finalmap.addVertex(vertex);
        }

        for (Vertex vertex: vertexMap.values()) {

            for (Vertex padosi: vertex.neighbours.keySet()) {

                edges.add(new Edge(vertex,padosi, vertex.neighbours.get(padosi)));
            }
        }

        Collections.sort(edges);

        for (Edge e: edges) {

            if(union(e.first,e.second)){

                finalmap.addEdge(e.first.value,e.second.value, e.weight);
            }
        }

        return finalmap;
    }

    public boolean union(Vertex first,  Vertex second){

        Vertex f = find(first);
        Vertex s = find(second);

        if(!f.value.equals(s.value)){

            parent.put(f,s);
            return true;
        }

        return false;
    }

    public Vertex find(Vertex vertex){

        while(parent.get(vertex)!=null){
            vertex = parent.get(vertex);
        }

        return vertex;
    }

    public void setparent(){

        for (Vertex vertex: vertexMap.values()) {

            parent.put(vertex,null);
        }
    }

    class PrimsPair implements Comparable<PrimsPair>{

        T vertexname;
        T acqVertexname;

        int cost;

        @Override
        public int compareTo(PrimsPair o) {
            return this.cost - o.cost;
        }

    }

    public Adjacencymap<T> prims(){

        Adjacencymap<T> graph = new Adjacencymap<>();

        Heaps<PrimsPair> heap = new Heaps<>();

        HashMap<T, PrimsPair> map = new HashMap<>();

        // inserting all pairs in heap and map

        for (T key: vertexMap.keySet()) {

            PrimsPair np = new PrimsPair();
            np.vertexname = key;
            np.acqVertexname =null;
            np.cost = Integer.MAX_VALUE;

            heap.insert(np);
            map.put(key,np);
        }

        // for creating our graph
        while(!heap.isEmpty()){

            PrimsPair rp = heap.remove();

            map.remove(rp.vertexname);

            //adding vertex and edges acc to the scenario
            if(rp.acqVertexname ==null){

                graph.addVertex(rp.vertexname);
            }

            else{
                graph.addVertex(rp.vertexname);
                graph.addEdge(rp.vertexname,rp.acqVertexname,rp.cost);
            }

            //padosiyo ka kaam

            for (Vertex padosi: vertexMap.get(rp.vertexname).neighbours.keySet()) {

                if(map.containsKey(padosi.value)){


                    int oldcost = map.get(padosi.value).cost;

                    int newcost = vertexMap.get(rp.vertexname).neighbours.get(padosi);

                    if (newcost < oldcost){

                        PrimsPair gp = map.get(padosi.value);

                        gp.acqVertexname = rp.vertexname;

                        gp.cost = newcost;

                        heap.update(gp);

                    }
                }
            }

        }
        return graph;

    }

    class Edge implements Comparable<Edge>{

        Vertex first;
        Vertex second;
        int weight;

        public Edge(Vertex first, Vertex second, int weight) {
            this.first = first;
            this.second = second;
            this.weight = weight;
        }


        @Override
        public int compareTo(Edge o) {
            return this.weight-o.weight;
        }
    }

    class Vertex{

        T value;
        HashMap<Vertex, Integer> neighbours;

        public Vertex(T value) {
            this.value = value;
            this.neighbours = new HashMap<>();
        }
    }
}
