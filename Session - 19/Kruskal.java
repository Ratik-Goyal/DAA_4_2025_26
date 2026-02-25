import java.util.*;
public class Kruskal {
    int findUltimateParent(int node, int[] parent) {
        if (node == parent[node]) return node;
        return parent[node] = findUltimateParent(parent[node], parent);
    }

    int kruskalsMST(int V, int[][] edges) {

        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int[] e : edges) {
            pq.add(new int[]{e[2], e[0], e[1]});
        }

        int[] parent = new int[V];
        int[] size = new int[V];

        for (int i = 0; i < V; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        int ans = 0, count = 0;

        while (!pq.isEmpty() && count != V - 1) {
            int[] cur = pq.poll();
            int w = cur[0];
            int u = cur[1];
            int v = cur[2];

            int pu = findUltimateParent(u, parent);
            int pv = findUltimateParent(v, parent);

            if (pu == pv) continue;

            if (size[pu] > size[pv]) {
                parent[pv] = pu;
                size[pu] += size[pv];
            } else {
                parent[pu] = pv;
                size[pv] += size[pu];
            }

            ans += w;
            count++;
        }

        return ans;
    }
}