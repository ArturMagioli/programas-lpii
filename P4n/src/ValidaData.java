import java.time.LocalDate;

public class ValidaData {

    private static boolean isNumber(String arg) {
        for (int i = 0; i < arg.length(); i++) {
            if (arg.charAt(0) < 48 || arg.charAt(i) > 57) return false;
        }
        return true;
    }

    public static int converterMes(String mes) {
        if(isNumber(mes)) {
            return Integer.parseInt(mes);
        }else{
            for(MesEnum m : MesEnum.values()) {
                if(mes.toUpperCase().equals(m.toString())) {
                    return m.getMes();
                }
            }
            return -1;
        }
    }

    public static boolean isDia(String dia) {
        if(isNumber(dia)) {
            int diaInt = Integer.parseInt(dia);
            return diaInt >= 1 && diaInt <= 31;
        }else {
            return false;
        }
    }

    public static  boolean isAno(String ano) {
        if(isNumber(ano)) {
            int anoInt = Integer.parseInt(ano);
            return anoInt <= LocalDate.now().getYear() && anoInt >= LocalDate.now().getYear() - 120;
        }else{
            return false;
        }
    }

    public static boolean isMes(String mes) {
        int mesInt = converterMes(mes);
        return mesInt >= 1 && mesInt <= 12;
    }
    
    private static boolean isDiaMesValido(String dia, int limite) {
        return Integer.parseInt(dia) <= limite;
    }

    private static boolean isDataValida2(String dia, String mes) {
        if(mes.toUpperCase().equals("JANEIRO")) return isDiaMesValido(dia, 31);
        if(mes.toUpperCase().equals("FEVEREIRO")) return isDiaMesValido(dia, 28);
        if(mes.toUpperCase().equals("MARCO")) return isDiaMesValido(dia, 31);
        if(mes.toUpperCase().equals("ABRIL")) return isDiaMesValido(dia, 30);
        if(mes.toUpperCase().equals("MAIO")) return isDiaMesValido(dia, 31);
        if(mes.toUpperCase().equals("JUNHO")) return isDiaMesValido(dia, 30);
        if(mes.toUpperCase().equals("JULHO")) return isDiaMesValido(dia, 31);
        if(mes.toUpperCase().equals("AGOSTO")) return isDiaMesValido(dia, 31);
        if(mes.toUpperCase().equals("SETEMBRO")) return isDiaMesValido(dia, 30);
        if(mes.toUpperCase().equals("OUTUBRO")) return isDiaMesValido(dia, 31);
        if(mes.toUpperCase().equals("NOVEMBRO")) return isDiaMesValido(dia, 30);
        if(mes.toUpperCase().equals("DEZEMBRO")) return isDiaMesValido(dia, 31);

        return false;
    }

    private static boolean isDataValida2(String dia, int mes) {
        //verificando os meses
        switch (mes) {
            case 1:
                return isDiaMesValido(dia, 31);
            case 2:
                return isDiaMesValido(dia, 28);
            case 3:
                return isDiaMesValido(dia, 31);
            case 4:
                return isDiaMesValido(dia, 30);
            case 5:
                return isDiaMesValido(dia, 31);
            case 6:
                return isDiaMesValido(dia, 30);
            case 7:
                return isDiaMesValido(dia, 31);
            case 8:
                return isDiaMesValido(dia, 31);
            case 9:
                return isDiaMesValido(dia, 30);
            case 10:
                return isDiaMesValido(dia, 31);
            case 11:
                return isDiaMesValido(dia, 30);
            case 12:
                return isDiaMesValido(dia, 31);
            default:
                return false;
        }
    }

    public static boolean isDataValida(String dia, String mes) {
        if(isNumber(mes))
            return isDataValida2(dia, Integer.parseInt(mes));
        else
            return isDataValida2(dia, mes);
    }
}
