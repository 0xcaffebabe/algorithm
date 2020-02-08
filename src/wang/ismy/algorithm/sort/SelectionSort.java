package wang.ismy.algorithm.sort;

import static wang.ismy.algorithm.sort.util.SortUtils.*;

/**
 * @author MY
 * @date 2020/2/7 20:10
 */
public class SelectionSort {

    public static void sort(Comparable<?>[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // 寻找[i,n)里的最小值
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (less(arr[j],arr[min])) {
                    min = j;
                }
            }
            swap(arr, i, min);
        }
    }

    public static void main(String[] args) {
        Integer[] arr = genRndIntArr(100000, 10,50);
        test("selection sort",SelectionSort::sort,arr);
    }
}
