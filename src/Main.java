import java.util.Scanner;

class Produto {
    String nome;
    double preco;
    int quantidadeEstoque;

    public Produto(String nome, double preco, int quantidadeEstoque) {
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public boolean processarVenda(int quantidadeVendida) {
        if (quantidadeVendida > quantidadeEstoque) {
            System.out.println("Estoque insuficiente para realizar a venda.");
            return false;
        } else {
            quantidadeEstoque -= quantidadeVendida;
            return true;
        }
    }

    public void exibirInformacoesAntesVenda() {
        System.out.println("Produto: " + nome);
        System.out.printf("Preço: R$ %.2f\n", preco);
        System.out.println("Estoque antes da venda: " + quantidadeEstoque + " unidades");
    }

    public void exibirInformacoesDepoisVenda(int quantidadeVendida) {
        System.out.println("Venda realizada: " + quantidadeVendida + " unidades");
        System.out.println("Estoque atualizado: " + quantidadeEstoque + " unidades");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nome do produto: ");
        String nome = scanner.nextLine();

        System.out.print("Preço do produto: ");
        double preco = scanner.nextDouble();

        System.out.print("Quantidade inicial em estoque: ");
        int quantidadeEstoque = scanner.nextInt();

        System.out.print("Quantidade vendida: ");
        int quantidadeVendida = scanner.nextInt();

        Produto produto = new Produto(nome, preco, quantidadeEstoque);

        produto.exibirInformacoesAntesVenda();

        if (produto.processarVenda(quantidadeVendida)) {

            produto.exibirInformacoesDepoisVenda(quantidadeVendida);
        }

        scanner.close();
    }
}
