import java.util.Scanner;

        class CalculadoraDePrecioFinal{
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        double precioBaseCentimos;
        double IVA;
        int unidades;
        
        System.out.println ("Precio unitario base (en centimos): ");
        precioBaseCentimos = scanner.nextInt();
        System.out.println ("Cantidad de unidades: ");
        unidades = scanner.nextInt();
        System.out.println ("Tipo de IVA (21, 10 o 4): ");
        IVA = scanner.nextInt();
        
        precioBaseCentimos = precioBaseCentimos / 100;
        double descuento;
        descuento = (unidades >= 10) ? 0.95 : 1;
        descuento = (unidades >= 50) ? 0.9: descuento;
        descuento = (unidades >= 100) ? 0.85 : descuento;
        
        double precioFinal;
        precioFinal = IVA * descuento * precioBaseCentimos;
        double pagoTotal;
        pagoTotal = precioFinal * unidades;
        System.out.println ("IVA: " + 100 * (1-IVA) + "%");
        System.out.println ("Descuento: " + precioFinal + " euros");
        System.out.println ("Precio total: " + pagoTotal + " euros");
        
        
        
         
                
    }
}