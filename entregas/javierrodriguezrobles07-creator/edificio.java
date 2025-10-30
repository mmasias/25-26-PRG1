import java.util.Random;

public class edificio {

    public static void main(String[] args) {
        final int PLANTAS = 7;           
        final int HABITACIONES_POR_PLANTA = 6;
        final int DIAS = 7;
        final int HORAS_DIA = 24;

        final double PROB_PERSIANA_ABIERTA = 0.70; 
        final double PROB_LUZ_ENCENDIDA = 0.60;    
        final double PROB_RAYO_POR_HORA = 0.20;   
        final double PROB_MANTENIMIENTO_DIA = 0.05;

        Random rnd = new Random();

        int[] consumosDiarios = new int[DIAS];

        for (int dia = 1; dia <= DIAS; dia++) {
            
            boolean[] columnaAveriada = new boolean[HABITACIONES_POR_PLANTA];
            int plantaEnMantenimiento = -1; 

            
            if (rnd.nextDouble() < PROB_MANTENIMIENTO_DIA) {
                plantaEnMantenimiento = 1 + rnd.nextInt(PLANTAS); // 1..7
            }

            boolean rayoCaidoHoy = false;
            int columnaRayo = -1;
            Integer horaRayo = null;

            int consumoDelDia = 0;

            
            for (int hora = 0; hora < HORAS_DIA; hora++) {
                if (!rayoCaidoHoy) {
                    for (int col = 0; col < HABITACIONES_POR_PLANTA; col++) {
                        if (rnd.nextDouble() < PROB_RAYO_POR_HORA) {
                            columnaAveriada[col] = true;
                            rayoCaidoHoy = true;
                            columnaRayo = col + 1; 
                            horaRayo = hora;
                            break; 
                        }
                    }
                }

                
                int contadorLucesHora = 0;

                
                System.out.println();
                System.out.println("               __/\\__");
                System.out.println("  |    |    |  |####|  |    |    |  ");
                System.out.println("====================================");

                
                for (int p = PLANTAS; p >= 1; p--) {
                    StringBuilder fila = new StringBuilder();
                    fila.append(":");
                    for (int c = 1; c <= HABITACIONES_POR_PLANTA; c++) {
                        if (c == 4) {
                        }

                        
                        boolean averia = columnaAveriada[c - 1];
                        boolean mantenimiento = (p == plantaEnMantenimiento);

                        String simbolo;
                        if (mantenimiento) {
                            simbolo = "[#]";
                        } else if (averia) {
                            simbolo = "[X]";
                        } else {
                           
                            boolean persianaAbierta = rnd.nextDouble() < PROB_PERSIANA_ABIERTA;
                            boolean luzEncendida = rnd.nextDouble() < PROB_LUZ_ENCENDIDA;

                            
                            if (averia || mantenimiento) luzEncendida = false;

                            // Contabilizar consumo real (si la lámpara está encendida, aunque no sea visible)
                            if (luzEncendida) contadorLucesHora++;

                            // Mostrar: si persiana abierta -> "[ ]" (vacío)
                            // si persiana cerrada -> ver estado de la luz: encendida "[*]" o apagada "[º]"
                            if (persianaAbierta) {
                                simbolo = "[ ]";
                            } else {
                                simbolo = luzEncendida ? "[*]" : "[º]";
                            }
                        }

                        // Añadir símbolo en la posición correspondiente
                        fila.append(simbolo);

                       
                        if (c == 3) {
                            fila.append(":");                // cierre izquierda
                            fila.append("[    ]");           // hueco central
                            fila.append(":");                // apertura derecha
                        }
                        if (c < HABITACIONES_POR_PLANTA) fila.append(":");
                    }

                   
                    fila.append(" - P").append(p);
                    System.out.println(fila.toString());
                }

                System.out.println("------------------------------------");
                System.out.println("     ==========================");
                System.out.println("   ==============================");
                System.out.println(" ==================================");

                
                System.out.println();
                System.out.printf("Dia %d - %02d:00h Consumo hora: %d%n", dia, hora, contadorLucesHora);

               
                if (rayoCaidoHoy && hora == horaRayo) {
                    System.out.println("Un rayo ha inutilizado la columna " + columnaRayo);
                }
                if (plantaEnMantenimiento != -1 && hora == 0) {
                    System.out.println(plantaEnMantenimiento + "º planta en mantenimiento");
                }

                consumoDelDia += contadorLucesHora;
            } 

            consumosDiarios[dia - 1] = consumoDelDia;
           
            System.out.println();
            System.out.print("CONSUMOS: ");
            for (int d = 1; d <= dia; d++) {
                System.out.print("D" + d + ": " + consumosDiarios[d - 1] + " | ");
            }
            System.out.println();
            System.out.println("Consumo total dia " + dia + ": " + consumoDelDia);
            System.out.println("----------------------------------------------------");
        } 

      
        System.out.println();
        System.out.print("CONSUMOS: ");
        int suma = 0;
        for (int d = 0; d < DIAS; d++) {
            System.out.print("D" + (d + 1) + ": " + consumosDiarios[d] + " | ");
            suma += consumosDiarios[d];
        }
        double media = (double) suma / DIAS;
        System.out.println();
        System.out.printf("Media de consumo semanal: %.0f%n", media);
    }
}

