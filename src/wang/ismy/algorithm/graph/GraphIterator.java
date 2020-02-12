package wang.ismy.algorithm.graph;

/**
 * 图的迭代器抽象接口
 * @author MY
 * @date 2020/2/12 11:01
 */
public interface GraphIterator {

    int begin();

    int next();

    boolean end();
}
