package algs;
import java.util.ArrayList;
import java.util.Stack;

import com.fasterxml.jackson.databind.JsonNode;
public class Util {
    
    public static class Edge{

        public int to;
        public int weight;
        public Edge(int v, int w){

            this.to = v;
            this.weight = w;

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


    public static ArrayList<ArrayList<Edge>> readJsonWeighted(JsonNode json){

        int n = json.get("n").asInt();
        ArrayList<ArrayList<Edge>> list = new ArrayList<>();
        for(int i = 0 ; i < n ; i ++){

            list.add(new ArrayList<>());

        } 
        for(JsonNode edge : json.get("edges")){

            int u = edge.get("u").asInt();
            int v = edge.get("v").asInt();
            int w = edge.get("w").asInt();
            list.get(u).add(new Edge(v,w));
        }
        return list;

    }

    public static ArrayList<ArrayList<Integer>> readJson(JsonNode json){

        int n = json.get("n").asInt();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            for (int i = 0; i < n; i++){list.add(new ArrayList<>());}

        for (JsonNode edge : json.get("edges")) {
            int u = edge.get("u").asInt();
            int v = edge.get("v").asInt();
            list.get(u).add(v);
        }
        return list;

    
    }

}
