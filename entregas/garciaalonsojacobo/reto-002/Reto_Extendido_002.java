import java.util.Scanner;

public class Reto_Extendido_002 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int VIDA_GUERRERO = 150;
        final int DAÑO_ARMA_1_GUERRERO = 7;
        final int DAÑO_ARMA_2_GUERRERO = 15;
        final int DAÑO_ARMA_3_GUERRERO = 30;
        final double PORCENTAJE_EXITO_GUERRERO_ARMA_1 = 0.5;
        final double PORCENTAJE_EXITO_GUERRERO_ARMA_2 = 0.25;
        final double PORCENTAJE_EXITO_GUERRERO_ARMA_3 = 0.12;

        int VIDA_VAMPIRO = 60;
        final int DAÑO_ATAQUE_1_VAMPIRO = 5;
        final int DAÑO_ATAQUE_2_VAMPIRO = 10;
        final int DAÑO_ATAQUE_3_VAMPIRO = 20;
        final double PORCENTAJE_EXITO_VAMPIRO_ATAQUE_1 = 0.9;
        final double PORCENTAJE_EXITO_VAMPIRO_ATAQUE_2 = 0.6;
        final double PORCENTAJE_EXITO_VAMPIRO_ATAQUE_3 = 0.4;

        boolean algunMuerto = false;

        boolean vampiroVivo = VIDA_VAMPIRO >= 0;
        boolean guerreroVivo = VIDA_GUERRERO >= 0;

        do {
            boolean exito_Arma_1_guerrero = Math.random() < PORCENTAJE_EXITO_GUERRERO_ARMA_1;
            boolean exito_Arma_2_guerrero = Math.random() < PORCENTAJE_EXITO_GUERRERO_ARMA_2;
            boolean exito_Arma_3_guerrero = Math.random() < PORCENTAJE_EXITO_GUERRERO_ARMA_3;
            boolean exito_ataque_1_vampiro = Math.random() < PORCENTAJE_EXITO_VAMPIRO_ATAQUE_1;
            boolean exito_ataque_2_vampiro = Math.random() < PORCENTAJE_EXITO_VAMPIRO_ATAQUE_2;
            boolean exito_ataque_3_vampiro = Math.random() < PORCENTAJE_EXITO_VAMPIRO_ATAQUE_3;
            int arma_Escogida_Usuario = 0;
            do {
                System.out.println("¿QUE ARMA ESCOGES HEROE, entre 1,2,3?");
                arma_Escogida_Usuario = scanner.nextInt();
                if (arma_Escogida_Usuario < 1 || arma_Escogida_Usuario > 3) {
                    System.out.println("El arma selecionada es incorrecta debes elegir entre 1,2,3!!");
                }
            } while (arma_Escogida_Usuario < 1 || arma_Escogida_Usuario > 3);
            if (guerreroVivo) {
                if (arma_Escogida_Usuario == 1) {
                    if (exito_Arma_1_guerrero) {
                        VIDA_VAMPIRO = VIDA_VAMPIRO - DAÑO_ARMA_1_GUERRERO;
                        System.out.println("El guerrero ha golpeado al vampiro.");
                    } else {
                        System.out.println("El vampiro a esquivado el golpe");
                    }
                } else if (arma_Escogida_Usuario == 2) {
                    if (exito_Arma_2_guerrero) {
                        VIDA_VAMPIRO = VIDA_VAMPIRO - DAÑO_ARMA_2_GUERRERO;
                        System.out.println("El guerrero ha golpeado al vampiro.");
                    } else {
                        System.out.println("El vampiro a esquivado el golpe");
                    }
                } else if (arma_Escogida_Usuario == 3) {
                    if (exito_Arma_3_guerrero) {
                        VIDA_VAMPIRO = VIDA_VAMPIRO - DAÑO_ARMA_3_GUERRERO;
                        System.out.println("El guerrero ha golpeado al vampiro.");
                    } else {
                        System.out.println("El vampiro a esquivado el golpe");
                    }
                }
            }

            int ataqueVampiro = (int) (Math.random() * 3) + 1;
            if (vampiroVivo) {
                if (ataqueVampiro == 1) {
                    if (exito_ataque_1_vampiro) {
                        VIDA_GUERRERO = VIDA_GUERRERO - DAÑO_ATAQUE_1_VAMPIRO;
                        System.out.println("El vampiro a golpeado al heroe con su ataque 1");
                    } else {
                        System.out.println("El guerrero a esquivado al vampiro ");
                    }
                } else if (ataqueVampiro == 2) {
                    if (exito_ataque_2_vampiro) {
                        VIDA_GUERRERO = VIDA_GUERRERO - DAÑO_ATAQUE_2_VAMPIRO;
                        System.out.println("El vampiro a golpeado al heroe con su ataque 2");
                    } else {
                        System.out.println("El guerrero a esquivado al vampiro ");
                    }
                } else if (ataqueVampiro == 3) {
                    if (exito_ataque_3_vampiro) {
                        VIDA_GUERRERO = VIDA_GUERRERO - DAÑO_ATAQUE_3_VAMPIRO;
                        System.out.println("El vampiro a golpeado al heroe con su ataque 3");
                    }
                 else {
                    System.out.println("El guerrero a esquivado al vampiro ");
                }
            }
            }

            System.out.println("vida del vampiro= " + "[" + VIDA_VAMPIRO + "]" + " / " + "Vida del guerrero= " + "["
                    + VIDA_GUERRERO + "]");
            System.out.println();
            vampiroVivo = VIDA_VAMPIRO >= 0;
            guerreroVivo = VIDA_GUERRERO >= 0;
            algunMuerto = !guerreroVivo || !vampiroVivo;

        } while (!algunMuerto);
        System.out.println("El ganador es : " + (VIDA_GUERRERO < 0 ? " ¡EL VAMPRIO!" : " ¡EL GUERRERO!"));
scanner.close();
    }
}
