public class Mulher extends PessoaIMC{
    public Mulher(String nome, int dia, int mes, int ano, long numCPF, float peso, float altura) {
        super(nome, dia, mes, ano, numCPF, peso, altura);
    }

    public Mulher(String nome, int dia, int mes, int ano, float peso, float altura) {
        super(nome, dia, mes, ano, peso, altura);
    }

    @Override
    public String resultIMC() {
        float imc = calculaIMC();
        if (imc < 19) return "Abaixo do peso ideal";
        if (imc <= 25.8) return "Peso ideal";

        return "Acima do peso ideal";
    }

    
    @Override
    public String toString() {
        return super.toString() +
            "\nResultado IMC: " + resultIMC();
    }
}
