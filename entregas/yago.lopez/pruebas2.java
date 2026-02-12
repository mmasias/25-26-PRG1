import java.util.Scanner;

public class pruebas2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("¿Cuántos estudiantes hay?");
        int cantidadEstudiantes = scanner.nextInt();
        int [] notas = new int[cantidadEstudiantes];
        int sumaTotal = 0;
        int i = 0;

        for(i = 0 ; i < cantidadEstudiantes; i++){
            System.out.println("Que nota ha sacado el estudiante numero "+ (i+1));
            notas[i] = scanner.nextInt();

            sumaTotal = sumaTotal + notas[i];
        }
        
        System.out.println("=== RESULTADOS FINALES ===");
        for (i = 0; i < cantidadEstudiantes; i++) {
            System.out.println("Estudiante " + (i + 1) + ": " + notas[i] + (notas[i] >= 5 ? " (Aprobado)" : " (Suspenso)"));
        }
        
        double media = (double) sumaTotal / cantidadEstudiantes;
        System.out.println("\nSuma total de notas: " + sumaTotal);
        System.out.println("Media de la clase: " + media);

        if (media >= 5) {
            System.out.println("¡La clase aprueba en conjunto!");
        } else {
            System.out.println("La clase suspende en conjunto.");
        }
        
        scanner.close();
    }
}
