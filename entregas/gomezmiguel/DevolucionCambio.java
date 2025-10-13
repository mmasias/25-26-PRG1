import java.util.Scanner;

class DevolucionCambio {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int[] denominaciones = {100, 50, 20, 10, 5, 2, 1};
        final String[] tipos = {"billete", "billete", "billete", "billete", "billete", "moneda", "moneda"};

        System.out.print("¿Cuánto dinero tienes que pagar? ");
        int montoAPagar = scanner.nextInt();

        System.out.print("¿Con cuánto vas a pagar? ");
        int montoEntregado = scanner.nextInt();

        int cambioPendiente = montoEntregado - montoAPagar;

        System.out.println("\nCambio a devolver: " + cambioPendiente + " €");

        for (int indice = 0; indice < denominaciones.length; indice++) {
            int unidades = cambioPendiente / denominaciones[indice];
            cambioPendiente %= denominaciones[indice];

            if (unidades > 0) {
                String tipoBase = tipos[indice];
                String tipoFinal = unidades > 1 ? (tipoBase.equals("billete") ? "billetes" : "monedas") : tipoBase;
                System.out.println(unidades + " " + tipoFinal + " de " + denominaciones[indice] + " €");
            }
        }

        scanner.close();
    }
}