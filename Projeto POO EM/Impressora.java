import java.util.Scanner;

public class Impressora {
    int opcao;

    static boolean conexaoAberta = false;
    static int tipo;
    static String modelo;
    static String conexao;
    static int parametro;
    static Scanner input = new Scanner(System.in);

    public void Menu(){
        do{
            System.out.println(" MENU ");
            System.out.println("1 - Configurar conexão");
            System.out.println("2 - Abrir conexão");
            System.out.println("3 - Fechar conexão");
            System.out.println("4 - Imprimir texto");
            System.out.println("5 - Imprimir QR Code");
            System.out.println("6 - Imprimir código de barras");
            System.out.println("7 - Imprimir XML SAT");
            System.out.println("8 - Imprimir XML de cancelamento SAT");
            System.out.println("9 - Abrir gaveta");
            System.out.println("10 - Emitir beep");
            System.out.println("11 - Sair");

            System.out.println("Escolha uma opção: ");
            opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    configurarImpressora();
                    break;

                case 2:
                    System.out.println("Abrir conexão");
                    break;

                case 3:
                    System.out.println("Fechar conexão");
                    break;

                case 4:
                    System.out.println("Imprimir texto");
                    break;

                case 5:
                    System.out.println("Imprimir QR Code");
                    break;

                case 6:
                    System.out.println("Imprimir código de barras");
                    break;

                case 7:
                    System.out.println("Imprimir XML SAT");
                    break;

                case 8:
                    System.out.println("Imprimir XML de cancelamento SAT");
                    break;

                case 9:
                    System.out.println("Abrir gaveta");
                    break;

                case 10:
                    System.out.println("Emitir beep");
                    break;

                case 11:
                    System.out.println("Saindo do programa...");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }while(opcao != 11);
    }

    public void configurarImpressora() {
        System.out.println("Digite o tipo: ");
        tipo = input.nextInt();
        System.out.println("Digite o modelo: ");
        modelo = input.next();
        System.out.println("Digite a conexão: ");
        conexao = input.next();
        System.out.println("Digite o parâmetro: ");
        parametro = input.nextInt();
        System.out.println("Dados armazenados com sucesso!");
    }
}
