import java.util.Scanner;

public class Aspiradora {

    public static void main(String[] args) {

        int[][] superficie = {
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { -1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, -1, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
        };

        int[] posicionAspiradora = { 0, 0 };
        int[] posicionGato = { 4, 4 };

        int[][] actores = { posicionAspiradora, posicionGato };

        ensuciarEscenario(superficie);
        boolean hayQueLimpiar = estaSucia(superficie);
        String respuestaUsuario = "";
        Scanner scanner = new Scanner(System.in);

        do {
            mover(actores, superficie);
            imprimirEscenario(superficie, actores);
            afectar(superficie, actores);
            hayQueLimpiar = estaSucia(superficie);
            pause(0.5);
        } while (hayQueLimpiar);
    }

    static boolean estaSucia(int[][] superficie) {
        for (int i = 0; i < superficie.length; i++) {
            for (int j = 0; j < superficie[i].length; j++) {
                int tile = superficie[i][j];
                if (estaSucio(tile)) {
                    return true;
                }
            }
        }
        return false;
    }

    static void afectar(int[][] superficie, int[][] actores) {
        final int LIMPIA = -1;
        final int ENSUCIA = 1;
        final int SUCIEDAD_MAXIMA = 4;
        final int SUCIEDAD_MINIMA = 0;

        for (int actor = 0; actor < 2; actor++) {

            int[] posicionActor = actores[actor];
            int x = posicionActor[1];
            int y = posicionActor[0];

            int intFactorLimpieza = actor == 0 ? LIMPIA : ENSUCIA;

            superficie[y][x] = superficie[y][x] + intFactorLimpieza;

            superficie[y][x] = superficie[y][x] > SUCIEDAD_MAXIMA ? SUCIEDAD_MAXIMA : superficie[y][x];
            superficie[y][x] = superficie[y][x] < SUCIEDAD_MINIMA ? SUCIEDAD_MINIMA : superficie[y][x];
        }
    }

    static boolean estaSucio(int tile) {
        return tile > 0;
    }

    static void mover(int[][] actores, int[][] superficie) {
        final int X = 1;
        final int Y = 0;

        for (int actor = 0; actor < 2; actor++) {
            int[] posicionActor = actores[actor];
            int movimientoX = (int) (Math.random() * 3) - 1;
            int movimientoY = (int) (Math.random() * 3) - 1;

            posicionActor[X] = posicionActor[X] + movimientoX;
            posicionActor[Y] = posicionActor[Y] + movimientoY;

            if (!posicionValida(posicionActor, superficie)) {
                posicionActor[X] = posicionActor[X] - movimientoX;
                posicionActor[Y] = posicionActor[Y] - movimientoY;
            }
        }
    }

    static boolean posicionValida(int[] posicion, int[][] superficie) {
        int x = posicion[1];
        int y = posicion[0];
        return y >= 0 && y < superficie.length && 
                x >= 0 && x < superficie[0].length &&
                superficie[y][x] >= 0;
    }

    static void ensuciarEscenario(int[][] superficie) {

        for (int row = 0; row < superficie.length; row++) {
            for (int column = 0; column < superficie[row].length; column++) {
                int[] laPosicion = {row, column};
                if(posicionValida(laPosicion,superficie)) {
                    superficie[row][column] = (int) (Math.random() * 5);
                }
            }
        }
    }

    static void imprimirEscenario(int[][] superficie, int[][] actores) {

        int[] posicionAspiradora = actores[0];
        int[] posicionGato = actores[1];

        cleanScreen();
        String elBorde = imprimeBordeHorizontal(superficie[0].length);
        System.out.println(elBorde);

        for (int row = 0; row < superficie.length; row++) {
            System.out.print("|");
            for (int column = 0; column < superficie[row].length; column++) {

                if (row == posicionGato[0] && column == posicionGato[1] && row == posicionAspiradora[0]
                        && column == posicionAspiradora[1]) {
                    System.out.print("G&A");
                } else if (row == posicionGato[0] && column == posicionGato[1]) {
                    System.out.print(mapearGato());
                } else if (row == posicionAspiradora[0] && column == posicionAspiradora[1]) {
                    System.out.print(mapearAspiradora());
                } else {
                    int elTile = superficie[row][column];
                    System.out.print(mapear(elTile));
                }
            }
            System.out.println("|");
        }
        System.out.println(elBorde);

        if (posicionAspiradora[0] == posicionGato[0] &&
                posicionAspiradora[1] == posicionGato[1]) {
            System.out.println("MIAUUUUUUUUUUUUUU");
        }

    }

    static String imprimeBordeHorizontal(int length) {
        return "+" + "===".repeat(length) + "+";
    }

    static String mapearAspiradora() {
        return "(O)";
    }

    static String mapearGato() {
        return ">G<";
    }

    static String mapear(int tile) {

        String[] estadosSuciedad = {
                " . ",
                "...",
                "ooo",
                "OOO",
                "***"
        };
        return tile < 0 ? "###" : estadosSuciedad[tile];
    }

    static void cleanScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    static void pause(double seconds) {
        try {
            Thread.sleep((int) (1000 * seconds));
        } catch (InterruptedException e) {
        }
    }
}
