package wang.ismy.algorithm.sort.advance;

import wang.ismy.algorithm.sort.Sortable;

import java.util.SimpleTimeZone;

import static wang.ismy.algorithm.sort.util.SortUtils.*;

/**
 * @author MY
 * @date 2020/2/8 11:39
 */
public class MergeSortBottomUp implements Sortable {
    @Override
    public void sort(Comparable<?>[] a) {
        // 每次归并的数组大小依次为1 2 4 ...
        for (int sz = 1; sz <= a.length; sz += sz) {
            for (int i = 0; i < a.length; i += sz + sz) {
                // 归并a[i...i+size-1] 与 a[i+size...i+2*size-1]
                if (i + sz < a.length) { // 只有左数组长度小于整个排序数组长度使（代表目前没有右数组），才进行归并（否则数组就是有序的了）
                    merge(a, i, i + sz - 1, min(i + sz + sz - 1, a.length - 1));
                }
            }
        }
    }

    private void merge(Comparable<?>[] a, int l, int mid, int r) {
        // 开辟一块新空间给l-r之间的元素
        Comparable<?>[] aux = new Comparable<?>[r - l + 1];
        for (int i = l; i <= r; i++) {
            aux[i - l] = a[i];
        }

        int i = l, j = mid + 1;
        // 对l到r之间的元素进行扫描，将它们放到指定位置
        for (int k = l; k <= r; k++) {
            if (i > mid) { // 如果左指针已经跑过了mid，那此时让右指针去跑
                a[k] = aux[j - l];
                j++;
            } else if (j > r) { // 如果右指针已经跑完了，则此时让左指针去跑
                a[k] = aux[i - l];
                i++;
            } else if (less(a[i - l], a[j - l])) { // 否则就比较左右两指针谁的值比较小，谁小就把谁的值复制到结果里，然后该指针往后移动
                a[k] = aux[i - l];
                i++;
            } else {
                a[k] = aux[j - l];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arr1 = genRndIntArr(10000,0,5000);
        Integer[] arr2 = copyIntArr(arr1);
        test("自顶向下的归并排序",new MergeSort(),arr1);
        test("自低向上的归并排序",new MergeSortBottomUp(),arr1);
    }
}
