import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MinhaListaOrdenavel {
    private ArrayList<PessoaIMC> pessoasIMC = new ArrayList<>();
    
    //tabela de constantes:
    private final int NOME = 1;
    private final int NOME_DECRESCENTE = 2;
    private final int PESO_CRESCENTE = 3;
    private final int PESO_DECRESCENTE = 4;
    private final int HOMEM = 5;
    private final int MULHER = 6;
    private final int IDADE = 7;
    private final int DATA_NASCIMENTO_CRESCENTE = 8;
    private final int DATA_NASCIMENTO_DECRESCENTE = 9;
    private final int CPF_CRESCENTE = 10;
    private final int CPF_DECRESCENTE = 11;

    //Comparadores:
    public Comparator<PessoaIMC> nomeC = new Comparator<PessoaIMC>() {
        public int compare(PessoaIMC p1, PessoaIMC p2) {
            int num1 = p1.getNome().charAt(0);
            int num2 = p2.getNome().charAt(0);
            return Integer.compare(num1, num2);
        };
    };

    public Comparator<PessoaIMC> nomeCI = new Comparator<PessoaIMC>() {
        public int compare(PessoaIMC p1, PessoaIMC p2) {
            int num1 = p1.getNome().charAt(0);
            int num2 = p2.getNome().charAt(0);
            return Integer.compare(num2, num1);
        };
    };

    public Comparator<PessoaIMC> pesoC = new Comparator<PessoaIMC>() {
        public int compare(PessoaIMC p1, PessoaIMC p2) {
            double pf1, pf2;
            pf1 = p1.getPeso();
            pf2 = p2.getPeso();
            return Double.compare(pf1, pf2);
        };
    };

    public Comparator<PessoaIMC> pesoCD = new Comparator<PessoaIMC>() {
        public int compare(PessoaIMC p1, PessoaIMC p2) {
            return Double.compare(p2.getPeso(), p1.getPeso());
        };
    };

    public Comparator<PessoaIMC> homemC = new Comparator<PessoaIMC>() {
        public int compare(PessoaIMC p1, PessoaIMC p2) {
            if (p1 instanceof Homem && p2 instanceof Mulher) return -1;
            if (p1 instanceof Homem && p2 instanceof Homem) return 0;

            //último caso: p1 instanceof Mulher && p2 instanceof Homem
            return 1;
        };
    };

    public Comparator<PessoaIMC> mulherC = new Comparator<PessoaIMC>() {
        public int compare(PessoaIMC p1, PessoaIMC p2) {
            if (p1 instanceof Homem && p2 instanceof Mulher) return 1;
            if (p1 instanceof Homem && p2 instanceof Homem) return 0;

            //último caso: p1 instanceof Mulher && p2 instanceof Homem
            return -1;
        };
    };

    public Comparator<PessoaIMC> idadeC = new Comparator<PessoaIMC>() {
        public int compare(PessoaIMC p1, PessoaIMC p2) {
            return Integer.compare(p1.getIdade(), p2.getIdade());
        };
    };

    public Comparator<PessoaIMC> dataNascC = new Comparator<PessoaIMC>() {
        public int compare(PessoaIMC p1, PessoaIMC p2) {
            LocalDate d01 = p1.getDataNasc();
            LocalDate d02 = p2.getDataNasc();
            return d01.compareTo(d02);
        };
    };

    public Comparator<PessoaIMC> dataNascD = new Comparator<PessoaIMC>() {
        public int compare(PessoaIMC p1, PessoaIMC p2) {
            LocalDate d01 = p1.getDataNasc();
            LocalDate d02 = p2.getDataNasc();

            return d02.compareTo(d01);
        };
    };

    public Comparator<PessoaIMC> cpfC = new Comparator<PessoaIMC>() {
        public int compare(PessoaIMC p1, PessoaIMC p2) {
            return Long.compare(p1.getNumCPF(), p2.getNumCPF());
        };
    };

    public Comparator<PessoaIMC> cpfD = new Comparator<PessoaIMC>() {
        public int compare(PessoaIMC p1, PessoaIMC p2) {
            return Long.compare(p2.getNumCPF(), p1.getNumCPF());
        };
    };

    public void add(PessoaIMC p) {
        pessoasIMC.add(p);
    }

    public PessoaIMC get(int index) {
        return pessoasIMC.get(index);
    }

    public ArrayList<PessoaIMC> ordena (int criterio) {
        switch(criterio) {
            case NOME:
                Collections.sort(this.pessoasIMC, nomeC);
                break;
            case NOME_DECRESCENTE:
                Collections.sort(this.pessoasIMC, nomeCI);
                break;
            case PESO_CRESCENTE:
                Collections.sort(this.pessoasIMC, pesoC);
                break;
            case PESO_DECRESCENTE:
                Collections.sort(this.pessoasIMC, pesoCD);
                break;
            case HOMEM:
                Collections.sort(this.pessoasIMC, homemC);
                break;
            case MULHER:
                Collections.sort(this.pessoasIMC, mulherC);
                break;
            case IDADE:
                Collections.sort(this.pessoasIMC, idadeC);
                break;
            case DATA_NASCIMENTO_CRESCENTE:
                Collections.sort(this.pessoasIMC, dataNascC);
                break;
            case DATA_NASCIMENTO_DECRESCENTE:
                Collections.sort(this.pessoasIMC, dataNascD);
                break;
            case CPF_CRESCENTE:
                Collections.sort(this.pessoasIMC, cpfC);
                break;
            case CPF_DECRESCENTE:
                Collections.sort(this.pessoasIMC, cpfD);
                break;
            default:
                return null;
        }

        return this.pessoasIMC;
    }
    
}
