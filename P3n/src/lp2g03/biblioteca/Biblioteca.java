package lp2g03.biblioteca;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;

public class Biblioteca {
    private static String discPath = "C:\\Users\\artur\\Code\\LPII\\programas\\P3n\\src\\dadosBiblioteca\\";
    private Hashtable<Long, Usuario> usuarios;
    private Hashtable<Integer, Livro> livros;

    public Biblioteca () {
        this.usuarios = new Hashtable<>();
        this.livros = new Hashtable<>();
    }

    public Biblioteca(String arquivoUsuarios, String arquivoLivros) {
        this.usuarios = carregarUsuarios(arquivoUsuarios);
        this.livros = carregarLivros(arquivoLivros);
    }

    private Hashtable<Long, Usuario> carregarUsuarios(String arquivoUsuarios) {
        Hashtable<Long, Usuario> usuarios = new Hashtable<>();

        Usuario usuario = null;
        try (BufferedReader leitor = new BufferedReader(new FileReader(discPath + arquivoUsuarios))) {
            String linha = leitor.readLine();
            while (linha != null) {
                usuario = obterUsuarioPelaLinha(linha);
                usuarios.put(usuario.getNumCPF(), usuario);
                linha = leitor.readLine();
            }

            return usuarios;
        }catch(IOException exception) {
            System.out.println("Error: " + exception.getMessage());
        }

        return null;
    }

    private Usuario obterUsuarioPelaLinha(String linha) {
        String[] dadosUsuario = linha.split(";");
        
        String nome = dadosUsuario[0];
        String sobrenome = dadosUsuario[1];
        int dia = Integer.parseInt(dadosUsuario[2]);
        int mes = Integer.parseInt(dadosUsuario[3]);
        int ano = Integer.parseInt(dadosUsuario[4]);
        long numCPF = Long.parseLong(dadosUsuario[5]);
        float peso = Float.parseFloat(dadosUsuario[6]);
        float altura = Float.parseFloat(dadosUsuario[7]);
        String endereco = dadosUsuario[8];

        return new Usuario(nome, sobrenome, dia, mes, ano, numCPF, peso, altura, endereco);
    }

    private Hashtable<Integer, Livro> carregarLivros(String arquivoLivros) {
        Hashtable<Integer, Livro> livros = new Hashtable<>();

        Livro livro = null;
        try (BufferedReader leitor = new BufferedReader(new FileReader(discPath + arquivoLivros))) {
            String linha = leitor.readLine();
            while (linha != null) {
                livro = obterLivroPelaLinha(linha);
                livros.put(livro.getCodigo(), livro);
                linha = leitor.readLine();
            }

            return livros;
        }catch(IOException exception) {
            System.out.println("Error: " + exception.getMessage());
        }

        return null;
    }

    private Livro obterLivroPelaLinha(String linha) {
        String[] dados = linha.split(";");

        int codigo = Integer.parseInt(dados[0]);
        String titulo = dados[1];
        String categoria = dados[2];
        int copiasDisponiveis = Integer.parseInt(dados[3]);
        int copiasEmprestadas = Integer.parseInt(dados[4]);

        return new Livro(codigo, titulo, categoria, copiasDisponiveis, copiasEmprestadas);
    }

    public Hashtable<Long, Usuario> getUsuarios() {
        return this.usuarios;
    }

    public Hashtable<Integer, Livro> getLivros() {
        return this.livros;
    }

    public static String getDiscPath() {
        return discPath;
    }

    public void cadastraUsuario(Usuario usuario) throws CadastroInvalidoEx {
        if (usuarios.contains(usuario.getNumCPF()))
            throw new CadastroInvalidoEx("Error: cpf já usado para o cadastro de outro usuário");;
        usuarios.put(usuario.getNumCPF(), usuario);
    }

    public void cadastraLivro(Livro livro) throws CadastroInvalidoEx{
        if (livros.contains(livro.getCodigo()))
            throw new CadastroInvalidoEx("Error: código já usado para o cadastro de outro livro");
        livros.put(livro.getCodigo(), livro);
    }

