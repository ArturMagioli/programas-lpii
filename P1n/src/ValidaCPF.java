import java.util.InputMismatchException;

public class ValidaCPF {

    public ValidaCPF() {}

    /**
     * Verifica se existe somente números em uma String
     * @param CPF
     * @return
     */
    private boolean justNumbers(String CPF) {
        for(int i = 0; i < CPF.length(); i++)
            if((CPF.charAt(i) < 48) || (CPF.charAt(i) > 57)) 
                return false;

        return true;
    }

    private boolean isJustCPFNumbers(String CPF) {
        if(CPF.length() != 11) 
            return false;

        if (!justNumbers(CPF)) 
            return false;

        return true;
    }

    private boolean isStandardCPFFormat(String CPF) {

        if(CPF.length() != 14)
            return false;

        String CPFPart = CPF.substring(0, 3);
        if (!justNumbers(CPFPart))
            return false;

        CPFPart = CPF.substring(3, 4);
        if (!CPFPart.equals(".")) {
            return false;
        }

        CPFPart = CPF.substring(4, 7);
        if (!justNumbers(CPFPart))
            return false;
        
        CPFPart = CPF.substring(7, 8);
        if(!CPFPart.equals("."))
            return false;

        CPFPart = CPF.substring(8, 11);
        if(!justNumbers(CPFPart))
            return false;

        CPFPart = CPF.substring(11, 12);
        if(!CPFPart.equals("-") && !CPFPart.equals("/"))
            return false;

        CPFPart = CPF.substring(12, 14);
        if(!justNumbers(CPFPart))
            return false;

        return true;
    }

    public boolean isConvertible(String CPF) {
        return isJustCPFNumbers(CPF) || isStandardCPFFormat(CPF);
    }

    /**
     * Realiza a validação de um CPF.
     * inspirando por: <a>https://www.devmedia.com.br/validando-o-cpf-em-uma-aplicacao-java/22097</a>
     * @param CPF
     * @return
     */
    public boolean isCPF(String CPF) throws InputMismatchException{
        //verificando se pode ser convertível.
        if (!isConvertible(CPF)) throw new InputMismatchException("Formato de CPF inválido. Formatos aceitos: XXXXXXXXX, XXX.XXX.XXX-XX, XXX.XXX.XXX/XX");

        //Pode-se remover todos os símbolos desnecessários.
        CPF = CPF.replaceAll("[-./]", "");
        // considere-se erro de CPF's formados por uma sequencia de numeros iguais
        if (CPF.equals("00000000000") || CPF.equals("11111111111") ||
            CPF.equals("22222222222") || CPF.equals("33333333333") ||
            CPF.equals("44444444444") || CPF.equals("55555555555") ||
            CPF.equals("66666666666") || CPF.equals("77777777777") ||
            CPF.equals("88888888888") || CPF.equals("99999999999"))
            throw new InputMismatchException("O número de CPF não deve conter todos os números iguais");

        char dig10, dig11;
        int sm, i, r, num, peso;

        // Calculo do 1o. Digito Verificador
        sm = 0;
        peso = 10;
        for (i=0; i<9; i++) {
            // converte o i-esimo caractere do CPF em um numero:
            // por exemplo, transforma o caractere "0" no inteiro 0
            // (48 eh a posicao de "0" na tabela ASCII)
            num = (int)(CPF.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
        }

        r = 11 - (sm % 11);
        if ((r == 10) || (r == 11)) dig10 = '0';
        else dig10 = (char)(r + 48); // converte no respectivo caractere numerico

        // Calculo do 2o. Digito Verificador
        sm = 0;
        peso = 11;
        for(i=0; i<10; i++) {
            num = (int)(CPF.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
        }

        r = 11 - (sm % 11);
        if ((r == 10) || (r == 11)) dig11 = '0';
        else dig11 = (char)(r + 48);

        // Verifica se os digitos calculados conferem com os digitos informados.
        if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10))) return(true);
        else throw new InputMismatchException("O CPF inserido não é válido.");
    }

    /**
     * Retorna um long de um String CPF válido
     * @param CPF
     * @return
     */
    public long toLong (String CPF) throws RuntimeException {
        if (isCPF(CPF))
            return Long.parseLong(CPF.replaceAll("[-./]", ""));
        else
            throw new RuntimeException("Não foi possível realizar a conversão");
    }
    
    public String imprimeCPF(String CPF) {
        CPF = CPF.replaceAll("[-./]", "");
        return CPF.substring(0, 3) + "." + CPF.substring(3, 6) + "." +
        CPF.substring(6, 9) + "-" + CPF.substring(9, 11);
    }
}
