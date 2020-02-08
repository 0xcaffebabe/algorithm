package wang.ismy.algorithm.sort.basic;

import wang.ismy.algorithm.sort.Sortable;

import static wang.ismy.algorithm.sort.util.SortUtils.*;

/**
 * @author MY
 * @date 2020/2/8 9:05
 */
public class InsertionSort implements Sortable {

    @Override
    public void sort(Comparable<?>[] a) {
        for (int i = 1; i < a.length; i++) {
            // 从右到左扫描，如果右值小于左值，则交换，否则跳出本轮循环
            for (int j = i; j > 0; j--) {
                if (less(a[j], a[j - 1])) {
                    swap(a, j, j - 1);
                }else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int size=10000;
        Integer[] arr1 = genRndIntArr(size, 50, 100);
        Integer[] arr2 = copyIntArr(arr1);
        test("选择排序",new SelectionSort(),arr1);
        test("插入排序",new InsertionSort(),arr2);
    }
}
