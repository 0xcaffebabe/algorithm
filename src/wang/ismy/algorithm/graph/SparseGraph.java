package wang.ismy.algorithm.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author MY
 * @date 2020/2/12 9:50
 */
public class SparseGraph implements Graph {
    private int n, m;
    private boolean directed;
    private List<List<Integer>> g;

    public SparseGraph(int n, boolean directed) {
        this.n = n;
        this.directed = directed;
        g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
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
        g.get(v).add(w);
        if (!directed && v != w) {
            g.get(w).add(v);
        }
        m++;
    }

    public boolean hasEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;

        for (int i = 0; i < g.get(v).size(); i++) {
            if (g.get(v).get(i).equals(w)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public GraphIterator iterator(int v) {
        return new Iterator(this, v);
    }

    public static class Iterator implements GraphIterator {
        private SparseGraph graph;
        private int v;
        private int index;

        public Iterator(SparseGraph graph, int v) {
            this.graph = graph;
            this.v = v;
        }

        public int begin() {
            index = 0;
            if (graph.g.get(v).size() == 0) {
                return -1;
            }
            return graph.g.get(v).get(0);
        }

        public int next() {
            index++;
            if (index < graph.g.get(v).size()) {
                return graph.g.get(v)
                        .get(index);
            }
            return -1;
        }

        public boolean end() {
            return index >= graph.g.get(v).size();
        }
    }

    public static void main(String[] args) {
        int n = 200;
        SparseGraph graph = new SparseGraph(n, false);
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            graph.addEdge(random.nextInt(n), random.nextInt(n));
        }
        for (int i = 0; i < n; i++) {
            Iterator iterator = new Iterator(graph, i);
            System.out.print(i + ":");
            int w = iterator.begin();
            while (!iterator.end()) {
                System.out.print(w + ",");
                w = iterator.next();
            }
            System.out.println();
        }

    }
}
