
import java.text.ParseException;
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
            System.out.print("Quantas pessoas a mais deseja inserir? ");
            int quantidadePessoas = sc.nextInt();

            //criando a instância do array
            Pessoa[] pessoas = new Pessoa[quantidadePessoas];
            int quantidadeHomens = 0;
            int quantidadeMulheres = 0;
            int cont = 0;
            //Limpando \n
            sc.nextLine();

            while(cont < quantidadePessoas) {
                //lendo os dados
                String[] dados = lerDados(sc);

                //validando os dados
                validarArgumentos(dados);

                //instanciando uma nova pessoa
                pessoa = novaPessoa(dados);
                if(pessoa instanceof Homem) quantidadeHomens++;
                if(pessoa instanceof Mulher) quantidadeMulheres++;
                pessoas[cont++] = pessoa;

            }
            //Mostrando as inform
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
        if(pessoas.length != 0) {
            System.out.println("-----------------------------------------------------------");
            System.out.println("Informacoes inseridas: ");
            for(Pessoa p : pessoas) {
                System.out.println(p);
                System.out.println();
            }
        }
    }

    private static String[] lerDados(Scanner sc) {
        String[] dados = new String[9];

        System.out.print("Insira o nome: ");
        dados[1] = sc.nextLine();
        System.out.print("Insira o sobrenome: ");
        dados[2] = sc.nextLine();
        System.out.print("Dia de nascimento: ");
        dados[3] = sc.next();
        System.out.print("Mes de nascimento: ");
        dados[4] = sc.next();
        System.out.print("Ano de nascimento: ");
        dados[5] = sc.next();
        System.out.print("Insira o CPF: ");
        dados[6] = sc.next();
        System.out.print("Insira o peso: ");
        dados[7] = sc.next();
        System.out.print("Insira a altura: ");
        dados[8] = sc.next();
        System.out.print("Esta pessoa é do genero feminino ou masculino (f ou m)? ");
        dados[0] = sc.next();
        sc.nextLine();
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
        if (!isGender(args[0])) throw new RuntimeException("Valores aceitos para gênero: 'f' ou 'm'.");

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
