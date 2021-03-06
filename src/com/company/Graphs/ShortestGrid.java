package com.company.Graphs;

import java.util.*;

public class ShortestGrid {

    static class Node{

        int x;
        int y;
        int dist;

        Node(int x,int y,int dist){
            this. x = x;
            this.y = y;
            this.dist = dist;
        }
    };

    static class Compare implements Comparator<Node>{

        @Override
        public int compare(Node o1, Node o2) {
            if(o1.dist <= o2.dist){
                return 1;
            }
            return -1;
        }
    }

    //comparator should return boolean value,
// indicating whether the element passed as
// first argument is considered to go before the second in the specific strict weak ordering



    public static int shortest_path(int[][] grid){
        //return the shortest path len

        int m = grid.length;
        int n = grid[0].length;

        int i = 0;
        int j = 0;

        //2D vector to denote of each cell
       int[][] dist = new int[m][n];

        for (int k = 0; k <=m; k++) {
            for (int l = 0; l <m ; l++) {
                dist[k][l] = Integer.MAX_VALUE;
            }
        }
        dist[i][j] = grid[0][0];
        TreeSet<Node> s = new TreeSet<>(new Compare());


        s.add(new Node(0,0,dist[0][0]));

        int dx[] = {0,0,1,-1};
        int dy[] = {1,-1,0,0};


        while(!s.isEmpty()){

            Node it = s.first();
            int cx = it.x;
            int cy = it.y;
            int cd = it.dist;
            s.remove(it);

            //update nbrs
            for(int k=0;k<4;k++){
                int nx = cx + dx[k];
                int ny = cy + dy[k];

                if(nx>=0 && nx<m && ny>=0 && ny<n && cd + grid[nx][ny] < dist[nx][ny]){
                    //remove the old node if it exist
                    Node temp = new Node(nx,ny,dist[nx][ny]);
                    if(s.contains(temp)){
                        s.remove(temp);
                    }

                    //insert the new node in the set
                    int nd = grid[nx][ny] + cd;
                    dist[nx][ny] = nd;
                    s.add(new Node(nx,ny,nd));
                }

            }

        }
        return dist[m-1][n-1];

    }

}
