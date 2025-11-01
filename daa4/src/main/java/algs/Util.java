package algs;
import java.util.ArrayList;
import java.util.Stack;
public class Util {
    
    public static class Edge{

        int u;
        int v;
        int w;
        public Edge(int u, int v, int w){

            this.u = u;
            this.v = v;
            this.w = w;

        }

    }

    public static void DFS1(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int s, Stack<Integer> stack){

        visited[s] = true;
        for(int i : adj.get(s)){

            if(!visited[i]){

                DFS1(adj, visited, i, stack);

            }

        }
        stack.push(s);

    }

    public static void DFS2(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int s, ArrayList<Integer> res) {
        visited[s] = true;
        res.add(s);
        for (int v : adj.get(s)) {
            if (!visited[v]) {
                DFS2(adj, visited, v, res);
            }
        }
    }

    public static ArrayList<ArrayList<Integer>> reverseGraph (ArrayList<ArrayList<Integer>> orig){

        int n = orig.size();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        for(int i = 0 ; i < n; i ++){res.add(new ArrayList<>());}
        for(int i = 0 ; i < n ; i++){
            for(int j : orig.get(i)){

                res.get(j).add(i);

            }
        }
        return res;
    }

}
