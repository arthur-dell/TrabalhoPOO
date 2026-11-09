import java.util.Scanner;

public class Impressora {
    int opcao;
    public void Menu(){
        Scanner sc = new Scanner(System.in);
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
            opcao = sc.nextInt();
        }while(opcao != 11);
    }
}
