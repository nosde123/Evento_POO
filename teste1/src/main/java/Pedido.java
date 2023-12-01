import java.util.ArrayList;

public class Pedido {
    private int numeroPedido;
    private int statusPedido;
    private ArrayList<PedidoItem> itens;

    public Pedido(int numeroPedido, int statusPedido) {
        this.numeroPedido = numeroPedido;
        this.statusPedido = statusPedido;
        this.itens = new ArrayList<>();
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public int getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(int statusPedido) {
        this.statusPedido = statusPedido;
    }

    public ArrayList<PedidoItem> getItens() {
        return itens;
    }

    public void setItens(ArrayList<PedidoItem> itens) {
        this.itens = itens;
    }

    public void adicionarItem(PedidoItem item) {
        itens.add(item);
    }

    public double calculaTotalPagar() {
        double totalPagar = 0.0;

        for (PedidoItem item : itens) {
            totalPagar += item.getQuantidade() * item.getEvento().getPrecoIngresso();
        }

        return totalPagar;
    }
}
