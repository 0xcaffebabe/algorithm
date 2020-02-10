package wang.ismy.algorithm.search;

import java.util.Random;

import static wang.ismy.algorithm.sort.util.SortUtils.*;
import static wang.ismy.algorithm.search.util.SearchUtils.*;
/**
 * 使用二分查找树查找
 * @author MY
 * @date 2020/2/10 10:11
 */
public class BSTSearch implements Searchable {
    @Override
    public int search(Comparable<?>[] a, Comparable<?> target) {
        BST<Comparable<?>,Integer> bst = new BST<>();
        for (int i = 0; i < a.length; i++) {
            bst.insert(a[i],i);
        }
        return bst.search(target);
    }


    public static void main(String[] args) {
        Integer[] a = genRndIntArr(10_00000,0,10_00000);
        Integer[] a1 = copyIntArr(a);
        Integer i = a[new Random().nextInt(10_0000)];
        test("二分查找",a,new BinarySearch(),i);
        test("二叉查找树",a1,new BSTSearch(),i);
    }
}
