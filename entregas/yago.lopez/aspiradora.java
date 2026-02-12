import java.util.Scanner;
import java.util.Random;

public class aspiradora {
    public static void main(String[] args) {
  
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
    
        char[][] tablero = new char[5][5];
        
        int tesoroFila = rand.nextInt(5);  
        int tesoroColumna = rand.nextInt(5);
 
        for (int fila = 0; fila < 5; fila++) {
            for (int columna = 0; columna < 5; columna++) {
                tablero[fila][columna] = '.';
            }
        }
     
        int intentos = 5;
        boolean encontrado = false;
        
        System.out.println(" BUSCA EL TESORO ");
        System.out.println("Tienes " + intentos + " intentos");
 
        while (intentos > 0 && !encontrado) {
     
            System.out.println("\nTablero:");
            for (int fila = 0; fila < 5; fila++) {
                for (int columna = 0; columna < 5; columna++) {
                    System.out.print(tablero[fila][columna] + " ");
                }
                System.out.println();
            }
    
            System.out.print("\nFila (0-4): ");
            int filaJugador = sc.nextInt();
            System.out.print("Columna (0-4): ");
            int columnaJugador = sc.nextInt();
  
            if (filaJugador == tesoroFila && columnaJugador == tesoroColumna) {
                encontrado = true;
                tablero[filaJugador][columnaJugador] = 'X';
            } else {
   
                int distanciaFila = Math.abs(filaJugador - tesoroFila);
                int distanciaColumna = Math.abs(columnaJugador - tesoroColumna);
                int distanciaTotal = distanciaFila + distanciaColumna;
      
                if (distanciaTotal == 1) {
                    System.out.println("¡MUY CALIENTE! Estás a 1 casilla");
                } else if (distanciaTotal <= 2) {
                    System.out.println("Caliente... Estás cerca");
                } else if (distanciaTotal <= 4) {
                    System.out.println("Tibio... No tan lejos");
                } else {
                    System.out.println("FRÍO... Estás lejos");
                }

                tablero[filaJugador][columnaJugador] = 'O';
                intentos--;
                System.out.println("Te quedan " + intentos + " intentos");
            }
        }
  
        System.out.println("\n" + "=".repeat(30));
        if (encontrado) {
            System.out.println("¡FELICIDADES! Encontraste el tesoro ");
        } else {
            System.out.println("¡PERDISTE! El tesoro estaba en [" + 
                             tesoroFila + "," + tesoroColumna + "]");
        }
       
        System.out.println("\nTablero final:");
        for (int fila = 0; fila < 5; fila++) {
            for (int columna = 0; columna < 5; columna++) {
                if (fila == tesoroFila && columna == tesoroColumna) {
                    System.out.print("X ");
                } else {
                    System.out.print(tablero[fila][columna] + " ");
                }
            }
            System.out.println();
        }
        
        sc.close();
    }
}