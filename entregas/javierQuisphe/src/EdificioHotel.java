import java.util.Random;

public class EdificioHotel {
    private static final int TOTAL_DIAS = 7;
    private static final int HORAS_POR_DIA = 24;
    private static final int TOTAL_PLANTAS = 7;
    private static final int HABITACIONES_POR_PLANTA = 6;
    private static final int HABITACION_ASCENSOR = 4;
    private static final double PROBABILIDAD_PERSIANA_ABIERTA = 0.7;
    private static final double PROBABILIDAD_LUZ_ENCENDIDA = 0.6;
    
    public static void main(String[] args) {
        Random random = new Random();
        
        for (int dia = 1; dia <= TOTAL_DIAS; dia++) {
            for (int hora = 0; hora < HORAS_POR_DIA; hora++) {
                System.out.println("Dia " + dia + " - " + hora + ":00h");
                System.out.println("Ventana cerrada\tLuz apagada\tLuz encendida");
                System.out.println("[ ]\t[º]\t[*]");
                System.out.println();
                
                System.out.println("               __/\\__");
                System.out.println("  |    |    |  |####|  |    |    |  ");
                System.out.println("====================================");
                
                for (int planta = TOTAL_PLANTAS; planta >= 1; planta--) {
                    System.out.print(":");
                    
                    for (int habitacion = 1; habitacion <= HABITACIONES_POR_PLANTA; habitacion++) {
                        if (habitacion == HABITACION_ASCENSOR) {
                            System.out.print("[    ]");
                        } else {
                            boolean persianaAbierta = random.nextDouble() < PROBABILIDAD_PERSIANA_ABIERTA;
                            
                            if (persianaAbierta) {
                                boolean luzEncendida = random.nextDouble() < PROBABILIDAD_LUZ_ENCENDIDA;
                                
                                if (luzEncendida) {
                                    System.out.print("[*]"); 
                                } else {
                                    System.out.print("[º]"); 
                                }
                            } else {
                                System.out.print("[ ]"); 
                            }
                        }
                        
                        if (habitacion != HABITACIONES_POR_PLANTA) {
                            System.out.print("::");
                        }
                    }
                    
                    System.out.println(": - P" + planta);
                }
                
                System.out.println("------------------------------------");
                System.out.println("     ==========================");
                System.out.println("   ==============================");
                System.out.println(" ==================================");
                System.out.println();
                System.out.println();
            }
        }
    }
}