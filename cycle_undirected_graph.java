import java.util.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}// } Driver Code Ends


class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
       int[] vis = new int[V];
       for(int i=0;i<V;i++){
           if(vis[i] == 0){
               if(cycle(adj,vis,-1,i) == true)return true;
           }
       }
       return false;
    }
     public boolean cycle(ArrayList<ArrayList<Integer>> adj,int[] vis,  int parent,int node){
       vis[node] = 1;
       for(int i:adj.get(node)){
           if(vis[i] == 0){
               if(cycle(adj,vis,node,i) == true)return true;
           }else if(i != parent)return true;
       }
       
       return false;
   }
}