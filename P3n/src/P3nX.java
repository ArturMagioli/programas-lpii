import lp2g03.biblioteca.Biblioteca;

import java.util.InputMismatchException;
import java.util.Scanner;

public class P3nX {
    public static void main(String[] args) {
        Biblioteca biblioteca = levantarBancoDeDados();
        menuDeAcoes(biblioteca);
    }

    private static Biblioteca levantarBancoDeDados() {
        Biblioteca biblioteca = null;

        System.out.println("Você gostaria de: ");
        System.out.println("1. Carregar uma biblioteca pre-existente");
        System.out.println("2. Carregar uma nova biblioteca");
        boolean valido = false;
        Scanner sc = new Scanner(System.in);
        while (!valido) {
            try {
                int resposta = sc.nextInt();
                switch (resposta) {
                    case 1:
                        biblioteca = new Biblioteca();
                        biblioteca.leArqUsu("u");
                        biblioteca.leArqLiv("l");
                        valido = true;
                        break;
                    case 2:
                        biblioteca = new Biblioteca();
                        valido = true;
                        break;
                    default:
                        System.out.println("Valor inválido!");
                }
            }catch(InputMismatchException exception) {
                System.out.println("Error: Insira um valor válido!");
                sc.nextLine();
            }
        }
        return biblioteca;
    }

    public static void menuDeAcoes(Biblioteca biblioteca) {
        boolean valido = false;
        Scanner sc = new Scanner(System.in);
        while (!valido) {
            System.out.println("MENU DE ACAO: ");
            System.out.println("1. Manutencao");
            System.out.println("2. Cadastro");
            System.out.println("3. Emprestimo");
            System.out.println("4. Relatorio");
            try {
                int resposta = sc.nextInt();
                switch (resposta) {
                    case 1:
                        opcoesManutencao(biblioteca);
                        valido = true;
                        break;
                    case 2:
                        opcoesCadastro(biblioteca);
                    default:
                        System.out.println("Error: Insira um valor válido!");
                        break;
                }
            }catch (InputMismatchException exception) {
                System.out.println("Error: valor inválido!");
                sc.nextLine();
            }
        }
        sc.close();
    }

    public static void opcoesManutencao(Biblioteca biblioteca) {
        boolean valido = false;
        Scanner sc = new Scanner(System.in);
        while (!valido) {
            System.out.println("OPCOES MANUTENCAO:");
            System.out.println("1. Abrir arquivos");
            System.out.println("2. Salvar arquivos");
            try {
                int resposta = sc.nextInt();
                switch (resposta) {
                    case 1:
                        abrirArquivos(biblioteca);
                        break;
                    case 2:
                        salvarArquivos(biblioteca);
                    default:
                        System.out.println("Error: Insira um valor válido!");
                        break;
                }
            }catch (InputMismatchException exception) {
                System.out.println("Error: valor inválido!");
                sc.nextLine();
            }
        }
    }

    private static void abrirArquivos(Biblioteca biblioteca) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Informe um nome para carregar usuarios: ");
        String arquivoUsuario = sc.next();
        sc.nextLine();
        System.out.println("Informe um nome para carregar livros: ");
        String arquivoLivro = sc.next();

        biblioteca.leArqUsu(arquivoUsuario);
        biblioteca.leArqLiv(arquivoLivro);
    }

    private static void salvarArquivos(Biblioteca biblioteca) {
        salvarUsuarios(biblioteca);
        salvarLivros(biblioteca);
    }

    private static void salvarUsuarios(Biblioteca biblioteca) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe um nome para salvar usuarios: ");
        String arquivoUsuario = sc.next();
        biblioteca.salvaArqUsu(biblioteca.getUsuarios(), arquivoUsuario);
    }

    private static void salvarLivros(Biblioteca biblioteca) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe um nome para salvar livros: ");
        String arquivoLivro = sc.next();
        biblioteca.salvaArqLiv(biblioteca.getLivros(), arquivoLivro);
    }

    private static void opcoesCadastro(Biblioteca biblioteca) {
        boolean valido = false;
        Scanner sc = new Scanner(System.in);
        while (!valido) {
            System.out.println("OPCOES CADASTRO:");
            System.out.println("1. Cadastrar usuarios");
            System.out.println("2. Cadastrar livros");
            try {
                int resposta = sc.nextInt();
                switch (resposta) {
                    case 1:
                        cadastrarUsuario(biblioteca);
                        break;
                    case 2:
                        cadastrarLivro(biblioteca);
                    default:
                        System.out.println("Error: Insira um valor válido!");
                        break;
                }
            }catch (InputMismatchException exception) {
                System.out.println("Error: valor inválido!");
                sc.nextLine();
            }
        }
    }

    private static void cadastrarUsuario(Biblioteca biblioteca) {
        System.out.println("Incompleto");
    }

    private static void cadastrarLivro(Biblioteca biblioteca) {
        System.out.println("Incompleto");
    }
}