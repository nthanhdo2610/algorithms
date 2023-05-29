package miu.edu.algorithms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(10, Comparator.reverseOrder());
        pq.addAll(Arrays.asList(2,6,1,4,6,2,8,0));
        while(!pq.isEmpty()){
            System.out.println(pq.poll());
        }
    }
}
