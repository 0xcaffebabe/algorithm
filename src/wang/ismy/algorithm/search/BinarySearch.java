package wang.ismy.algorithm.search;

import wang.ismy.algorithm.sort.advance.MergeSort;
import wang.ismy.algorithm.sort.advance.QuickSort;

import java.util.Random;

import static wang.ismy.algorithm.sort.util.SortUtils.*;
import static wang.ismy.algorithm.search.util.SearchUtils.*;
/**
 * @author MY
 * @date 2020/2/10 8:45
 */
public class BinarySearch implements Searchable{

    public int search(Comparable<?>[] a, Comparable<?> target) {
        new QuickSort().sort(a);
        int l = 0, r = a.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (a[mid].equals(target)) {
                return mid;
            }

            if (less(target, a[mid])) {// 要查找的元素在左边
                r = mid - 1;
            } else if (greater(target, a[mid])) { // 要查找的元素在右边
                l = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Integer[] a = genRndIntArr(10_0000,0,10_0000);
        new QuickSort().sort(a);
        test("二分查找",a,new BinarySearch(),a[new Random().nextInt(10_0000)]);
    }
}
