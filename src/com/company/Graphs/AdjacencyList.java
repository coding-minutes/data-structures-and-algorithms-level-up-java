package com.company.Graphs;


import java.util.*;

public class AdjacencyList {

    LinkedList<Vertex> vertices = new LinkedList<>();

    public void addVertex(String value){

        vertices.add(new Vertex(value));
    }

    public void addEdge(String first, String second){

        Vertex f = get(first);
        Vertex s = get(second);

        if(f!=null && s!=null){
            f.neighbours.add(s);
            s.neighbours.add(f);
        }
    }


    public Vertex get(String value){

        for (Vertex vertex: vertices) {

            if(vertex.value.equals(value)){
                return vertex;
            }
        }

        return null;
    }

    public void display(){

        for (Vertex vertex: vertices) {

            System.out.print( vertex.value + " => ");

            for (Vertex padosi: vertex.neighbours) {

                System.out.print(padosi.value + " ");
            }
            System.out.println();
        }
    }

    public void DFT(){

        Stack<Vertex> stack= new Stack<>();

        Set<Vertex> visited = new HashSet<>();

        Vertex vertex = vertices.get(0);

        visited.add(vertex);
        stack.add(vertex);

        while(!stack.isEmpty()){

            Vertex temp = stack.pop();
            System.out.println(temp.value);

            for (Vertex padosi: temp.neighbours) {

                if(!visited.contains(padosi)){
                    stack.add(padosi);
                    visited.add(padosi);
                }
            }
        }
    }

    public void BFT(){

        Queue<Vertex> queue = new LinkedList<>();

        Set<Vertex> visited = new HashSet<>();

        Vertex vertex = vertices.get(0);

        visited.add(vertex);
        queue.add(vertex);

        while(!queue.isEmpty()){

            Vertex temp = queue.remove();
//            System.out.println(temp.value);

            for (Vertex padosi: temp.neighbours) {

                if(!visited.contains(padosi)){
                    queue.add(padosi);
                    visited.add(padosi);
                }
            }
        }
    }

    public int connectedComponents(){

        Queue<Vertex> queue = new LinkedList<>();

        Set<Vertex> visited = new HashSet<>();

        int cnt = 0;

        for (Vertex vertex: vertices) {

            if(visited.contains(vertex)){
                continue;
            }
            cnt = cnt + 1;
//            System.out.println();

            visited.add(vertex);
            queue.add(vertex);

        while(!queue.isEmpty()) {

            Vertex temp = queue.remove();
//            System.out.println(temp.value);

            for (Vertex padosi : temp.neighbours) {

                if (!visited.contains(padosi)) {
                    queue.add(padosi);
                    visited.add(padosi);
                }
            }
        }

        }

        return cnt;
    }

    public boolean isConnected(){

        return connectedComponents() <= 1;
    }

    public boolean BFS (String value){

        Queue<Vertex> queue = new LinkedList<>();

        Set<Vertex> visited = new HashSet<>();

        Vertex vertex = vertices.get(0);

        visited.add(vertex);
        queue.add(vertex);

        while(!queue.isEmpty()){

            Vertex temp = queue.remove();
//            System.out.println(temp.value);

            if(temp.value.equals(value)){
                return true;
            }


            for (Vertex padosi: temp.neighbours) {

                if(!visited.contains(padosi)){
                    queue.add(padosi);
                    visited.add(padosi);
                }
            }
        }
        return false;
    }


    public boolean bipartite(){

        Set<Vertex> red = new HashSet<>();
        Set<Vertex > green = new HashSet<>();

        Set<Vertex> visited = new HashSet<>();

        Queue<Vertex> queue = new LinkedList<>();

        Vertex vertex = vertices.get(0);
        visited.add(vertex);
        queue.add(vertex);
        red.add(vertex);

        while(!queue.isEmpty()){

            Vertex temp = queue.remove();

            if (red.contains(temp)){

            for (Vertex padosi: temp.neighbours) {

                if (!visited.contains(padosi)) {

                    queue.add(padosi);
                    green.add(padosi);
                    visited.add(padosi);
                }

                else {
                    if(red.contains(padosi)){
                        return false;
                    }
                }
            }
            }

            if (green.contains(temp)){
                for (Vertex padosi: temp.neighbours) {

                    if (!visited.contains(padosi)) {

                        queue.add(padosi);
                        red.add(padosi);
                        visited.add(padosi);
                    }

                    else {

                        if(green.contains(padosi)){
                            return false;
                        }
                    }
                }
            }
        }

        return true;

    }


    class Vertex{

        String value;
        LinkedList<Vertex> neighbours;

        public Vertex(String value) {
            this.value = value;
            neighbours = new LinkedList<>();
        }
    }
}
