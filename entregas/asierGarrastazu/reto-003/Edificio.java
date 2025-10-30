

public class Edificio {
    public static void main(String[] args) {
       final double PERSIANA_ABIERTA = 0.7;
       final double LUZ_ENCENDIDA =0.6;

       final String VENTANA_CERRADA = "[ ]";
       final String VENTANA_ABIERTA_CON_LUZ = "[*]";
       final String VENATANA_ABIERTA_SIN_LUZ = "[º]";
       final String PICO = "               __/\\__";
       final String TEJADO = "  |    |    |  |####|  |    |    |  ";
       final String SEPARADOR = "====================================";
       final String BASE = "------------------------------------";


       
       boolean abierta;
       boolean encendida;
       for (int dia =1 ; dia <=30; dia++) {
        for (int hora =0 ; hora <24; hora++){
              System.out.println("Son las" + hora + "en el dia" +dia );
              System.out.println(PICO);
              System.out.println(TEJADO);
              System.out.println(SEPARADOR);           
           
            for (int planta=1 ; planta <=7; planta++) {
              for (int columna=1 ; columna <=6; columna++) {
                  abierta =Math.random() < PERSIANA_ABIERTA;
                  encendida =Math.random() < LUZ_ENCENDIDA;
                  System.out.println(!abierta ? VENTANA_CERRADA: (encendida ? VENTANA_ABIERTA_CON_LUZ: VENATANA_ABIERTA_SIN_LUZ));
                
            }
        }
       }
       System.out.println(BASE);
    

        }
       }
    }


     