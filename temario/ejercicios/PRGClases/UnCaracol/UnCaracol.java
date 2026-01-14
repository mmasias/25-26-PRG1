package temario.ejercicios.PRGClases.UnCaracol;

import java.util.Scanner;
public class UnCaracol {

    public static void main(String[] args) {


        final int PROFUNDIDAD_POZO = 20;
        
        int dia = 1;

        final String INICIO_DE_POZO = "[]____________________[]";
        final String POZO = "|:.:.:.::.:.:.:.:.:.:|";
        final String CARACOL_EN_POZO = "|:.:.:.:.:.:.:.:_@)_/|";

        int i = 0;
        int numeroParaLinea = i++;
        String numeroDeLinea = "-- numeroParaLinea";


        boolean caracolEnPozo = true;
        boolean dia = true;
        boolean muerto = false;

        int caracol = 1;
       
        
        
        int caracolEstaAqui = 10 + (int)(Math.random() * 11);
        int caracol = 1;

        System.out.println("El caracol ha caído en el pozo a " + caracolEstaAqui + " m de profundidad.");
        System.out.println();
        System.out.println("INICIO_DE_POZO")

        while (PROFUNDIDAD_DE_POZO < 20) {
            System.out.println(POZO);
        }



        System.out.println("POZO")
                if (caracolEstaAqui) {
                    System.out.println(CARACOL_EN_POZO + numeroDeLinea); 
                } else {
                    System.out.println(POZO); 
                }


        int subir = (int)(Math.random()* 4);    
        int bajar = 1 + (int)(Math.random()* 2 ); 
        int caracolSube = caracolEstaAqui = caracolEstaAqui + subir;
        int caracolBaja = caracolEstaAqui = caracolEstaAqui - bajar;

        boolean caracolAfuera = 

        while (caracolEnPozo) { dia++; 
            if (caracolEnPozo) {
             System.out.println("Hoy es un nuevo dia");
             caracolSube; 
             System.out.println("Hoy ha subio " + subir + "metros");
            } else {
                System.out.println("Ha oscurecido, es la hora de dormir de el caracol");
                caracolBaja;
                System.out.println("Mientras dormia ha caido" + bajar + "metros");;
            }
            System.out.println("Hoy" + dia + ", ha subio " + subir + "metros");
            
        } 

        

        System.out.println(" dia" + dia + ", ha subio " + subir + "metros y ha bajado" + bajar + "metros");

        


    }
}
