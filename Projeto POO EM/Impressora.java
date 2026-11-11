import java.util.Scanner;

public class Impressora {
    int opcao;

    static boolean conexaoAberta = false;
    static int tipo;
    static String modelo;
    static String conexao;
    static int parametro;
    String impressao;
    int posicao;
    int estilo;
    int tamanho;
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
            opcao = input.nextInt();

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
            System.out.println("Digite a posição que deseja imprimir: ");
            posicao = input.nextInt();
            System.out.println("Digite o estilo que deseja imprimir: ");
            estilo = input.nextInt();
            System.out.println("Digite o tamanho que deseja imprimir: ");
            tamanho = input.nextInt();
            int resultado = ImpressoraDLL.INSTANCE.ImpressaoTexto(impressao, posicao, estilo,tamanho);
            if(resultado >= 0){
                System.out.println("Impressão realizada com sucesso!");
            }else{
                System.out.println("Erro ao imprimir. Código: " + resultado);
            }
        }else{
            System.out.println("Conexão com a impressora está fechada.");
        }
    }
    public void imprimirQRCode(){
        int tamanho;
        String conteudo;
        int nivelCorrecao;

        if (conexaoAberta == true){
            input.nextLine();
            System.out.println("Digite o conteudo: ");
            conteudo = input.nextLine();
            System.out.println("Digite o tamanho: ");
            tamanho = input.nextInt();
            System.out.println("Digite o nivel de correção: ");
            nivelCorrecao = input.nextInt();
            int impressao = ImpressoraDLL.INSTANCE.ImpressaoQRCode(conteudo,tamanho,nivelCorrecao);
            if(impressao >= 0 ){
                System.out.println("Impressão realizada com sucesso!");
            }else{
                System.out.println("Erro ao imprimir. Código: " + impressao);
            }
        }else{
            System.out.println("Conexão com a impressora está fechada.");
        }
    }

    public void imprimirCodigoBarras(){
        int tipo;
        String dados;
        int altura;
        int largura;
        int hri;
        if(conexaoAberta == true){
            input.nextLine();

            System.out.println("Digite o tipo do código de barras: ");
            tipo = input.nextInt();

            input.nextLine();
            System.out.println("Digite os dados do código de barras: ");
            dados = input.nextLine();

            System.out.println("Digite a altura (1 a 255): ");
            altura = input.nextInt();

            System.out.println("Digite a largura (1 a 6): ");
            largura = input.nextInt();

            System.out.println("Digite o HRI (1 a 4): ");
            hri = input.nextInt();
            int resultado = ImpressoraDLL.INSTANCE.ImpressaoCodigoBarras(tipo, dados, altura, largura, hri);

            if (resultado >= 0) {
                System.out.println("Código de barras impresso com sucesso!");
            } else {
                System.out.println("Erro ao imprimir. Código: " + resultado);
            }
        }else {
            System.out.println("Conexão com a impressora está fechada.");
        }
    }
}
