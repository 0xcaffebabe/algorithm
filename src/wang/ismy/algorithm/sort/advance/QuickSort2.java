package wang.ismy.algorithm.sort.advance;

import wang.ismy.algorithm.sort.Sortable;
import wang.ismy.algorithm.sort.basic.InsertionSort2;
import wang.ismy.algorithm.sort.basic.SelectionSort;
import wang.ismy.algorithm.sort.basic.ShellSort;

import static wang.ismy.algorithm.sort.util.SortUtils.*;

/**
 * 改进的快速排序
 *
 * @author MY
 * @date 2020/2/8 14:24
 */
public class QuickSort2 implements Sortable {
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

    private int partition(Comparable<?>[] a, int l, int r) {
        var v = a[l];

        // i:a[l+1...i] <=v  j:[j...r] >=v
        int i = l + 1, j = r;
        while (true) {
            while (i <= r && less(a[i], v)) i++;
            while (j >= l + 1 && greater(a[j], v)) j--;
            if (i > j) {
                break;
            } else {
                swap(a, i, j);
                i++;j--;
            }
        }
        swap(a,l,j);
        return j;
    }

    public static void main(String[] args) {
        Integer[] arr1 = genRndIntArr(100_0000,0,100_0000);
        Integer[] arr2 = copyIntArr(arr1);
        test("快速排序",new QuickSort(),arr1);
        test("改进的快速排序",new QuickSort2(),arr2);
    }

}
