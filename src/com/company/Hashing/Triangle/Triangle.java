package com.company.Hashing.Triangle;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;

public class Triangle {


    static class Pair<K,V>{

        int value1;
        int value2;

        public Pair(int value1, int value2) {
            this.value1 = value1;
            this.value2 = value2;
        }
    }

    public static int count_triangles(Vector<Pair<Integer,Integer> > points){

        HashMap<Integer,Integer> freq_x = new HashMap<>();
        HashMap<Integer, Integer> freq_y= new HashMap<>();

        //Count the freq by iterating over all the points
        for(Pair<Integer,Integer> p:points){
            int x = p.value1;
            int y = p.value2;
            if (freq_x.containsKey(x)) {
                freq_x.put(x, freq_x.get(x)+1);
            } else {
                freq_x.put(x, 1);
            }

            if (freq_y.containsKey(y)) {
                freq_y.put(y, freq_y.get(y)+1);
            } else {
                freq_y.put(y, 1);
            }
        }


        //count
        int count = 0;
        for(Pair p:points){
            int x = p.value1;
            int y = p.value2;

            int fx = freq_x.getOrDefault(x, 0);
            int fy = freq_y.getOrDefault(y, 0);

            count += (fx-1)*(fy-1);
        }
        return count;

    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        Vector<Pair<Integer,Integer>> vc = new Vector<>();
        for (int i = 0; i <n; i++) {

            int a = s.nextInt();
            int b =s.nextInt();

            vc.add(new Pair<>(a,b));

        }

        System.out.println(count_triangles(vc));

    }

}
