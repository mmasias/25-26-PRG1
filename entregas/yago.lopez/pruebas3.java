import java.util.Scanner;

public class pruebas3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("cuantos dias quieres ingresar?");
        int temperaturasDias = scanner.nextInt();
        int[] temperaturas = new int [temperaturasDias];
        int sumaTotal = 0;
        int temperaturaMedia = 0;
        int mayor20 = 0;
        int temperaturaMaxima = 0;
    

        for(int i = 0; i<temperaturasDias; i++){
            System.out.println("Introduce la temperatura del dia "+(i+1));
            temperaturas[i] = scanner.nextInt();

            sumaTotal=sumaTotal + temperaturas[i];

            if(temperaturas[i] > 20){
                mayor20++;
            }
            
        }
        
        temperaturaMedia = sumaTotal/temperaturasDias;

        System.out.println("=== RESULTADOS ===");
        System.out.println("La media de temperatura es: " +temperaturaMedia);
        System.out.println("Ha habido "+mayor20 + "dias con mas de 20 grados");


        scanner.close();
    }
}