import java.util.Scanner;

public class CalculadoraPrecio {

        public static void main(String[] args) {
                final int CANTIDAD_DESCUENTO_15 = 100;
                final int CANTIDAD_DESCUENTO_10 = 50;
                final int CANTIDAD_DESCUENTO_5 = 10;
                final int DESCUENTO_15 = 15;
                final int DESCUENTO_10 = 10;
                final int DESCUENTO_5 = 5;
                final int SIN_DESCUENTO = 0;
                final double CENTIMOS_POR_EURO = 100.00;
                final int IVA_21 = 21;
                final int IVA_10 = 10;
                final int IVA_4 = 4;

                int descuento;
                System.out.println("¿Precio unitario base (céntimos)?");
                Scanner scanner = new Scanner(System.in);
                int precioUnitario = scanner.nextInt();

                System.out.println("¿Tipo de IVA (21, 10 o 4)?");
                int tipoIva = scanner.nextInt();

                int cantidadUnidades;
                System.out.println("¿Cantidad de unidades?");
                cantidadUnidades = scanner.nextInt();

                descuento = cantidadUnidades >= CANTIDAD_DESCUENTO_15 ? DESCUENTO_15
                                : cantidadUnidades >= CANTIDAD_DESCUENTO_10 ? DESCUENTO_10
                                                : cantidadUnidades >= CANTIDAD_DESCUENTO_5 ? DESCUENTO_5
                                                                : SIN_DESCUENTO;

                double precioFinal = precioUnitario / CENTIMOS_POR_EURO;

                System.out.println("precioBase: " + String.format("%.2f", precioFinal) + " EUR");

                System.out.println("IVA aplicado: " + tipoIva + "%");

                System.out.println("Descuento aplicado: " + descuento + "%");

                final double FACTORIVA_21 = 1.21;
                final double FACTOR_IVA10 = 1.10;
                final double FACTOR_IVA4 = 1.04;
                final double FACTOR_DESCUENTO15 = 0.85;
                final double FACTOR_DESCUENTO10 = 0.9;
                final double FACTOR_DESCUENTO5 = 0.95;
                final double FACTOR_SINDESCUENTO = 1.00;

                double factorIVA = tipoIva == IVA_21 ? FACTORIVA_21
                                : tipoIva == IVA_10 ? FACTOR_IVA10 : tipoIva == IVA_4 ? FACTOR_IVA4 : FACTORIVA_21;

                double factorDescuento = cantidadUnidades >= CANTIDAD_DESCUENTO_15 ? FACTOR_DESCUENTO15
                                : cantidadUnidades >= CANTIDAD_DESCUENTO_10 ? FACTOR_DESCUENTO10
                                                : cantidadUnidades >= CANTIDAD_DESCUENTO_5 ? FACTOR_DESCUENTO5
                                                                : FACTOR_SINDESCUENTO;
                double precio_Unitario_Final = precioFinal * factorIVA * factorDescuento;
                System.out.println("precioBase: " + String.format("%.2f", precio_Unitario_Final) + " EUR");
                double precio_Total = precio_Unitario_Final * cantidadUnidades;
                System.out.println("precioBase: " + String.format("%.2f", precio_Total) + " EUR");

                scanner.close();
        }

}
