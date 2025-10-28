
import java.util.Scanner;

class Pozo{
    public static void main(String[] args){
        Scanner sc = new Scanner (System.in);

        final int PROFUNDIDAD_POZO = 20;
        final String BORDESUPERIOR = "[   ]                   [   ]";
        final String PAREDESPOZO = " []:.:.:.:.:.:.:.:.:.:.:.[]";
        final String FONDOPOZO = " [][][][][][][][][][][][][]";
        final String SEPARADOR = "----";
       
       
        System.out.println ("Profundidad del agua?");
        final int PROFUNDIDAD_AGUA = Scanner.nextInt() <= PROFUNDIDAD_POZO;
        final String AGUA = " []____________________[]";
       
       
       
        System.out.println ("Profundidad del caracol?");
        final int CARACOL = Scanner.nextInt();
        final String CARACOL;
         if (CARACOL >= PROFUNDIDAD_AGUA){
            final String CARACOL = " []________-@-!________[]";
        }else{
            final String CARACOL = " []:.:.:.:.-@-/.:.:.:.[]";
        }
        
        System.out.println (BORDESUPERIOR);
        System.out.println (PAREDESPOZO);
        System.out.println (AGUA);
        System.out.println (CARACOL);

        sc.close();

    }
}