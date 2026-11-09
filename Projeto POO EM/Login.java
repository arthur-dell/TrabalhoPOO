
import java.util.Scanner;

public class Login {

    String usuario = "admin";
    int senha = 1234;

    public void realizarLogin() {

        Scanner sc = new Scanner(System.in);
        int contador = 0;

        while (contador < 3) {

            System.out.println("Digite o usuario: ");
            String usuarioDigitado = sc.nextLine();

            System.out.println("Digite a senha: ");
            int senhaDigitada = sc.nextInt();
            sc.nextLine();

            if (usuarioDigitado.equals(usuario) && senhaDigitada == senha) {

                System.out.println("Acesso permitido!");
                break;

            } else {
                contador++;
                System.out.println("Acesso negado. Tentativas restantes: " + (3 - contador));
            }
        }
        if (contador == 3) {
            System.out.println("Limite de tentativas atingido!");
        }
    }
}
