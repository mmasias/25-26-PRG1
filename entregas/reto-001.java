public class Reto-001 {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);

        System.out.print("Monto a pagar: ");
        int montoPagar = sc.nextInt();

        System.out.print("Monto entregado: ");
        int montoEntregado = sc.nextInt();

        // Usamos ternario para decidir qué mensaje mostrar
        String resultado = (montoEntregado < montoPagar)
                ? "Faltan " + (montoPagar - montoEntregado) + " euros para completar el pago."
                : calcularCambio(montoEntregado - montoPagar);

        System.out.println(resultado);

        sc.close();
    }

   
    public static String calcularCambio(int cambio) {
        int[] valores = {100, 50, 20, 10, 5, 2, 1};
        String[] nombres = {"billete(s) de 100€", "billete(s) de 50€", "billete(s) de 20€", 
                            "billete(s) de 10€", "billete(s) de 5€", "moneda(s) de 2€", "moneda(s) de 1€"};

        StringBuilder sb = new StringBuilder();
        sb.append("Cambio a devolver: ").append(cambio).append(" euros\n");

        for (int i = 0; i < valores.length; i++) {
            int cantidad = cambio / valores[i];
            cambio %= valores[i];
           
            sb.append(cantidad > 0 ? cantidad + " " + nombres[i] + "\n" : "");
        }
        return sb.toString();

    }}
