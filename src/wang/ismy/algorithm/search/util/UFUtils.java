package wang.ismy.algorithm.search.util;

import wang.ismy.algorithm.search.find.Findable;
import wang.ismy.algorithm.sort.util.SortUtils;

import java.util.Random;

/**
 * @author MY
 * @date 2020/2/11 15:06
 */
public class UFUtils {

    public static void test(String name, Findable findable,int n){
        Random random = new Random();
        long time = System.nanoTime();
        for (int i = 0; i < n; i++) {
            findable.union(random.nextInt(n),random.nextInt(n));
        }
        long consumes = System.nanoTime() - time;
        double v = consumes / 100_0000000.00;
        System.out.println(name+"测试完成，耗时"+v+"s");
    }
}
