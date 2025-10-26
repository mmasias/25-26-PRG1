class batalla {

    public static void main(String[] args) {

        boolean algunMuerto = false;
        
        final int DAÑO_ESPADA = 2;
        int vidaGuerrero = 20;
        final double PORCENTAJE_EXITO_GUERRERO = 0.5;
        boolean caballeroVivo = true;

        final int DAÑO_MORDIDA = 4;
        int vidaVampiro = 10;
        final double PORCENTAJE_EXITO_VAMPIRO = 0.5;
        boolean vampiroVivo = true;

        double probabilidadGolpe;

        while (!algunMuerto) {

            if (caballeroVivo == true){
                
                System.out.println("Turno del guerrero, con " + vidaGuerrero + " puntos de vida");
                probabilidadGolpe = Math.random();
                if (probabilidadGolpe >= PORCENTAJE_EXITO_GUERRERO){
                    vidaVampiro = vidaVampiro - DAÑO_ESPADA;
                    System.out.println("El ataque ha herido al vampiro con -" + DAÑO_ESPADA + " puntos de vida");
                    if (vidaVampiro <=0){
                        vampiroVivo = false;
                        System.out.println("El vampiro ha muerto");
                    }
                } else {
                    System.out.println("El vampiro ha conseguido esquivar el ataque");
                }
            }

            if (vampiroVivo == true){
                System.out.println("Turno del vampiro, con " + vidaVampiro + " puntos de vida");
                probabilidadGolpe = Math.random();
                if (probabilidadGolpe >= PORCENTAJE_EXITO_VAMPIRO){
                    vidaGuerrero = vidaGuerrero - DAÑO_MORDIDA;
                    System.out.println("El vampiro ha herido al guerrero con -" + DAÑO_MORDIDA + " puntos de vida");
                    if (vidaGuerrero <= 0){
                        caballeroVivo = false;
                        System.out.println("El guerrero ha caido");
                    }
                } else {
                    System.out.println("El guerrero ha conseguido esquivar el ataque");
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