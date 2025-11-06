import java.util.Scanner;

public class Carrera {
    
public static void main (String [] args) {
    Scanner scanner = new Scanner (System.in);

    final double ACIERTO_AGUJUERO_1 = 0.6;
    final double ACIERTO_AGUJERO_2 = 0.4;
    final double ACIERTO_AGUJERO_3 = 0.3;
    final double ACIERTO_AGUJERO_4 = 0.1;
    final int AVANCE_AGUJERO_1 = 1;
    final int AVANCE_AGUJERO_2 = 2;
    final int AVANCE_AGUJERO_3 = 4;
    final int AVANCE_AGUJERO_4 = 6;
    
    int posicion = 0;
    final int POSICION_FINAL = 60;
    int turno = 0;
    
    boolean alcanzoMeta = false;
    
    int agujeroElegido = 0;
    double probabilidadAcierto = 0.0;
    int avanceTurno = 0;
    boolean aciertoTiro = false;
    
    int fallosConsecutivos = 0; // NUEVA VARIABLE PARA EL RETO EXTENDIDO
    
    final String CAMELLO = ";--;'";
    final String PISTA_1 = "---+-----------+---------+---------+---------+---------+-----------+";
    final String PISTA_2 = "---| 0.........1.........2.........3.........4.........5.........6 |";
    final String PISTA_3 = "---| 0123456789012345678901234567890123456789012345678901234567890 |";
    final String PISTA_4 = "---+-----------+---------+---------+---------+---------+-----------+";
    final String CABECERA_PISTA = "[J]";
    final String AVANCE = " ";
    
    String mensajeTurno = "";
    
    do {
        turno++;
        
        String mensajeRetorno = "";
        
        if (fallosConsecutivos == 3) {
            posicion = 0;
            fallosConsecutivos = 0;
            mensajeRetorno = " ¡FALLO CRÍTICO! Vuelve a la casilla 0.";
        }
        
        if (turno > 1) {
             if (aciertoTiro) {
                 mensajeTurno = " - Avanza " + avanceTurno + " casillas - Esta en la casilla " + posicion;
             } else {
                 mensajeTurno = " - No avanza ninguna casilla - Esta en la casilla " + posicion;
             }
        } else {
            mensajeTurno = "";
        }
        
        System.out.println (PISTA_1);
        System.out.println (PISTA_2);
        System.out.println (PISTA_3);
        System.out.println (PISTA_4);
        
        int posImpresion = posicion;
        if (posImpresion > POSICION_FINAL) {
            posImpresion = POSICION_FINAL;
        }
        System.out.println (CABECERA_PISTA + AVANCE.repeat(posImpresion) + CAMELLO);
        System.out.println (PISTA_1);
        System.out.println("Turno " + (turno - 1) + mensajeTurno + mensajeRetorno);
        
        if (posicion >= POSICION_FINAL) {
            alcanzoMeta = true;
            break; 
        }

        System.out.println("Elija un agujero (1 a 4): ");
        agujeroElegido = scanner.nextInt(); 
        scanner.nextLine(); 
        
        avanceTurno = 0; 
        probabilidadAcierto = 0.0;

        if (agujeroElegido == 1) {
            probabilidadAcierto = ACIERTO_AGUJUERO_1;
            avanceTurno = AVANCE_AGUJERO_1;
        } 
        else if (agujeroElegido == 2) {
            probabilidadAcierto = ACIERTO_AGUJERO_2;
            avanceTurno = AVANCE_AGUJERO_2;
        } 
        else if (agujeroElegido == 3) {
            probabilidadAcierto = ACIERTO_AGUJERO_3;
            avanceTurno = AVANCE_AGUJERO_3;
        } 
        else if (agujeroElegido == 4) {
            probabilidadAcierto = ACIERTO_AGUJERO_4;
            avanceTurno = AVANCE_AGUJERO_4;
        } 
        else {
            probabilidadAcierto = -1.0;
            avanceTurno = 0;
        }
        
        if (Math.random() < probabilidadAcierto) {
            aciertoTiro = true;
            posicion = posicion + avanceTurno;
            fallosConsecutivos = 0; // Reinicia fallos al acertar
        } else {
            aciertoTiro = false;
            fallosConsecutivos++; // Incrementa fallos
        }
        
        alcanzoMeta = posicion>=POSICION_FINAL;

        if (!alcanzoMeta) {
            System.out.println("\nPresiona ENTER para continuar...");
            scanner.nextLine();
        }

    } while (!alcanzoMeta);

    System.out.println("El juego ha terminado");
    scanner.close();
} 

}