package wang.ismy.algorithm.sort;

import static wang.ismy.algorithm.sort.util.SortUtils.*;


/**
 * 改进的插入排序
 *
 * @author MY
 * @date 2020/2/8 9:31
 */
public class InsertionSort2 implements Sortable {
    @Override
    public void sort(Comparable<?>[] a) {
        for (int i = 1; i < a.length; i++) {
            var e = a[i];
            int j;
            for (j = i; j > 0 && greater(a[j - 1], e); j--) {
                // 将
                a[j]=a[j-1];
            }
            a[j]=e;
        }
    }

    public static void main(String[] args) {
        int size=50000;
        Integer[] arr1 = genRndIntArr(size, 50, 100);
        Integer[] arr2 = copyIntArr(arr1);
        Integer[] arr3 = copyIntArr(arr1);
        test("选择排序",new SelectionSort(),arr1);
        test("插入排序",new InsertionSort(),arr2);
        test("改进的插入排序",new InsertionSort2(),arr3);
    }
}
