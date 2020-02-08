package wang.ismy.algorithm.sort;

import static wang.ismy.algorithm.sort.util.SortUtils.*;

/**
 * @author MY
 * @date 2020/2/8 9:48
 */
public class BubbleSort2 implements Sortable {
    @Override
    public void sort(Comparable<?>[] a) {
        for (int i = 1; i < a.length; i++) {
            int lastSwap = 1;
            for (int j = 0; j < a.length - i && j < lastSwap; j++) {
                if (less(a[i], a[j])) {
                    swap(a, i, j);
                    // 记录最后一次交换的位置，该位置后的元素在下一轮扫描后不会被扫描
                    lastSwap = j;
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arr = genRndIntArr(100000, 0, 10000);
        Integer[] arr2 = copyIntArr(arr);
        test("冒泡排序", new BubbleSort2(), arr);
        test("改进的冒泡排序", new BubbleSort2(), arr2);
    }
}
