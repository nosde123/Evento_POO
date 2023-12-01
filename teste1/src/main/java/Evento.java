import java.time.LocalDateTime;

class Evento {
    private String nomeEvento;
    private LocalDateTime dataEvento;
    private String descricaoEvento;
    private int qtdeIngresso;
    private double precoIngresso;
    private Categoria categoria;

    public Evento(String nomeEvento, LocalDateTime dataEvento, String descricaoEvento, int qtdeIngresso, double precoIngresso, Categoria categoria) {
        this.nomeEvento = nomeEvento;
        this.dataEvento = dataEvento;
        this.descricaoEvento = descricaoEvento;
        this.qtdeIngresso = qtdeIngresso;
        this.precoIngresso = precoIngresso;
        this.categoria = categoria;
    }

    // Métodos getters e setters para todos os atributos
    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public LocalDateTime getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDateTime dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getDescricaoEvento() {
        return descricaoEvento;
    }

    public void setDescricaoEvento(String descricaoEvento) {
        this.descricaoEvento = descricaoEvento;
    }

    public int getQtdeIngresso() {
        return qtdeIngresso;
    }

    public void setQtdeIngresso(int qtdeIngresso) {
        this.qtdeIngresso = qtdeIngresso;
    }

    public double getPrecoIngresso() {
        return precoIngresso;
    }

    public void setPrecoIngresso(double precoIngresso) {
        this.precoIngresso = precoIngresso;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    // Método para atualizar o estoque de ingressos do evento
    public void atualizarEstoque(int quantidade) {
        if (this.qtdeIngresso >= quantidade) {
            this.qtdeIngresso -= quantidade;
            System.out.println("Estoque atualizado para o evento: " + this.nomeEvento);
        } else {
            System.out.println("Quantidade insuficiente de ingressos para o evento: " + this.nomeEvento);
        }
    }
}
