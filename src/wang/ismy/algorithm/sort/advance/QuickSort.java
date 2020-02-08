package wang.ismy.algorithm.sort.advance;

import wang.ismy.algorithm.sort.Sortable;

import static wang.ismy.algorithm.sort.util.SortUtils.*;

/**
 * @author MY
 * @date 2020/2/8 12:11
 */
public class QuickSort implements Sortable {
    @Override
    public void sort(Comparable<?>[] a) {
        quickSort(a, 0, a.length - 1);
    }

    private void quickSort(Comparable<?>[] a, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition(a, l, r);
        quickSort(a, l, p - 1);
        quickSort(a, p + 1, r);
    }

    /**
     * 返回一个p，使得a[l...p-1] < a[p] 并且 a[p+1...r] > a[p]
     *
     * @param a
     * @param l
     * @param r
     * @return
     */
    private int partition(Comparable<?>[] a, int l, int r) {
        var v = a[l];
        int j = l;
        // 从左到右扫描
        for (int i = l + 1; i <= r; i++) {
            //扫描的元素小于v，则将该元素跟大数组的第一个元素交换，同时，小数组的位置扩张1
            if (less(a[i], v)) {
                swap(a, j + 1, i);
                j++;
            }
        }
        // 最后，将v与小数组的最后一个元素交换位置
        swap(a, l, j);
        return j;
    }

    public static void main(String[] args) {
        Integer[] arr1 = genRndIntArr(100_0000,0,10);
        Integer[] arr2 = copyIntArr(arr1);

        test("归并排序",new MergeSortBottomUp(),arr1);
        test("快速排序",new QuickSort(),arr2);
    }
}
