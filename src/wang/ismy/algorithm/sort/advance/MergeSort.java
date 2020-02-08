package wang.ismy.algorithm.sort.advance;

import wang.ismy.algorithm.sort.Sortable;
import wang.ismy.algorithm.sort.basic.InsertionSort2;

import static wang.ismy.algorithm.sort.util.SortUtils.*;

/**
 * @author MY
 * @date 2020/2/8 10:49
 */
public class MergeSort implements Sortable {
    @Override
    public void sort(Comparable<?>[] a) {
        mergeSort(a, 0, a.length - 1);
    }

    private void mergeSort(Comparable<?>[] a, int l, int r) {
        if (r>=l) {
            return;
        }
        int mid = (l + r) / 2;
        mergeSort(a, l, mid);
        mergeSort(a, mid + 1, r);
        if (greater(a[mid],a[mid+1])){
            merge(a, l, mid, r);
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
        Integer[] arr1 = genRndIntArr(10000, 0, 5000);
        Integer[] arr2 = copyIntArr(arr1);

        test("归并排序", new MergeSort(), arr1);
        test("改进的插入排序", new InsertionSort2(), arr2);
    }


}
