public class PreASpirar {
    public static void main(String[] args) {
        int[][] superficie = new int[7][11];
        int posicionAspiradora[] = { 4, 4 };

        int tanque = 0;
        double bateria = 100;

        final int CAPACIDAD_MAX_TANQUE = 150;

        ensuciarEscenario(superficie);
        sofa(superficie);

        while (tanque < CAPACIDAD_MAX_TANQUE && bateria > 0) {

            movimientoAspiradora(posicionAspiradora, superficie);
            tanque = limpiezaAspiradora(posicionAspiradora, superficie, tanque);
            bateria = bateria - 0.25;
            System.out.println("Capacidad tanque: " + tanque + "/" + CAPACIDAD_MAX_TANQUE + ". Batería: " + bateria);
            gato(superficie);
            imprimirEscenario(superficie, posicionAspiradora);
        }
    }

    static void ensuciarEscenario(int[][] superficie) {
        for (int row = 0; row < superficie.length; row++) {
            for (int column = 0; column < superficie[row].length; column++) {
                superficie[row][column] = (int) (Math.random() * 5);
            }
        }
    }

    static void imprimirEscenario(int[][] superficie, int[] posicionAspiradora) {

        String suciedad[] = { " .  ", "... ", "ooo ", "OOO ", "*** " };

        borde();
        for (int row = 0; row < superficie.length; row++) {
            System.out.print("|");
            for (int column = 0; column < superficie[row].length; column++) {

                if (row == posicionAspiradora[0] && column == posicionAspiradora[1]) {
                    System.out.print("(O) ");
                } else if (superficie[row][column] == -1) {
                    System.out.print("[#] ");
                } else {
                    System.out.print(suciedad[superficie[row][column]]);
                }
            }
            System.out.print("|");
            System.out.println();
        }
        borde();
    }

    static void borde() {
        System.out.println("+============================================+");
    }

    static void movimientoAspiradora(int posicionAspiradora[], int superficie[][]) {
        int movimientoAspiradora = (int) (Math.random() * 4);

        int filaAnterior = posicionAspiradora[0];
        int columnaAnterior = posicionAspiradora[1];

        if (movimientoAspiradora == 0) {
            posicionAspiradora[0]--;
        } else if (movimientoAspiradora == 1) {
            posicionAspiradora[0]++;
        } else if (movimientoAspiradora == 2) {
            posicionAspiradora[1]--;
        } else {
            posicionAspiradora[1]++;
        }

        boolean aspiradoraFueraMapa = posicionAspiradora[0] < 0 || posicionAspiradora[0] > 6
                || posicionAspiradora[1] < 0 || posicionAspiradora[1] > 10;

        if (aspiradoraFueraMapa || superficie[posicionAspiradora[0]][posicionAspiradora[1]] == -1) {
            posicionAspiradora[0] = filaAnterior;
            posicionAspiradora[1] = columnaAnterior;
        }

    }

    static int limpiezaAspiradora(int[] posicionAspiradora, int[][] superficie, int tanque) {

        if (superficie[posicionAspiradora[0]][posicionAspiradora[1]] != 0
                && superficie[posicionAspiradora[0]][posicionAspiradora[1]] != -1) {
            tanque++;
            superficie[posicionAspiradora[0]][posicionAspiradora[1]]--;

        }

        return tanque;
    }

    static void sofa(int[][] superficie) {
        int posicionSofa[] = new int[2];
        posicionSofa[0] = (int) (Math.random() * 7);
        posicionSofa[1] = (int) (Math.random() * 8);
        int posicionSofaFinal = posicionSofa[1] + 2;
        for (int w = posicionSofa[1]; w <= posicionSofaFinal; w++) {
            superficie[posicionSofa[0]][w] = -1;

        }

    }

    static void gato(int[][] superficie) {
        final double PROB_GATO = 0.02;
        double aparicionGato = Math.random();

        if (aparicionGato <= PROB_GATO) {
            int cantidadMovimientoGato = 0;
            System.out.println("El gato se ha movido!");
            int posicionGato[] = new int[2];

            do {
                posicionGato[0] = (int) (Math.random() * 7);
                posicionGato[1] = (int) (Math.random() * 11);
            } while (superficie[posicionGato[0]][posicionGato[1]] == -1);

            for (cantidadMovimientoGato = 0; cantidadMovimientoGato < 25; cantidadMovimientoGato++) {

                int filaAnt = posicionGato[0];
                int colAnt = posicionGato[1];

                int movimientoGato = (int) (Math.random() * 4);

                if (movimientoGato == 0) {
                    posicionGato[0]--;
                } else if (movimientoGato == 1) {
                    posicionGato[0]++;
                } else if (movimientoGato == 2) {
                    posicionGato[1]--;
                } else if (movimientoGato == 3) {
                    posicionGato[1]++;
                }

                boolean fueraMapa = posicionGato[0] < 0 || posicionGato[1] < 0 || posicionGato[0] > 6
                        || posicionGato[1] > 10;

                if (fueraMapa) {
                    posicionGato[0] = filaAnt;
                    posicionGato[1] = colAnt;
                } else if (superficie[posicionGato[0]][posicionGato[1]] == -1) {
                    posicionGato[0] = filaAnt;
                    posicionGato[1] = colAnt;
                } else if (superficie[posicionGato[0]][posicionGato[1]] < 4) {
                    superficie[posicionGato[0]][posicionGato[1]]++;
                }

            }
        } else {
        }
    }

}
