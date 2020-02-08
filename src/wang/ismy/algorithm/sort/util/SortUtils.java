package wang.ismy.algorithm.sort.util;

import wang.ismy.algorithm.sort.Sortable;

import java.util.Random;
import java.util.function.Consumer;

/**
 * @author MY
 * @date 2020/2/7 20:12
 */
public class SortUtils {

    public static void swap(Comparable<?>[] arr, int i, int j) {
        Comparable<?> t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static Integer[] genRndIntArr(int size, int rangeL, int rangeR) {
        if (rangeL > rangeR) {
            throw new IllegalArgumentException("rangeL 需要小于等于 rangeR");
        }
        Random random = new Random();
        Integer[] ret = new Integer[size];
        for (int i = 0; i < size; i++) {
            ret[i] = random.nextInt(rangeR) + rangeL;
        }
        return ret;
    }

    public static void print(Comparable<?>[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static boolean less(Comparable e1, Comparable e2) {
        return e1.compareTo(e2) < 0;
    }

    public static boolean greater(Comparable e1, Comparable e2) {
        return e1.compareTo(e2) > 0;
    }

    /**
     * 判断一个数组是否有序
     *
     * @param arr   数组
     * @param order 值为true代表升序，反之降序
     * @return
     */
    public static boolean isSorted(Comparable<?>[] arr, boolean order) {
        for (int i = 1; i < arr.length; i++) {
            if (order){
                if (!less(arr[i - 1], arr[i])) {
                    if (!arr[i-1].equals(arr[i])){
                        return false;
                    }
                }
            }else {
                if (!greater(arr[i - 1], arr[i])) {
                    if (!arr[i-1].equals(arr[i])){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void test(String name, Sortable sortable, Comparable<?>[] arr){
        long time = System.nanoTime();
        sortable.sort(arr);
        long consumes = System.nanoTime()-time;
        assert isSorted(arr,true);
        System.out.println(name+"测试完成，耗时："+consumes/100_0000000.00+"s,");
    }

    public static Integer[] copyIntArr(Integer[] arr){
        Integer[] ret = new Integer[arr.length];
        System.arraycopy(arr,0,ret,0,ret.length);
        return ret;
    }
}
