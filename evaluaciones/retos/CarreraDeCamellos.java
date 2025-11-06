
import java.util.Scanner;

public class CarreraDeCamellos {
    public static void main(String[] args) {
        final String BARRERA1 = "---+-----------+---------+---------+---------+---------+-----------+";
        final String BARRERA2 = "---| 0.........1.........2.........3.........4.........5.........6 |";
        final String BARRERA3 = "---| 0123456789012345678901234567890123456789012345678901234567890 |";
        final String BARRERA4 = "[J]|";
        final String CAMELLO = ";--;'";
        final double PROBABILIDAD1 = 0.6; 
        final double PROBABILIDAD2 = 0.4;
        final double PROBABILIDAD3 = 0.3;
        final double PROBABILIDAD4 = 0.1;
        final int AVANCE1 = 1;
        final int AVANCE2 = 2;
        final int AVANCE3 = 4;
        final int AVANCE4 = 6;

        int turno = 0;
        int posicion = 0;

        final int LONGITUD = 60;
        int agujero = 0;
        boolean avance=false;

Scanner scanner = new Scanner(System.in);
        do { 
            avance=false;
            System.out.println( BARRERA1); 
            System.out.println(BARRERA2);
            System.out.println(BARRERA3);
            System.out.println(BARRERA1);
            System.out.println(BARRERA4+" ".repeat(posicion)+ CAMELLO);
            System.out.println(BARRERA1);
            System.out.println("turno "+ turno);
            System.out.println("Elija un agujero( 1, 2, 3, 4)");
            agujero = scanner.nextInt(); 

            if (agujero==1){
                if(Math.random()<PROBABILIDAD1){
                    posicion=posicion+AVANCE1;
                    avance=true;
                    System.out.println("avanza "+ AVANCE1+ " casillas");
                }
            }else if(agujero==2){
                if(Math.random()<PROBABILIDAD2){
                    posicion=posicion+AVANCE2;
                    avance=true;
                     System.out.println("avanza "+ AVANCE2+ " casillas");
                }

            }else if(agujero==3){
                if(Math.random()<PROBABILIDAD3){
                    posicion=posicion+AVANCE3;
                    avance=true;
                    System.out.println("avanza "+ AVANCE3+ " casillas");
                }
            }else if(agujero==4){
                if(Math.random()<PROBABILIDAD4){
                    posicion=posicion+AVANCE4;  
                    avance=true;
                    System.out.println("avanza "+ AVANCE4+ " casillas");
                } 
            }
        
            System.out.println(!avance?"no avanza ninguna casilla.":"");

        } while (posicion<LONGITUD);
        
        System.out.print("el juego a terminado");
    }
}
    
