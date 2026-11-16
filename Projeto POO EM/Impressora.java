import java.util.Scanner;

public class Impressora {
    int opcao;
    String qrVenda = "kAmMUV2AFOP11vsbAwb4S1MrcnzIm8o6trefwjpRvpJaNGeXXcM2GKbs+aALc3WDxrimeOf9BdgoZl29RvtC1DmvqZ56oVEoRz0ymi"
            + "a1tHUdGPzuO035OuiEseEj3+gU+8NzGzqWQIJgqdgLOZgnmUP2aBOkC0QcokhHPVfwm9tJFQnQkzGzu4692+LtpxhLwEhnFjoZh+1h"
            + "pBXn5AEcbMS4Lx751qvFlfZX0hsYJf5pKcFH88E3byU82MU8UD5p9fyX2qL5Ae+Uql1VLPqoJOsQmC2BCBkMW7oQRCCR0osz6eLX1D"
            + "HHJU+stxKCkITlQnz6XJd4LKXifGZuZ25+Uw==";
    String qrCancelamento = "Q5DLkpdRijIRGY6YSSNsTWK1TztHL1vD0V1Jc4spo/CEUqICEb9SFy82ym8EhBRZjbh3btsZhF+sjHqEMR159i4agru9x6KsepK/q0E2e5xlU5cv3m1woYfgHyOkWDNcSdMsS6bBh2Bpq6s89yJ9Q6qh/J8YHi306ce9Tqb/drKvN2XdE5noRSS32TAWuaQEVd7u+TrvXlOQsE3fHR1D5f1saUwQLPSdIv01NF6Ny7jZwjCwv1uNDgGZONJdlTJ6p0ccqnZvuE70aHOI09elpjEO6Cd+orI7XHHrFCwhFhAcbalc+ZfO5b/+vkyAHS6CYVFCDtYR9Hi5qgdk31v23w==";
    static boolean conexaoAberta = false;
    static int tipo;
    static String modelo;
    static String conexao;
    static int parametro;
    String impressao;
    static boolean configurada = false;
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
            try {
            opcao = input.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Digite apenas números!");
                input.nextLine();
                opcao = 0;
            }
            switch (opcao) {
                case 1:
                    configurarImpressora();
                    break;

                case 2:
                    abrirConexao();
                    break;

                case 3:
                    fecharConexao();
                    break;

                case 4:
                    imprimirTexto();
                    break;

                case 5:
                    imprimirQRCode();
                    break;

                case 6:
                    imprimirCodigoBarras();
                    break;

                case 7:
                    imprimirCodigoXMLSAT();
                    break;

                case 8:
                    imprimirXMLCancelamentoSAT();
                    break;

                case 9:
                    abrirGaveta();
                    break;

                case 10:
                    emitirBeep();
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
        configurada = false;
        System.out.println("Digite o tipo: ");
        try {
        tipo = input.nextInt();
        } catch (java.util.InputMismatchException e) {
            System.out.println("Digite um número válido!");
            input.nextLine();
            return;
        }
        System.out.println("Digite o modelo: ");
        modelo = input.next();
        System.out.println("Digite a conexão: ");
        conexao = input.next();
        System.out.println("Digite o parâmetro: ");
        try {
        parametro = input.nextInt();
        } catch (java.util.InputMismatchException e) {
            System.out.println("Digite um número válido!");
            input.nextLine();
            return;
        }
        System.out.println("Dados armazenados com sucesso!");
        configurada = true;
    }

    public void abrirConexao() {
        if (configurada == true){
            if(conexaoAberta == false){
                int resultado = ImpressoraDLL.INSTANCE.AbreConexaoImpressora(tipo, modelo, conexao, parametro);
                if (resultado == 0) {
                    conexaoAberta = true;
                    System.out.println("Conexão aberta com sucesso!");
                } else {
                    System.out.println("Erro ao abrir conexão. Código: " + resultado);
                }
            } else{
                System.out.println("Conexão já esta aberta!");
            }
        } else{
            System.out.println("Impressora ainda não configurada!");
        }
    }

