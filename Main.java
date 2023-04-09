import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Variaveis
        Scanner leitura = new Scanner(System.in);
        String nomeCliente;
        String tipoConta = "Corrente";
        double valorConta;
        //Dados iniciais do projeto!
        System.out.println("Ola, seja bem vindo ao LS BANK\n" +
                "Digite seu nome:");
        nomeCliente = leitura.nextLine();
        System.out.println(String.format("Ola %s, informe o saldo inicial da conta:", nomeCliente));
        valorConta = leitura.nextDouble();
        //Corpo do Projeto
        System.out.println("****************************");
        System.out.println("Dados inicias do cliente:");
        System.out.println("");
        System.out.println("NOME: " + nomeCliente);
        System.out.println("TIPO DE CONTA: " + tipoConta);
        System.out.println("SALDO INICIAL: R$" + valorConta);
        System.out.println("****************************");
        System.out.println("");
        boolean continuar = true;
        while (continuar) {
            System.out.printf("""
                    Operacoes:\n
                    [1] - Consultar Saldo
                    [2] - Receber Valor
                    [3] - Transferir Valor
                    [4] - Sair\n
                    Digite a opcao desejada:
                    """);

            int selecionaOperacao = leitura.nextInt();
            String resposta;
            switch (selecionaOperacao) {
                case 1:
                    System.out.println("O saldo da conta de " + nomeCliente + " e de R$" + valorConta);
                    System.out.println("Deseja voltar ao menu principal? [S/N]");
                    resposta = leitura.next().toUpperCase();
                    if (resposta.equals("S")) {
                        continuar = true;
                    } else {
                        continuar = false;
                    }
                    break;
                case 2:
                    System.out.println("Informe o valor que deseja depositar:");
                    double depositarValor = leitura.nextDouble();
                    if (depositarValor <= 0) {
                        System.out.println("Valor invalido para deposito\nDeseja voltar ao menu principal? [S/N]");
                        resposta = leitura.next().toUpperCase();
                        if (resposta.equals("S")) {
                            continuar = true;
                        } else {
                            continuar = false;
                        }
                        break;
                    } else if (depositarValor >= 1) {
                        valorConta += depositarValor;
                        System.out.println("Depositado a quantia de R$" + depositarValor);
                        System.out.println("Saldo atualizado de R$" + valorConta);
                        System.out.println("Deseja voltar ao menu principal? [S/N]");
                        resposta = leitura.next().toUpperCase();
                        if (resposta.equals("S")) {
                            continuar = true;
                        } else {
                            continuar = false;
                        }
                        break;
                    }
                case 3:
                    System.out.println("Informe o valor que deseja transferir:");
                    double transferirValor = leitura.nextDouble();
                    if (transferirValor <= valorConta) {
                        valorConta -= transferirValor;
                        System.out.println("Transferido a quatia de R$" + transferirValor);
                        System.out.println("Saldo atualizado de R$" + valorConta);
                        System.out.println("Deseja voltar ao menu principal? [S/N]");
                        resposta = leitura.next().toUpperCase();
                        if (resposta.equals("S")) {
                            continuar = true;
                        } else {
                            continuar = false;
                        }
                        break;
                    } else if (transferirValor > valorConta) {
                        System.out.println("Saldo indisponivel para realizar esta operacao.");
                        System.out.println("Deseja voltar ao menu principal? [S/N]");
                        resposta = leitura.next().toUpperCase();
                        if (resposta.equals("S")) {
                            continuar = true;
                        } else {
                            continuar = false;
                        }
                        break;
                    }
                case 4:
                    System.out.println("Deseja realmente encerrar o programa? [S/N]");
                    resposta = leitura.next().toUpperCase();
                    if (resposta.equals("S")) {
                        continuar = false;
                    } else {
                        continuar = true;
                    }
                    break;
                default:
                    System.out.println("Operacao Invalida!");
                    break;
            }
        }
        System.out.println(String.format("Obrigado %s por utilizar nossos servicos!", nomeCliente));
    }
}