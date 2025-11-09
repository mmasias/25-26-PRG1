package entregas.AguilarAdriana.ejercicios;

import java.util.Scanner;


public class CarreraCamellos {
    public static void main(String[] args) {

        final double PROBABILIDAD_ACIERTO_AGUJERO_1 = 0.6;
        final double PROBABILIDAD_ACIERTO_AGUJERO_2 = 0.4;
        final double PROBABILIDAD_ACIERTO_AGUJERO_3 = 0.3;
        final double PROBABILIDAD_ACIERTO_AGUJERO_4 = 0.1;
      
        final int AVANCE_AGUJERO_1=1;
        final int AVANCE_AGUJERO_2=2;
        final int AVANCE_AGUJERO_3=3;
        final int AVANCE_AGUJERO_4=4;
      
        final String PISTA_01="---+-----------+---------+---------+---------+---------+-----------+";
        final String PISTA_02="---| 0.........1.........2.........3.........4.........5.........6 |";
        final String PISTA_03="---| 0123456789012345678901234567890123456789012345678901234567890 |";
        final String PISTA_04="---+-----------+---------+---------+---------+---------+-----------+";
        final String CABECERA="[J]|";
        final String CAMELLO=";--;'";
        final String SEPARADOR="====================================================";

        double casillaProbabilidad;

        final String AVANCE=" ";
        boolean carreraFinalizada=false;
        final int POSICION_FINAL=60;
        int posicion=0;
        Scanner input=new Scanner(System.in);
        int casillaEscogida;
        int turno=0;

        do { 
            System.out.println(SEPARADOR);
            turno++;
            System.out.println("Turno: "+turno);
            System.out.println(PISTA_01);
            System.out.println(PISTA_02);
            System.out.println(PISTA_03);
            System.out.println(PISTA_04);
            System.out.println(CABECERA+AVANCE.repeat(posicion)+CAMELLO);
            System.out.println(PISTA_04);
            System.out.println();


            System.out.println("a que casilla desea apuntar?(1/2/3/4): ");
            casillaEscogida=input.nextInt();

            if (casillaEscogida==1){
                casillaProbabilidad=(Math.random());
                if(PROBABILIDAD_ACIERTO_AGUJERO_1>casillaProbabilidad){
                    posicion= posicion+AVANCE_AGUJERO_1;
                    System.out.println("Acertaste el tiro! Avance casillas: "+AVANCE_AGUJERO_1);
                }else{

                    System.out.println("Has fallado el tiro! Avance casillas: 0");
                }


            }
            else if (casillaEscogida==2){
                casillaProbabilidad=(Math.random());
                if(PROBABILIDAD_ACIERTO_AGUJERO_2>casillaProbabilidad){
                    posicion= posicion+AVANCE_AGUJERO_2;
                    System.out.println("Acertaste el tiro! Avance casillas: "+AVANCE_AGUJERO_2);
                }else{

                    System.out.println("Has fallado el tiro! Avance casillas: 0");
                }


            }
            else if (casillaEscogida==3){
                casillaProbabilidad=(Math.random());
                if(PROBABILIDAD_ACIERTO_AGUJERO_3>casillaProbabilidad){
                    posicion= posicion+AVANCE_AGUJERO_3;
                    System.out.println("Acertaste el tiro! Avance casillas: "+AVANCE_AGUJERO_3);
                }else{

                    System.out.println("Has fallado el tiro! Avance casillas: 0");
                }


            }
            else if (casillaEscogida==4){
                casillaProbabilidad=(Math.random());
                if(PROBABILIDAD_ACIERTO_AGUJERO_4>casillaProbabilidad){
                    posicion= posicion+AVANCE_AGUJERO_4;
                    System.out.println("Acertaste el tiro! Avance casillas: "+AVANCE_AGUJERO_4);
                }else{

                    System.out.println("Has fallado el tiro! Avance casillas: 0");
                }


            }
            else{
                System.out.println("Casilla no valida.");
            }
            if (posicion==POSICION_FINAL){
                carreraFinalizada=true;
                System.out.println("Enhorabuena, has llegado al final en el turno"+turno);
            }

          System.out.println("El jugador está en la posición "+posicion);
          System.out.println(SEPARADOR);
        } while(!carreraFinalizada);



    }

}
