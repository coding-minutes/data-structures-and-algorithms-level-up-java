package com.company.Graphs;

import java.util.*;

public class Djikstra<E extends Comparable<E>> {
    private Map<E, Vertex> vertices = new HashMap<>();

    private class Vertex {
        E value;
        Map<Vertex, Integer> neighbours;
        public Vertex(E value) {
            this.value = value;
            this.neighbours = new HashMap<>();
        }

        public void addNeighbours(Vertex vertex, int cost) {
            this.neighbours.put(vertex, cost);
        }
    }

    private class Edge {
        Vertex start, end;
        Integer cost;
        public Edge(Vertex start, Vertex end, Integer cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }

    public void addVertex(E value) {
        if (!vertices.containsKey(value)) {
            vertices.put(value, new Vertex(value));
        }
    }

    public void addEdge(E start, E end, Integer cost) {
        Vertex s = vertices.get(start);
        Vertex e = vertices.get(end);
        if (s == null) {
            addVertex(start);
            s = vertices.get(start);
        }
        if (e == null) {
            addVertex(end);
            e = vertices.get(end);
        }
        s.addNeighbours(e, cost);
        e.addNeighbours(s, cost);
    }

    public void DFT(E start) {
        Vertex v = vertices.get(start);
        Stack<Vertex> stack = new Stack<>();
        Set<Vertex> visited = new HashSet<>();
        stack.push(v);
        visited.add(v);
        while (!stack.isEmpty()) {
            Vertex currVertex = stack.pop();
            System.out.println(currVertex.value + " ");
            for (Vertex padosi : currVertex.neighbours.keySet()) {
                if (!visited.contains(padosi)) {
                    stack.push(padosi);
                    visited.add(padosi);
                }
            }
        }
    }

    public void BFT(E start) {
        Vertex v = vertices.get(start);
        Queue<Vertex> queue = new LinkedList<>();
        Set<Vertex> visited = new HashSet<>();
        queue.add(v);
        visited.add(v);
        while (!queue.isEmpty()) {
            Vertex currVertex = queue.remove();
            System.out.println(currVertex.value + " ");
            for (Vertex padosi : currVertex.neighbours.keySet()) {
                if (!visited.contains(padosi)) {
                    queue.add(padosi);
                    visited.add(padosi);
                }
            }
        }
    }

    public Map<Vertex, Vertex> generateParents() {
        Map<Vertex, Vertex> parents = new HashMap<>();
        for(Vertex vertex : vertices.values()) {
            parents.put(vertex, null);
        }
        return parents;
    }

    private Vertex findParent(Vertex vertex, Map<Vertex, Vertex> parentMap) {
        while (parentMap.get(vertex) != null) {
            vertex = parentMap.get(vertex);
        }
        return vertex;
    }

    private boolean union(Vertex start, Vertex end, Map<Vertex, Vertex> parentMap) {
        Vertex parentStart = findParent(start, parentMap);
        Vertex parentEnd = findParent(end, parentMap);

        if (parentStart != parentEnd) {
            parentMap.put(start, parentEnd);
            return true;
        }
        return false;
    }

    public int kruskal() {
        ArrayList<Edge> list = new ArrayList<>();
        for (Vertex start : vertices.values()) {
            for (Vertex end : start.neighbours.keySet()) {
                int cost = start.neighbours.get(end);
                list.add(new Edge(start, end, cost));
            }
        }

        list.sort((o1, o2) -> o1.cost-o2.cost);

        Map<Vertex, Vertex> parentMap = generateParents();
        int totalCost = 0;
        for (Edge edge : list) {
            if (union(edge.start, edge.end, parentMap)) {
                totalCost += edge.cost;
            }
        }
        return totalCost;
    }

    public int prims() {
        Vertex start = vertices.values().iterator().next();
        Set<Vertex> visited = new HashSet<>();
        PriorityQueue<Edge> queue = new PriorityQueue<>((Comparator<Edge>) (o1, o2) -> o1.cost-o2.cost);
        visited.add(start);
        for (Vertex end : start.neighbours.keySet()) {
            int currCost = start.neighbours.get(end);
            queue.add(new Edge(start, end, currCost));
        }
        int totalCost = 0;
        while (!queue.isEmpty()) {
            Edge edge = queue.remove();
            if (!visited.contains(edge.end)) {
                totalCost += edge.cost;
                start = edge.end;
                for (Vertex end : start.neighbours.keySet()) {
                    if (!visited.contains(end)) {
                        int currCost = start.neighbours.get(end);
                        queue.add(new Edge(start, end, currCost));
                    }
                }
            }
        }
        return totalCost;
    }

    class DjPair implements Comparable<DjPair> {
        int cost;
        E connectingVertex;
        E endingVertex;

        DjPair(E connectingVertex, int cost, E endingVertex) {
            this.connectingVertex = connectingVertex;
            this.endingVertex = endingVertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(DjPair pair) {
            return this.cost - pair.cost;
        }
    }

    public void dijkstra (E source) {
        HashMap<E, DjPair> map = new HashMap<>();
        PriorityQueue<DjPair> minHeap = new PriorityQueue<>();
        Set<E> allVertices = this.vertices.keySet();

        for (E vertex : allVertices) {
            DjPair pair;
            if (vertex.equals(source)) {
                pair = new DjPair(null, 0, vertex);
            } else {
                pair = new DjPair(null, Integer.MAX_VALUE, vertex);
            }
            minHeap.add(pair);
            map.put(vertex, pair);
        }

        while (!minHeap.isEmpty()) {
            DjPair currPair = minHeap.remove();
            map.remove(currPair.endingVertex);
            System.out.println(currPair.endingVertex + " -> " + currPair.cost);
            Set<Vertex> neighbourSet = vertices.get(currPair.endingVertex).neighbours.keySet();
            for (Vertex padosi : neighbourSet) {
                if (map.containsKey(padosi.value)) {
                    DjPair pair = map.get(padosi.value);
                    int oldCost = pair.cost;
                    int edgeCost = vertices.get(currPair.endingVertex).neighbours.get(padosi);
                    int newCost = currPair.cost + edgeCost;
                    if (newCost < oldCost) {
                        minHeap.remove(map.get(padosi.value));
                        pair.cost = newCost;
                        pair.connectingVertex = currPair.endingVertex;
                        map.put(padosi.value, pair);
                        minHeap.add(pair);
                    }
                }
            }
        }
    }
}
