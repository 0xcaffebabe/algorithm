package wang.ismy.algorithm.sort.advance;

import wang.ismy.algorithm.sort.Sortable;

import static wang.ismy.algorithm.heap.util.HeapUtils.*;
import static wang.ismy.algorithm.sort.util.SortUtils.*;

/**
 * @author MY
 * @date 2020/2/9 11:13
 */
public class HeapSort3 implements Sortable {
    @Override
    public void sort(Comparable<?>[] a) {
        int n = a.length;
        // 先将整个数组构造成一个最大堆
        for (int i = (n - 2) / 2; i >= 0; i--) {
            shiftDown(a, n, i);
        }
        // 将堆中的第一大元素移到末尾，再次构造最大堆(排除末尾排好序的元素)
        // 然后下一次循环再将第一大元素移到倒数第二个...以此类推，直至只剩一个元素
        for (int i = n - 1; i > 0; i--) {
            swap(a, 0, i);
            shiftDown(a, i, 0);
        }
    }

    private void shiftDown(Comparable[] a, int n, int k) {
        while (2 * k + 1 <= n) {
            int j = 2 * k + 1;
            // 确定要跟左子树比较还是跟右子树
            if (j + 1 < n && a[j + 1].compareTo(a[j]) > 0) {
                // 右子树
                j++;
            }
            // 如果自己大于要比较的子树，则停止
            if (a[k].compareTo(a[j]) >= 0) {
                break;
            }
            swap(a, k, j);
            k = j;
        }
    }

    public static void main(String[] args) {

        Integer[] arr1 = genRndIntArr(100_0000,0,100_0000);
        Integer[] arr2 = copyIntArr(arr1);
        Integer[] arr3 = copyIntArr(arr1);
        test("堆排序",new HeapSort(),arr1);
        test("改进的堆排序",new HeapSort(),arr2);
        test("原地堆排序",new HeapSort(),arr3);
    }

}