    public void salvaArqUsu(Hashtable<Long, Usuario> usuarios, String nomeArquivo) {
        try (ObjectOutputStream fluxoSaida = new ObjectOutputStream(new FileOutputStream(discPath + nomeArquivo + ".dat"))) {
            fluxoSaida.writeObject(usuarios);
        }catch (IOException e) {
            System.out.println("Error ao salvar o usuários. Por favor, tente novamente");
            e.printStackTrace();
        }
    }

    public void salvaArqLiv(Hashtable<Integer, Livro> livros, String nomeArquivo) {
        try (ObjectOutputStream fluxoSaida = new ObjectOutputStream(new FileOutputStream(discPath + nomeArquivo + ".dat"))) {
            fluxoSaida.writeObject(livros);
        }catch (IOException e) {
            System.out.println("Erro ao salvar os livros. Por favor, tente novamente.");
        }
    }

    public void leArqUsu(String nomeArquivo) {
        try (ObjectInputStream fluxoEntrada = new ObjectInputStream(new FileInputStream(discPath + nomeArquivo + ".dat"))) {
            this.usuarios = (Hashtable<Long, Usuario>) fluxoEntrada.readObject();
        } catch(IOException e) {
            System.out.println("Erro. Não foi possível abrir o arquivo ou este não existe. Por favor, tente novamente");
        } catch(ClassNotFoundException e) {
            System.out.println("Erro. Classe não foi devidamente carregada. Conselho verificar o CLASSPATH e tentar novamente.");
        }
    }

    public void leArqLiv(String nomeArquivo) {
        try (ObjectInputStream fluxoEntrada = new ObjectInputStream(new FileInputStream(discPath + nomeArquivo + ".dat"))) {
            this.livros = (Hashtable<Integer, Livro>) fluxoEntrada.readObject();
        } catch(IOException e) {
            System.out.println("Erro. Não foi possível abrir o arquivo ou este não existe. Por favor, tente novamente");
        } catch(ClassNotFoundException e) {
            System.out.println("Erro. Classe não foi devidamente carregada. Conselho verificar o CLASSPATH e tentar novamente.");
        }
    }

    public void emprestaLivro(Usuario usuario, Livro livro) throws CopiaNaoDisponivelEx {
        livro.empresta();
        livro.addUsuarioHist(LocalDate.now(), null, usuario.getNumCPF());
        usuario.addLivroHist(LocalDate.now(), livro.getCodigo());
    }

    public void devolveLivro(Usuario usuario, Livro livro) throws NenhumaCopiaEmprestadaEx {
        livro.devolve();
        livro.getEmprestimoPendente(usuario).setDataDevolucao(LocalDate.now());
        usuario.getEmprestimoPendente(livro).setDataDevolucao(LocalDate.now());;
    }

    public String imprimeLivros() {
        String livrosCadastrados = "";
        Map<Integer, Livro> livrosOrdenados = new TreeMap<>(this.livros);
        for (Map.Entry<Integer, Livro> entrada : livrosOrdenados.entrySet()) {
            livrosCadastrados += entrada.getValue().toString() + "|-------------------------\n";
        }
        return livrosCadastrados;
    }

    public String imprimeUsuarios() {
        String usuariosCadastrados = "";
        Map<Long, Usuario> usuariosOrdenados = new TreeMap<>(this.usuarios);
        for (Map.Entry<Long, Usuario> entrada : usuariosOrdenados.entrySet()) {
            usuariosCadastrados += entrada.getValue().toString() + "|-------------------------\n";
        }
        return usuariosCadastrados;
    }

    public Livro getLivro(int cod) throws LivroNaoCadastradoEx {
        Livro livro = livros.get(cod);
        if (livro == null) throw new LivroNaoCadastradoEx("O código informado não possui um livro correspondente.");
        return livro;
    }

    public Usuario getUsuario(long CPF) throws UsuarioNaoCadastradoEx {
        Usuario usuario = usuarios.get(CPF);
        if (usuario == null) throw new UsuarioNaoCadastradoEx("O CPF informado não possui um usuário correspondente.");
        return usuario;
    }
}
