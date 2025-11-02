package algs;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestAlgs {

    private static final ObjectMapper mapper = new ObjectMapper();

    private static JsonNode load(String path) throws IOException{

        return mapper.readTree(new File(path));

    }
    private static void write(String path, Object obj) throws IOException{

        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(path), obj);

    }

    @Test
    public void mainTest() throws Exception{

        JsonNode json = load("json/input.json");
        int n = json.get("n").asInt();
        int source = json.get("source").asInt();

        ArrayList<ArrayList<Util.Edge>> listWeighted = Util.readJson(json);

        //Kosaraju

        Kosaraju kosaraju = new Kosaraju();

        // var scc = kosaraju.getSCC(listWeighted,n);



    }

    
}
