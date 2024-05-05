import java.io.IOException;
import java.util.Scanner;

public class MenuEscolha {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        boolean encerra = false;

        while (!encerra){
            System.out.println("************************************************");
            System.out.println("       Bem vindo/a ao conversor de moedas");
            System.out.println("************************************************");
            System.out.println("             Escolha uma opção:");
            System.out.println("         1 - Dólar -> Peso argentino");
            System.out.println("         2 - Peso argentino -> Dólar");
            System.out.println("         3 - Dólar -> Real brasileiro");
            System.out.println("         4 - Real brasileiro -> Dólar");
            System.out.println("         5 - Dólar -> Peso colombiano");
            System.out.println("         6 - Peso colombiano -> Dólar");
            System.out.println("         7 - Sair");
            System.out.println("************************************************");

            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    APIeCalculo.sendHttpGETRequest(scanner,"USD", "ARS");
                    break;

                case 2:
                    APIeCalculo.sendHttpGETRequest(scanner,"ARS", "USD");
                    break;

                case 3:
                    APIeCalculo.sendHttpGETRequest(scanner,"USD", "BRL");
                    break;

                case 4:
                    APIeCalculo.sendHttpGETRequest(scanner,"BRL","USD" );
                    break;

                case 5:
                    APIeCalculo.sendHttpGETRequest(scanner,"USD", "COP");
                    break;

                case 6:
                    APIeCalculo.sendHttpGETRequest(scanner,"COP", "USD");
                    break;

                default:
                    if(escolha == 7) {
                        System.out.println("Obrigado por usar este serviço");
                        encerra = true;
                    } else {
                        System.out.println("Opção Inválida!");
                    }
                    break;

            }
        }
    }

}