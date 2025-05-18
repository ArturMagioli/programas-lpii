import java.util.InputMismatchException;

public class P1nX {

    /**
     * Sobre a estrutura dos programas: 
     * programas > P1n > P1nX 
     * -> fazer isso dentro do servidor do professor e sem uso de packages!!
     * @param args
     */
    public static void main(String[] args) {
        try {
            ValidaCPF validaCPF = new ValidaCPF();
            System.out.println(validaCPF.toLong(args[0]));
        }catch (InputMismatchException exception) {
            System.out.println("Error: " + exception.getMessage());
        }
    }
}