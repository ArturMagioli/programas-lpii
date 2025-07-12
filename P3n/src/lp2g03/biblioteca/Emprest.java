package lp2g03.biblioteca;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Emprest implements Serializable {

    private static final long serialVersionUID = 1L;

    private LocalDate dataLocacao;
    private LocalDate dataDevolucao;
    private int codigoLivro;

    public Emprest(LocalDate dataLocacao, int codigoLivro) {
        this.dataLocacao = dataLocacao;
        this.codigoLivro = codigoLivro;
    }

    public LocalDate getDataLocacao() {
        return this.dataLocacao;
    }

    public LocalDate getDataDevolucao() {
        return this.dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public int getCodigoLivro() {
        return this.codigoLivro;
    }

    @Override
    public String toString() {
        return "Codigo do livro: " + this.codigoLivro +
                "\nData de locacao: " + this.dataLocacao.format(DateTimeFormatter.ofPattern("dd/MM/yyy")) +  
                "\nData de devolucao: " + (this.dataDevolucao == null ? "Pendente" : this.dataDevolucao);
    }
}
