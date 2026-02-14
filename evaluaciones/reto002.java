import java.util.Random;

public class reto002 {
    public static void main(String[] args) {
        Random random = new Random();
        int hpGuerrero = 20;
        int dañoGuerrero = 2;
        int hpVampiro = 10;
        int dañoVampiro = 4;
        double probabilidadAcierto = 0.5;
        int ronda=1;

        while(hpGuerrero>0&&hpVampiro>0){
            System.out.println("--------RONDA "+ronda+"-------");
            boolean aciertaGuerrero = random.nextDouble()<probabilidadAcierto;
            
             if(aciertaGuerrero){
                hpVampiro= hpVampiro-dañoGuerrero;
                System.out.println("El guerrero acirta y hace "+dañoGuerrero);

                
            }
            else{
                hpVampiro=hpVampiro;
                System.out.println("El guerrero ha fallado el golpe");

            }
            boolean aciertaVampiro = random.nextDouble()<probabilidadAcierto;
            if(aciertaVampiro){
                hpGuerrero=hpGuerrero-dañoVampiro;
                System.out.println("El vampiro asesta una mordida y hace "+dañoVampiro);

            }
            else{
                hpGuerrero=hpGuerrero;
                System.out.println("El vampiro, a pesar de agil, falla en su intento de mordida");
            }
            System.out.println("Vida Guerrero: "+hpGuerrero);
            System.out.println("Vida vampiro: "+hpVampiro);
            ronda++;
        }
        System.out.println("Fin de la batalla");
        if(hpGuerrero<hpVampiro){
            System.out.println("El vampiro ha ganado la batalla.--------Has perdido-------");
        }
        else if(hpVampiro<hpGuerrero){
            System.out.println("El guerrero ha ganado la batalla.--------Has ganado---------");
        }
        else{
            System.out.println("Ambos murieron en el campo de batalla y los cuerpos jamas fueron encontrados");
        }
        System.out.println("----------FIN-----------");
    }
    
}
