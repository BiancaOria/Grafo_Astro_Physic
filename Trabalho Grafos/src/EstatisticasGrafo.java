import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;

public class EstatisticasGrafo {

    public static void main(String[] args) {

        In in = new In("Conversor\\astro_formatado.txt");
        Graph g = new Graph(in);
        int V = g.V();
        int E = g.E();

        System.out.println("=== Métricas Básicas ===");
        System.out.println("Vértices (Ordem): " + V);
        System.out.println("Arestas (Tamanho) : " + E);


        //Grau Médio e Densidade
        double grauMedio = (2.0 * E) / V;
        double densidade = (2.0 * E) / (V * (V - 1));
        System.out.printf("Grau Médio: %.4f\n", grauMedio);
        System.out.printf("Densidade: %.6f\n", densidade);

        // Grau Minimo
        int grauMinimo = 999999999;
        for (int v = 0; v < V; v++) {
            if (g.degree(v) < grauMinimo) {
                grauMinimo = g.degree(v);
            }
        }
        System.out.println("Grau Minimo: " + grauMinimo);

        // Grau Máximo
        int grauMaximo = -1;
        for (int v = 0; v < V; v++) {
            if (g.degree(v) > grauMaximo) {
                grauMaximo = g.degree(v);
            }
        }
        System.out.println("Grau Máximo: " + grauMaximo);



        double cc = ClusteringAnalysis.calcularMedia(g);
        System.out.printf("Coeficiente de Clustering Médio: %.4f\n", cc);

        // CSV distribuição Grau

        GerarDistribuiçaoCSV.salvar(g, "distribuicao_final.csv","distribuicao_final_bruto.csv");

    }
}
