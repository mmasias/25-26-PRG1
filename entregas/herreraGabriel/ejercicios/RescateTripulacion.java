import java.util.Random;
import java.util.Scanner;


public class RescateTripulacion {
    static final int ESPACIO = 8;
    static final int MAXIMOS_TURNOS = 50;
    static final int TOTAL_TRIPULANTES = 10;

    static final String NIEBLA= ".";
    static final String AGUA= "-";
    static final String TRIPULANTE = "\0/";

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Random random = new Random();

        String[][] tableroReal =new String[ESPACIO][ESPACIO];
        String[][] tableroVisible =new String[ESPACIO][ESPACIO];

        int turnosUsados=0;
        int tripulantesRescatados=0;
        boolean jugando= true;

        inicializarTableros(tableroReal, tableroVisible);
        colocarTripulantes(tableroReal,random);

        System.out.println("Rescate en el mar");
        System.out.println("Hay "+TOTAL_TRIPULANTES+" tripulantes perdidos en el mar");
        System.out.println("Tienes "+MAXIMOS_TURNOS+" turnos para rescatarlos a todos");
        System.out.println("Usa coordenadas como: A4, B7, H3, etc");

        do{
            mostrarTablero(tableroVisible);
            System.out.println("Turnos usados: "+ turnosUsados+ "/"+MAXIMOS_TURNOS);
            System.out.println("Tripulantes rescatados: "+tripulantesRescatados+"/"+TOTAL_TRIPULANTES);

            System.out.println("Introduce coordenadas o salir para terminar:");
            String entrada =scanner.nextLine();
            
            if (entrada.equals("SALIR")){
                jugando = false;
                System.out.println("Gracias por jugar");
                continue;
            }
            if (!validarCoordenadas(entrada)){
                System.out.println("Coordenadas invalidas, usa el formato: A4, B6, etc");
                continue;
            }
            char letraColumna = entrada.charAt(0);
            int columna=0;

            if (letraColumna=='A') columna=0;
            else if (letraColumna=='B') columna=1;
            else if (letraColumna=='C') columna=2;
            else if (letraColumna=='D') columna=3;
            else if (letraColumna=='E') columna=4;
            else if (letraColumna=='F') columna=5;
            else if (letraColumna=='G') columna=6;
            else if (letraColumna=='H') columna=7;

            char numeroChar= entrada.charAt(1);
            int fila=0;

            if (numeroChar=='1') fila=0;
            else if (numeroChar=='2') fila=1;
            else if (numeroChar=='3') fila=2;
            else if (numeroChar=='4') fila=3;
            else if (numeroChar=='5') fila=4;
            else if (numeroChar=='6') fila=5;
            else if (numeroChar=='7') fila=6;
            else if (numeroChar=='8') fila=7;

            if(!tableroVisible[fila][columna].equals(NIEBLA)){
                System.out.println("Ya has explorado esta posicion");
                continue;
            }
            tableroVisible[fila][columna] = tableroReal[fila][columna];
            turnosUsados++;

            String resultado = tableroReal[fila][columna].equals(TRIPULANTE) ? "Rescataste a un tripulante" : "Solo hay agua aqui";
            System.out.println(resultado);

            if (tableroReal[fila][columna].equals(TRIPULANTE)){
                tripulantesRescatados++;
            }
            if (tripulantesRescatados==TOTAL_TRIPULANTES){
                mostrarTablero(tableroVisible);
                System.out.println("Felicidades, rescataste a todos los tripulantes");
                System.out.println("Lo lograste en "+turnosUsados+" turnos");
                jugando =false;
            } else if (turnosUsados>= MAXIMOS_TURNOS){
                mostrarTablero(tableroReal);
                System.out.println("Se acabaron los turnos");
                System.out.println("Rescataste "+tripulantesRescatados+"/"+TOTAL_TRIPULANTES+" tripulantes");
                jugando = false;
            }

        }while (jugando);
    }
    static void inicializarTableros(String[][]real, String[][]visible){
        for (int i = 0; i< ESPACIO; i++){
            for (int j =0;j<ESPACIO;j++){
                real[i][j]= AGUA;
                visible[i][j]=NIEBLA;
            }
        }
    }
    static void colocarTripulantes(String[][] tablero, Random random){
        int colocados = 0;
        while (colocados< TOTAL_TRIPULANTES){
            int fila= random.nextInt(ESPACIO);
            int columna=random.nextInt(ESPACIO);

            if (tablero[fila][columna].equals(AGUA)){
                tablero[fila][columna]= TRIPULANTE;
                colocados++;
            }
        }
    }
    static void mostrarTablero(String[][]tablero) {
        System.out.println("    A    B    C    D    E    F    G    H");
        System.out.println("+----+----+----+----+----+----+----+----+");

        for (int i = 0; i < ESPACIO;i++){
            System.out.println((i+1)+"|");
            
            for (int j=0;j<ESPACIO;j++){
                System.out.println(""+ tablero[i][j]+"|");
            }
            System.out.println("+----+----+----+----+----+----+----+----+");
        }
    }
    static boolean validarCoordenadas(String coordenadas){
        if (coordenadas.length() !=2){
            return false;
        }

        char letra= coordenadas.charAt(0);
        if (letra != '1' && letra != '2'&& letra != '3' && letra != '4' && letra != '5' && letra != '6' && letra != '7' && letra != '8'){
            return false;
        }
        char numero= coordenadas.charAt(1);
        if (numero != '1' && numero != '2'&& numero != '3' && numero != '4' && numero != '5' && numero != '6' && numero != '7' && numero != '8') {
            return false;
        }
        return true;
    }
}
