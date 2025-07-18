package HeapPractice;

import java.util.ArrayList;
import java.util.List;

public class CustomHeap {
    List<Integer> list;

    public  CustomHeap() {
        list = new ArrayList<>();
    }

    int parent(int index) {
        return (index-1) / 2;
    }

    int left(int index) {
        return 2 * index + 1;
    }

    int right(int index) {
        return 2 * index + 2;
    }

    void swap(int index1, int index2) {
        int temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);
    }

    void print() {
        System.out.println(list.toString());
    }

    public void insert(int value) {
        list.add(value);
        upheap(list.size() - 1);
    }

    void upheap(int index) {
        if (index == 0) {
            return;
        }

        int parentIndex = parent(index);

        if (list.get(parentIndex) > list.get(index)) {
            swap(parentIndex, index);
            upheap(parentIndex);
        }
    }

    public int remove() {
        int removed = list.getFirst();

        int last = list.removeLast();

        if (!list.isEmpty()) {
            list.set(0, last);
            downHeap(0);
        }

        return removed;
    }

    void downHeap(int index) {
        int min = index;
        int leftIndex = left(index);
        int rightIndex = right(index);

        if (leftIndex < list.size() && list.get(min) > list.get(leftIndex)) {
            min = leftIndex;
        }

        if (rightIndex < list.size() && list.get(min) > list.get(rightIndex)) {
            min= rightIndex;
        }

        if (min != index) {
            swap(min, index);
            downHeap(min);
        }
    }

    List<Integer> heapSort() {
        List<Integer> result = new ArrayList<>();
        while (!list.isEmpty()) {
            result.add(remove());
        }
        return result;
    }

    public static void main(String[] args) {
        CustomHeap heap = new CustomHeap();
        heap.insert(12);
        heap.insert(8);
        heap.insert(10);
        heap.insert(13);
        heap.insert(11);
        heap.insert(14);
        heap.insert(7);
        heap.insert(9);

        heap.print();

        System.out.println(heap.remove());
        heap.print();

        System.out.println(heap.heapSort());
    }
}
