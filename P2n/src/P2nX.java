
import java.util.Scanner;

public class P2nX {
    public static void main(String[] args) {
        MinhaListaOrdenavel listaOrdenavel = new MinhaListaOrdenavel();
        Scanner sc = new Scanner(System.in);
        inserirElementos(listaOrdenavel);

        int resultadoPrimeiroMenu = obterValorPrimeiroMenu(sc);
        while (resultadoPrimeiroMenu != 2) {
            int resultadoSegundoMenu = obterValorSegundoMenu(sc);
            System.out.println(listaOrdenavel.ordena(resultadoSegundoMenu));
            resultadoPrimeiroMenu = obterValorPrimeiroMenu(sc);
        }
        sc.close();
        System.out.println("\nPrograma encerrado.");
    }

    private static void inserirElementos(MinhaListaOrdenavel listaOrdenavel) {
        listaOrdenavel.add(new Homem("João", 12, 5, 1980, Long.parseLong("11111111111"), (float)78.5, (float)1.75));
        listaOrdenavel.add(new Homem("Carlos", 23, 8, 1990, Long.parseLong("22222222222"), (float)82.0, (float)1.80));
        listaOrdenavel.add(new Homem("Marcos", 7, 1, 1975, Long.parseLong("33333333333"), (float)90.2, (float)1.78));
        listaOrdenavel.add(new Homem("Felipe", 30, 9, 1988, Long.parseLong("44444444444"), (float)70.0, (float)1.70));
        listaOrdenavel.add(new Mulher("Ana", 5, 3, 1985, Long.parseLong("66666666666"), (float)60.5, (float)1.65));
        listaOrdenavel.add(new Mulher("Beatriz", 18, 7, 1992, Long.parseLong("77777777777"), (float)68.0, (float)1.70));
        listaOrdenavel.add(new Mulher("Camila", 10, 11, 1989, Long.parseLong("88888888888"), (float)55.3, (float)1.60));
        listaOrdenavel.add(new Mulher("Daniela", 25, 6, 1993, Long.parseLong("99999999999"), (float)64.7, (float)1.68));
        listaOrdenavel.add(new Mulher("Eduarda", 2, 2, 1990, Long.parseLong("10101010101"), (float)72.1, (float)1.72));
    }

    private static int obterValorPrimeiroMenu(Scanner sc) {
        int resultado = 0;
        while(resultado != 1 && resultado != 2) {
            try {
                System.out.println("----------------------------------------------------------");
                System.out.println("1.Imprimir Lista");
                System.out.println("2.Sair");
                System.out.print("Digite sua opcao: ");
                resultado = sc.nextInt();

                if (resultado != 1 && resultado != 2) {
                    System.out.println("Opcao invalida!");
                    System.out.println();
                }
            }catch(Exception exception) {
                System.out.println("Opcao invalida!");
                System.out.println();
                sc.nextLine();
            }
        }

        return resultado;
    }

    private static int obterValorSegundoMenu(Scanner sc) {
        int resultado = 0;
        while(resultado < 1 || resultado > 11) {
            try {
                System.out.println("Escolha seu modo de ordenação");
                System.out.println("1.Nome (crescente)");
                System.out.println("2.Nome (decrescente)");
                System.out.println("3.Peso (crescente)");
                System.out.println("4.Peso (decrescente)");
                System.out.println("5.Homens primeiro");
                System.out.println("6.Mulheres primeiro");
                System.out.println("7.Idade");
                System.out.println("8.Data de nascimento (crescente)");
                System.out.println("9.Data de nascimento (decrescente)");
                System.out.println("10.CPF (crescente)");
                System.out.println("11.CPF (decrescente)");
                resultado = sc.nextInt();

                if(resultado < 1 || resultado > 11) {
                    System.out.println("Opcao invalida!");
                    System.out.println();
                }
            }catch(Exception exception) {
                System.out.println("Opcao invalida!");
                System.out.println();
                sc.nextLine();
            }
        }

        return resultado;
    }
}