package wang.ismy.algorithm.search.find;

import java.util.Arrays;

/**
 * 并查集
 *
 * @author MY
 * @date 2020/2/11 14:19
 */
public class UnionFind implements Findable{

    private int[] data;
    private int count;

    public UnionFind(int n) {
        data = new int[n];
        count = n;
        for (int i = 0; i < data.length; i++) {
            data[i] = i;
        }
    }

    public int find(int p) {
        assert p >= 0 && p < count;
        return data[p];
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p,int q){
        int pid = find(p);
        int qid = find(q);
        if (pid == qid){
            return;
        }
        for (int i = 0; i < count; i++) {
            if (data[i]==pid){
                data[i]=qid;
            }
        }
    }
}
