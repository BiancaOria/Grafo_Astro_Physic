import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;

public class Main {
    public static void main(String[] args) {

        In in = new In("Conversor\\astro_formatado.txt");
        System.out.println(in);
        Graph g = new Graph(in);


        //sugestão
//        int[] reverseMap = new int[g.V()];
//        In inMap = new In("C:\\Users\\55859\\Downloads\\Trabalho Grafos V2\\Conversor\\mapeamento.txt");
//        for (int i = 0; i < g.V(); i++) {
//            reverseMap[i] = inMap.readInt();
//        }
//
//        int autorNovo = 0;
//        System.out.println("Autor Original: " + reverseMap[autorNovo]);
//
//        System.out.print("Vizinhos (IDs Originais): ");
//        for (int vizinhoNovo : g.adj(autorNovo)) {
//            System.out.print(reverseMap[vizinhoNovo] + " ");
//        }


    }
}
