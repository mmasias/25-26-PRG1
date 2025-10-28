import java.util.Scanner;

class PiedraPapelTijeras {
    public static void main(String[] args) {

    boolean piedraJugador = false;
    boolean papelJugador = false;
    boolean tijerasJugador = false;

    boolean piedraMaquina = false;
    boolean papelMaquina = false;
    boolean tijerasMaquina = false;
    
    boolean error = false;
        System.out.println("Elige: piedra(1), papel(2) o tijeras(3)");
    Scanner scanner = new Scanner(System.in);
    int elegidoJugador = scanner.nextInt();

scanner.close();
    
    String resultado = "";

        if (elegidoJugador == 1) {
            piedraJugador = true;
        } else if (elegidoJugador == 2) {
            papelJugador = true;
        } else if (elegidoJugador == 3) {
            tijerasJugador = true;
        } else {
            error = true;
        }

        int elegidoMaquina = (int)(Math.random() * 3) + 1;
        if (elegidoMaquina == 1) {
            piedraMaquina = true;
            System.out.println("La máquina eligió piedra");
        } else if (elegidoMaquina == 2) {
            papelMaquina = true;
            System.out.println("La máquina eligió papel");
        } else if (elegidoMaquina == 3) {
            tijerasMaquina = true;
            System.out.println("La máquina eligió tijeras");
        }

    if (!error) {
        if (piedraJugador && tijerasMaquina || papelJugador && piedraMaquina || tijerasJugador && papelMaquina) {
        resultado = "Gana el jugador.";
    } else if (piedraMaquina && tijerasJugador || papelMaquina && piedraJugador || tijerasMaquina && papelJugador) {
        resultado = "Gana la máquina.";
    } else {
        resultado = "Empate.";
    }
    } else {
        resultado = "Error en la elección del jugador.";
    }
    
        System.out.println("Resultado: " + resultado);
 
}
}