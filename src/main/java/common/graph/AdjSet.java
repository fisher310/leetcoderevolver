package common.graph;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author lihailong
 * @since 2021/1/23 0023
 */
public class AdjSet {

    private int V;
    private int E;
    private List<TreeSet<Integer>> adj;

    public AdjSet(String filename) {

        File file = new File(filename);
        try (Scanner scanner = new Scanner(file)) {
            V = scanner.nextInt();
            adj = new ArrayList<>(V);
            for (int i = 0; i < V; i++) {
                adj.add(new TreeSet<>());
            }
            E = scanner.nextInt();

            for (int i = 0; i < E; i++) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                adj.get(a).add(b);
                adj.get(b).add(a);
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
            for (int v : adj.get(i)) {
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
        return adj.get(i).contains(j);
    }

    public int degree(int v) {
        return adj.get(v).size();
    }

    public Iterable<Integer> adj(int v) {
        return adj.get(v);
    }

    public static void main(String[] args) {
        AdjSet m = new AdjSet("data/g.txt");
        System.out.println(m);
    }
}
