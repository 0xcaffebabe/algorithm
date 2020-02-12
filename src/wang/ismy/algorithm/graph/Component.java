package wang.ismy.algorithm.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * @author MY
 * @date 2020/2/12 10:55
 */
public class Component {

    private Graph graph;
    private boolean[] visited;
    private int[] id;
    private int count;
    private Queue<Integer> queue = new LinkedList<>();

    public Component(Graph graph) {
        this.graph = graph;
        visited = new boolean[graph.V()];
        id = new int[graph.V()];
        Arrays.fill(visited, false);
        Arrays.fill(id, -1);
        for (int i = 0; i < graph.V(); i++) {
            // 对每个节点进行深度优先遍历
            if (!visited[i]) {
                dfs(i);
                count++;
            }
        }
    }

    public boolean isConnected(int v, int w) {
        assert v >= 0 && v < graph.V();
        assert w >= 0 && w < graph.V();
        return id[v] == id[w];
    }

    private void dfs(int v) {
        visited[v] = true;
        id[v] = count;
        // 对传进来的节点所连接的节点再进行DFS
        GraphIterator iterator = graph.iterator(v);
        for (int i = iterator.begin(); !iterator.end(); i = iterator.next()) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }

    public void bfs(int v) {
        if (queue.contains(v)){
            return;
        }
        queue.add(v);
        GraphIterator iterator = graph.iterator(v);
        for (int w = iterator.begin(); !iterator.end(); w = iterator.next()) {
            bfs(v);
        }
    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) {
        int n = 1000;
        DenseGraph graph = new DenseGraph(n, false);
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            graph.addEdge(random.nextInt(n), random.nextInt(n));
        }
        Component component = new Component(graph);
        component.bfs(0);
        System.out.println(component);
    }
}
