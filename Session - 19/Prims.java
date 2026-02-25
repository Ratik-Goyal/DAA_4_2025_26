import java.util.*;
public class Prims {

    int spanningTree(int V, int[][] edges) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (int[] e : edges) {
            adj.get(e[0]).add(new int[]{e[1], e[2]});
            adj.get(e[1]).add(new int[]{e[0], e[2]});
        }

        boolean[] vis = new boolean[V];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        pq.add(new int[]{0, 0});
        int sum = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int w = cur[0];
            int u = cur[1];

            if (vis[u]) continue;

            vis[u] = true;
            sum += w;

            for (int[] v : adj.get(u)) {
                if (!vis[v[0]]) {
                    pq.add(new int[]{v[1], v[0]});
                }
            }
        }

        return sum;
    }
}