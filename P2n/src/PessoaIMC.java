public abstract class PessoaIMC extends Pessoa {
    
    protected float peso;

    protected float altura;

    public PessoaIMC(String nome, int dia, int mes, int ano, long numCPF, float peso, float altura) {
        super(nome, dia, mes, ano, numCPF);
        this.peso = peso;
        this.altura = altura;
    }

    public PessoaIMC(String nome, int dia, int mes, int ano, float peso, float altura) {
        super(nome, dia, mes, ano);
        this.peso = peso;
        this.altura = altura;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float calculaIMC() {
        return this.peso / (this.altura * this.altura);
    }
 
    public abstract String resultIMC();

    @Override
    public String toString() {
        return super.toString() +
            "\nPeso: " + peso +
            "\nAltura: " + altura +
            "\nIdade: " + super.getIdade();
    }
}
