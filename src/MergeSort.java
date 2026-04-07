public class MergeSort<T extends Comparable<T>> implements IOrdenador<T> {

    private long comparacoes;
    private long movimentacoes;
    private double tempoOrdenacao;

    @Override
    public T[] ordenar(T[] dados) {
        comparacoes = 0;
        movimentacoes = 0;

        long inicio = System.nanoTime();

        mergeSort(dados, 0, dados.length - 1);

        long fim = System.nanoTime();
        tempoOrdenacao = (fim - inicio) / 1_000_000.0;

        return dados;
    }

    private void mergeSort(T[] array, int esq, int dir) {
        if (esq < dir) {
            int meio = (esq + dir) / 2;

            mergeSort(array, esq, meio);
            mergeSort(array, meio + 1, dir);

            intercalar(array, esq, meio, dir);
        }
    }

    private void intercalar(T[] array, int esq, int meio, int dir) {

        int n1 = meio - esq + 1;
        int n2 = dir - meio;

        Object[] a1 = new Object[n1];
        Object[] a2 = new Object[n2];

        for (int i = 0; i < n1; i++) {
            a1[i] = array[esq + i];
            movimentacoes++;
        }

        for (int j = 0; j < n2; j++) {
            a2[j] = array[meio + j + 1];
            movimentacoes++;
        }

        int i = 0, j = 0, k = esq;

        while (i < n1 && j < n2) {
            comparacoes++;

            if (((T) a1[i]).compareTo((T) a2[j]) <= 0) {
                array[k++] = (T) a1[i++];
            } else {
                array[k++] = (T) a2[j++];
            }
            movimentacoes++;
        }

        while (i < n1) {
            array[k++] = (T) a1[i++];
            movimentacoes++;
        }

        while (j < n2) {
            array[k++] = (T) a2[j++];
            movimentacoes++;
        }
    }

    @Override
    public long getComparacoes() {
        return comparacoes;
    }

    @Override
    public long getMovimentacoes() {
        return movimentacoes;
    }

    @Override
    public double getTempoOrdenacao() {
        return tempoOrdenacao;
    }
}