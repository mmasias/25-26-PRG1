import java.util.Scanner;

public class pruebas1 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        double[] temperaturas = new double[30];
        int diasRegistrados = 0;
        boolean continuar = true;
        
        System.out.println("REGISTRO DE TEMPERATURAS");
        System.out.println("------------------------");
        
        while (continuar && diasRegistrados < 30) {
            System.out.print("Temperatura del dia " + (diasRegistrados + 1) +   " (o -100 para terminar): ");
            double temperaturaIngresada = entrada.nextDouble();
            
            if (temperaturaIngresada == -100) {
                continuar = false;
            } else {
   
                temperaturas[diasRegistrados] = temperaturaIngresada;
                diasRegistrados = diasRegistrados + 1;
            }
        }
        

        if (diasRegistrados == 0) {
            System.out.println("No se ingresaron temperaturas.");
        } else {

            double sumaTotal = 0;
            for (int i = 0; i < diasRegistrados; i++) {
                sumaTotal = sumaTotal + temperaturas[i];
            }

            double promedio = sumaTotal / diasRegistrados;
            

            double temperaturaMaxima = temperaturas[0];
            int diaMaxima = 1;
            
            for (int i = 1; i < diasRegistrados; i++) {
                if (temperaturas[i] > temperaturaMaxima) {
                    temperaturaMaxima = temperaturas[i];
                    diaMaxima = i + 1;
                }
            }
            

            double temperaturaMinima = temperaturas[0];
            int diaMinima = 1;
            
            for (int i = 1; i < diasRegistrados; i++) {
                if (temperaturas[i] < temperaturaMinima) {
                    temperaturaMinima = temperaturas[i];
                    diaMinima = i + 1;
                }
            }
            
            System.out.println("\nRESULTADOS:");
            System.out.println("-----------");
            System.out.println("Dias registrados: " + diasRegistrados);
            System.out.println("Temperatura promedio: " + promedio);
            System.out.println("Temperatura maxima: " + temperaturaMaxima + 
                             " (dia " + diaMaxima + ")");
            System.out.println("Temperatura minima: " + temperaturaMinima + 
                             " (dia " + diaMinima + ")");
            

            System.out.println("\nDias sobre el promedio (" + promedio + "):");
            boolean existeSobrePromedio = false;
            
            for (int i = 0; i < diasRegistrados; i++) {
                if (temperaturas[i] > promedio) {
                    System.out.println("  Dia " + (i + 1) + ": " + temperaturas[i]);
                    existeSobrePromedio = true;
                }
            }
            
            if (!existeSobrePromedio) {
                System.out.println("  Ningun dia supero el promedio");
            }
        }
        entrada.close();
        System.out.println("\nPrograma terminado.");
    }
}