import java.util.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V + 1; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
        sc.close();
    }
}// } Driver Code Ends

/* Complete the function below */

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[V];
        int[] dfs = new int[V];

        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                if (cycle(adj, vis, dfs, i) == true)
                    return true;
            }
        }
        return false;
    }

    public boolean cycle(ArrayList<ArrayList<Integer>> adj, int[] vis, int[] dfs, int node) {
        vis[node] = 1;
        dfs[node] = 1;
        for (int i : adj.get(node)) {
            if (vis[i] == 0) {
                if (cycle(adj, vis, dfs, i) == true)
                    return true;
            } else if (dfs[i] == 1) {
                return true;
            }
        }
        dfs[node] = 0;

        return false;
    }
}