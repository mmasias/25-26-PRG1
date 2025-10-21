import java.util.Scanner;
import java.util.Random;

public class PiedraPapelTijera {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] opciones = { "piedra", "papel", "tijera" };
        int victoriasUsuario = 0;
        int victoriasPrograma = 0;
        int ronda = 1;
        int maxVictorias = 2;

        System.out.println("=================================");
        System.out.println(" PIEDRA, PAPEL O TIJERA");
        System.out.println(" AL MEJOR DE 3");
        System.out.println("=================================");

        while (victoriasUsuario < maxVictorias && victoriasPrograma < maxVictorias && ronda <= 3) {
            System.out.println("\n--- RONDA " + ronda + " ---");
            System.out.println("Elige tu jugada:");
            System.out.println("1. Piedra");
            System.out.println("2. Papel");
            System.out.println("3. Tijera");
            System.out.print("\nTu eleccion: ");

            int eleccionUsuario = scanner.nextInt();

            if (eleccionUsuario >= 1 && eleccionUsuario <= 3) {
                String jugadaUsuario = opciones[eleccionUsuario - 1];
                int numeroAleatorio = random.nextInt(3);
                String jugadaPrograma = opciones[numeroAleatorio];

                System.out.println("\nTu jugada: " + jugadaUsuario.toUpperCase());
                System.out.println("Jugada del programa: " + jugadaPrograma.toUpperCase());

                String resultado = determinarGanador(jugadaUsuario, jugadaPrograma);

                if (resultado.equals("usuario")) {
                    victoriasUsuario++;
                    System.out.println("\nGanaste esta ronda!");
                } else if (resultado.equals("programa")) {
                    victoriasPrograma++;
                    System.out.println("\nEl programa gano esta ronda!");
                } else {
                    System.out.println("\nEmpate! No cuenta para el marcador.");
                    ronda--;
                }

                System.out.println("\nMarcador: Tu " + victoriasUsuario + " - " + victoriasPrograma + " Programa");
                ronda++;

            } else {
                System.out.println("\nOpcion invalida. Elige 1, 2 o 3.");
            }
        }

        System.out.println("\n=================================");
        String ganadorFinal = victoriasUsuario > victoriasPrograma ? "GANASTE EL JUEGO!" : "EL PROGRAMA GANO EL JUEGO!";
        System.out.println(ganadorFinal);
        System.out.println("Resultado final: " + victoriasUsuario + " - " + victoriasPrograma);
        System.out.println("=================================");

        scanner.close();
    }

    public static String determinarGanador(String jugadaUsuario, String jugadaPrograma) {
        String resultado = "";

        if (jugadaUsuario.equals(jugadaPrograma)) {
            resultado = "empate";
        } else if (jugadaUsuario.equals("piedra")) {
            resultado = jugadaPrograma.equals("tijera") ? "usuario" : "programa";
        } else if (jugadaUsuario.equals("papel")) {
            resultado = jugadaPrograma.equals("piedra") ? "usuario" : "programa";
        } else if (jugadaUsuario.equals("tijera")) {
            resultado = jugadaPrograma.equals("papel") ? "usuario" : "programa";
        }

        return resultado;
    }
}
