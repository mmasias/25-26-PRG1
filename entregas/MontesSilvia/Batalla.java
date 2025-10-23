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
    }
}
}
