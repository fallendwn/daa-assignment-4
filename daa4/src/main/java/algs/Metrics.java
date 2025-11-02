package algs;

public class Metrics {
    
    private static long startTime;
    private static long endTime;
    private static int dfsVisits;
    private static int edgesVisited;
    private static int queueOps;
    private static int relaxations;
    public static void reset() {
        dfsVisits = 0;
        edgesVisited = 0;
        queueOps = 0;
        relaxations = 0;
        startTime = 0;
        endTime = 0;
    }

    public static void startTimer() {
        startTime = System.nanoTime();
    }

    public static void stopTimer() {
        endTime = System.nanoTime();
    }

    public static double getElapsedMillis() {
        return (endTime - startTime) / 1_000_000.0;
    }

    public static void incDFS() {
        dfsVisits++;
    }

    public static void incEdge() {
        edgesVisited++;
    }

    public static void incQueue() {
        queueOps++;
    }

    public static void incRelaxation() {
        relaxations++;
    }

    public static int getDFSVisits() { return dfsVisits; }
    public static int getEdgesVisited() { return edgesVisited; }
    public static int getQueueOps() { return queueOps; }
    public static int getRelaxations() { return relaxations; }

    public static String[] getHeader() {
        return new String[]{"Algorithm", "DFS Visits", "Edges", "Queue Ops", "Relaxations", "Time (ms)"};
    }

    public static String[] getValues(String algoName) {
        return new String[]{
            algoName,
            String.valueOf(dfsVisits),
            String.valueOf(edgesVisited),
            String.valueOf(queueOps),
            String.valueOf(relaxations),
            String.format("%.3f", getElapsedMillis())
        };
    }
}
