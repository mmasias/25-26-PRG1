import java.util.Scanner;

class batallaExtendida {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        boolean algunMuerto = false;
        
        final int DAÑO_CUCHILLO = 7;
        final int DAÑO_ESPADA = 15;
        final int DAÑO_HACHA = 30;
        int vidaGuerrero = 150;
        final double PORCENTAJE_EXITO_GUERRERO_CUCHILLO = 0.5;
        final double PORCENTAJE_EXITO_GUERRERO_ESPADA = 0.25;
        final double PORCENTAJE_EXITO_GUERRERO_HACHA = 0.12;
        boolean caballeroVivo = true;
        int ataqueElegidoGuerrero;

        final int DAÑO_MORDIDA1 = 5;
        final int DAÑO_MORDIDA2 = 10;
        final int DAÑO_MORDIDA3 = 20;
        int vidaVampiro = 60;
        final double PORCENTAJE_EXITO_VAMPIRO_ATAQUE_1 = 0.9;
        final double PORCENTAJE_EXITO_VAMPIRO_ATAQUE_2 = 0.6;
        final double PORCENTAJE_EXITO_VAMPIRO_ATAQUE_3 = 0.4;
        double eleccionAtaqueVampiro;
        final double PROBABILIDAD_ELECCION_ATAQUE_1 = 0.3;
        final double PROBABILIDAD_ELECCION_ATAQUE_2 = 0.6;
        boolean vampiroVivo = true;

        double probabilidadGolpe;

        while (!algunMuerto) {

            if (caballeroVivo){
                
                System.out.println("Turno del guerrero, con " + vidaGuerrero + " puntos de vida");
                ataqueElegidoGuerrero = 0;

                while (ataqueElegidoGuerrero != 1 && ataqueElegidoGuerrero != 2 && ataqueElegidoGuerrero != 3){

                    System.out.println("Elige el ataque: \n [1] Ataque cuchillo \n [2] Ataque espada \n [3] Ataque hacha");
                    ataqueElegidoGuerrero = scanner.nextInt();
                    if(ataqueElegidoGuerrero != 1 && ataqueElegidoGuerrero != 2 && ataqueElegidoGuerrero != 3){
                        System.out.println("El guerrero no conoce ese ataque");
                    }
                }

                switch (ataqueElegidoGuerrero){
                    
                    case 1 -> {
                        probabilidadGolpe = Math.random();
                        if (probabilidadGolpe <= PORCENTAJE_EXITO_GUERRERO_CUCHILLO){
                            vidaVampiro = vidaVampiro - DAÑO_CUCHILLO;
                            System.out.println("El guerrero ha herido al vampiro con -" + DAÑO_CUCHILLO + " puntos de vida");
                        }else{
                            System.out.println("El vampiro ha conseguido esquivar el ataque");
                        }
                    }
                

                    case 2 -> {
                        probabilidadGolpe = Math.random();
                        if (probabilidadGolpe <= PORCENTAJE_EXITO_GUERRERO_ESPADA){
                            vidaVampiro = vidaVampiro - DAÑO_ESPADA;
                            System.out.println("El guerrero ha herido al vampiro con -" + DAÑO_ESPADA + " puntos de vida");
                        }else{
                            System.out.println("El vampiro ha conseguido esquivar el ataque");
                        }
                    }
                
                    case 3 -> {
                        probabilidadGolpe = Math.random();
                        if (probabilidadGolpe <= PORCENTAJE_EXITO_GUERRERO_HACHA){
                            vidaVampiro = vidaVampiro - DAÑO_HACHA;
                            System.out.println("El guerrero ha herido al vampiro con -" + DAÑO_HACHA + " puntos de vida");
                        }else{
                            System.out.println("El vampiro ha conseguido esquivar el ataque");
                        }
                    }
                }

                if (vidaVampiro <= 0){
                    vampiroVivo = false;
                    System.out.println("El vampiro ha caido");
                }
            }
            if (vampiroVivo){
                System.out.println("Turno del vampiro, con " + vidaVampiro + " puntos de vida");
                
                eleccionAtaqueVampiro = Math.random();
                if (eleccionAtaqueVampiro <= PROBABILIDAD_ELECCION_ATAQUE_1){
                    System.out.println("El vampiro trata de atacar al guerrero con sus garras");
                    probabilidadGolpe = Math.random();
                    if (probabilidadGolpe <= PORCENTAJE_EXITO_VAMPIRO_ATAQUE_1){
                        vidaGuerrero = vidaGuerrero - DAÑO_MORDIDA1;
                        System.out.println("El vampiro ha herido al guerrero con -" + DAÑO_MORDIDA1 + " puntos de vida");
                    }else{
                        System.out.println("El guerrero ha conseguido esquivar el ataque");
                    } 
                    
                }else if (eleccionAtaqueVampiro >= PROBABILIDAD_ELECCION_ATAQUE_1 && eleccionAtaqueVampiro <= PROBABILIDAD_ELECCION_ATAQUE_2){
                    System.out.println("El vampiro intenta morder al guerrero en un brazo");
                    probabilidadGolpe = Math.random();
                    if (probabilidadGolpe <= PORCENTAJE_EXITO_VAMPIRO_ATAQUE_2){
                        vidaGuerrero = vidaGuerrero - DAÑO_MORDIDA2;
                        System.out.println("El vampiro ha herido al guerrero con -" + DAÑO_MORDIDA2 + " puntos de vida");
                    }else{
                        System.out.println("El guerrero ha conseguido esquivar el ataque");
                    }
                }else {
                    System.out.println("El vampiro ataca con sus colmillos al cuello del guerrero");
                    probabilidadGolpe = Math.random();
                    if (probabilidadGolpe <= PORCENTAJE_EXITO_VAMPIRO_ATAQUE_3){
                        vidaGuerrero = vidaGuerrero - DAÑO_MORDIDA3;
                        System.out.println("El vampiro ha herido al guerrero con -" + DAÑO_MORDIDA3 + " puntos de vida");
                    }else{
                        System.out.println("El guerrero ha conseguido esquivar el ataque");
                    }
                }   

                if (vidaGuerrero <= 0){
                    caballeroVivo = false;
                    System.out.println("El guerrero ha caido");
                }
            }

            if (vidaGuerrero <= 0 || vidaVampiro <= 0) {
                algunMuerto = true;
            }
        }

        if (vidaGuerrero <= 0) {
            System.out.println("La batalla ha terminado. El vampiro ha ganado");
        }else{
            System.out.println("La batalla ha terminado. El guerrero ha ganado");
        }
    }
}
