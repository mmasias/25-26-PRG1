import java.util.Scanner;

public class reto001 {
    public static void main(String[] args) {
        String mensaje = "¿Cuánto tienes que pagar?";
        String mensaje2 = "¿Con cuanto has pagado?";
        System.out.println(mensaje);
        Scanner scanner = new Scanner(System.in);
        int precioPagar = scanner.nextInt();
        System.out.println(mensaje2);
        Scanner scanner2 = new Scanner(System.in);
        int dineroEntregado = scanner2.nextInt();
        int devolucion = dineroEntregado-precioPagar;
        
        
        int[] billetes={100,50,20,10,5,2,2};
        String[] nombres={
            "billete(s) de 100",
            "billete(s) de 50",
            "billete(s) de 20",
            "billete(s) de 10",
            "billete(s) de 5",
            "moneda(s) de 2",
            "moneda(s) de 1"
        };
        System.out.println();
        for(int i = 0; i<billetes.length;i++){
            int cantidad = devolucion/ billetes[i];
            devolucion= devolucion % billetes[i];
            System.out.println(cantidad+" "+nombres[i]);
        }
    }

    
}
