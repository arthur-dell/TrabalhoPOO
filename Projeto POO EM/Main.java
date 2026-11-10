import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Login login = new Login();
        Impressora impressora = new Impressora();
        if (login.realizarLogin()){
            impressora.Menu();
        }
    }
}
