package miu.edu.algorithms.adts.PQsort;

public class TestPQ_Sort {
    public static void sort(Integer[] seq,
                            PriorityQueue<Integer, Integer> PQ) {
        for (int i = 0; i < seq.length; i++) {
            Integer elem = seq[i];
            PQ.insertItem(elem, elem);
        }
        int i = 0;
        while (PQ.size() > 0) {
            Integer elem = PQ.removeFirst();
            seq[i] = elem;
            i++;
        }
    }

    public static void print(Integer[] arr) {
        System.out.print("[ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("]");
    }

    public static void sortTest() {
        System.out.println("ascending sort test");
        PriorityQueue<Integer, Integer> PQ
                = new PriorityQueue<Integer, Integer>();
        Integer[] arr = {9, 6, 5, 14, 4, 12, 15, 3, 2};
        print(arr);
        sort(arr, PQ);
        print(arr);
        Integer[] arr0 = {};
        sort(arr0, PQ);
        print(arr0);

        Integer[] arr1 = {5};
        sort(arr1, PQ);
        print(arr1);
        Integer[] arr2 = {5, 3};
        print(arr2);
        sort(arr2, PQ);
        print(arr2);
        Integer[] arr6 = {5, 3, 1, 8, 6, 5};
        print(arr6);
        sort(arr6, PQ);
        print(arr6);
    }

    public static void descendingSortTest() {
        System.out.println("descending sort test");
        MaxPriorityQueue<Integer, Integer> PQ
                = new MaxPriorityQueue<Integer, Integer>();
        Integer[] arr = {9, 6, 5, 14, 4, 12, 15, 3, 2};
        print(arr);
        sort(arr, PQ);
        print(arr);
        Integer[] arr0 = {};
        sort(arr0, PQ);
        print(arr0);

        Integer[] arr1 = {5};
        sort(arr1, PQ);
        print(arr1);
        Integer[] arr2 = {3, 5};
        print(arr2);
        sort(arr2, PQ);
        print(arr2);
        Integer[] arr6 = {5, 3, 1, 8, 6, 5};
        print(arr6);
        sort(arr6, PQ);
        print(arr6);
    }

    public static void main(String arg[]) {
        System.out.println();
        sortTest();
        System.out.println();
        descendingSortTest();
    }
}
