package lp2g03.biblioteca;

public class LivroNaoCadastradoEx extends Exception{
    private static final long serialVersionUID = 1149241039409861914L;

    public LivroNaoCadastradoEx(String msg) {
        super(msg);
    }
}
