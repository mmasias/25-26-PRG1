import java.util.Random;
import java.util.Scanner;

class Adivinacion{

    public static void main(String[] args){

        int numero_generado = (int)(Math.random()*100 + 1);

        int intentos_restantes = 10;

        boolean numero_caliente = false;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Adivina el número que estoy pensando!");



        for(; intentos_restantes>0; intentos_restantes--){

            int numero_intento = 11 - intentos_restantes;

            System.out.println("(Escribe un número del 1 al 100): ");
            int numero_usuario = scanner.nextInt();
            int diferencia;
            if (numero_generado > numero_usuario) {
                diferencia = numero_generado - numero_usuario;
            } else {
                diferencia = numero_usuario - numero_generado;
            }



            if(numero_usuario == numero_generado){
                System.out.println("CORRECTO!!! Lo has adivinado en el intento " + (numero_intento));
                break;
            }else{
                System.out.println("INCORRECTO. Te quedan "+ (intentos_restantes-1) + " intentos.");
                if(diferencia > 10){
                    System.out.println("FRIO");
                }else if(diferencia > 5){
                    System.out.println("TIBIO");
                }else{
                    System.out.println("CALIENTE");
                    if (numero_caliente){
                        int desplazamiento = (int)((Math.random()*11)-5);
                        numero_generado = (numero_generado + desplazamiento);
                        System.out.println("AAAATCHÚUS");
                        if (numero_generado > 100) {
                            numero_generado = 100;
                        } else if (numero_generado < 0) {
                            numero_generado = 0;
                        }
                    }
                    numero_caliente = true;
                }
            }
        }

    }

}

//HACER RETO EXTENDIDO: Agregue al algoritmo la posibilidad de "hacer trampa" si el usuario se acerca mucho al resultado
// (por ejemplo, si hace caliente dos veces seguidas).
// Haga que modifique el número pensado un valor aleatorio entre 1 y 5, sin exceder los límites de 1 y 100.
//NOTA: El ordenador estornuda cuando hace trampa. ;)
