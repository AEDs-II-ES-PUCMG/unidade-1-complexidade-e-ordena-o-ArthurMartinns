import java.util.Comparator;

/**
 * Critério C - Índice de Economia (decrescente).
 * O índice de economia é a diferença entre o valor de catálogo atual e o valor efetivamente pago.
 * Desempate 1: Valor Final do Pedido (crescente).
 * Desempate 2: Código Identificador do pedido (crescente).
 */
public class ComparadorCriterioC implements Comparator<Pedido> {

    @Override
    public int compare(Pedido o1, Pedido o2) {
        int c = Double.compare(o1.indiceEconomia(), o2.indiceEconomia());
        if (c != 0) return c;

        c = Double.compare(o1.valorFinal(), o2.valorFinal());
        if (c != 0) return c;

        return Integer.compare(o1.getIdPedido(), o2.getIdPedido());
    }
}
