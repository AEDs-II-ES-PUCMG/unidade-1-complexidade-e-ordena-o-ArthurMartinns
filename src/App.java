import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class App {
    static final int[] tamanhosTesteGrande = { 31_250_000, 62_500_000, 125_000_000, 250_000_000, 500_000_000 };
    static final int[] tamanhosTesteMedio = { 12_500, 25_000, 50_000, 100_000, 200_000 };
    static final int[] tamanhosTestePequeno = { 3, 6, 12, 24, 48 };
    static Random aleatorio = new Random();
    static long operacoes;
    static double nanoToMilli = 1.0 / 1_000_000;

    /**
     * Gerador de vetores aleatórios de tamanho pré-definido.
     * 
     * @param tamanho Tamanho do vetor a ser criado.
     * @return Vetor com dados aleatórios, com valores entre 1 e (tamanho/2),
     *         desordenado.
     */
    static int[] gerarVetor(int tamanho) {
        int[] vetor = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = aleatorio.nextInt(1, tamanho / 2);
        }
        return vetor;
    }

    /**
     * Gerador de vetores de objetos do tipo Integer aleatórios de tamanho
     * pré-definido.
     * 
     * @param tamanho Tamanho do vetor a ser criado.
     * @return Vetor de Objetos Integer com dados aleatórios, com valores entre 1 e
     *         (tamanho/2), desordenado.
     */
    static Integer[] gerarVetorObjetos(int tamanho) {
        Integer[] vetor = new Integer[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = aleatorio.nextInt(1, 10 * tamanho);
        }
        return vetor;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        int[] tamanhos = { 20, 100, 500, 1000 };

        while (continuar) {
            exibirMenuPrincipal();
            int opcao = obterInteiro(scanner, "Escolha uma opção: ");

            switch (opcao) {
                case 1:
                    executarTodosAlgoritmos(tamanhos);
                    break;
                case 2:
                    executarAlgoritmoEspecifico(scanner, tamanhos);
                    break;
                case 0:
                    System.out.println("\nEncerrando sistema...");
                    continuar = false;
                    break;
                default:
                    System.out.println("\n Opção inválida! Tente novamente.\n");
            }
        }

        scanner.close();
    }

    static void exibirMenuPrincipal() {
        System.out.println("\n");
        System.out.println("  SISTEMA DE ORDENAÇÃO DE VETORES         ");
        System.out.println("");
        System.out.println(" 1. Executar todos os algoritmos          ");
        System.out.println(" 2. Escolher um algoritmo específico      ");
        System.out.println(" 0. Sair                                  ");
        System.out.println("");
    }

    static void exibirMenuAlgoritmos() {
        System.out.println("\n ESCOLHA O ALGORITMO ");
        System.out.println(" 1. Bubble Sort                           ");
        System.out.println(" 2. Insertion Sort                        ");
        System.out.println(" 3. Selection Sort                        ");
        System.out.println(" 4. Merge Sort                            ");
        System.out.println("");
    }

    static void executarTodosAlgoritmos(int[] tamanhos) {
        System.out.println("\n=== TESTE DE ALGORITMOS DE ORDENAÇÃO ===\n");

        for (int tam : tamanhos) {
            System.out.println("\n--- Tamanho do vetor: " + tam + " ---");

            Integer[] vetor1 = gerarVetorObjetos(tam);
            Integer[] vetor2 = gerarVetorObjetos(tam);
            Integer[] vetor3 = gerarVetorObjetos(tam);
            Integer[] vetor4 = gerarVetorObjetos(tam);

            BubbleSort<Integer> bolha = new BubbleSort<>();
            InsertionSort<Integer> insercao = new InsertionSort<>();
            SelectionSort<Integer> selecao = new SelectionSort<>();
            MergeSort<Integer> merge = new MergeSort<>();

            Integer[] vetorOrdenadoBolha = bolha.ordenar(vetor1);
            Integer[] vetorOrdernadoInsercao = insercao.ordenar(vetor2);
            Integer[] vetorOrdernadoSelecao = selecao.ordenar(vetor3);
            Integer[] vetorOrdenadoMerge = merge.ordenar(vetor4);

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

            System.out.println("\nMergeSort:");
            System.out.println("  Comparações: " + merge.getComparacoes());
            System.out.println("  Movimentações: " + merge.getMovimentacoes());
            System.out.println("  Tempo (ms): " + String.format("%.3f", merge.getTempoOrdenacao()));
        }
    }

    static void executarAlgoritmoEspecifico(Scanner scanner, int[] tamanhos) {
        exibirMenuAlgoritmos();
        int algoritmo = obterInteiro(scanner, "Escolha o algoritmo: ");

        String nomeAlgoritmo = "";
        Class<?> classeOrdenador = null;

        switch (algoritmo) {
            case 1:
                nomeAlgoritmo = "Bubble Sort";
                classeOrdenador = BubbleSort.class;
                break;
            case 2:
                nomeAlgoritmo = "Insertion Sort";
                classeOrdenador = InsertionSort.class;
                break;
            case 3:
                nomeAlgoritmo = "Selection Sort";
                classeOrdenador = SelectionSort.class;
                break;
            case 4:
                nomeAlgoritmo = "Merge Sort";
                classeOrdenador = MergeSort.class;
                break;
            default:
                System.out.println("\n Algoritmo inválido!");
                return;
        }

        System.out.println("\n=== TESTE: " + nomeAlgoritmo.toUpperCase() + " ===\n");

        for (int tam : tamanhos) {
            System.out.println("--- Tamanho do vetor: " + tam + " ---");

            Integer[] vetor = gerarVetorObjetos(tam);
            IOrdenador<Integer> ordenador = criarOrdenador(classeOrdenador);
            Integer[] vetorOrdenado = ordenador.ordenar(vetor);

            System.out.println("  Comparações: " + ordenador.getComparacoes());
            System.out.println("  Movimentações: " + ordenador.getMovimentacoes());
            System.out.println("  Tempo (ms): " + String.format("%.3f", ordenador.getTempoOrdenacao()) + "\n");
        }
    }

    static IOrdenador<Integer> criarOrdenador(Class<?> classe) {
        if (classe == BubbleSort.class) {
            return new BubbleSort<>();
        } else if (classe == InsertionSort.class) {
            return new InsertionSort<>();
        } else if (classe == SelectionSort.class) {
            return new SelectionSort<>();
        } else if (classe == MergeSort.class) {
            return new MergeSort<>();
        }
        return null;
    }

    static int obterInteiro(Scanner scanner, String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Digite um número inteiro.\n");
            }
        }
    }
}
