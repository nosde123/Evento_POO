
import java.time.LocalDateTime;


public class VendaIngressos {
    public static void main(String[] args) {
        Categoria categoriaRock = new Categoria("Rock");
        Categoria categoriaTeatro = new Categoria("Teatro");

        Evento evento1 = new Evento("Show de Rock", LocalDateTime.of(2023, 12, 20, 20, 0),
                "Apresentação de bandas de rock", 500, 100.0, categoriaRock);

        Evento evento2 = new Evento("Teatro", LocalDateTime.of(2023, 11, 15, 18, 0),
                "Peça de teatro", 300, 50.0, categoriaTeatro);

        Evento evento3 = new Evento("Exposição de Arte", LocalDateTime.of(2023, 11, 30, 12, 0),
                "Mostra de pinturas e esculturas", 200, 80.0, categoriaTeatro);

        PedidoItem item1 = new PedidoItem(evento1, 2);
        PedidoItem item2 = new PedidoItem(evento3, 5);

        Pedido pedido = new Pedido(1, 1);
        pedido.adicionarItem(item1);
        pedido.adicionarItem(item2);

        // Exibindo informações sobre os eventos
        exibirInformacoesEvento(evento1);
        exibirInformacoesEvento(evento2);
        exibirInformacoesEvento(evento3);

        // Calculando o total a pagar
        double totalPagar = pedido.calculaTotalPagar();
        System.out.println("Total a pagar pelo pedido: " + totalPagar);
    }

    // Método para exibir informações de um evento
    public static void exibirInformacoesEvento(Evento evento) {
        System.out.println("Nome do evento: " + evento.getNomeEvento());
        System.out.println("Data do evento: " + evento.getDataEvento());
        System.out.println("Descrição do evento: " + evento.getDescricaoEvento());
        System.out.println("Quantidade de ingressos disponíveis: " + evento.getQtdeIngresso());
        System.out.println("Preço do ingresso: " + evento.getPrecoIngresso());
        System.out.println("Categoria do evento: " + evento.getCategoria().getDescricaoCategoria());
        System.out.println("------------------------------------------");
    }
}
