package wang.ismy.algorithm.sort;
import java.time.temporal.ValueRange;

import static wang.ismy.algorithm.sort.util.SortUtils.*;
/**
 * @author MY
 * @date 2020/2/8 10:13
 */
public class ShellSort implements Sortable {
    @Override
    public void sort(Comparable<?>[] a) {
        int h = 1;
        // 计算增长序列，1,4，13,40...
        while (h < a.length / 3) {
            h = 3 * h + 1;
        }
        while (h>=1){
            for (int i = h; i < a.length; i++) {
                // 对第i,i-h,i-2*h,i-3*h进行插入排序
                var e = a[i];
                int j;
                for (j = i; j > h && less(a[j - h], e); j-=h) {
                    a[j]=a[j-h];
                }
                a[j]=e;
            }
            h/=3;
        }
    }

    public static void main(String[] args) {
        Integer[] arr= genRndIntArr(100,0,100);
        Integer[] arr1=copyIntArr(arr);
        test("希尔排序",new ShellSort(),arr);
        test("改进后的插入排序",new InsertionSort2(),arr1);
    }
}
