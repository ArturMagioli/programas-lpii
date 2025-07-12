package lp2g03.biblioteca;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Livro implements Serializable {

    private static final long serialVersionUID = 1L;

    private int codigo;
    private String titulo;
    private String categoria;
    private int disponiveis;
    private int emprestados;
    private List<EmprestPara> hist = new ArrayList<>();

    public Livro(int codigo, String titulo, String categoria, int disponiveis, int emprestados) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.categoria = categoria;
        this.disponiveis = disponiveis;
        this.emprestados = emprestados;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getDisponiveis() {
        return disponiveis;
    }

    public void setDisponiveis(int disponiveis) {
        this.disponiveis = disponiveis;
    }

    public int getEmprestados() {
        return emprestados;
    }

    public void setEmprestados(int emprestados) {
        this.emprestados = emprestados;
    }

    public List<EmprestPara> getHist() {
        return this.hist;
    }

    public EmprestPara getEmprestimoPendente(Usuario usuario) {
        for (EmprestPara registro : hist) {
            if (registro.getDataDevolucao() == null && registro.getCPF() == usuario.getNumCPF())
                return registro;
        }
        return null;
    }

    public void empresta() throws CopiaNaoDisponivelEx {
        if (this.emprestados == 0) 
            throw new CopiaNaoDisponivelEx("Não há cópias disponíveis para este livro.");
        setEmprestados(getEmprestados() + 1);
    }

    public void devolve() throws NenhumaCopiaEmprestadaEx {
        if (this.emprestados == 0) 
            throw new NenhumaCopiaEmprestadaEx("Nenhuma cópia deste livro foi emprestada.");
        setDisponiveis(getDisponiveis() + 1);
    }

    public void addUsuarioHist(LocalDate dataLocacao, LocalDate dataDevolucao, long CPF) {
        hist.add(new EmprestPara(dataLocacao, dataDevolucao, CPF));
    }

    @Override
    public String toString() {
        return  "Código: " + codigo + "\n" +
                "Título: " + titulo + "\n" +
                "Categoria: " + categoria + "\n" +
                "Cópias disponíveis: " + disponiveis + "\n" +
                "Cópias emprestadas: " + emprestados + "\n" +
                "Historico: " + hist.toString() + "\n";
    }
}
