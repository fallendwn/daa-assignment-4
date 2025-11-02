package algs;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
public class Kahn {
    
    public ArrayList<Integer> KahnSort(ArrayList<ArrayList<Integer>> list, int n){
        Metrics.reset();
        Metrics.startTimer();
        int[] index = new int[n];
        for(int i = 0; i < n ; i++){

            for(int j : list.get(i)) {
                index[j]++;
                Metrics.incEdge();
            }

        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0 ; i < n ; i++){

            if (index[i] == 0){
                queue.add(i);
            }

        }

        ArrayList<Integer> result = new ArrayList<>();

        while(!queue.isEmpty()){

            int i = queue.poll();
            result.add(i);

            Metrics.incQueue();
            for(int j : list.get(i)){

                index[j]--;
                if(index[j]==0){

                    queue.add(j);

                }

            }

        }
        Metrics.stopTimer();
        return result;

    }

}
