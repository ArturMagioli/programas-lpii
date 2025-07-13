import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Interface extends JFrame{

    private JPanel sideBar;
    private JPanel footer;
    private JPanel content;

    private TabelaPessoas tabelaPessoas;
    private JScrollPane rolagem;

    private Operador operador;

    private JButton nomeCrescente;
    private JButton nomeDecrescente;
    private JButton pesoCrescente;
    private JButton pesoDecrescente;
    private JButton homensPrimeiro;
    private JButton mulheresPrimeiro;
    private JButton idade;
    private JButton nascimentoCrescente;
    private JButton nascimentoDecrescente;
    private JButton cpfCrescente;
    private JButton cpfDecrescente;
    private JButton saida;

    public Interface(Operador operador) {
        inicializarOperador(operador);
        configurarFrame();
        adicionarTabelaAoPainel(this.content);
        adicionarBotoesAoPainel(this.sideBar);
        mostrarFrame();
    }

    private void inicializarOperador(Operador operador) {
        this.operador = new Operador();
    }

    private void configurarFrame() {
        configurarBase();
        estabelecerLayout();
    }

    private void configurarBase() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 1000);
        this.setLayout(new BorderLayout(20, 20));
        this.setTitle("Tabela de pessoas");
    }

    private void estabelecerLayout() {
        adicionarSideBar();
        adicionarFooter();
        adicionarContent();
    }

    private void adicionarSideBar() {
        this.sideBar = new JPanel();
        this.sideBar.setPreferredSize(new Dimension(200, 100));
        this.sideBar.setLayout(new GridLayout(12, 1, 10 ,10));
        this.sideBar.setBackground(Color.lightGray);
        this.add(this.sideBar, BorderLayout.WEST);
    }

    private void adicionarFooter() {
        this.footer = new JPanel();
        this.footer.setPreferredSize(new Dimension(100, 200));
        this.footer.setBackground(Color.lightGray);
        this.add(this.footer, BorderLayout.SOUTH);
    }

    private void adicionarContent() {
        this.content = new JPanel();
        this.content.setPreferredSize(new Dimension(800, 800));
        this.content.setLayout(new BorderLayout());
        this.content.setBackground(Color.lightGray);
        this.add(this.content, BorderLayout.CENTER);
    }

    public void adicionarTabelaAoPainel(JPanel painel) {
        inicializarTabela();
        rolagem = new JScrollPane(tabelaPessoas);
        painel.add(rolagem);
    }

    private void inicializarTabela() {
        String[] campos = {"Nome", "Data de nascimento", "CPF", "Peso", "Altura"};
        tabelaPessoas = new TabelaPessoas(campos, operador.getListaOrdenavel().getPessoasIMC());
    }

    private void adicionarBotoesAoPainel(JPanel painel) {
        inicializarBotoes();
        painel.add(nomeCrescente);
        painel.add(nomeDecrescente);
        painel.add(pesoCrescente);
        painel.add(pesoDecrescente);
        painel.add(homensPrimeiro);
        painel.add(mulheresPrimeiro);
        painel.add(idade);
        painel.add(nascimentoCrescente);
        painel.add(nascimentoDecrescente);
        painel.add(cpfCrescente);
        painel.add(cpfDecrescente);
        painel.add(saida);
    }

    private void inicializarBotoes() {
        definirInstancias();
        removerFocos();
        definirEventos();
    }

    private void definirInstancias() {
        nomeCrescente = new JButton("Nome (crescente)");
        nomeDecrescente = new JButton("Nome (decrescente)");
        pesoCrescente = new JButton("Peso (crescente)");
        pesoDecrescente = new JButton("Peso (decrescente)");
        homensPrimeiro = new JButton("Homens primeiro");
        mulheresPrimeiro = new JButton("Mulheres primeiros");
        idade = new JButton("Idade");
        nascimentoCrescente = new JButton("Data de nascimento (crescente)");
        nascimentoDecrescente = new JButton("Data de nascimento (decrescente)");
        cpfCrescente = new JButton("CPF (crescente)");
        cpfDecrescente = new JButton("CPF (decrescente)");
        saida = new JButton("Sair");
    }

    private void removerFocos() {
        nomeCrescente.setFocusable(false);
        nomeDecrescente.setFocusable(false);
        pesoCrescente.setFocusable(false);
        pesoDecrescente.setFocusable(false);
        homensPrimeiro.setFocusable(false);
        mulheresPrimeiro.setFocusable(false);
        idade.setFocusable(false);
        nascimentoCrescente.setFocusable(false);
        nascimentoDecrescente.setFocusable(false);
        cpfCrescente.setFocusable(false);
        cpfDecrescente.setFocusable(false);
        saida.setFocusable(false);
    }

    private void definirEventos() {
        nomeCrescente.addActionListener(e -> {
            operador.getListaOrdenavel().ordena(1);
            recarregarTabela();;
        });
        nomeDecrescente.addActionListener(e -> {
            operador.getListaOrdenavel().ordena(2);
            recarregarTabela();
        });
        pesoCrescente.addActionListener(e -> {
            operador.getListaOrdenavel().ordena(3);
            recarregarTabela();
        });
        pesoDecrescente.addActionListener(e -> {
            operador.getListaOrdenavel().ordena(4);
            recarregarTabela();
        });
        homensPrimeiro.addActionListener(e -> {
            operador.getListaOrdenavel().ordena(5);
            recarregarTabela();
        });
        mulheresPrimeiro.addActionListener(e -> {
            operador.getListaOrdenavel().ordena(6);
            recarregarTabela();
        });
        idade.addActionListener(e -> {
            operador.getListaOrdenavel().ordena(7);
            recarregarTabela();
        });
        nascimentoCrescente.addActionListener(e -> {
            operador.getListaOrdenavel().ordena(8);
            recarregarTabela();
        });
        nascimentoDecrescente.addActionListener(e -> {
            operador.getListaOrdenavel().ordena(9);
            recarregarTabela();
        });
        cpfCrescente.addActionListener(e -> {
            operador.getListaOrdenavel().ordena(10);
            recarregarTabela();
        });
        cpfDecrescente.addActionListener(e -> {
            operador.getListaOrdenavel().ordena(11);
            recarregarTabela();
        });
        saida.addActionListener(e -> fecharAplicacao());
    }

    private void recarregarTabela() {
        for (int registro = 0; registro < tabelaPessoas.getRowCount(); registro++) {
            String[] valores = operador.getListaOrdenavel().get(registro).converterParaString();
            for (int campo = 0; campo < valores.length; campo++) {
                tabelaPessoas.setValueAt(valores[campo], registro, campo);
            }
        }
    }

    private void fecharAplicacao() {
        System.exit(0);
    }

    public void mostrarFrame() {
        this.setVisible(true);
    }
}
