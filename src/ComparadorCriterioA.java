import java.util.Comparator;

/**
 * Critério A - Valor Final do Pedido (crescente).
 * Desempate 1: Volume Total de Itens (quantProdutos).
 * Desempate 2: Código Identificador do primeiro item do pedido.
 */
public class ComparadorCriterioA implements Comparator<Pedido> {

    @Override
    public int compare(Pedido o1, Pedido o2) {

        int c = Double.compare(o1.valorFinal(), o2.valorFinal());
        if (c != 0) return c;

        c = Double.compare(o1.getQuantosProdutos(), o2.getQuantosProdutos());
        if (c != 0) return c;

        return Integer.compare(
            o1.getIdPrimeiroProduto(),
            o2.getIdPrimeiroProduto()
        );
        }
}
