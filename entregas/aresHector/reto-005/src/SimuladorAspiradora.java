public class SimuladorAspiradora {

    static final int FILAS = 7;
    static final int COLUMNAS = 11;
    static final int CAPACIDAD_MAX_TANQUE = 150;
    static final double CONSUMO_BATERIA = 0.25;
    static final double PROBABILIDAD_GATO = 0.02;
    
    static final int OBSTACULO = -1;
    static final int SUCIEDAD_MAXIMA = 4;

    public static void main(String[] args) {
        int[][] habitacion = new int[FILAS][COLUMNAS];
        int[] posRobot = { 4, 4 }; 

        int tanqueActual = 0;
        double bateriaActual = 100;

        inicializarSuciedad(habitacion);
        colocarSofa(habitacion);

        while (tanqueActual < CAPACIDAD_MAX_TANQUE && bateriaActual > 0) {
            
            moverRobot(posRobot, habitacion);
            tanqueActual = limpiarCasilla(posRobot, habitacion, tanqueActual);
            
            bateriaActual -= CONSUMO_BATERIA;

            System.out.println("Capacidad tanque: " + tanqueActual + "/" + CAPACIDAD_MAX_TANQUE 
                             + ". Batería: " + String.format("%.2f", bateriaActual) + "%");
            
            eventoGato(habitacion);
            imprimirEscenario(habitacion, posRobot);
            
            try { Thread.sleep(100); } catch (InterruptedException e) { }
        }
    }

    static void inicializarSuciedad(int[][] habitacion) {
        for (int i = 0; i < habitacion.length; i++) {
            for (int j = 0; j < habitacion[i].length; j++) {
                habitacion[i][j] = (int) (Math.random() * (SUCIEDAD_MAXIMA + 1));
            }
        }
    }

    static void colocarSofa(int[][] habitacion) {
        int filaSofa = (int) (Math.random() * FILAS);
        int colSofa = (int) (Math.random() * (COLUMNAS - 2)); 

        for (int k = 0; k < 3; k++) {
            habitacion[filaSofa][colSofa + k] = OBSTACULO;
        }
    }

    static void moverRobot(int[] pos, int[][] habitacion) {
        int movimiento = (int) (Math.random() * 4);
        
        int filaAnt = pos[0];
        int colAnt = pos[1];

        switch (movimiento) {
            case 0: pos[0]--; break;
            case 1: pos[0]++; break;
            case 2: pos[1]--; break;
            case 3: pos[1]++; break;
        }

        boolean fueraDeLimites = pos[0] < 0 || pos[0] >= FILAS || pos[1] < 0 || pos[1] >= COLUMNAS;

        if (fueraDeLimites || habitacion[pos[0]][pos[1]] == OBSTACULO) {
            pos[0] = filaAnt;
            pos[1] = colAnt;
        }
    }

    static int limpiarCasilla(int[] pos, int[][] habitacion, int tanque) {
        int suciedadActual = habitacion[pos[0]][pos[1]];

        if (suciedadActual > 0 && suciedadActual != OBSTACULO) {
            habitacion[pos[0]][pos[1]]--; 
            tanque++;
        }
        return tanque;
    }

    static void eventoGato(int[][] habitacion) {
        if (Math.random() > PROBABILIDAD_GATO) {
            return;
        }

        System.out.println("¡MIAU! El gato ha entrado y está haciendo un desastre.");
        
        int[] posGato = new int[2];
        
        do {
            posGato[0] = (int) (Math.random() * FILAS);
            posGato[1] = (int) (Math.random() * COLUMNAS);
        } while (habitacion[posGato[0]][posGato[1]] == OBSTACULO);

        for (int i = 0; i < 25; i++) {
            int filaAnt = posGato[0];
            int colAnt = posGato[1];
            
            int dir = (int) (Math.random() * 4);
            if (dir == 0) posGato[0]--;
            else if (dir == 1) posGato[0]++;
            else if (dir == 2) posGato[1]--;
            else posGato[1]++;

            boolean fueraMapa = posGato[0] < 0 || posGato[0] >= FILAS || posGato[1] < 0 || posGato[1] >= COLUMNAS;

            if (fueraMapa || habitacion[posGato[0]][posGato[1]] == OBSTACULO) {
                posGato[0] = filaAnt;
                posGato[1] = colAnt;
            } else {
                if (habitacion[posGato[0]][posGato[1]] < SUCIEDAD_MAXIMA) {
                    habitacion[posGato[0]][posGato[1]]++;
                }
            }
        }
    }

    static void imprimirEscenario(int[][] habitacion, int[] posRobot) {
        String[] graficosSuciedad = { " .  ", "... ", "ooo ", "OOO ", "*** " };
        
        imprimirBorde();
        for (int i = 0; i < habitacion.length; i++) {
            System.out.print("|");
            for (int j = 0; j < habitacion[i].length; j++) {
                if (i == posRobot[0] && j == posRobot[1]) {
                    System.out.print("(O) ");
                } else if (habitacion[i][j] == OBSTACULO) {
                    System.out.print("[#] ");
                } else {
                    System.out.print(graficosSuciedad[habitacion[i][j]]);
                }
            }
            System.out.print("|");
            System.out.println();
        }
        imprimirBorde();
    }

    static void imprimirBorde() {
        System.out.println("+============================================+");
    }
}