import java.util.Arrays;
import java.util.Random;

public class App {
    static final int[] tamanhosTesteGrande =  { 31_250_000, 62_500_000, 125_000_000, 250_000_000, 500_000_000 };
    static final int[] tamanhosTesteMedio =   {     12_500,     25_000,      50_000,     100_000,     200_000 };
    static final int[] tamanhosTestePequeno = {          3,          6,          12,          24,          48 };
    static Random aleatorio = new Random();
    static long operacoes;
    static double nanoToMilli = 1.0/1_000_000;
    

    /**
     * Gerador de vetores aleatórios de tamanho pré-definido. 
     * @param tamanho Tamanho do vetor a ser criado.
     * @return Vetor com dados aleatórios, com valores entre 1 e (tamanho/2), desordenado.
     */
    static int[] gerarVetor(int tamanho){
        int[] vetor = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = aleatorio.nextInt(1, tamanho/2);
        }
        return vetor;        
    }

    /**
     * Gerador de vetores de objetos do tipo Integer aleatórios de tamanho pré-definido. 
     * @param tamanho Tamanho do vetor a ser criado.
     * @return Vetor de Objetos Integer com dados aleatórios, com valores entre 1 e (tamanho/2), desordenado.
     */
    static Integer[] gerarVetorObjetos(int tamanho) {
        Integer[] vetor = new Integer[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = aleatorio.nextInt(1, 10 * tamanho);
        }
        return vetor;
    }


    public static void main(String[] args) {
        System.out.println("=== TESTE DE ALGORITMOS DE ORDENAÇÃO ===\n");
        
        int[] tamanhos = {20, 100, 500, 1000};
        
        for (int tam : tamanhos) {
            System.out.println("\n--- Tamanho do vetor: " + tam + " ---");
            
            Integer[] vetor1 = gerarVetorObjetos(tam);
            Integer[] vetor2 = gerarVetorObjetos(tam);
            Integer[] vetor3 = gerarVetorObjetos(tam);
            
            BubbleSort<Integer> bolha = new BubbleSort<>();
            InsertionSort<Integer> insercao = new InsertionSort<>();
            SelectionSort<Integer> selecao = new SelectionSort<>();
            
            Integer[] vetorOrdenadoBolha = bolha.ordenar(vetor1);
            Integer[] vetorOrdernadoInsercao = insercao.ordenar(vetor2);
            Integer[] vetorOrdernadoSelecao = selecao.ordenar(vetor3);
            
            System.out.println("\nBubbleSort:");
            System.out.println("  Comparações: " + bolha.getComparacoes());
            System.out.println("  Movimentações: " + bolha.getMovimentacoes());
            System.out.println("  Tempo (ms): " + String.format("%.3f", bolha.getTempoOrdenacao()));
            
            System.out.println("\nInsertionSort:");
            System.out.println("  Comparações: " + insercao.getComparacoes());
            System.out.println("  Movimentações: " + insercao.getMovimentacoes());
            System.out.println("  Tempo (ms): " + String.format("%.3f", insercao.getTempoOrdenacao()));
            
            System.out.println("\nSelectionSort:");
            System.out.println("  Comparações: " + selecao.getComparacoes());
            System.out.println("  Movimentações: " + selecao.getMovimentacoes());
            System.out.println("  Tempo (ms): " + String.format("%.3f", selecao.getTempoOrdenacao()));
        }
        
        System.out.println("\n\n=== TESTE DE DESEMPENHO (ARRAY GRANDE) ===");
        int tamGrande = 10000;
        
        Integer[] vetor1 = gerarVetorObjetos(tamGrande);
        Integer[] vetor2 = gerarVetorObjetos(tamGrande);
        Integer[] vetor3 = gerarVetorObjetos(tamGrande);
        
        BubbleSort<Integer> bolhaGrande = new BubbleSort<>();
        InsertionSort<Integer> insercaoGrande = new InsertionSort<>();
        SelectionSort<Integer> selecaoGrande = new SelectionSort<>();
        
        System.out.println("\nTamanho do vetor: " + tamGrande);
        
        Integer[] vetorOrdenadoBolha = bolhaGrande.ordenar(vetor1);
        System.out.println("\nBubbleSort:");
        System.out.println("  Comparações: " + bolhaGrande.getComparacoes());
        System.out.println("  Movimentações: " + bolhaGrande.getMovimentacoes());
        System.out.println("  Tempo (ms): " + String.format("%.3f", bolhaGrande.getTempoOrdenacao()));
        
        Integer[] vetorOrdernadoInsercao = insercaoGrande.ordenar(vetor2);
        System.out.println("\nInsertionSort:");
        System.out.println("  Comparações: " + insercaoGrande.getComparacoes());
        System.out.println("  Movimentações: " + insercaoGrande.getMovimentacoes());
        System.out.println("  Tempo (ms): " + String.format("%.3f", insercaoGrande.getTempoOrdenacao()));
        
        Integer[] vetorOrdernadoSelecao = selecaoGrande.ordenar(vetor3);
        System.out.println("\nSelectionSort:");
        System.out.println("  Comparações: " + selecaoGrande.getComparacoes());
        System.out.println("  Movimentações: " + selecaoGrande.getMovimentacoes());
        System.out.println("  Tempo (ms): " + String.format("%.3f", selecaoGrande.getTempoOrdenacao()));
    }
}
