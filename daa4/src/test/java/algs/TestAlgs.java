package algs;
import java.io.File;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class TestAlgs {

    
    @Test
    public void testSmallGraph() throws Exception {
        for (int i = 1; i <= 3; i++) {
            String inputPath = "json/graph_small" + i + ".json";
            String outputPath = "json/output_small" + i + ".json";
        runTest(inputPath, outputPath);
        }
    }

    @Test
    public void testMediumGraph() throws Exception {
        for (int i = 1; i <= 3; i++) {
            String inputPath = "json/graph_medium" + i + ".json";
            String outputPath = "json/output_medium" + i + ".json";
            runTest(inputPath, outputPath);
        }
    }

    @Test
    public void testLargeGraph() throws Exception {
        for (int i = 1; i <= 3; i++) {
            String inputPath = "json/graph_large" + i + ".json";
            String outputPath = "json/output_large" + i + ".json";
            runTest(inputPath, outputPath);
        }
    }

    static ObjectMapper mapper = new ObjectMapper();

    private void runTest(String inPath, String outPath) throws Exception{
        JsonNode json = mapper.readTree(new File(inPath));

        ArrayList<ArrayList<Util.Edge>> weightedList = Util.readJsonWeighted(json);
        ArrayList<ArrayList<Integer>> unweightedList = Util.readJson(json);
        int n = json.get("n").asInt();
        int src = json.has("source") ? json.get("source").asInt() : 0;


        Kahn kahn = new Kahn();
        ArrayList<Integer> topological = kahn.KahnSort(Util.readJson(json), n);
        MetricsExport.writeCSV("metrics_results.csv", "Kahn");

        ShortestPath sp = new ShortestPath();
        ShortestPath.ResultFromSP resultSP = sp.computeEverything(weightedList, topological, n, src);
        MetricsExport.writeCSV("metrics_results.csv", "Shortest Path");

        Kosaraju kosaraju = new Kosaraju();
        ArrayList<ArrayList<Integer>> scc = kosaraju.getSCC(unweightedList, n);
        MetricsExport.writeCSV("metrics_results.csv", "Kosaraju");
        
        ObjectNode result = mapper.createObjectNode();
        result.put("n", n);
        result.put("source", src);
        result.putPOJO("topologicalOrder", topological);
        result.putPOJO("shortestPath", resultSP.shortest);
        result.putPOJO("longestPath", resultSP.longest);
        result.putPOJO("stronglyConnectedComponents", scc);

        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(outPath), result);
    }

    
}
