
import java.util.Scanner;

public class Tablasdemultiplicar {
    public static void main(String[] args) {

        boolean funcionando = true;
        do {
            enseñarMenu();
            int opcion = pedirNumeroValidado("Ingresa un numero entre 1 y 5: ", 1, 5);

            switch (opcion) {
                case 1 -> sumar();
                case 2 -> restar();
                case 3 -> multiplicar();
                case 4 -> dividir();
                case 5 -> funcionando = false;
            }

        } while (funcionando);

    }

    private static void sumar() {
        System.out.println("ESTOY SUMANDO");
    }

    private static void restar() {
        System.out.println("ESTOY RESTANDO");
    }

    private static void multiplicar() {

        int numeroLimite = pedirNumeroValidado("¿Qué tabla quieres ver? (1 a 10): ", 1, 10);

        int numero = numeroLimite;

        do {
            System.out.println("TABLA DEL " + numero);

            int contador = 1;
            final int NUMERO_MAXIMO_MULTIPLICACION = 10;

            do {
                int resultado = numero * contador;
                System.out.println(numero + " x " + contador + " = " + resultado);
                contador++;
            } while (contador <= NUMERO_MAXIMO_MULTIPLICACION);

            numero++;

        } while (numero <= numeroLimite);
    }

    private static void dividir() {
        int divisor = pedirNumero("El divisor");
        int dividendo = pedirNumeroValidado("El dividendo (distinto de cero!)", 0);
        int resultado = divisor / dividendo;
        System.out.println(divisor + " / " + dividendo + " = " + resultado);

    }

    private static void enseñarMenu() {
        System.out.println("MENU");
        System.out.println("1. Sumar");
        System.out.println("2. Restar");
        System.out.println("3. Multiplicar");
        System.out.println("4. Dividir");
        System.out.println("5. Salir");
    }

    private static int pedirNumero(String mensaje) {

        Scanner scanner = new Scanner(System.in);
        System.out.println(mensaje);
        int elNumero;
        elNumero = scanner.nextInt();
        return elNumero;
    }

    private static boolean validarOpcion(int valor, int minimo, int maximo) {

        boolean esValido;

        esValido = valor >= minimo && valor <= maximo;
        return esValido;
    }

    private static int pedirNumeroValidado(String mensaje, int minimo, int maximo) {
        int numero;
        boolean esValido;
        do {
            numero = pedirNumero(mensaje);
            esValido = validarOpcion(numero, minimo, maximo);
        } while (!esValido);
        return numero;
    }

    private static int pedirNumeroValidado(String mensaje, int valorPorEvitar) {
        int numero;
        boolean esValido;
        do {
            numero = pedirNumero(mensaje);
            esValido = validarOpcion(numero, valorPorEvitar);
        } while (!esValido);
        return numero;
    }

    private static boolean validarOpcion(int valor, int valorPorEvitar) {
        boolean esValido;
        esValido = valor != valorPorEvitar;
        return esValido;
    }
}