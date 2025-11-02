package algs;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MetricsExport {
    
    public static void writeCSV(String fileName, String algoName){
    File f = new File(fileName);
    boolean writeHeader = !f.exists() || f.length() == 0;
    try (FileWriter csv = new FileWriter(fileName, true)) {
        if(writeHeader){
            csv.append(String.join(",", Metrics.getHeader())).append("\n");
        }
        csv.append(String.join(",", Metrics.getValues(algoName))).append("\n");
    } catch (IOException e) {
        e.printStackTrace();
    }




    }

}
