package Heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KWayMerge {
    public static void main(String[] args) {
        List<List<Integer>> lists = Arrays.asList(Arrays.asList(10, 15, 20, 30), Arrays.asList(2, 5, 8, 14, 24),
                Arrays.asList(0, 11, 60, 90));
        List<Integer> result = merge(lists);
        System.out.println(result);
    }

    private static List<Integer> merge(List<List<Integer>> lists) {
        //logic
        List<Integer> outPut = new ArrayList<>();
        // triplet of (value, array_index,value_index)
        PriorityQueue<Element> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.value));

        for (int i = 0; i < lists.size(); i++) {
            Element e = new Element(lists.get(i).get(0), 0, i);
            pq.offer(e);
        }

        while (!pq.isEmpty()) {
            Element peek = pq.peek();
            pq.remove();

            int elem = peek.value;
            int arrayIndex = peek.row;
            int elemIndex = peek.idx;

            outPut.add(elem);

            if (elemIndex + 1 < lists.get(arrayIndex).size()) {
                pq.offer(new Element(lists.get(arrayIndex).get(elemIndex + 1), elemIndex + 1, arrayIndex));
            }
        }

        return outPut;
    }

}

class Element {
    int value;
    int idx;
    int row;

    public Element(int value, int idx, int row) {
        this.value = value;
        this.idx = idx;
        this.row = row;
    }
}
