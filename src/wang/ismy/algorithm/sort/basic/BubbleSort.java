package wang.ismy.algorithm.sort.basic;

import wang.ismy.algorithm.sort.Sortable;

import static wang.ismy.algorithm.sort.util.SortUtils.*;

/**
 * @author MY
 * @date 2020/2/8 9:48
 */
public class BubbleSort implements Sortable {
    @Override
    public void sort(Comparable<?>[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < a.length - i; j++) {
                if (less(a[i],a[j])){
                    swap(a,i,j);
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arr = genRndIntArr(50000,50,100);
        Integer[] arr1 = copyIntArr(arr);
        Integer[] arr2 = copyIntArr(arr);
        test("冒泡排序",new BubbleSort(),arr);
        test("选择排序",new SelectionSort(),arr1);
        test("改进的插入排序",new InsertionSort2(),arr2);
    }
}
