package wang.ismy.algorithm.sort.advance;

import wang.ismy.algorithm.heap.MaxHeap;
import wang.ismy.algorithm.sort.Sortable;

import static wang.ismy.algorithm.sort.util.SortUtils.*;
/**
 * @author MY
 * @date 2020/2/9 10:36
 */
public class HeapSort implements Sortable {

    @Override
    public void sort(Comparable<?>[] a) {
        MaxHeap<Comparable<?>> heap = new MaxHeap<>(a.length+1);
        for (int i = 0; i < a.length; i++) {
            heap.insert(a[i]);
        }
        for (int i = 0; i < a.length; i++) {
            a[i]=heap.remove();
        }
    }

    public static void main(String[] args) {
        Integer[] arr1 = genRndIntArr(100_0000,0,100);
        Integer[] arr2 = copyIntArr(arr1);

        test("归并排序",new MergeSort(),arr1);
        test("堆排序",new HeapSort(),arr2);
    }
}
