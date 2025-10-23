class juego {
    public static void main(String[] args) {

        int vidaGuerrero = 150;
        final int DAÑO_ARMA_UNO = 7;
        final double PORCENTAJE_EXITO_ARMA_UNO = 0.5;
        final int DAÑO_ARMA_DOS = 15;
        final double PORCENTAJE_EXITO_ARMA_DOS = 0.25;
        final int DAÑO_ARMA_TRES = 30;
        final double PORCENTAJE_EXITO_ARMA_TRES = 0.12;

        int vidaVampiro = 60;
        final int DAÑO_ARMA_CUATRO = 5;
        final double PORCENTAJE_EXITO_ARMA_CUATRO = 0.9;
        final int DAÑO_ARMA_CINCO = 10;
        final double PORCENTAJE_EXITO_ARMA_CINCO = 0.6;
        final int DAÑO_ARMA_SEIS = 20;
        final double PORCENTAJE_EXITO_ARMA_SEIS = 0.4;

        boolean algunMuerto = false;

       do{
                if(Math.random()<PORCENTAJE_EXITO_ARMA_UNO){
                vidaVampiro = vidaVampiro - DAÑO_ARMA_UNO;
                System.out.println("Vampiro recibe un golpe");
            } else if (Math.random()<PORCENTAJE_EXITO_ARMA_DOS){
                vidaVampiro = vidaVampiro - DAÑO_ARMA_DOS;
                System.out.println("Vampiro recibe un buen golpe");
            } else if(Math.random()<PORCENTAJE_EXITO_ARMA_TRES){
                vidaVampiro = vidaVampiro - DAÑO_ARMA_TRES;
                System.out.println("Vampiro recibio un gran golpe en la boca");
            } else {
                System.out.println("Vampiro esquivo el golpe");
            }
            
    
            if(Math.random()<PORCENTAJE_EXITO_ARMA_CUATRO){
                vidaGuerrero = vidaGuerrero - DAÑO_ARMA_CUATRO;
                System.out.println("Guerrero recibe un golpe");
            } else if (Math.random()<PORCENTAJE_EXITO_ARMA_CINCO){
                vidaGuerrero = vidaGuerrero - DAÑO_ARMA_CINCO;
                System.out.println("Guerrero recibio un buen golpe");
            } else if(Math.random()<PORCENTAJE_EXITO_ARMA_SEIS){
                vidaGuerrero = vidaGuerrero - DAÑO_ARMA_SEIS;
                System.out.println("Guerrero recibio un gran golpe en la cabeza");
            } else {
                System.out.println("Guerrero esquivo el golpe");
            }
       
    
        

            System.out.println("Vida guerrero ["+vidaGuerrero+"] / Vida vampiro ["+vidaVampiro+"]");

            algunMuerto = vidaGuerrero<=0 || vidaVampiro<=0;
       }while(!algunMuerto);

    String elGanador = vidaGuerrero > 0 ? "Guerrero" : "Vampiro";
    System.out.println("Gano el"+elGanador);

}}