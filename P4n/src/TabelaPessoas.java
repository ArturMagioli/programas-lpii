import javax.swing.JTable;

import java.util.ArrayList;

public class TabelaPessoas extends JTable {
    public TabelaPessoas(String[] campos, ArrayList<PessoaIMC> dados) {
        super(extrairDados(dados, campos), campos);
    }

    private static Object[][] extrairDados(ArrayList<PessoaIMC> dados, String[] campos) {
        Object[][] dadosTabela = new Object[dados.size()][campos.length];
        
        for (int i = 0; i < dados.size(); i++) {
            dadosTabela[i] = dados.get(i).converterParaString();
        }
        
        return dadosTabela;
    }
}
