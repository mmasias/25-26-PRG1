import java.util.Scanner;

class PeleaConPocion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final double CHANCE_DAGA = 0.50;
        final double CHANCE_ESPADA = 0.25;
        final double CHANCE_HACHA = 0.12;
        final double CHANCE_DEFENSA = 0.80;
        final int DANO_DAGA = 7;
        final int DANO_ESPADA = 15;
        final int DANO_HACHA = 30;
        final int LIMITE_DESMAYO_GUERRERO = 30;

        final double CHANCE_ARANAZO = 0.90;
        final double CHANCE_MORDIDA = 0.60;
        final double CHANCE_TORTURA = 0.40;
        final int DANO_ARANAZO = 5;
        final int DANO_MORDIDA = 10;
        final int DANO_TORTURA = 20;
        final int LIMITE_DESMAYO_VAMPIRO = 20;

        int guerreroHP = 150;
        int vampiroHP = 60;
        int danoBase = 0;
        int opcionGuerrero, opcionVampiro;
        boolean dadoGuerrero = true;
        boolean dadoVampiro = true;
        boolean seDefiendeGuerrero = false;
        boolean hayMuerto = false;

        System.out.println("VAMPIRO vs EL GUERRERO !!!!!!");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        do {
            System.out.println();
            System.out.println("HP Guerrero [" + guerreroHP + "]");
            System.out.println("HP Vampiro [" + vampiroHP + "]");
            if(guerreroHP > LIMITE_DESMAYO_GUERRERO) {
                System.out.println(">>>>>>> Tu arsenal >>>>>>>");
                System.out.println("1. Daga [Daño: " + DANO_DAGA + "] [Chance: " + CHANCE_DAGA + "]");
                System.out.println("2. Espada [Daño: " + DANO_ESPADA + "] [Chance: " + CHANCE_ESPADA + "]");
                System.out.println("3. Hacha [Daño: " + DANO_HACHA + "] [Chance: " + CHANCE_HACHA + "]");
                System.out.println("4. Defenderse");
                System.out.println("Con que golpeara el Guerrero?");
                opcionGuerrero = scanner.nextInt();
                if (opcionGuerrero == 1) {
                    dadoGuerrero = Math.random() < CHANCE_DAGA;
                    vampiroHP = vampiroHP - (dadoGuerrero ? DANO_DAGA : 0);
                    System.out.println(dadoGuerrero ? "El ataque dio al vampiro!" : "Pero el guerrero falló");
                }
                else if (opcionGuerrero == 2) {
                    dadoGuerrero = Math.random() < CHANCE_ESPADA;
                    vampiroHP = vampiroHP - (dadoGuerrero ? DANO_ESPADA : 0);
                    System.out.println(dadoGuerrero ? "El ataque dio al vampiro!" : "Pero el guerrero falló");
                }
                else if (opcionGuerrero == 3) {
                    dadoGuerrero = Math.random() < CHANCE_HACHA;
                    vampiroHP = vampiroHP - (dadoGuerrero ? DANO_HACHA : 0);
                    System.out.println(dadoGuerrero ? "El ataque dio al vampiro!" : "Pero el guerrero falló");
                }
                else if (opcionGuerrero == 4) {
                        seDefiendeGuerrero = Math.random() < CHANCE_DEFENSA;
                        System.out.println(seDefiendeGuerrero ? "@@ El guerrero está en guardia a la defensa!" : "...Pero falló!");
                    }
            }
            else {
                System.out.println("El guerrero está tirado en mitad de batalla!");
                System.out.println();
                guerreroHP = guerreroHP + 2;
            }

            hayMuerto = guerreroHP * vampiroHP <= 0;
            opcionVampiro = hayMuerto ?  16 :(int) (Math.random() * 10);
            if(vampiroHP > LIMITE_DESMAYO_VAMPIRO) {
                if (opcionVampiro >= 0 && opcionVampiro < 3){
                    dadoVampiro = Math.random() < CHANCE_ARANAZO;
                    danoBase = seDefiendeGuerrero ? (DANO_ARANAZO - 5) : DANO_ARANAZO;
                    guerreroHP = guerreroHP - (dadoVampiro ? danoBase : 0);
                    System.out.print("El vampiro hizo arañazo");
                }
                else if(opcionVampiro >= 3 && opcionVampiro <= 6){
                    dadoVampiro = Math.random() < CHANCE_MORDIDA;
                    danoBase = seDefiendeGuerrero ? (DANO_MORDIDA - 5) : DANO_MORDIDA;
                    guerreroHP = guerreroHP - (dadoVampiro ? danoBase : 0);
                    System.out.print("El vampiro hizo mordida");
                }
                else if (opcionVampiro > 6 && opcionVampiro <=10) {
                    dadoVampiro = Math.random() < CHANCE_TORTURA;
                    danoBase = seDefiendeGuerrero ? (DANO_TORTURA-5) : DANO_TORTURA;
                    guerreroHP = guerreroHP - (dadoVampiro ? danoBase : 0);
                    System.out.print("El vampiro hizo tortura mental");
                }
                else {
                    System.out.println("Ya hay un ganador!");
                }
                    System.out.print(dadoVampiro ? " y ha herido al guerrero": "... pero fallo");
            }
            else {
                System.out.println("El vampiro se ha desmayado en mitad de batalla!");
                vampiroHP = vampiroHP + 2;
            }
            System.out.println();
            seDefiendeGuerrero = false;
            hayMuerto = guerreroHP * vampiroHP <= 0;
        } while(!hayMuerto);

        boolean ganoGuerrero = guerreroHP > 0;
        System.out.println(ganoGuerrero ? "El Guerrero es el vencedor" : "Las fuerzas del mal han vencido esta noche");
        scanner.close();
    }
}