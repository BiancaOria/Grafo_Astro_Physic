import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {

        String inputFile = "Conversor\\CA-AstroPh.txt";
        String outputFile = "Conversor\\astro_formatado.txt";

        BufferedReader br = new BufferedReader(new FileReader(inputFile));

        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<int[]> edges = new ArrayList<>();
        //teste
        HashSet<String> seenEdges = new HashSet<>();

        int index = 0;
        int loops = 0;

        String line;

        while ((line = br.readLine()) != null) {

            // Ignorar comentários
            if (line.startsWith("#")) continue;

            line = line.trim();
            if (line.isEmpty()) continue;

            String[] parts = line.split("\\s+");
            if (parts.length < 2) continue;

            int vOriginal = Integer.parseInt(parts[0]);
            int wOriginal = Integer.parseInt(parts[1]);

            //teste ignorar loops
            if (vOriginal == wOriginal){loops++; continue;};
            // teste normaliação

            int vMin = Math.min(vOriginal, wOriginal);
            int vMax = Math.max(vOriginal, wOriginal);
            String edgeKey = vMin + "-" + vMax;

            if (seenEdges.add(edgeKey)) {
                if (!map.containsKey(vOriginal)) map.put(vOriginal, index++);
                if (!map.containsKey(wOriginal)) map.put(wOriginal, index++);

                edges.add(new int[]{vOriginal, wOriginal});
            }

        }

        br.close();

        BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));

        System.out.println(edges.size());

        bw.write(index + "\n");
        bw.write(edges.size() + "\n");

        for (int[] edge : edges) {
            int v = map.get(edge[0]);
            int w = map.get(edge[1]);
            bw.write(v + " " + w + "\n");
        }

        bw.close();


        System.out.println("Conversão concluída!");
        System.out.println("Arquivo gerado: " + outputFile);
        System.out.println("Vértices: " + (index));
        System.out.println("Arestas: " + edges.size());
        System.out.println("Loops:"+ loops);

        BufferedWriter bwMap = new BufferedWriter(new FileWriter("C:\\Users\\55859\\Downloads\\Trabalho Grafos V2 - Sem duplicatas\\Conversor\\mapeamento.txt"));
        int[] reverseArray = new int[index];
        for (int original : map.keySet()) {
            reverseArray[map.get(original)] = original;
        }
        for (int i = 0; i < reverseArray.length; i++) {
            bwMap.write(reverseArray[i] + "\n");
        }
        bwMap.close();

    }
}
