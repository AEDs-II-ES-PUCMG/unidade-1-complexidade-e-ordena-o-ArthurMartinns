import java.util.Comparator;

/**
 * Critério B - Volume Total de Itens (crescente).
 * Desempate 1: Data do Pedido.
 * Desempate 2: Código Identificador do pedido.
 */
public class ComparadorCriterioB implements Comparator<Pedido> {

    @Override
    public int compare(Pedido o1, Pedido o2) {
        int c = Double.compare(o1.valorCatalogoAtual(), o2.valorCatalogoAtual());
        if (c != 0) return c;

        c = Double.compare(o1.valorFinal(), o2.valorFinal());
        if (c != 0) return c;

        return Integer.compare(o1.getIdPedido(), o2.getIdPedido());
        }
    }
