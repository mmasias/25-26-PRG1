import java.util.Scanner;

class WhacAMole{

    public static void main(String[] args){

        final String AGUJERO = "( )";
        final String AGUJERO_CON_MONIGOTE = "(‘’)";
        final String AGUJERO_GOLPEADO = "[[]]";
        final String AGUJERO_CON_MONIGOTE_GOLPEADO = "[**]";

        Scanner scanner = new Scanner(System.in);

        int turnos_restantes = 15;

        int aciertos = 0;

        for(; turnos_restantes>0; turnos_restantes--){

            int fila_monigote = (int)(Math.random()*4)+1;
            int columna_monigote = (int)(Math.random()*4)+1;

            System.out.print("FILA: ");
            int fila_seleccionada = scanner.nextInt();
            System.out.print("COLUMNA: ");
            int columna_seleccionada = scanner.nextInt();

            for(int fila = 1; fila <= 4; fila++){
                for(int columna = 1 ;columna <= 4; columna++){

                    if((fila_monigote == fila_seleccionada && fila_seleccionada == fila) && (columna_monigote == columna_seleccionada && columna_seleccionada == columna)){
                        aciertos = aciertos + 1;

                        System.out.print(AGUJERO_CON_MONIGOTE_GOLPEADO);

                    }else if((fila == fila_seleccionada) && (columna == columna_seleccionada)){
                        System.out.print(AGUJERO_GOLPEADO);
                    }else if((fila == fila_monigote) && (columna == columna_monigote)){
                        System.out.print(AGUJERO_CON_MONIGOTE);
                    }else{
                        System.out.print(AGUJERO);
                    }



                }
                System.out.println();
            }


        }
        System.out.println("ACIERTOS: " + aciertos);

    }
}