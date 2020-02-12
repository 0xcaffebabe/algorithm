package wang.ismy.algorithm.graph;

/**
 * 图的抽象接口
 * @author MY
 * @date 2020/2/12 10:55
 */
public interface Graph {

    int E();

    int V();

    void addEdge(int v,int w);

    boolean hasEdge(int v,int w);

    GraphIterator iterator(int v);
}
