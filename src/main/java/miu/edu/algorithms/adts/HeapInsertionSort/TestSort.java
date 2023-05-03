package miu.edu.algorithms.adts.HeapInsertionSort;

public class TestSort {
    static int keyComparisons = 0;

    static public void main(String[] args) {
        System.out.println("\n heapsort");
        testSort(TestSort::heapsort);
        System.out.println("\n insertionsort");
        testSort(TestSort::insertionsort);
    }

    private static interface MySort {
        void sort(Integer[] arr);
    }

    static public void testSort(MySort My) {
        Integer[] seq = {9, 6, 5, 14, 4, 12, 15, 3, 2};
        System.out.println("Original");
        print(seq);
        My.sort(seq);
        System.out.println("Sorted");
        print(seq);
        System.out.println("Key Comparisons =" + keyComparisons);
        Integer[] seq1 = {9, 6, 5, 14, 4, 12, 15, 3, 2, 25, 16, 19, 5, 14, 41, 12, 15, 3, 2, 75};
        System.out.println("Original");
        print(seq1);
        My.sort(seq1);
        System.out.println("Sorted");
        print(seq1);
        System.out.println("Key Comparisons =" + keyComparisons);
        Integer[] seq2 = {75, 71, 69, 67, 65, 63, 61, 60, 59, 57, 50, 41, 25, 15, 19, 18, 17, 16, 15, 14, 12, 10, 9, 7, 6, 5, 4, 3, 2, 1};
        System.out.println("Original");
        print(seq2);
        My.sort(seq2);
        System.out.println("Sorted");
        print(seq2);
        System.out.println("Key Comparisons =" + keyComparisons);
        Integer[] seq3 = {2, 2, 3, 3, 4, 5, 5, 6, 9, 12, 12, 14, 14, 15, 15, 16, 19, 25, 41, 50, 57, 59, 60, 61, 63, 65, 67, 69, 71, 75};
        System.out.println("Original");
        print(seq3);
        My.sort(seq3);
        System.out.println("Sorted");
        print(seq3);
        System.out.println("Key Comparisons =" + keyComparisons);
    }

    static public void insertionsort(Integer[] arr) {
        keyComparisons = 0;
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            Integer temp = arr[i];
            while (j > 0 && temp < arr[j - 1]) {
                keyComparisons = keyComparisons + 1;
                arr[j] = arr[j - 1];         // shift element to right
                j = j - 1;
            }
            if (j > 0) {
                keyComparisons = keyComparisons + 1;
            }
            arr[j] = temp;
        }
    }

    static public void heapsort(Integer[] seq) {
        // buildHeap(seq);  // build heap bottom up iteratively
        keyComparisons = 0;
        recBuildHeap(seq, 0);  // build  heap bottom up recursively
        System.out.println("Heapified");
        print(seq);
        System.out.println("Key Comparisons =" + keyComparisons);

        // sort the array
        int last = seq.length - 1;
        while (last > 0) {
            Integer maxElem = seq[0];
            seq[0] = seq[last];
            seq[last] = maxElem; // move max into its sorted position
            last--;         // decrease heap size, increase sorted size
            downHeap(seq, last, 0); // restore heap order property
        }
    }

    static public void print(Integer[] seq) {
        System.out.print("{");
        if (seq.length > 0) {
            System.out.print(seq[0]);
        }
        for (int i = 1; i < seq.length; i++) {
            System.out.print(", " + seq[i]);
        }
        System.out.println("}");
    }

    // Private Helper Methods

    static private void recBuildHeap(Integer[] seq, int next) {
        // recursive build of heap from the bottom up in O(n) time
        int last = seq.length - 1;
        if (next <= parent(last)) {
            int left = 2 * next + 1;
            int right = left + 1;
            recBuildHeap(seq, left);
            recBuildHeap(seq, right);
            downHeap(seq, last, next);
        }
    }

    static private void buildHeap(Integer[] seq) {
        // iterative build of heap from the bottom up in O(n) time
        int last = seq.length - 1;
        int next = last;
        while (next > 0) {
            downHeap(seq, last, parent(next));
            next = next - 2;
        }
    }

    static private void downHeap(Integer[] seq, int last, int index) {
        while (last != index) {
            int left = 2 * index + 1;
            int right = left + 1;
            int largest = index;
            if (left <= last && seq[largest] < seq[left]) {
                largest = left;
            }
            if (right <= last && seq[largest] < seq[right]) {
                largest = right;
            }
            keyComparisons = keyComparisons + 2;
            if (largest != index) { // swap elements and move down
                Integer temp = seq[index];
                seq[index] = seq[largest];
                seq[largest] = temp;
                index = largest;
            } else {
                index = last; // Heap order has been restored
            }
        }
    }

    static private int parent(int index) {
        return (index - 1) / 2;
    }
}
