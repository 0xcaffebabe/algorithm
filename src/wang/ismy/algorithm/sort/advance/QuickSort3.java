package wang.ismy.algorithm.sort.advance;

import wang.ismy.algorithm.sort.Sortable;

import static wang.ismy.algorithm.sort.util.SortUtils.*;
import static wang.ismy.algorithm.sort.util.SortUtils.test;

/**
 * @author MY
 * @date 2020/2/8 14:46
 */
public class QuickSort3 implements Sortable {
    @Override
    public void sort(Comparable<?>[] a) {
        quickSort(a, 0, a.length - 1);
    }

    private void quickSort(Comparable[] a, int l, int r) {
        if (l >= r) {
            return;
        }

        // partition
        var v = a[l];

        int lt = l; // a[l+1...lt] < v
        int gt = r + 1; // a[gt...r] > v
        int i = l + 1; // a[lt+1...i) == v
        while (i < gt) {
            if (a[i].compareTo(v) < 0) {
                swap(a, i, lt + 1);
                lt++;
                i++;
            } else if (a[i].compareTo(v) > 0) {
                swap(a, i, gt - 1);
                gt--;
            }else {
                i++;
            }
        }
        swap(a,i,lt);

        quickSort(a, l, lt - 1);
        quickSort(a, gt, r);
    }

    public static void main(String[] args) {
        Integer[] arr1 = genRndIntArr(100_00, 0, 10);
        Integer[] arr2 = copyIntArr(arr1);
        Integer[] arr3 = copyIntArr(arr1);
        test("归并排序",new MergeSortBottomUp(),arr1);
        test("改进的快速排序3", new QuickSort3(), arr3);
    }
}
