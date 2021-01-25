package common.graph;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 空间复杂度 O(V + E)
 *
 * 时间复杂度：
 *   建图: O(E * V)  最坏的情况下，每个点都和其他节点连接, 开销要大于 邻接矩阵
 *   查看两点是否相邻 O(Degree(V))
 *   求一个点的相邻节点 O(Degree(V))
 * 使用红黑树 TreeSet O(log(V))
 *  红黑树保持节点顺序
 *  红黑树更节省空间
 *
 * @author lihailong
 * @since 2021/1/23 0023
 */
public class AdjList {

    private int V;
    private int E;
    private LinkedList<Integer>[] adj;

    public AdjList(String filename) {

        File file = new File(filename);
        try (Scanner scanner = new Scanner(file)) {
            V = scanner.nextInt();
            adj = new LinkedList[V];
            for (int i = 0; i < V; i++) {
                adj[i] = new LinkedList<>();
            }
            E = scanner.nextInt();

            for (int i = 0; i < E; i++) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                adj[a].add(b);
                adj[b].add(a);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("V = %d, E = %d\n", V, E));
        for (int i = 0; i < V; i++) {
            sb.append(i).append(": ");
            for (int v : adj[i]) {
                sb.append(String.format("%d ", v));
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    public int V() {
        return this.V;
    }

    public int E() {
        return this.E;
    }

    public boolean hasEdge(int i, int j) {
        return adj(i).contains(j);
    }

    public int degree(int v) {
        return adj(v).size();
    }

    public List<Integer> adj(int v) {
        return adj[v];
    }

    public static void main(String[] args) {
        AdjList m = new AdjList("data/g.txt");
        System.out.println(m);
    }
}
