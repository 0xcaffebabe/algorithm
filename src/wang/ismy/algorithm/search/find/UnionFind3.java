package wang.ismy.algorithm.search.find;

import static wang.ismy.algorithm.search.util.UFUtils.*;
/**
 * 并查集
 *
 * @author MY
 * @date 2020/2/11 14:19
 */
public class UnionFind3 implements Findable{

    private int[] parent;
    private int[] sz; // 以i为根的集合的元素个数
    private int count;

    public UnionFind3(int n) {
        parent = new int[n];
        sz = new int[n];
        count = n;
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            sz[i] = 1;
        }
    }

    public int find(int p) {
        assert p >= 0 && p < count;
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int qRoot = find(p);
        int pRoot = find(q);

        if (qRoot == pRoot) {
            return;
        }
        if (sz[pRoot]<sz[qRoot]){

            parent[pRoot] = qRoot;
            sz[qRoot]+=sz[pRoot];
        }else {
            parent[qRoot] = pRoot;
            sz[qRoot]+=sz[pRoot];
        }
    }

    public static void main(String[] args) {
        int n = 100000;
        test("UF1",new UnionFind(n),n);
        test("UF2",new UnionFind2(n),n);
        test("UF3",new UnionFind3(n),n);
    }
}
