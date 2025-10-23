import java.util.Scanner;

public class BatallaGuerreroVampirobase {
  public static void main(String[] args) {
    int vidaGuerrero = 20;
    final double PORCENTAJE_EXITO_GUERRERO = 0.5;

    final int DAÑO_MORDIDA = 4;
    int vidaVampiro = 10;
    final double PORCENTAJE_EXITO_VAMPIRO = 0.5;

    boolean algunMuerto = false;
    boolean guerreroVivo = true;
    boolean vampiroVivo = true;

  do {
    if (Math.random() < PORCENTAJE_EXITO_GUERRERO) {
      vidaVampiro = vidaVampiro - DAÑO_ESPADA;
      System.out.println("El vampiro recibe el golpe");
    } else {
      System.out.println("El vampiro esquiva el golpe");
    }
    
    if (vidaVampiro <= 0) {
      algunMuerto = true;
    } else {
      if (Math.random() < PORCENTAJE_EXITO_VAMPIRO) {
        vidaGuerrero = vidaGuerrero - DAÑO_MORDIDA;
        System.out.println("El guerrero recibe una mordida");
      } else {
        System.out.println("El guerrero esquiva la mordida");
      }
    }

    if (vidaGuerrero <= 0) {
      algunMuerto = true; 
    }

    System.out.println("Vidad Guerrero [" + vidaGuerrero + "] / Vida Vampiro [" + vidaVampiro + "];

  }

    while (algunMuerto);

    System.out.println("La batalla ha terminado");

    if (VidaGuerrero > 0) {
      System.out.println("El guerrero ha ganado");
    } else {
      System.out.println("El vampiro ha ganado");
    }
  }
}
    
    
