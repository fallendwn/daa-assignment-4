package algs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class ShortestPath {

    public static class ResultFromSP{

        public Map<Integer, Integer> shortest;
        public Map<Integer, Integer> longest;
    }

    public Map<Integer, Integer> shortestPath(ArrayList<ArrayList<Util.Edge>> list, ArrayList<Integer> topological, int n, int source){
        Metrics.reset();
        Metrics.startTimer();
        Map<Integer, Integer> distance = new HashMap<>();
        for(int i = 0 ; i < n ; i ++){

            distance.put(i, Integer.MAX_VALUE);

        }
        distance.put(source, 0);

        for(int i : topological){

            if(distance.get(i) != Integer.MAX_VALUE){

                for(Util.Edge edge : list.get(i)){

                    int newDistance = distance.get(i) + edge.weight;
                    if(newDistance < distance.get(edge.to)){

                        distance.put(edge.to, newDistance);
                        Metrics.incRelaxation();
                    }

                }

            }

        }  
        Metrics.stopTimer();
        return distance;

    }

    
    public Map<Integer, Integer> LongestPath(ArrayList<ArrayList<Util.Edge>> list, ArrayList<Integer> topological, int n, int source){
        Metrics.reset();
        Metrics.startTimer();
        Map<Integer, Integer> distance = new HashMap<>();
        for(int i = 0 ; i < n ; i ++){

            distance.put(i, Integer.MIN_VALUE);

        }
        distance.put(source, 0);

        for(int i : topological){

            if(distance.get(i) != Integer.MIN_VALUE){

                for(Util.Edge edge : list.get(i)){

                    int newDistance = distance.get(i) + edge.weight;
                    if(newDistance > distance.get(edge.to)){
                        Metrics.incRelaxation();
                        distance.put(edge.to, newDistance);

                    }

                }

            }

        }
        Metrics.stopTimer();
        return distance;

    }

    public ResultFromSP computeEverything(ArrayList<ArrayList<Util.Edge>> list, ArrayList<Integer> topological, int n, int source){

        ResultFromSP result = new ResultFromSP();
        result.shortest = shortestPath(list, topological, n, source);
        result.longest = LongestPath(list, topological, n, source);
        return result;

    }

}
