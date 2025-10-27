import java.util.Scanner;

public class DevolverCambio {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el importe a pagar: ");
        int importe = scanner.nextInt();

        System.out.print("Ingrese el dinero entregado: ");
        int entregado = scanner.nextInt();

        
        if (entregado < importe) {
            System.out.println("El dinero entregado debe ser mayor que el importe a pagar.");
            return;
        }

        int cambio = entregado - importe;
        System.out.println("Cambio a devolver: " + cambio);

        int[] denominaciones = {100, 50, 20, 10, 5, 2, 1};

        for (int denominacion : denominaciones) {
            int cantidad = cambio / denominacion;
            if (cantidad > 0) {
                System.out.println(denominacion + " x " + cantidad);
                cambio %= denominacion;
            }
        }
    }
}
