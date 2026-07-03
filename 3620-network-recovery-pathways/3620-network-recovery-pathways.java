import java.util.*;

class Solution {

    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {

        int n = online.length;

        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        int high = 0;

        for (int[] e : edges) {
            graph[e[0]].add(new int[]{e[1], e[2]});
            high = Math.max(high, e[2]);
        }

        int low = 0;
        int ans = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canReach(graph, online, k, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    private boolean canReach(List<int[]>[] graph, boolean[] online, long k, int limit) {

        int n = graph.length;

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);

        PriorityQueue<long[]> pq =
                new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));

        dist[0] = 0;
        pq.offer(new long[]{0, 0});

        while (!pq.isEmpty()) {

            long[] cur = pq.poll();

            int node = (int) cur[0];
            long cost = cur[1];

            if (cost > dist[node])
                continue;

            if (node == n - 1)
                return true;

            for (int[] edge : graph[node]) {

                int next = edge[0];
                int wt = edge[1];

                if (wt < limit)
                    continue;

                if (next != n - 1 && !online[next])
                    continue;

                long newCost = cost + wt;

                if (newCost <= k && newCost < dist[next]) {
                    dist[next] = newCost;
                    pq.offer(new long[]{next, newCost});
                }
            }
        }

        return false;
    }
}