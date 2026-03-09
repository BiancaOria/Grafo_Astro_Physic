import edu.princeton.cs.algs4.Graph;

import java.util.Locale;
import java.util.TreeMap;
import java.util.Map;
import java.io.PrintWriter;
import java.io.IOException;

public class GerarDistribuiçaoCSV{

    public static void salvar(Graph G, String nomeArquivo, String nomeArquivobruto) {
        int V = G.V();

        TreeMap<Integer, Integer> contagemFrequencia = new TreeMap<>();

        for (int v = 0; v < V; v++) {
            int k = G.degree(v);
            if (k > 0) {
                contagemFrequencia.put(k, contagemFrequencia.getOrDefault(k, 0) + 1);
            }
        }

        try (PrintWriter writer = new PrintWriter(nomeArquivo)) {
            writer.println("k,Pk");

            for (Map.Entry<Integer, Integer> entrada : contagemFrequencia.entrySet()) {
                int k = entrada.getKey();
                int freq = entrada.getValue();


                double pk = (double) freq / V;

                writer.printf(Locale.US,"%d,%.8f\n", k, pk);
            }

            System.out.println("Distribuição salva em: " + nomeArquivo);


        } catch (IOException e) {
            System.err.println("Erro ao salvar o arquivo CSV: " + e.getMessage());
        }

        try (PrintWriter writer = new PrintWriter(nomeArquivobruto)) {
            writer.println("k,freq");

            for (Map.Entry<Integer, Integer> entrada : contagemFrequencia.entrySet()) {
                int k = entrada.getKey();
                int freq = entrada.getValue();

                writer.printf(Locale.US,"%d,%d\n", k,freq);
            }

            System.out.println("Distribuição bruta salva em: " + nomeArquivo);


        } catch (IOException e) {
            System.err.println("Erro ao salvar o arquivo CSV: " + e.getMessage());
        }
    }
}