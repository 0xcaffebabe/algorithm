package wang.ismy.algorithm.search.find;

/**
 * @author MY
 * @date 2020/2/11 15:07
 */
public interface Findable {

    int find(int p);

    boolean isConnected(int p,int q);

    void union(int p,int q);
}
