package wang.ismy.algorithm.sort.advance;

import wang.ismy.algorithm.heap.MaxHeap;
import wang.ismy.algorithm.sort.Sortable;
import static wang.ismy.algorithm.sort.util.SortUtils.*;
/**
 * @author MY
 * @date 2020/2/9 10:51
 */
public class HeapSort2 implements Sortable {
    @Override
    public void sort(Comparable<?>[] a) {
        MaxHeap<Comparable<?>> heap = new MaxHeap<>(a);

        for (int i = 0; i < a.length; i++) {
            a[i]=heap.remove();
        }
    }

    public static void main(String[] args) {
        Integer[] arr1 = genRndIntArr(100_0000,0,100_0000);
        Integer[] arr2 = copyIntArr(arr1);
        test("堆排序",new HeapSort(),arr1);
        test("改进的堆排序",new HeapSort(),arr2);
    }
}
