package lp2g03.biblioteca;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EmprestPara implements Serializable {

    private static final long serialVersionUID = 1L;

    private LocalDate dataLocacao;
    private LocalDate dataDevolucao;
    private long CPF;

    public EmprestPara(LocalDate dataLocacao, LocalDate dataDevolucao, long CPF) {
        this.dataLocacao = dataLocacao;
        this.dataDevolucao = dataDevolucao;
        this.CPF = CPF;
    }

    public LocalDate getDataLocacao() {
        return dataLocacao;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public long getCPF() {
        return CPF;
    }

    @Override
    public String toString() {
        return "CPF do usuário: " + this.CPF +
                "\nData de locacao: " + this.dataLocacao.format(DateTimeFormatter.ofPattern("dd/MM/yyy")) +  
                "\nData de devolucao: " + (this.dataDevolucao == null ? "Pendente" : this.dataDevolucao);
    }
}
