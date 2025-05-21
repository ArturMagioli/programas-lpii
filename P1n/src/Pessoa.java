import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pessoa {

    //lista de pessoas
    private static List<Pessoa> pessoas = new ArrayList<>();

    //atributos
    private String nome;

    private String sobreNome;

    private LocalDate dataNasc;

    private long numCPF;

    private float peso;

    private float altura;

    public Pessoa(String nome, String sobreNome, int dia, int mes, int ano, long numCPF, float peso, float altura) {
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.dataNasc = LocalDate.of(ano, mes, dia);
        this.numCPF = numCPF;
        this.peso = peso;
        this.altura = altura;
    }

    public Pessoa(String nome, String sobreNome, int dia, int mes, int ano) {
        //reaproveitando o construtor e impondo valores padão para os não preenchidos: 
        this(nome, sobreNome, dia, mes, ano, -1, -1, -1);
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

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public static List<Pessoa> getPessoas() {
        return Pessoa.pessoas;
    }

    public static void addPessoa(Pessoa p) {
        Pessoa.pessoas.add(p);
    }

    private LocalDate getIdade() {
        return LocalDate.now().minusYears(dataNasc.getYear());
    }

    @Override
    public String toString() {
        return "Nome: " + nome +
                "\nSobrenome: " + sobreNome + 
                "\nIdade" + getIdade() +
                "\nCPF" + numCPF +
                "\nPeso: " + peso + 
                "\nAltura: " + altura;
    }
    
}
