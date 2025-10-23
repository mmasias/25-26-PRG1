package src;
class Batalla {
    public static void main (String []args) {
        boolean algunMuerto =false;
        final int DAÑO_ESPADA=2;
        int vidaGuerrero =20;
        final double PORCENTAJE_EXITO_GUERRERO=0.5;
        final int DAÑO_MORDIDA =4;
        int vidaVampiro=10;
        final double PORCENTAJE_EXITO_VAMPIRO=0.5;
        boolean algunMuerto=false;
        boolean guerreroVivo= true;
        boolean vampiroVivo=true;
        int vidaGuerrero = 150;
        int vidaVampiro = 60;
        final int DAÑO_ARMA1 = 7;
        final double EXITO_ARMA1 = 0.5;
        final int DAÑO_ARMA2= 15;
        final double EXITO_ARMA2= 0.25;
        final int DAÑO_ARMA3 = 30;
        final double EXITO_ARMA3 = 0.12;
        final int DAÑO_ATAQUE1 = 5;
        final double EXITO_ATAQUE1 = 0.9;
         final int DAÑO_ATAQUE2 = 10;
        final double EXITO_ATAQUE2 = 0.6;

        final int DAÑO_ATAQUE3 = 20;
        final double EXITO_ATAQUE3 = 0.4;

        boolean guerreroVivo = true;
        boolean vampiroVivo = true;
        double probabilidadGolpe = 0;

        System.out.println("¡Comienza la batalla entre el Guerrero y el Vampiro!");
        System.out.println("Vida Guerrero [" + vidaGuerrero + "] / Vida Vampiro [" + vidaVampiro + "]");
    
        double probabilidadGolpe=0;
        while (!algunMuerto){
            if (Math.random()<PORCENTAJE_EXITO_GUERRERO){
                vidaVampiro=vidaVampiro - DAÑO_ESPADA;
                System.out.println ("El vampiro recibe una torta");
            } else {
                System.out.println ("El vampiro esquiva la torta");
            }
            boolean vampiroVivo =vidaVampiro <=0;
            if (vampiroVivo) {

            
            if (Math.random() <PORCENTAJE_EXITO_VAMPIRO){
                vidaGuerrero =vidaGuerrero- DAÑO_MORDIDA;
                System.out.println ("El guerrero recibe una mordida");

            } else {
                System.out.println ("El guerrero esquiva la mordida");
            }
            System.out.println ("Vida Guerrero [" + vidaGuerrero + "] /Vida Vampiro [" + vidaVampiro + "]");
            boolean guerreroVivo= vidaGuerrero <=0;
            algunMuerto=vidaGuerrero<=0 || vidaVampiro <=0 ;

               
            
                
            



        } while (!algunMuerto);
        String elGanador = vidaGuerrero >0 ? "Guerrero" : "Vampiro";
        System.out.println ("Ganó el " + elGanador);
        System.out.println("\nTurno del Guerrero. Elige tu arma:");
        System.out.println(" (Daño 7 por tanto éxito 50%)");
        System.out.println("(Daño 15 por tanto éxito 25%)");
        System.out.println ("(Daño 30 por tanto éxito 12%)");

         if (Math.random() < EXITO_ATAQUE1) {
                    vidaGuerrero = vidaGuerrero - DAÑO_ATAQUE1;
                    System.out.println("El vampiro usa ATAQUE 1. El guerrero recibe " + DAÑO_ATAQUE1 + " de daño.");
                } else {
                    System.out.println("El guerrero esquiva el ATAQUE 1 del vampiro.");
      

                }
        if (Math.random() < EXITO_ATAQUE2) {
                    vidaGuerrero = vidaGuerrero - DAÑO_ATAQUE2;
                    System.out.println(" El vampiro usa ATAQUE 2. El guerrero recibe " + DAÑO_ATAQUE2 + " de daño.");
                } else {
                    System.out.println("El guerrero esquiva el ATAQUE 2 del vampiro.");
                }
        if (Math.random() < EXITO_ATAQUE3) {
                    vidaGuerrero = vidaGuerrero - DAÑO_ATAQUE3;
                    System.out.println(" El vampiro usa ATAQUE 3. El guerrero recibe " + DAÑO_ATAQUE2 + " de daño.");
                } else {
                    System.out.println("El guerrero esquiva el ATAQUE 3 del vampiro.");
                }
           
            
                    
        
        


        
    }
}
}
