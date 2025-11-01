package algs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Kosaraju{

    public ArrayList<ArrayList<Integer>> getSCC(ArrayList<ArrayList<Integer>> adj, int n){

        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        ArrayList<ArrayList<Integer>> SCCList = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){

            if(!visited[i]){
                Util.DFS1(adj, visited, i, stack);
            }

        }

        ArrayList<ArrayList<Integer>> reversed = Util.reverseGraph(adj);

        Arrays.fill(visited, false);

        while (!stack.isEmpty()) {
            int v = stack.pop();
            if (!visited[v]) {
                ArrayList<Integer> component = new ArrayList<>();
                Util.DFS2(reversed, visited, v, component);
                SCCList.add(component);
            }
        }

        return SCCList;


    }

}