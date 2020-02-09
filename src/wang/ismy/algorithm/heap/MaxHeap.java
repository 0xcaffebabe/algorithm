package wang.ismy.algorithm.heap;

import java.util.Random;

import static wang.ismy.algorithm.heap.util.HeapUtils.*;

/**
 * @author MY
 * @date 2020/2/9 9:04
 */
public class MaxHeap<T extends Comparable<?>> {

    private Object[] data;
    private int count;
    private int capacity;

    public MaxHeap(int capacity) {
        data = new Object[capacity];
        count = 0;
        this.capacity = capacity;
    }

    public void insert(T e) {
        assert count + 1 <= capacity;
        data[++count] = e;
        shiftUp(count);
    }

    public T remove() {
        assert count > 0;
        T ret = (T) data[1];
        swap(data, 1, count);
        count--;
        shiftDown(1);
        return ret;
    }

    private void shiftDown(int k) {
        while (2 * k <= count) {
            int j =2*k;
            // 确定要跟左子树比较还是跟右子树
            if (j+1<=count && greater(data,j+1,j)){
                // 右子树
                j++;
            }
            // 如果自己大于要比较的子树，则停止
            if (greaterThan(data,k,j)){
                break;
            }
            swap(data,k,j);
            k=j;
        }
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void print() {
        for (int i = 1; i <= count; i++) {
            System.out.print(data[i] + " ");
        }
    }

    private void shiftUp(int i) {
        while (less(data, i / 2, i)) {
            swap(data, i / 2, i);
            i /= 2;
        }
    }


    public static void main(String[] args) {
        MaxHeap<Integer> heap = new MaxHeap<>(100);
        Random random = new Random();
        for (int i = 0; i < 15; i++) {
            heap.insert(random.nextInt(100));
        }
        heap.print();
        System.out.println();
        for (int i = 0; i < 15; i++) {
            System.out.print(heap.remove() + " ");
        }
    }
}
