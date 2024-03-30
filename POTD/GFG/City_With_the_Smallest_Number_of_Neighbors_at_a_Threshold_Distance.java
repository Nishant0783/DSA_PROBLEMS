// There are n cities labeled from 0 to n-1 with m edges connecting them. Given the array edges where edges[i] = [fromi , toi ,weighti]  represents a bidirectional and weighted edge between cities fromi and toi, and given the integer distanceThreshold. You need to find out a city with the smallest number of cities that are reachable through some path and whose distance is at most Threshold Distance. If there are multiple such cities, our answer will be the city with the greatest label.

// Note: The distance of a path connecting cities i and j is equal to the sum of the edge's weights along that path.

// Date: 28 March 2024

class Solution {
    public int dijkstra(int n, ArrayList<ArrayList<Pair>> adj, int k, int src) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        q.add(src);

        // Initializing an array to store the minimum distance from the source
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        while (!q.isEmpty()) {
            int node = q.poll();

            for (Pair x : adj.get(node)) {
                int nbr = x.first;
                int wt = x.second;
                if (dist[nbr] > dist[node] + wt) {
                    dist[nbr] = dist[node] + wt;
                    q.add(nbr);
                }
            }
        }

        // Counting the number of cities within the distance threshold
        int c = 0;
        for (int i = 0; i < n; i++) {
            if (dist[i] <= k)
                c++;
        }
        return c;
    }

    public int findCity(int n, int m, int[][] edges, int distanceThreshold) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Pair>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(new Pair(edge[1], edge[2]));
            adj.get(edge[1]).add(new Pair(edge[0], edge[2]));
        }

        int[] dis = new int[n];

        // Finding the number of cities within the distance threshold for each city
        for (int i = 0; i < n; i++) {
            dis[i] = dijkstra(n, adj, distanceThreshold, i);
        }

        int ans = Integer.MAX_VALUE;
        int idx = -1;
        for (int i = 0; i < n; i++) {
            if (ans >= dis[i]) {
                ans = dis[i];
                idx = i;
            }
        }
        return idx;
    }

    static class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
