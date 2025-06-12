
import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class P1nX {
    public static void main(String[] args) {
        Scanner sc = null;
        try {
            sc = new Scanner(System.in);
            //Validando os argumentos pelo terminal
            validarArgumentos(args);
            //obtendo a nova pessoa pelo terminal
            Pessoa pessoa = novaPessoa(args);
            System.out.println(pessoa);
            //Inserindo novas pessoas 
            int quantidadePessoas = 0;
            do {
                System.out.print("Quantas pessoas a mais deseja inserir? ");
                quantidadePessoas = sc.nextInt();
                if (quantidadePessoas < 0) System.out.println("Quantidade inválida! Insira um número positivo.");
            }while(quantidadePessoas < 0);

            //criando a instância do array
            Pessoa[] pessoas = new Pessoa[quantidadePessoas];
            int cont = 0;
            //Limpando \n
            sc.nextLine();

            while(cont < quantidadePessoas) {
                //lendo os dados e validando
                String[] dados = lerDados(sc);

                //instanciando uma nova pessoa
                if(dados == null) break;
                pessoa = novaPessoa(dados);
                pessoas[cont++] = pessoa;

            }
            //Mostrando as informações
            printarPessoas(pessoas);
        }catch(ParseException exception){
            System.out.println("Formatação de dados inválida. Segue-se o valor dos campos que devem ser inseridos, nessa determinada ordem:");
            System.out.println("Gênero;");
            System.out.println("Nome;");
            System.out.println("Sobrenome;");
            System.out.println("Dia do seu nascimento;");
            System.out.println("Mês do seu nascimento;");
            System.out.println("Ano do seu nascimento;");
            System.out.println("Seu CPF;");
            System.out.println("Seu peso;");
            System.out.println("Altura (em metros)");
        }catch(RuntimeException exception) {

            //Deixando mais abrangente o tratamento das exceções para o primeiro exercício:
            System.out.println(exception.getMessage());
        }finally {
            sc.close();
        }

        System.out.println("Programa encerrado.");
    }

    private static void printarPessoas(Pessoa[] pessoas) {
        int quantidadeHomens = 0;
        int quantidadeMulheres = 0;
        if(pessoas.length != 0) {
            System.out.println("-----------------------------------------------------------");
            System.out.println("Informacoes inseridas: ");
            for(Pessoa p : pessoas) {
                if(p != null) {
                    if(p instanceof Homem) quantidadeHomens++;
                    if(p instanceof Mulher) quantidadeMulheres++;
                    System.out.println(p);
                    System.out.println();
                }
            }

            System.out.println("Quantidade de mulheres inseridas: " + quantidadeMulheres);
            System.out.println("Quantidade de homens inseridos: " + quantidadeHomens);
        }
    }

    private static String[] lerDados(Scanner sc) throws InputMismatchException, RuntimeException, ParseException{
        String[] dados = new String[9];
        boolean valido = false;
        do {
            System.out.print("Insira o nome: ");
            dados[1] = sc.nextLine();
            if (dados[1].trim().isEmpty()) return null;
            valido = isName(dados[1]);
            if(!valido) System.out.println("Um nome não pode conter números. Ex.: Alexandre");
        }while(!valido);

        valido = false;
        do {
            System.out.print("Insira o sobrenome: ");
            dados[2] = sc.nextLine();
            if (dados[2].trim().isEmpty()) return null;
            valido = isName(dados[2]);
            if(!valido) System.out.println("O sobrenome não pode contar números. Ex: Vasconcellos");
        }while(!valido);

        valido = false;
        do {
            System.out.print("Dia de nascimento: ");
            dados[3] = sc.nextLine();
            if (dados[3].trim().isEmpty()) return null;
            valido = ValidaData.isDia(dados[3]);
            if(!valido) System.out.println("Dia inválido. Insira um dia existente. O dia do mês deve estar de acordo com o calendário usual de seu ano.");
        }while(!valido);

        valido = false;
        do {
            System.out.print("Mes de nascimento: ");
            dados[4] = sc.nextLine();
            if (dados[4].trim().isEmpty()) return null;
            valido = ValidaData.isMes(dados[4]) && ValidaData.isDataValida(dados[3], dados[4]);
            if(!valido) System.out.println("Mes inválido. O mês deve ser escrito por extenso sem acentuacoes ou o seu respectivo número de acordo com o calendário e deve estar em conformidade com o dia escolhido" + "\nExemplo de data válida: 31 de janeiro" + "\n Exemplo de data inválida: 31 de fevereiro");
        }while(!valido);

        valido = false;
        do {
            System.out.print("Ano de nascimento: ");
            dados[5] = sc.nextLine();
            if (dados[5].trim().isEmpty()) return null;
            valido = ValidaData.isAno(dados[5]);
            if(!valido) System.out.println("Ano inválido. O ano deve deve conter um distância de 120 até a data atual.");
        }while(!valido);

        valido = false;
        do {
            try {
                System.out.print("Insira o CPF: ");
                dados[6] = sc.nextLine();
                if (dados[6].trim().isEmpty()) return null;
                valido = ValidaCPF.isCPF(dados[6]);
            }catch(RuntimeException exception) {
                System.out.println(exception.getMessage());
            }
        }while(!valido);

        valido = false;
        do {
            System.out.print("Insira o peso: ");
            dados[7] = sc.nextLine();
            if (dados[7].trim().isEmpty()) return null;
            valido = isPeso(dados[7]);
            if(!valido) System.out.println("Peso inválido. Insira um peso possível. Ex.: 70.0, 120.0, 45.0");
        }while(!valido);

        valido = false;
        do {
            System.out.print("Insira a altura");
            dados[8] = sc.nextLine();
            if (dados[8].trim().isEmpty()) return null;
            valido = isAltura(dados[8]);
            if(!valido) System.out.println("Altura inválida. Insira uma altura possível. Ex.: 0.4, 1.6, 2.07");
        }while(!valido);

        valido = false;
        do {
            System.out.print("Esta pessoa é do genero feminino ou masculino (f ou m)? ");
            dados[0] = sc.nextLine();
            if (dados[0].trim().isEmpty()) return null;
            valido = isGender(dados[0]);
            if(!valido) System.out.println("Entrada de gênero incorreta. Valores aceitos para gênero: 'f' ou 'm'.");
        }while(!valido);

        return dados;
    }

    private static Pessoa novaPessoa(String[] args) {
        Pessoa pessoa = null;
        String genero = args[0];
        String nome = args[1];
        String sobreNome = args[2];
        int dia = Integer.parseInt(args[3]);
        int mes = ValidaData.converterMes(args[4]);
        int ano = Integer.parseInt(args[5]);
        long numCPF = Long.parseLong(args[6].replaceAll("[-./]", ""));
        float peso = Float.parseFloat(args[7]);
        float altura = Float.parseFloat(args[8]);

        if (genero.equals("f")) {
            pessoa = new Mulher(nome, sobreNome, dia, mes, ano, numCPF, peso, altura);
        }
        if (genero.equals("m")) {
            pessoa = new Homem(nome, sobreNome, dia, mes, ano, numCPF, peso, altura);
        }

        return pessoa;
    }

    private static void validarArgumentos(String[] args) throws RuntimeException, ParseException {
        //Verificando se foi passado os 9 argumentos:
        if (args.length != 9) throw new RuntimeException("Informações faltando. Por favor, preencha todos os dados separados por espaço: Nome, Sobrenome, dia, mes, ano, CPF, peso e altura.");
        
        //Verificando o genero:
        if (!isGender(args[0])) throw new RuntimeException("Entrada de gênero incorreta. Valores aceitos para gênero: 'f' ou 'm'.");

        //Verificando o nome:
        if (!isName(args[1])) throw new RuntimeException("Um nome não pode conter números. Ex.: Alexandre");

        //Verificando o sobrenome:
        if (!isName(args[2])) throw new RuntimeException("O sobrenome não pode contar números. Ex: Vasconcellos");

        //Verificando o dia de nascimento:
        if (!ValidaData.isDia(args[3])) throw new RuntimeException("Dia inválido. Insira um dia existente. O dia do mês deve estar de acordo com o calendário usual de seu ano.");
        
        //Verificando mês:
        if (!ValidaData.isMes(args[4])) throw new RuntimeException("Mes inválido. O mês deve ser escrito por extenso sem acentuacoes ou o seu respectivo número de acordo com o calendário.");

        //Verificando o ano:
        if(!ValidaData.isAno(args[5])) throw new RuntimeException("Ano inválido. O ano deve deve conter um distância de 120 até a data atual.");

        //Verificando as relações entre as datas.
        if(!ValidaData.isDataValida(args[3], args[4])) throw new RuntimeException("Data inválida. O dia não está de acordo com o mês inserido." + "\nExemplo de data válida: 31 de janeiro" + "\n Exemplo de data inválida: 31 de fevereiro");

        //Verificando o CPF:
        ValidaCPF.isCPF(args[6]);

        //Verificando o peso:
        if(!isPeso(args[7])) throw new RuntimeException("Peso inválido. Insira um peso possível. Ex.: 70.0, 120.0, 45.0");

        //Verificando a altura:
        if(!isAltura(args[8])) throw new RuntimeException("Altura inválida. Insira uma altura possível. Ex.: 0.4, 1.6, 2.07");
    }

    private static boolean isGender(String c) {
        if (!c.equals("f") && !c.equals("m")) return false;

        return true;
    }

    private static boolean isName(String nome) {
        for (int c = 0; c < nome.length(); c++) {
            if (nome.charAt(c) >= 48 && nome.charAt(c) <= 57)
                return false;
        }

        return true;
    }

    private static boolean isPeso(String peso) throws ParseException{
        float pesoFloat = Float.parseFloat(peso);
        return pesoFloat >= 20.0 && pesoFloat <= 300.0;
    }

    private static boolean isAltura(String altura) throws ParseException{
        float alturaFloat = Float.parseFloat(altura);
        return alturaFloat >= 0.4 && alturaFloat <= 2.5;
    }
}
