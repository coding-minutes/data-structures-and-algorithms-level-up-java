package com.company.Heaps;

import java.util.*;

public class heap_cabs {

    class Car{
    String id;
    int x,y;
    Car(String id,int x,int y){
        this.id = id;
        this.x = x;
        this.y = y;
    }

    final Integer dist() {
        return x*x + y*y; //square of the dist
    }
};

static class CarCompare implements Comparator<Car> {


    @Override
    public int compare(Car o1, Car o2) {
        return - (o1.dist().compareTo(o2.dist()));
    }
};


public static void printNearestCars(Vector<Car> cars, int k){

    PriorityQueue<Car> max_heap = new PriorityQueue<>(new CarCompare());

    for (int i = 0; i < k; i++) {
        max_heap.add(cars.get(i));
    }
    //create a max heap of size


        //remaining cars
        for(int i=k; i < cars.size();i++){
        Car car = cars.get(i);

        if(car.dist() < max_heap.peek().dist()){
        max_heap.peek(); //remove the root node largest
        max_heap.add(car);
        }
        }

        //print all the cars inside the heap they will be smallest
        Vector<Car> output = new Vector<>();
        while(!max_heap.isEmpty()){
        //cout<< max_heap.top().id <<endl;
        output.add(max_heap.peek());
        max_heap.remove();
        }

        //vector of k nearest cars
       Collections.reverse(output);

        for(Car car : output){
            System.out.println(car.id);
        }
}

}
