public class Homem extends Pessoa {
    private final String GENERO = "Masculino";
    
    public Homem(String nome, String sobreNome, int dia, int mes, int ano, long numCPF, float peso, float altura) {
        super(nome, sobreNome, dia, mes, ano, numCPF, peso, altura);
    }

    public Homem(String nome, String sobreNome, int dia, int mes, int ano) {
        super(nome, sobreNome, dia, mes, ano);
    }

    public String getGenero() {
        return this.GENERO;
    }

    //reuso de toString
    @Override
    public String toString() {
        return super.toString() +
                "\nGênero: " + this.GENERO;
    }
}
