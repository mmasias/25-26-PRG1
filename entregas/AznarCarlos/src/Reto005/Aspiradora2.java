package Reto005;



import java.util.Scanner;

public class Aspiradora2 {

    @SuppressWarnings("resource")
    public static void main(String[] args) {

        int[][] superficie = {
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
        };

        int[] posicionAspiradora = { 4, 4 };
        int[] posicionGato = { 2, 2 }; 

        ensuciarEscenario(superficie);
        boolean hayQueLimpiar = estaSucia(superficie);

        do {
            moverGato(posicionGato, superficie); 
            moverAspiradora(posicionAspiradora, superficie, posicionGato);

            imprimirEscenario(superficie, posicionAspiradora, posicionGato);

            limpiar(superficie, posicionAspiradora);
            hayQueLimpiar = estaSucia(superficie);

            new Scanner(System.in).nextLine();
        } while (hayQueLimpiar);
    }
    static void ensuciarPorGato(int[][] superficie, int[] posicionGato) {
        int x = posicionGato[0];
        int y = posicionGato[1];
    
        // Ensucia entre +1 y +4
        int suciedadExtra = 1 + (int)(Math.random() * 4);
    
        superficie[x][y] += suciedadExtra;
    
        // límite máximo por si se pasa
        if (superficie[x][y] > 4) superficie[x][y] = 4;
    }
    

    static boolean estaSucia(int[][] superficie){
        for (int i = 0; i < superficie.length; i++) {
            for (int j = 0; j < superficie[i].length; j++) {
                 if(superficie[i][j] > 0){
                     return true;
                 }
            }
        }
        return false;
    }

    static void limpiar(int[][] superficie, int[] aspiradora) {
        if (estaSucio(superficie[aspiradora[0]][aspiradora[1]])) {
            superficie[aspiradora[0]][aspiradora[1]]--;
        }
    }

    static boolean estaSucio(int tile) {
        return tile > 0;
    }


    static void moverGato(int[] posicionGato, int[][] superficie) {
        final int X = 1;
        final int Y = 0;
    
        int movimientoX = (int) (Math.random() * 3) - 1;
        int movimientoY = (int) (Math.random() * 3) - 1;
    
        posicionGato[X] += movimientoX;
        posicionGato[Y] += movimientoY;
    
        if (!posicionValida(posicionGato, superficie)) {
            posicionGato[X] -= movimientoX;
            posicionGato[Y] -= movimientoY;
        }
        ensuciarPorGato(superficie, posicionGato);
    }

   
    static void moverAspiradora(int[] posicionAspiradora, int[][] superficie, int[] posicionGato) {
        final int X = 1;
        final int Y = 0;

        int movimientoX = (int) (Math.random() * 3) - 1;
        int movimientoY = (int) (Math.random() * 3) - 1;

        int nuevoX = posicionAspiradora[X] + movimientoX;
        int nuevoY = posicionAspiradora[Y] + movimientoY;

        
        if (nuevoX == posicionGato[X] && nuevoY == posicionGato[Y]) {
            System.out.println(" La aspiradora intenta avanzar pero el gato la bloquea.");
            return;
        }

        
        if (posicionValida(new int[]{nuevoY, nuevoX}, superficie)) {
            posicionAspiradora[X] = nuevoX;
            posicionAspiradora[Y] = nuevoY;
        }
    }

    static boolean posicionValida(int[] pos, int[][] superficie) {
        return pos[0] >= 0 && pos[0] < superficie.length
                && pos[1] >= 0 && pos[1] < superficie[0].length;
    }

    static void ensuciarEscenario(int[][] superficie) {
        for (int row = 0; row < superficie.length; row++) {
            for (int column = 0; column < superficie[row].length; column++) {
                superficie[row][column] = (int) (Math.random() * 5);
            }
        }
    }

   
    static void imprimirEscenario(int[][] superficie, int[] posicionAspiradora, int[] posicionGato) {
        String borde = imprimeBordeHorizontal(superficie[0].length);
        System.out.println(borde);

        for (int row = 0; row < superficie.length; row++) {
            System.out.print("|");
            for (int column = 0; column < superficie[row].length; column++) {

                if (row == posicionAspiradora[0] && column == posicionAspiradora[1]) {
                    System.out.print(mapearAspiradora());
                } else if (row == posicionGato[0] && column == posicionGato[1]) {
                    System.out.print(mapearGato());
                } else {
                    System.out.print(mapear(superficie[row][column]));
                }
            }
            System.out.println("|");
        }
        System.out.println(borde);
    }

    static String imprimeBordeHorizontal(int length) {
        return "+" + "=".repeat(length * 5) + "+";
    }

    static String mapearAspiradora() { return " (O) "; }

    static String mapearGato() { return "jejej"; }  

    static String mapear(int tile) {
        String[] estadosSuciedad = { "  .  ",
        " ... ",
        " ooo ",
        " OOO ",
        " *** "};
        return estadosSuciedad[tile];
    }

}



