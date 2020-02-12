package wang.ismy.algorithm.graph;

import java.util.Arrays;
import java.util.Random;

/**
 * @author MY
 * @date 2020/2/12 9:42
 */
public class DenseGraph implements Graph {

    // n代表顶点的数量，v代表边的数量
    private int n, m;
    private boolean directed;
    private boolean[][] g;

    public DenseGraph(int n, boolean directed) {
        this.n = n;
        this.m = 0;
        this.directed = directed;
        g = new boolean[n][n];
    }

    public int V() {
        return n;
    }

    public int E() {
        return m;
    }

    public void addEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;
        if (hasEdge(v, w)) {
            return;
        }
        g[v][w] = true;
        if (!directed) {
            g[w][v] = true;
        }
        m++;
    }

    public boolean hasEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;
        return g[v][w];
    }

    @Override
    public GraphIterator iterator(int v) {
        return new Iterator(this,v);
    }

    public static class Iterator implements GraphIterator {
        private DenseGraph graph;
        private int v;
        private int index = -1;

        public Iterator(DenseGraph graph, int v) {
            this.graph = graph;
            this.v = v;
        }

        public int begin() {
            index = -1;
            return next();
        }

        public int next() {

            for (index += 1; index < graph.V(); index++) {
                if (graph.g[v][index]) {
                    return index;
                }
            }
            return -1;
        }

        public boolean end() {
            return index >= graph.V();
        }
    }

    public static void main(String[] args) {
        int n = 200;
        DenseGraph graph = new DenseGraph(n,false);
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            graph.addEdge(random.nextInt(n),random.nextInt(n));
        }
        for (int i = 0; i < n; i++) {
            DenseGraph.Iterator iterator = new Iterator(graph,i);
            System.out.print(i+":");
            int w = iterator.begin();
            while (!iterator.end()){
                System.out.print(w+",");
                w= iterator.next();
            }
            System.out.println();
        }
    }

}
