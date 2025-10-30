package reto003;

import java.util.Random;

class Edificio {
    public static void main(String[] args) {
        Random random = new Random();
        int hora = 0;
        int horasTotales = 24 * 7;
        int dia = 0;
        final string VENTANA_

        for (int i = 0; i <= horasTotales; i++) {

            hora++;

            if (hora == 24) {
                hora = 1;
                dia = dia + 1;
            };
            


            System.out.print("      __/\\__\r\n" +
                    "  |    |    |  |####|  |    |    |  \r\n" +
                    "====================================\r\n" +
                    ":[ ]::[ ]::[ ]:[    ]:[ ]::[ ]::[ ]: - P7\r\n" +
                    ":[ ]::[ ]::[ ]:[    ]:[ ]::[ ]::[ ]: - P6\r\n" +
                    ":[ ]::[ ]::[ ]:[    ]:[ ]::[ ]::[ ]: - P5\r\n" +
                    ":[ ]::[ ]::[ ]:[    ]:[ ]::[ ]::[ ]: - P4\r\n" +
                    ":[ ]::[ ]::[ ]:[    ]:[ ]::[ ]::[ ]: - P3\r\n" +
                    ":[ ]::[ ]::[ ]:[    ]:[ ]::[ ]::[ ]: - P2\r\n" +
                    ":[ ]::[ ]::[ ]:[    ]:[ ]::[ ]::[ ]: - P1\r\n" +
                    "------------------------------------\r\n" +
                    "     ==========================\r\n" +
                    "   ==============================\r\n" +
                    " ==================================\r\n" +

                    "Dia " + dia + " - " + hora + ":00h ");

        }
    };
}
