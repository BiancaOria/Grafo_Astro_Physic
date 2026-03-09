
import edu.princeton.cs.algs4.*;
import java.util.HashSet;

public class ClusteringAnalysis {

    public static double calcularMedia(Graph G) {
        double totalClustering = 0.0;
        int V = G.V();

        for (int v = 0; v < V; v++) {
            totalClustering += localClustering(G, v);
        }

        return totalClustering / V;
    }

    private static double localClustering(Graph G, int v) {
        int k = G.degree(v);

        if (k < 2) {
            return 0.0;
        }

        HashSet<Integer> vizinhos = new HashSet<>();
        for (int w : G.adj(v)) {
            vizinhos.add(w);
        }

        int arestasEntreVizinhos = 0;
        for (int u : vizinhos) {
            for (int w : G.adj(u)) {

                if (vizinhos.contains(w)) {
                    arestasEntreVizinhos++;

                }
            }
        }

        return (double) arestasEntreVizinhos / (k * (k - 1));
    }

}
