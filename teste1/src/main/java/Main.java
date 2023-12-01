import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Evento> eventos = new ArrayList<>();
        ArrayList<Pedido> pedidos = new ArrayList<>();

        Categoria categoriaRock = new Categoria("Rock");
        Categoria categoriaTeatro = new Categoria("Teatro");

        eventos.add(new Evento("Show de Rock 1", LocalDateTime.of(2023, 12, 20, 20, 0),
                "Apresentação de bandas de rock", 500, 100.0, categoriaRock));

        eventos.add(new Evento("Show de Rock 2", LocalDateTime.of(2023, 12, 21, 19, 0),
                "Festival de rock", 300, 80.0, categoriaRock));

        eventos.add(new Evento("Show de Rock 3", LocalDateTime.of(2023, 12, 22, 18, 30),
                "Noite de rock alternativo", 200, 120.0, categoriaRock));

        eventos.add(new Evento("Peça de Teatro 1", LocalDateTime.of(2023, 11, 25, 15, 0),
                "Drama teatral", 150, 70.0, categoriaTeatro));

        eventos.add(new Evento("Exposição de Arte 1", LocalDateTime.of(2023, 11, 30, 12, 0),
                "Mostra de pinturas e esculturas", 200, 80.0, categoriaTeatro));

        // Inserir 2 pedidos com 3 itens cada
        for (int i = 0; i < 2; i++) {
            Pedido pedido = criarPedido(scanner, eventos, pedidos.size() + 1);
            pedidos.add(pedido);
        }

        // Exibir eventos disponíveis para compra
        exibirEventosDisponiveis(eventos);

        // Calculando o valor total a pagar para cada pedido
        for (Pedido pedido : pedidos) {
            double totalPagar = pedido.calculaTotalPagar();
            System.out.println("Total a pagar pelo Pedido " + pedido.getNumeroPedido() + ": " + totalPagar);
        }

        scanner.close();
    }

    // Método para criar um pedido com itens inseridos pelo usuário
    public static Pedido criarPedido(Scanner scanner, ArrayList<Evento> eventos, int numeroPedido) {
        Pedido pedido = new Pedido(numeroPedido, 1);

        System.out.println("Inserindo itens para o Pedido " + numeroPedido + ":");

        for (int i = 0; i < 3; i++) {
            System.out.println("Insira o nome do evento para o item " + (i + 1) + ":");
            String nomeEvento = scanner.nextLine();

            Evento eventoEncontrado = null;

            for (Evento evento : eventos) {
                if (evento.getNomeEvento().equalsIgnoreCase(nomeEvento)) {
                    eventoEncontrado = evento;
                    break;
                }
            }

            if (eventoEncontrado != null) {
                System.out.println("Insira a quantidade de ingressos para o evento:");
                int quantidade = Integer.parseInt(scanner.nextLine());

                if (quantidade <= eventoEncontrado.getQtdeIngresso()) {
                    PedidoItem item = new PedidoItem(eventoEncontrado, quantidade);
                    pedido.adicionarItem(item);

                    // Atualiza a quantidade de ingressos disponíveis para o evento
                    eventoEncontrado.setQtdeIngresso(eventoEncontrado.getQtdeIngresso() - quantidade);
                } else {
                    System.out.println("Quantidade de ingressos indisponível para este evento.");
                    i--; // Para que o usuário insira novamente as informações para este item
                }
            } else {
                System.out.println("Evento não encontrado. Insira um evento válido.");
                i--; // Para que o usuário insira novamente as informações para este item
            }
        }

        pedido.setStatusPedido(2); // Atualiza status do pedido para 2 após inserção dos itens
        return pedido;
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

    // Método para exibir apenas os eventos disponíveis para compra
    public static void exibirEventosDisponiveis(ArrayList<Evento> eventos) {
        System.out.println("Eventos Disponíveis para Compra:");
        boolean algumDisponivel = false;

        for (Evento evento : eventos) {
            if (evento.getQtdeIngresso() > 0) {
                exibirInformacoesEvento(evento);
                algumDisponivel = true;
            }
        }

        if (!algumDisponivel) {
            System.out.println("Não há eventos disponíveis para compra no momento.");
        }
    }
}
