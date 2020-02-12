package wang.ismy.algorithm.graph;

import java.util.*;

/**
 * @author MY
 * @date 2020/2/12 11:21
 */
public class Path {
    private Graph graph;
    private boolean[] visited;
    private int[] from;
    private int s;

    public Path(Graph graph, int s) {
        this.graph = graph;
        this.s = s;
        visited = new boolean[graph.V()];
        from = new int[graph.V()];
        Arrays.fill(from, -1);
        dfs(s);
    }

    private void dfs(int v) {
        visited[v] = true;
        // 对传进来的节点所连接的节点再进行DFS
        GraphIterator iterator = graph.iterator(v);
        for (int i = iterator.begin(); !iterator.end(); i = iterator.next()) {
            if (!visited[i]) {
                // 当前节点的上一个节点是v
                from[i] = v;
                dfs(i);
            }
        }
    }

    public boolean hasPath(int w) {
        if (w>=0 && w<visited.length){
            return visited[w];
        }else {
            return false;
        }

    }

    public List<Integer> path(int w) {
        if (!hasPath(w)){
            return List.of();
        }
        Stack<Integer> stack = new Stack<>();
        int p = w;
        if (p != -1) {
            stack.push(p);
            p = from[p];
        }
        List<Integer> list = new ArrayList<>();
        if (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }

    public void showPath(int w) {
        List<Integer> path = path(w);
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + "->");
        }

    }

    public static void main(String[] args) {
        int n = 100;
        DenseGraph graph = new DenseGraph(n, false);
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            graph.addEdge(random.nextInt(10), random.nextInt(10));
        }
        for (int i = 0; i < n; i++) {
            GraphIterator iterator = graph.iterator(i);
            System.out.print(i+":");
            int w = iterator.begin();
            int p=-1;
            while (!iterator.end()){
                System.out.print(w+",");
                p=w;
                w= iterator.next();
            }
            System.out.println();
            Path path=new Path(graph,0);
            path.showPath(9);
            System.out.println();
        }
    }
}
