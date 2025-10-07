
import java.util.Scanner;

public class CalcularPrecioFinal {
    public static void main(String[] args) {
        final float general = 0.21f; 
        final float reducido = 0.1f;
        final float superreducido = 0.04f;
       
        Scanner sc = new Scanner(System.in);

        System.out.println("Precio unitario base (céntimos):");
        int centimos = sc.nextInt();

        System.out.println("Cantidad de unidades:");
        int unidades = sc.nextInt();

        System.out.println("Tipo de IVA (21,10 o 4)");
        int iva = sc.nextInt();

        float euros = centimos/100;

        System.out.println("Precio base: "+euros+" €");
        System.out.println("IVA aplicado: "+iva+"%");

        float descuento = 0;
        if(unidades <10 ){
            descuento = 0;
        }else if(unidades < 50){
            descuento = 0.05f;
        }else if(unidades < 100){
            descuento = 0.1f;
        }else{
            descuento = 0.15f;
        }

        System.out.println("Descuento aplicado: "+descuento*100+"%");
        float unitario = euros+euros*iva/100;
        unitario = unitario-descuento*unitario;
        
        System.out.println("Precio unitario final: "+unitario+" €");

        float total = unitario*unidades;
        System.out.println("Precio total: "+total+" €");


        }
    }