    public void fecharConexao(){
        if(conexaoAberta == true){
            int resultado = ImpressoraDLL.INSTANCE.FechaConexaoImpressora();
            if(resultado == 0){
                System.out.println("Conexão fechada com sucesso!");
                conexaoAberta = false;
            }else{
                System.out.println("Erro ao fechar conexão. Código: " + resultado);
            }
        }else{
            System.out.println("A conexão já está fechada!");
        }
    }
    public void imprimirTexto(){

        if(conexaoAberta == true){
            input.nextLine();
            System.out.println("Digite o texto que deseja imprimir: ");
            impressao = input.nextLine();
            int resultado = ImpressoraDLL.INSTANCE.ImpressaoTexto(impressao, 0, 0,0);
            if(resultado >= 0){
                System.out.println("Impressão realizada com sucesso!");
                ImpressoraDLL.INSTANCE.Corte(5);
            }else{
                System.out.println("Erro ao imprimir. Código: " + resultado);
            }
        }else{
            System.out.println("Conexão com a impressora está fechada.");
        }
    }
    public void imprimirQRCode(){
        if (conexaoAberta == true){

            int impressao = ImpressoraDLL.INSTANCE.ImpressaoQRCode(qrVenda,5,3);
            if(impressao == 0 ){
                System.out.println("Impressão realizada com sucesso!");
                ImpressoraDLL.INSTANCE.Corte(5);
            }else{
                System.out.println("Erro ao imprimir. Código: " + impressao);
            }
        }else{
            System.out.println("Conexão com a impressora está fechada.");
        }
    }

    public void imprimirCodigoBarras(){
        if(conexaoAberta == true){
            int resultado = ImpressoraDLL.INSTANCE.ImpressaoCodigoBarras(8, "{A012345678912", 100, 3, 4);

            if (resultado == 0) {
                System.out.println("Código de barras impresso com sucesso!");
                ImpressoraDLL.INSTANCE.Corte(5);
            } else {
                System.out.println("Erro ao imprimir. Código: " + resultado);
            }
        }else {
            System.out.println("Conexão com a impressora está fechada.");
        }
    }
    public void imprimirCodigoXMLSAT(){
        if (conexaoAberta == true) {
            int resultado = ImpressoraDLL.INSTANCE.ImprimeXMLSAT("path=XMLSAT.xml", 0);

            if (resultado == 0) {
                System.out.println("XML SAT impresso com sucesso!");
                ImpressoraDLL.INSTANCE.Corte(5);
            } else {
                System.out.println("Erro ao imprimir. Código: " + resultado);
            }
        } else {
            System.out.println("Conexão com a impressora está fechada.");
        }
    }
    public void imprimirXMLCancelamentoSAT(){
        if(conexaoAberta == true){
            int resultado = ImpressoraDLL.INSTANCE.ImprimeXMLCancelamentoSAT("path=CANC_SAT.xml", qrCancelamento, 0);
            if (resultado == 0) {
                System.out.println("XML de cancelamento impresso com sucesso!");
                ImpressoraDLL.INSTANCE.Corte(5);
            } else {
                System.out.println("Erro ao imprimir. Código: " + resultado);
            }
        }else{
            System.out.println("Conexão com a impressora está fechada.");
        }
    }

    public void abrirGaveta(){
        if(conexaoAberta == true){
            int resultado = ImpressoraDLL.INSTANCE.AbreGaveta(0, 100, 100);
            if(resultado == 0){
                System.out.println("Gaveta aberta com sucesso!");
            }else{
                System.out.println("Erro ao abrir gaveta. Código: " + resultado);
            }
        }else{
            System.out.println("Conexão com a impressora está fechada.");
        }
    }

    public void emitirBeep(){
        if(conexaoAberta == true){
            int resultado = ImpressoraDLL.INSTANCE.SinalSonoro(3, 5, 5);
            if(resultado == 0){
                System.out.println("Sinal sonoro emitido com sucesso!");
            }else{
                System.out.println("Erro ao emitir sinal sonoro. Código: " + resultado);
            }
        }else{
            System.out.println("Conexão com a impressora está fechada.");
        }
    }
}
