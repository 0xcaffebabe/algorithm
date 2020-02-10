package wang.ismy.algorithm.search.util;

import wang.ismy.algorithm.search.Searchable;
import wang.ismy.algorithm.search.util.SearchUtils;
import wang.ismy.algorithm.sort.util.SortUtils;

/**
 * @author MY
 * @date 2020/2/10 8:57
 */
public class SearchUtils {

    public static void test(String name, Comparable<?>[] a, Searchable searchable,Comparable<?> target){
        assert SortUtils.isSorted(a,true);
        long time = System.nanoTime();
        int index = searchable.search(a, target);
        long consumes = System.nanoTime() - time;
        double v = consumes / 100_0000000.00;
        System.out.println(name+"搜索完成，结果:"+index+" 耗时"+v+"s");
    }
}
