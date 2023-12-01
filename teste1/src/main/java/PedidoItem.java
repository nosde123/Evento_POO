class PedidoItem {
    private Evento evento;
    private int quantidade;

    public PedidoItem(Evento evento, int quantidade) {
        this.evento = evento;
        this.quantidade = quantidade;
    }

    public void atualizaEstoqueIngresso() {
        evento.atualizarEstoque(quantidade);
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
