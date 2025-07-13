public class Homem extends PessoaIMC {
    public Homem(String nome, int dia, int mes, int ano, long numCPF, float peso, float altura) {
        super(nome, dia, mes, ano, numCPF, peso, altura);
    }

    public Homem(String nome, int dia, int mes, int ano, float peso, float altura) {
        super(nome, dia, mes, ano, peso, altura);
    }


    @Override
    public String resultIMC() {
        float imc = calculaIMC();
        if (imc < 20.7) return "Abaixo do peso ideal";
        if (imc <= 26.4) return "Peso ideal";

        return "Acima do peso ideal";
    }

    @Override
    public String toString() {
        return super.toString() +
            "\nIMC: " + String.format("%.1f", calculaIMC()) + " " + resultIMC() + "\n";
    }
}
