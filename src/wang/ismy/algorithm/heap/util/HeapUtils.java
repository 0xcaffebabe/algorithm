package wang.ismy.algorithm.heap.util;

/**
 * @author MY
 * @date 2020/2/9 9:30
 */
public class HeapUtils {

    public static boolean less(Object[] a, int i, int j) {
        Comparable e1 = (Comparable) a[i];
        Comparable e2 = (Comparable) a[j];
        if (e1 == null || e2 == null){
            return false;
        }
        return e1.compareTo(e2) < 0;
    }

    public static boolean greater(Object[] a, int i, int j) {
        Comparable e1 = (Comparable) a[i];
        Comparable e2 = (Comparable) a[j];
        if (e1 == null || e2 == null){
            return false;
        }
        return e1.compareTo(e2) > 0;
    }

    public static boolean greaterThan(Object[] a, int i, int j) {
        Comparable e1 = (Comparable) a[i];
        Comparable e2 = (Comparable) a[j];
        if (e1 == null || e2 == null){
            return false;
        }
        return e1.compareTo(e2) >= 0;
    }

    public static void swap(Object[] a, int i, int j) {
        var t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
