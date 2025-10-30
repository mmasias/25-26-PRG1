package Prog1.retos;

public class GeneradorRandomNumeros
 {
    public static void main(String[] args) {
        int numeroAleatorio=(int) (Math.random()*100)+1;
        System.out.println("Introduce la cantidad de números aleatorios a generar:");
        
        for (int i = 0; i < 10; i++) {
            numeroAleatorio = (int) (Math.random() * 100) + 1;
            System.out.println(numeroAleatorio);
        }
    }
    
}
