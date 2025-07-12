package lp2g03.biblioteca;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Usuario extends Pessoa {

    private String endereco;
    private List<Emprest> hist;

    public Usuario(String nome,
                   String sobreNome,
                   int dia, 
                   int mes,
                   int ano, 
                   long numCPF, 
                   float peso, 
                   float altura,
                   String endereco) 
    {
        super(nome, sobreNome, dia, mes, ano, numCPF, peso, altura);
        this.endereco = endereco;
        this.hist = new ArrayList<>();
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Emprest getEmprestimoPendente(Livro livro) {
        for (Emprest registro : hist) {
            if (registro.getDataDevolucao() == null && registro.getCodigoLivro() == livro.getCodigo())
                return registro;
        }
        return null;
    }

    public void addLivroHist(LocalDate dataLocacao, int codigoLivro) {
        hist.add(new Emprest(dataLocacao, codigoLivro));
    }

    @Override
    public String toString() {
        return super.toString() +
            "\nEndereco: " + this.endereco + "\n" +
            "\nHistorico: " + this.hist.toString() + "\n";
    }
}
