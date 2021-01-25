package common.graph;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author lihailong
 * @since 2021/1/22 0022
 */
public class AdjMatrix {

    private int V;
    private int E;
    private int[][] adj;

    public AdjMatrix(String filename) {

        File file = new File(filename);
        try (Scanner scanner = new Scanner(file)) {
            V = scanner.nextInt();
            adj = new int[V][V];
            E = scanner.nextInt();

            for (int i = 0; i < E; i++) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                adj[a][b] = 1;
                adj[b][a] = 1;
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
            for (int j = 0; j < V; j++) {
                sb.append(String.format("%d ", adj[i][j]));
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
        return adj[i][j] == 1;
    }

    public int degree(int v) {
        return adj(v).size();
    }

    public List<Integer> adj(int v) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (adj[v][i] == 1) {
                res.add(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        AdjMatrix m = new AdjMatrix("data/g.txt");
        System.out.println(m);
    }
}
