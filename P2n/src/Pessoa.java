import java.time.LocalDate;

public class Pessoa {

    //lista de pessoas
    private static int qtdPessoas = 0;

    //atributos
    private String nome;

    private String sobreNome;

    private LocalDate dataNasc;

    private long numCPF;

    public Pessoa(String nome, String sobreNome, int dia, int mes, int ano, long numCPF) {
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.dataNasc = LocalDate.of(ano, mes, dia);
        this.numCPF = numCPF;
        
        incrementarPessoa();
    }

    public Pessoa(String nome, String sobreNome, int dia, int mes, int ano) {
        //reaproveitando o construtor e impondo valores padão para os não preenchidos: 
        this(nome, sobreNome, dia, mes, ano, -1);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
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

    private int getIdade() {
        return LocalDate.now().getYear() - dataNasc.getYear();
    }

    @Override
    public String toString() {
        return "Nome: " + nome +
                "\nSobrenome: " + sobreNome + 
                "\nIdade: " + getIdade() +
                "\nCPF: " + ValidaCPF.imprimeCPF("" + numCPF);
    }
}
