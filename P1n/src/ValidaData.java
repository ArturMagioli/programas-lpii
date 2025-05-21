import java.time.LocalDate;

public class ValidaData {
    
    public boolean isDia(int dia) {
        return dia >= 1 && dia <= 31;
    }

    public boolean isMes(int mes) {
        return mes >= 1 && mes <= 12;
    }

    public boolean isAno(int ano) {
        return ano <= LocalDate.now().getYear() && ano >= LocalDate.now().getYear() - 120;
    }

    private boolean isDiaMesValido(int dia, int limite) {
        return dia > limite;
    }

    public boolean isDataValida(int dia, MesEnum mes, int ano) {
        if (!isDia(dia) || !isMes(mes.getMes()) || !isAno(ano))
            return false;

        //verificando os meses
        switch (mes.getMes()) {
            case 1 :
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
}
