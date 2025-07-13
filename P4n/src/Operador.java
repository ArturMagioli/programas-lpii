public class Operador {
    private MinhaListaOrdenavel listaOrdenavel = new MinhaListaOrdenavel();

    public Operador() {
        inserirElementos();
    }

    public MinhaListaOrdenavel getListaOrdenavel() {
        return listaOrdenavel;
    }

    private void inserirElementos() {
        listaOrdenavel.add(new Homem("João", 12, 5, 1980, Long.parseLong("11111111111"), (float)78.5, (float)1.75));
        listaOrdenavel.add(new Homem("Carlos", 23, 8, 1990, Long.parseLong("22222222222"), (float)82.0, (float)1.80));
        listaOrdenavel.add(new Homem("Marcos", 7, 1, 1975, Long.parseLong("33333333333"), (float)90.2, (float)1.78));
        listaOrdenavel.add(new Homem("Felipe", 30, 9, 1988, Long.parseLong("44444444444"), (float)70.0, (float)1.70));
        listaOrdenavel.add(new Mulher("Ana", 5, 3, 1985, Long.parseLong("66666666666"), (float)60.5, (float)1.65));
        listaOrdenavel.add(new Mulher("Beatriz", 18, 7, 1992, Long.parseLong("77777777777"), (float)68.0, (float)1.70));
        listaOrdenavel.add(new Mulher("Camila", 10, 11, 1989, Long.parseLong("88888888888"), (float)55.3, (float)1.60));
        listaOrdenavel.add(new Mulher("Daniela", 25, 6, 1993, Long.parseLong("99999999999"), (float)64.7, (float)1.68));
        listaOrdenavel.add(new Mulher("Eduarda", 2, 2, 1990, Long.parseLong("10101010101"), (float)72.1, (float)1.72));
    }
}
