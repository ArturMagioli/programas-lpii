package lp2g03.biblioteca;

public class UsuarioNaoCadastradoEx extends Exception {
    
    private static final long serialVersionUID = 1149241039409861914L;
    
    public UsuarioNaoCadastradoEx(String msg) {
        super(msg);
    }
}
