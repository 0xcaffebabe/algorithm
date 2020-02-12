package wang.ismy.algorithm.search.find;

/**
 * 并查集
 *
 * @author MY
 * @date 2020/2/11 14:19
 */
public class UnionFind2 implements Findable {

    private int[] parent;
    private int count;

    public UnionFind2(int n) {
        parent = new int[n];
        count = n;
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
    }

    public int find(int p) {
        assert p >= 0 && p < count;
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }

    public boolean isConnected(int p,int q){
        return find(p) == find(q);
    }

    public void union(int p,int q){
        int qRoot = find(p);
        int pRoot = find(q);
        if (qRoot == pRoot){
            return;
        }
        parent[pRoot]=qRoot;
    }
}
