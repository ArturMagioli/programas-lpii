import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Pessoa {

    //lista de pessoas
    private static int qtdPessoas = 0;

    //atributos
    private String nome;

    private LocalDate dataNasc;

    private long numCPF;

    public Pessoa(String nome, int dia, int mes, int ano, long numCPF) {
        this.nome = nome;
        this.dataNasc = LocalDate.of(ano, mes, dia);
        this.numCPF = numCPF;
        
        incrementarPessoa();
    }

    public Pessoa(String nome, int dia, int mes, int ano) {
        //reaproveitando o construtor e impondo valores padão para os não preenchidos: 
        this(nome, dia, mes, ano, -1);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }

    public long getNumCPF() {
        return numCPF;
    }

    public void setNumCPF(long numCPF) {
        this.numCPF = numCPF;
    }

    public void incrementarPessoa() {
        Pessoa.qtdPessoas++;
    }

    public int getQtdPessoas() {
        return Pessoa.qtdPessoas;
    }

    public int getIdade() {
        return LocalDate.now().getYear() - dataNasc.getYear();
    }

    @Override
    public String toString() {
        String dados = "----------------------------------";
        if (this instanceof Homem) {
            dados += "\nNome: " + nome + " (Homem)";
        }else {
            dados += "\nNome: " + nome + " (Mulher)";
        }
        dados += "\nData de Nascimento: " + dataNasc.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + 
                "\nCPF: " + ValidaCPF.imprimeCPF("" + numCPF);

        return dados;
    }
}
