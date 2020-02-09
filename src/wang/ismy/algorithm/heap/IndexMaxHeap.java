package wang.ismy.algorithm.heap;

import java.util.Arrays;
import java.util.Random;

import static wang.ismy.algorithm.heap.util.HeapUtils.*;

/**
 * @author MY
 * @date 2020/2/9 9:04
 */
public class IndexMaxHeap<T extends Comparable<?>> {

    private Object[] data;
    private int[] indexes;
    private int[] rev;
    private int count;
    private int capacity;

    public IndexMaxHeap(int capacity) {
        data = new Object[capacity + 1];
        indexes = new int[capacity + 1];
        rev = new int[capacity + 1];
        Arrays.fill(rev, 0);
        count = 0;
        this.capacity = capacity;
    }

    /**
     * @param i 从0开始
     * @param e 被插入的元素
     */
    public void insert(int i, T e) {
        assert count + 1 <= capacity;
        assert i + 1 >= 1 && i + 1 <= capacity;
        i += 1;
        data[i] = e;
        indexes[++count] = i;
        rev[i] = count;
        shiftUp(count);
    }

    public int remove() {
        assert count > 0;

        int ret = indexes[1] - 1;
        swap(data, indexes[1], indexes[count]);
        rev[indexes[1]] = 1;
        rev[indexes[count]] = 0;
        count--;
        shiftDown(1);
        return ret;
    }

    public T get(int i) {
        assert contains(i);
        return (T) data[i + 1];
    }

    public void change(int i, T e) {
        assert contains(i);
        i += 1;
        data[i] = e;
        // 找到indexes[j]=i j表示data[i]在堆中的位置
        int j = rev[i];
        shiftUp(j);
        shiftDown(j);
    }

    private boolean contains(int i) {
        return rev[i + 1] != 0;
    }

    private void shiftDown(int k) {
        while (2 * k <= count) {
            int j = 2 * k;
            // 确定要跟左子树比较还是跟右子树
            if (j + 1 <= count && greater(data, indexes[j + 1], indexes[j])) {
                // 右子树
                j++;
            }
            // 如果自己大于要比较的子树，则停止
            if (greaterThan(data, indexes[k], indexes[j])) {
                break;
            }
            swap(data, indexes[k], indexes[j]);
            rev[indexes[k]] = k;
            rev[indexes[j]] = j;
            k = j;
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
        while (less(data, indexes[i / 2], indexes[i])) {
            swap(data, indexes[i / 2], indexes[i]);
            rev[indexes[i / 2]] = i / 2;
            rev[indexes[i]] = i;
            i /= 2;
        }
    }

    public static void main(String[] args) {
        IndexMaxHeap<String> heap = new IndexMaxHeap<>(100);
        for (int i = 1; i < 50; i++) {
            heap.insert(i,i+"");
        }
        for (int i = 1; i < 50; i++) {
            int j = heap.remove();
            System.out.println(j+":"+heap.get(j));
        }

    }
}
